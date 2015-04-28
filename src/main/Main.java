package main;

import domain.DoubleITMVerticalTrade;

public class Main {

	public static void main(String[] args) {
		/*
		Position a = new Position();
		a.setStrikePrice(55);
		a.setPosition(POSITION_TYPE.LONG);
		a.setPurchasePrice(0.5);
		a.setType(OPTION_TYPE.CALL);
		a.setTotalSpreadTrades(2);
		a.setApproxCommissionsTotal(12.99);
		a.setNumberOfContracts(1);
		try {
			double profit = a.profitAtMark(60, true);
			p(Double.toString(profit));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		DoubleITMVerticalTrade trade = new DoubleITMVerticalTrade();
		trade.getLongCall().setNumberOfContracts(2);
		trade.getLongCall().setPurchasePrice(19.36);
		trade.getLongCall().setTotalSpreadTrades(4);
		trade.getLongCall().setApproxCommissionsTotal((double) 0);
		trade.getLongCall().setStrikePrice(130);

		trade.getShortCall().setNumberOfContracts(2);
		trade.getShortCall().setPurchasePrice(-15.98);
		trade.getShortCall().setTotalSpreadTrades(4);
		trade.getShortCall().setApproxCommissionsTotal((double) 0);
		trade.getShortCall().setStrikePrice(135);
		
		trade.getLongPut().setNumberOfContracts(1);
		trade.getLongPut().setPurchasePrice(35.58); //35.58
		trade.getLongPut().setTotalSpreadTrades(4);
		trade.getLongPut().setApproxCommissionsTotal((double) 0);
		trade.getLongPut().setStrikePrice(475);

		trade.getShortPut().setNumberOfContracts(1);
		trade.getShortPut().setPurchasePrice(-30.92);
		trade.getShortPut().setTotalSpreadTrades(4);
		trade.getShortPut().setApproxCommissionsTotal((double) 0);
		trade.getShortPut().setStrikePrice(470);
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
