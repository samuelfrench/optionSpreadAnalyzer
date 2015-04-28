package main;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import domain.DoubleITMVerticalTrade;
import domain.ResultRow;

/*
 * WARNING: CURRENTLY ONLY SUPPORTS DOUBLE ITM VERICAL SPREADS - NO OTHER TRADE TYPES
 */
public class RangeAnalyzer {
	private Integer lowerBound;
	private Integer upperBound;
	private double interval;
	private DoubleITMVerticalTrade trade;
	
	private boolean commissions;
	private double commission;
	
	public RangeAnalyzer(Integer lowerBound, Integer upperBound, double interval, DoubleITMVerticalTrade trade){
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.interval = interval;
		this.trade = trade;
		this.setCommissions(false);
	}
	
	
	protected Map<BigInteger, ResultRow> runRangeAnalysis(){
		Map<BigInteger, ResultRow> resultMap = new HashMap<>();
		BigInteger iterator = BigInteger.ZERO;
		
		double pointer = lowerBound.doubleValue();
		
		while(pointer <= upperBound.doubleValue()){
			System.out.println("debug: " + iterator.toString());
			ResultRow row = new ResultRow();
			row.setMark(pointer);
			row.setProfit(trade.totalProfit(pointer, false));
			System.out.println("debug: MARK: " + pointer + " price: " + trade.totalProfit(pointer, false));
			row.setRowId(iterator.intValue());
			resultMap.put(iterator, row);
			iterator = iterator.add(BigInteger.ONE);
			pointer = pointer+ interval;
		}
		
		return resultMap;
	}


	public boolean isCommissions() {
		return commissions;
	}


	public void setCommissions(boolean commissions) {
		this.commissions = commissions;
	}


	public double getCommission() {
		return commission;
	}


	public void setCommission(double commission) {
		this.commission = commission;
	}
}
