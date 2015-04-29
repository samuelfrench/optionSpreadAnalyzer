package core;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import function.Util;

public class CSVWriter {
	public final static CSVFormat csvFormat = CSVFormat.MYSQL;
	
	
	public static void writeFile(Map<Double, Double> data, String fileName){
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		try{
			fileWriter = new FileWriter(fileName);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFormat);
			List<Double> keys = Util.sortedSet(data.keySet());
			for(Double d : keys){
				csvFilePrinter.print("Mark:," + d + ",Price:," + data.get(d));
			}
			csvFilePrinter.close();
			fileWriter.close();
		} catch (IOException e){
			System.err.println("writeFile: IOException: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
