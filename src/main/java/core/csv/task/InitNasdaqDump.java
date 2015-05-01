package core.csv.task;

import java.util.List;

public class InitNasdaqDump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * READ FROM nasdaqtickerreader
		 * Write to WriteNasdaqTicker
		 */
		List<String> tickers = NasdaqTickerReader.readFromFile();
		WriteNasdaqTicker wt = new WriteNasdaqTicker(tickers);
		wt.writeTickersToFile("nasdaqTickersSimple");
	}
}
