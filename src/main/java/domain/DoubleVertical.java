package domain;

import java.util.Map;

import function.RangeCalculation.POSITION_TYPE;

public class DoubleVertical extends RecordRow {
	
	private final Double DEFAULT_VALUE = Double.NEGATIVE_INFINITY;
	
	private Double longCallProfit;
	private Double shortCallProfit;
	
	private Double longPutProfit;
	private Double shortPutProfit;
	
	private String ROW_HEADER = "Mark, Long Call Profit, Short Call Profit, Long Put Profit, Short Put Profit, Net Profit";
	public DoubleVertical(){
		clearValues();
	}
	
	private void clearValues(){
		this.setLongCallProfit(DEFAULT_VALUE);
		this.setShortCallProfit(DEFAULT_VALUE);
		this.setLongPutProfit(DEFAULT_VALUE);
		this.setLongPutProfit(DEFAULT_VALUE);
	}
	
	public Double getLongCallProfit() {
		return longCallProfit;
	}
	public void setLongCallProfit(double longCallProfit) {
		this.longCallProfit = longCallProfit;
	}
	public Double getShortCallProfit() {
		return shortCallProfit;
	}
	public void setShortCallProfit(double shortCallProfit) {
		this.shortCallProfit = shortCallProfit;
	}
	public Double getLongPutProfit() {
		return longPutProfit;
	}
	public void setLongPutProfit(double longPutProfit) {
		this.longPutProfit = longPutProfit;
	}
	public Double getShortPutProfit() {
		return shortPutProfit;
	}
	public void setShortPutProfit(double shortPutProfit) {
		this.shortPutProfit = shortPutProfit;
	}
	
	public void setMap(Map<Double, Double> resultMap, POSITION_TYPE type){
		switch(type){
		case LONG_CALL:
			this.setLongCallProfit(resultMap.getOrDefault(this.getMark(), (DEFAULT_VALUE)));
			break;
		case SHORT_CALL:
			this.setShortCallProfit(resultMap.getOrDefault(this.getMark(), (DEFAULT_VALUE)));
			break;
		case LONG_PUT:
			this.setLongPutProfit(resultMap.getOrDefault(this.getMark(), (DEFAULT_VALUE)));
			break;
		case SHORT_PUT:
			this.setShortPutProfit(resultMap.getOrDefault(this.getMark(), (DEFAULT_VALUE)));
			break;
		default:
			break;
		}
	}
	
	public Double getNetProfit(){
		if(this.getLongCallProfit().equals(DEFAULT_VALUE) || this.getShortCallProfit().equals(DEFAULT_VALUE) 
				|| this.getLongPutProfit().equals(DEFAULT_VALUE) || this.getShortPutProfit().equals(DEFAULT_VALUE)){
			throw new IllegalArgumentException();
		}
		
		return Double.sum(Double.sum(this.getLongCallProfit(), this.getShortCallProfit()), Double.sum(this.getLongPutProfit(), this.getShortPutProfit()));
	}

	@Override
	public String toString() {
		if(!this.isPopulated()){
			return null;
		}
		StringBuilder sb = new StringBuilder(this.getMark().toString());
		appendDouble(sb, this.getLongCallProfit());
		appendDouble(sb, this.getShortCallProfit());
		appendDouble(sb, this.getLongPutProfit());
		appendDouble(sb, this.getShortPutProfit());
		appendDouble(sb, this.getNetProfit());
		return sb.toString();
	}
	
	private void appendDouble(StringBuilder sb, Double d){
		sb.append(",");
		sb.append(d.toString());
	}

	@Override
	public boolean isPopulated() {
		if(this.getLongCallProfit()==null){
			return false;
		}
		
		if(this.getShortCallProfit()==null){
			return false;
		}
		
		if(this.getLongPutProfit()==null){
			return false;
		}
		
		if(this.getShortPutProfit()==null){
			return false;
		}
		
		if(this.getMark()==null){
			return false;
		}
		return true;
	}

	@Override
	public String getRowHeader() {
		return this.ROW_HEADER;
	}
	
	
}
