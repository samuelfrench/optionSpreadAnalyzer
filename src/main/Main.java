package main;

import domain.Position;
import domain.Position.OPTION_TYPE;
import domain.Position.POSITION_TYPE;

public class Main {

	public static void main(String[] args) {
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

	}
	
	private static void p(String s){
		System.out.println("debug: " + s);
	}

}
