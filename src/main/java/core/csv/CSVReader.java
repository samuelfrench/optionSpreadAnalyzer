package core.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import domain.HistoricalDataRecord;
import function.Util;

public class CSVReader {
    private FileReader fileReader;
    private CSVParser csvReader;
    public CSVReader(String fileName){
	try{
	    this.fileReader = new FileReader(fileName);
	    this.csvReader = new CSVParser(fileReader,CSVFormat.EXCEL.withDelimiter(','));
	} catch (IOException e){
	    e.printStackTrace();
	}
    }
    
    public List<HistoricalDataRecord> readFile() throws IOException{
	List<HistoricalDataRecord> records = new ArrayList<>();
	List<CSVRecord> rawRecords = this.csvReader.getRecords();

	System.out.println(rawRecords.size());
		for(CSVRecord r:rawRecords){
		    HistoricalDataRecord d = new HistoricalDataRecord();
		    try{
		    	System.out.println(r.getRecordNumber());
			if(r.getRecordNumber()!=0){
			    //todo turn this to an enum
			    /*
			     * TODO
			     */
			    d.setId(r.getRecordNumber());
			    d.setDate(r.get(0));
			    d.setOpen(Double.parseDouble(r.get(1)));
			    d.setHigh(Double.parseDouble(r.get(2)));
			    d.setLow(Double.parseDouble(r.get(3)));
			    d.setClose(Double.parseDouble(r.get(4)));
			    d.setVolume(Integer.parseInt(r.get(5)));
			    d.setAdjClose(Double.parseDouble(r.get(6))); 
			    records.add(d);
			}
		    } catch (NumberFormatException e) {
			e.printStackTrace();
		    } catch (NullPointerException n) {
			n.printStackTrace();
		    }
		}
		
	return records;
    }
}
