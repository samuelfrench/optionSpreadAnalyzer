package core.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVParser;

import domain.HistoricalDataRecord;
import function.Util;

public class CSVReader {
    private FileReader fileReader;
    private CSVParser csvReader;
    public CSVReader(String fileName){
	try{
	    this.fileReader = new FileReader(fileName);
	    this.csvReader = new CSVParser(fileReader,Util.CSV_FORMAT_DEFAULT);
	} catch (IOException e){
	    e.printStackTrace();
	}
    }
    
    private Map<Long, HistoricalDataRecord> readFile(){
	Map<Long, HistoricalDataRecord> map = new HashMap<>();
		this.csvReader.getRecords().parallelStream().forEach((r) -> {
		    map.put(r.get(0), null);//todo
		});
	return map;
    }
}
