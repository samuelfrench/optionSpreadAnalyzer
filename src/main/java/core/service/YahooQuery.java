package core.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import core.csv.misc.PullYahoo;
import core.csv.task.NasdaqTickerReader;
import edu.emory.mathcs.backport.java.util.Arrays;

public class YahooQuery {
	
	public static final String[] dailyQuery = {"http://chartapi.finance.yahoo.com/instrument/1.0/","/chartdata;type=quote;range=1d/csv"};
	public static void getHistoricalStockData(String ticker, String startYear, String endYear, boolean timeStamp){
	  CloseableHttpClient httpclient = HttpClients.createDefault();
	  if(ticker.length()>10){
		  return;
	  }
      try {
    	  HttpGet httpget = new HttpGet("http://real-chart.finance.yahoo.com/table.csv?s="+ ticker + "&d=4&e=1&f="+endYear+"&g=d&a=0&b=3&c=" + startYear + "&ignore=.csv");



          System.out.println("executing request " + httpget.getRequestLine());
          CloseableHttpResponse response = httpclient.execute(httpget);
          try {
              System.out.println("----------------------------------------");
              System.out.println(response.getStatusLine());
              HttpEntity resEntity = response.getEntity();
              if (resEntity != null) {
                  System.out.println("Response content length: " + resEntity.getContentLength());
                  FileWriter fr;
                  if(timeStamp){
                	  fr = new FileWriter("csv/" + ticker + "_" + Long.toString((new java.util.Date().getTime())) + ".csv");
                  } else {
                	  fr = new FileWriter("csv/" + ticker + ".csv");
                  }
                  InputStreamReader ir = new InputStreamReader(resEntity.getContent());
                  while(ir.ready()){
                	  char[] cbuff = new char[255];
                	  if(ir.read(cbuff)<1){
                		  break;
                	  }
                	  fr.write(cbuff);
                	  if(!ir.ready()){
                		  EntityUtils.consume(resEntity);
                	  }
                  }
                  
                  fr.close();
                  
              
                  //return n;
              }
          } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
              try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
      } catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} finally {
          try {
			httpclient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
	//return null;
	}
	
	public static void getDailyStockCSV(String ticker, String fileName, boolean timeStamp) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		if (ticker.length() > 10) {
			return;
		}
		String query = getDailyURI(ticker);
	    	  HttpGet httpget = new HttpGet(query);



	          System.out.println("executing request " + httpget.getRequestLine());
	          CloseableHttpResponse response;
			try {
				response = httpclient.execute(httpget);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return;
			}
	          try {
	              System.out.println("----------------------------------------");
	              System.out.println(response.getStatusLine());
	              HttpEntity resEntity = response.getEntity();
	              if (resEntity != null) {
	                  System.out.println("Response content length: " + resEntity.getContentLength());
	                  FileWriter fr;
	                  if(fileName.toUpperCase().endsWith(".CSV")){
	                	  fileName = fileName.substring(0, fileName.indexOf(".CSV"));
	                  }
	                  if(timeStamp){
	                	  fr = new FileWriter("csv/daily/" + fileName + "_" + Long.toString((new java.util.Date().getTime())) + ".csv");
	                  } else {
	                	  fr = new FileWriter("csv/daily/" + fileName + ".csv");
	                  }
	                  InputStreamReader ir = new InputStreamReader(resEntity.getContent());
	                  while(ir.ready()){
	                	  char[] cbuff = new char[255];
	                	  if(ir.read(cbuff)<1){
	                		  break;
	                	  }
	                	  fr.write(cbuff);
	                	  if(!ir.ready()){
	                		  EntityUtils.consume(resEntity);
	                	  }
	                  }
	                  
	                  fr.close();
	                  
	              }
	                  //return n;
	              } catch (Exception e){
	            	  //
	              }
		

	}
	
	private static String getDailyURI(String ticker){
		StringBuilder sb = new StringBuilder(dailyQuery[0]);
		sb.append(ticker);
		sb.append(dailyQuery[1]);
		return sb.toString();
	}

	public final static String[] tickers = {"INTC","AMD","AMZN", "ARMH"};
	/**
	 * @return
	 */
	public static List<String> getNasdaqTickers() {
		List<String> ticks = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("nasdaqlisted.txt"));
			while(br.ready()){
				ticks.add(br.readLine().split("\\|")[0]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ticks.remove("Symbol");
		return ticks;
	}

	/**
	 * @todo need to find a better name for this - not daily - not sure what a proper name would be
	 * @param timeStamp - append timestamp to file
	 */
	public static void getAndWriteDailyCsv(boolean timeStamp) {
		List<String> ticks = NasdaqTickerReader.readFromFile();
		//YahooQuery query = new YahooQuery();
		ticks.parallelStream().forEach((t)->{
			getDailyStockCSV(t,t, timeStamp);
			//System.out.println(" " + t);
		});
	}

	@SuppressWarnings("unchecked")
	public static List<String> getAbbrTickers(){
		return Arrays.asList(PullYahoo.tickers);
	}
}
