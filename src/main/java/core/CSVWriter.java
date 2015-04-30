package core;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import domain.DoubleVertical;
import function.Util;

public class CSVWriter {
	public final static CSVFormat CSV_FORMAT_DEFAULT = CSVFormat.MYSQL;
	
	@Deprecated
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
	
	public void writeFile(Map<Double, DoubleVertical> toWrite, String fileName) throws IOException{
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		try{
			fileWriter = new FileWriter(fileName);
			csvFilePrinter = new CSVPrinter(fileWriter, CSV_FORMAT_DEFAULT);
			List<Double> keys = Util.sortedSet(toWrite.keySet());
			csvFilePrinter.print(toWrite.get(keys.get(0)).getRowHeader());
			csvFilePrinter.println();
			for(Double d : keys){
				csvFilePrinter.print(toWrite.get(d).toString());
				csvFilePrinter.println();
			}
		} catch (IOException e){
			System.err.println("writeFile: IOException: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try{
				csvFilePrinter.close();
				fileWriter.close();	
			} catch (Exception e){
				System.err.println("CSVWriter: could not close file writer");
			}
		}
	}

	/*
	private static void checkParam(Map<Double, RecordRow> data, Double d) {
		if(data.get(d)==null || (!data.get(d).isPopulated()) || data.get(d).toString()==null){
			throw new IllegalArgumentException();
		}
	} */
}
