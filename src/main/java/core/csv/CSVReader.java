package core.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import domain.HistoricalDataRecord;
import domain.MktDataRow;
import function.Util;

public class CSVReader {
	private FileReader fileReader;
	private CSVParser csvReader;

	public CSVReader(String fileName) {
		this.openFile(fileName);
	}

	public List<HistoricalDataRecord> readHistoricalFile() throws IOException {
		List<HistoricalDataRecord> records = new ArrayList<>();
		List<CSVRecord> rawRecords = this.csvReader.getRecords();

		// System.out.println(rawRecords.size());
		for (CSVRecord r : rawRecords) {
			HistoricalDataRecord d = new HistoricalDataRecord();
			try {
				// System.out.println(r.getRecordNumber());
				if (r.getRecordNumber() != 0) {
					// todo turn this to an enum
					/*
					 * TODO
					 */
					try {
						d.setId(r.getRecordNumber());
						d.setDate(r.get(0));
						d.setOpen(Double.parseDouble(r.get(1)));
						d.setHigh(Double.parseDouble(r.get(2)));
						d.setLow(Double.parseDouble(r.get(3)));
						d.setClose(Double.parseDouble(r.get(4)));
						d.setVolume(Integer.parseInt(r.get(5)));
						d.setAdjClose(Double.parseDouble(r.get(6)));
					} catch (Exception e) {
						continue;
					}
					records.add(d);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (NullPointerException n) {
				n.printStackTrace();
			} finally {
				this.csvReader.close();
			}
		}
		return records;
	}
	
	public boolean openFile(String fileName){
		try {
			this.fileReader = new FileReader(fileName);
			this.csvReader = new CSVParser(fileReader,
					CSVFormat.EXCEL.withDelimiter(','));
		} catch (IOException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}
	
	public List<MktDataRow> read() throws IOException {
		List<CSVRecord> rawRecords = this.csvReader.getRecords();
		rawRecords.removeIf((p) -> p == null || p.size()< 4 || !StringUtils.isNumeric(p.get(0)));
		//List<CSVRecord> filteredRecords = rawRecords.stream().filter((r)-> StringUtils.isNumeric(r.get('0').substring(0, 2))).collect(Collectors.toList());
		List<MktDataRow> resultSet = new ArrayList<>(rawRecords.size());
		for(CSVRecord r : rawRecords){
			MktDataRow row = new MktDataRow();
			row.setTimestamp(Long.parseLong(r.get(0)));
			row.setClose(Double.parseDouble(r.get(1)));
			row.setHigh(Double.parseDouble(r.get(2)));
			row.setLow(Double.parseDouble(r.get(3)));
			row.setOpen(Double.parseDouble(r.get(4)));
			row.setVolume(Long.parseLong(r.get(5)));
			resultSet.add(row);
		}
		
		return resultSet;
	}
}
