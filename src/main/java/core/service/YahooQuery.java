package core.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class YahooQuery {
	public void getStockData(String ticker, String startYear, String endYear){
	  CloseableHttpClient httpclient = HttpClients.createDefault();
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
                 
                  FileWriter fr = new FileWriter(ticker + "_" + Long.toString((new java.util.Date().getTime())) + ".csv");
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
}
