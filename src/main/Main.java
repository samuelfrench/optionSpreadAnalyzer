package main;

import domain.DoubleITMVerticalTrade;

public class Main {

	public static void main(String[] args) {
		/*
		Position a = new Position();
		a.setStrikePrice((double)55);
		a.setPosition(POSITION_TYPE.LONG);
		a.setPurchasePrice(0.5);
		a.setType(OPTION_TYPE.CALL);
		a.setTotalSpreadTrades(2);
		a.setApproxCommissionsTotal(12.99);
		a.setNumberOfContracts((double)1);
		try {
			double profit = a.profitAtMark(60, true);
			p(Double.toString(profit));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		DoubleITMVerticalTrade trade = new DoubleITMVerticalTrade();
		trade.getLongCall().setNumberOfContracts((double)2);
		trade.getLongCall().setPurchasePrice((double)19.36);
		trade.getLongCall().setStrikePrice((double)430);

		trade.getShortCall().setNumberOfContracts((double)2);
		trade.getShortCall().setPurchasePrice((double)-15.98);
		trade.getShortCall().setStrikePrice((double)435);
		
		trade.getLongPut().setNumberOfContracts((double)1);
		trade.getLongPut().setPurchasePrice((double)35.58); //35.58
		trade.getLongPut().setStrikePrice((double)475);

		trade.getShortPut().setNumberOfContracts((double)(double)1);
		trade.getShortPut().setPurchasePrice((double)30.92);
		trade.getShortPut().setStrikePrice((double)470);
		RangeAnalyzer analyzer = new RangeAnalyzer(400, 500, 1, trade);
		analyzer.setCommissions(false);
		analyzer.runRangeAnalysis();
	
	
	}
	
	/*
	 * TODO
	 */
	@SuppressWarnings("unused")
	private static void p(String s){
		System.out.println("debug: " + s);
	}

}
