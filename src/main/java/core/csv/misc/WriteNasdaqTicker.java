package core.csv.misc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVPrinter;
import function.Util;

public class WriteNasdaqTicker {
	private List<String> tickers;
	public WriteNasdaqTicker(List<String> tickers){
		this.tickers = tickers;
	}
	public boolean isPopulated(){
		return (this.tickers != null && this.tickers.size()>0);
	}
	
	public void writeTickersToFile(String fileName){
		FileWriter fr;
		CSVPrinter writer = null;
		try{
			fr = new FileWriter(fileName + ".csv");
			writer = new CSVPrinter(fr,Util.CSV_FORMAT_DEFAULT);
			for(String t : tickers){
				try {
					writer.print(t);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					writer.println();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e){
			System.err.println("Error writing nasdaq tickers: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
