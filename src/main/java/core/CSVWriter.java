package core;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import function.Util;

public class CSVWriter {
	public final static CSVFormat CSV_FORMAT_DEFAULT = CSVFormat.MYSQL;
	
	
	public static void writeFile(Map<Double, Double> data, String fileName, CSVFormat csvFormat){
		
		CSVFormat format = null;
		
		if(csvFormat==null){
			format = CSV_FORMAT_DEFAULT;
		} else {
			format = csvFormat;
		}
		
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		try{
			fileWriter = new FileWriter(fileName);
			csvFilePrinter = new CSVPrinter(fileWriter, format);
			List<Double> keys = Util.sortedSet(data.keySet());
			for(Double d : keys){
				csvFilePrinter.print("Mark:," + d + ",LongCallProfit:," + data.get(d));
				csvFilePrinter.println();
			}
			csvFilePrinter.close();
			fileWriter.close();
		} catch (IOException e){
			System.err.println("writeFile: IOException: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*
	 * TODO: Write a static method that can print our DoubleVertical objects - also need a method to create them all via maps returned from RangeCalculation
	 * @TODO
	 */
}
