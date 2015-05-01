package core.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import core.csv.CSVReader;

public class YahooQuery {
	public YahooQuery(){
	  CloseableHttpClient httpclient = HttpClients.createDefault();
      try {
    	  HttpGet httpget = new HttpGet("http://real-chart.finance.yahoo.com/table.csv?s=NOK&d=4&e=1&f=2015&g=d&a=0&b=3&c=1994&ignore=.csv");



          System.out.println("executing request " + httpget.getRequestLine());
          CloseableHttpResponse response = httpclient.execute(httpget);
          try {
              System.out.println("----------------------------------------");
              System.out.println(response.getStatusLine());
              HttpEntity resEntity = response.getEntity();
              if (resEntity != null) {
                  System.out.println("Response content length: " + resEntity.getContentLength());
                  BufferedReader br = new BufferedReader(new InputStreamReader(resEntity.getContent()));
                  //while br has next etc
              }
              EntityUtils.consume(resEntity);
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
	}
}
