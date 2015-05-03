package core.csv;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
    
    public Map<Long, HistoricalDataRecord> readFile() throws IOException{
	Map<Long, HistoricalDataRecord> map = new ConcurrentHashMap<>();
		this.csvReader.getRecords().parallelStream().forEach((r) -> {
		    HistoricalDataRecord d = new HistoricalDataRecord();
		    try{
			if(r.getRecordNumber()!=0){
			    //todo turn this to an enum
			    /*
			     * TODO
			     */
			    d.setId(Long.parseLong(r.get(0)));
			    d.setDate(Date.valueOf(r.get(1)));
			    d.setOpen(Double.parseDouble(r.get(2)));
			    d.setLow(Double.parseDouble(r.get(3)));
			    d.setClose(Double.parseDouble(r.get(4)));
			    d.setVolume(Long.getLong(r.get(5)));
			    d.setAdjVolume(Long.getLong(r.get(6))); 
			    map.put(d.getId().longValue(), d);
			}
		    } catch (NumberFormatException e) {
			e.printStackTrace();
		    } catch (NullPointerException n) {
			n.printStackTrace();
		    }
		});
	return map;
    }
}
