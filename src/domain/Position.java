package domain;

public class Position {
	
	public enum POSITION_TYPE {
	    LONG, SHORT
	}
	
	public enum OPTION_TYPE {
		CALL, PUT
	}

	private Double strikePrice;
	private Double purchasePrice;
	private Double approxCommissionsTotal; //this is as a pair,
			//so a vertical spread would have each of it's trades hold the base+ the per contract trade of both
	//private Boolean 
	private OPTION_TYPE type;
	private POSITION_TYPE position;
	
	public Double getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(Double strikePrice) {
		this.strikePrice = strikePrice;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public Double getApproxCommissionsTotal() {
		return approxCommissionsTotal;
	}
	public void setApproxCommissionsTotal(Double approxCommissionsTotal) {
		this.approxCommissionsTotal = approxCommissionsTotal;
	}
	
	//does not include commissions
	public Double profitAtMark(Double mark){
		//long call
		if(position == POSITION_TYPE.LONG){
			if(type == OPTION_TYPE.CALL){
				Double initialProfit;
				if(strikePrice < mark){
					initialProfit = mark - strikePrice;
				} else {
					initialProfit = new Double(0);
				}
				return new Double(initialProfit.doubleValue() - purchasePrice.doubleValue());
			} else { //long put
				
			}
			
		}
		
		
		
		
		//short call
		
		//short put
	}
	public OPTION_TYPE getType() {
		return type;
	}
	public void setType(OPTION_TYPE type) {
		this.type = type;
	}
	public POSITION_TYPE getPosition() {
		return position;
	}
	public void setPosition(POSITION_TYPE position) {
		this.position = position;
	}
	
	
}
