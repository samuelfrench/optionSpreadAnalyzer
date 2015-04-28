package domain;

public class Position {

	public Position() {
		// TODO
	}

	public Position(POSITION_TYPE position, OPTION_TYPE type) {
		super();
		this.type = type;
		this.position = position;
	}

	public Position(double strikePrice, double purchasePrice) {
		super();
		this.strikePrice = strikePrice;
		this.purchasePrice = purchasePrice;
	}

	public Position(Integer numberOfContracts, Integer totalSpreadTrades,
			double strikePrice, double purchasePrice,
			double approxCommissionsTotal, OPTION_TYPE type,
			POSITION_TYPE position) {
		super();
		this.numberOfContracts = numberOfContracts;
		this.totalSpreadTrades = totalSpreadTrades;
		this.strikePrice = strikePrice;
		this.purchasePrice = purchasePrice;
		this.approxCommissionsTotal = approxCommissionsTotal;
		this.type = type;
		this.position = position;
	}

	public enum POSITION_TYPE {
		LONG, SHORT
	}

	public enum OPTION_TYPE {
		CALL, PUT
	}

	private Integer numberOfContracts;
	private Integer totalSpreadTrades;
	private double strikePrice;
	private double purchasePrice; // make negative for short calls
	private double approxCommissionsTotal; // this is as a pair,
	// so a vertical spread would have each of it's trades hold the base+ the
	// per contract trade of both
	// private Boolean
	private OPTION_TYPE type;
	private POSITION_TYPE position;

	public double profitAtMark(double mark, boolean commissions)
			throws Exception {

		final String BAD_FLOW = "Exception: an unexpected flow of execution has occurred.";

		// long call
		if (position == POSITION_TYPE.LONG) {
			if (type == OPTION_TYPE.CALL) {
				double initialProfit = 0;
				if (strikePrice < mark) {
					initialProfit = mark - strikePrice;
				} else {
					initialProfit = 0;
				}
				double subTotal = initialProfit - purchasePrice;
				return applyCommissions(commissions, getTotal(subTotal));
			} else { // long put
				double initialProfit = 0;
				if (strikePrice > mark) {
					initialProfit = strikePrice - mark;
				} else {
					initialProfit = 0;
				}
				double subTotal = initialProfit - purchasePrice;
				return applyCommissions(commissions, getTotal(subTotal));
			}
		}

		// else if position is short
		if (position == POSITION_TYPE.SHORT) {
			double initialProfit = purchasePrice;
			double subTotal;

			// short call
			if (type == OPTION_TYPE.CALL) {
				if (mark > strikePrice) {
					subTotal = initialProfit - (mark - strikePrice);
				} else {
					subTotal = initialProfit;
				}
				return applyCommissions(commissions, getTotal(subTotal));
			}

			// else short put
			if (type == OPTION_TYPE.PUT) {
				if (mark < strikePrice) {
					subTotal = initialProfit - (strikePrice - mark);
				} else {
					subTotal = initialProfit;
				}
				return applyCommissions(commissions, getTotal(subTotal));
			}
		}
		throw new Exception(BAD_FLOW);
	}

	private double getTotal(double sub) {
		return (sub * (this.getNumberOfContracts() * 100));
	}

	private double calculatePostCommissions(double subTotal) {
		return subTotal
				- (this.getApproxCommissionsTotal() / this
						.getTotalSpreadTrades());
	}

	/**
	 * @param commissions
	 * @param subTotal
	 * @return
	 */
	private double applyCommissions(boolean commissions, double subTotal) {
		if (commissions) {
			return calculatePostCommissions(subTotal);
		}
		return subTotal;
	}

	// accessors

	public double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(double strikePrice) {
		this.strikePrice = strikePrice;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getApproxCommissionsTotal() {
		return approxCommissionsTotal;
	}

	public void setApproxCommissionsTotal(double approxCommissionsTotal) {
		this.approxCommissionsTotal = approxCommissionsTotal;
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

	public double getTotalSpreadTrades() {
		return totalSpreadTrades.doubleValue();
	}

	public void setTotalSpreadTrades(Integer totalSpreadTrades) {
		this.totalSpreadTrades = totalSpreadTrades;
	}

	public double getNumberOfContracts() {
		return numberOfContracts.doubleValue();
	}

	public void setNumberOfContracts(Integer numberOfContracts) {
		this.numberOfContracts = numberOfContracts;
	}

}
