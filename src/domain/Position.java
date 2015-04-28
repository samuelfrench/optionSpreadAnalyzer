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

	public Position(double numberOfContracts,
			double strikePrice, double purchasePrice, OPTION_TYPE type,
			POSITION_TYPE position) {
		super();
		this.numberOfContracts = numberOfContracts;
		this.strikePrice = strikePrice;
		this.purchasePrice = purchasePrice;
		this.type = type;
		this.position = position;
	}

	public enum POSITION_TYPE {
		LONG, SHORT
	}

	public enum OPTION_TYPE {
		CALL, PUT
	}

	private double numberOfContracts;
	private double strikePrice;
	private double purchasePrice; // make negative for short calls
	
	private OPTION_TYPE type;
	private POSITION_TYPE position;

	public double profitAtMark(double mark)
			throws Exception {

		final String BAD_FLOW = "Exception: an unexpected flow of execution has occurred.";

		// long call
		if (position == POSITION_TYPE.LONG) {
			if (type == OPTION_TYPE.CALL) {
				double initialProfit = -purchasePrice;
				if (strikePrice < mark) {
					initialProfit = initialProfit + (mark - strikePrice);
				}
				return initialProfit * this.getNumberOfContracts();
//return applyCommissions(commissions, getTotal(initialProfit));
			} else { // long put
				double initialProfit = -purchasePrice;
				if (strikePrice > mark) {
					initialProfit = initialProfit + (strikePrice - mark);
				}
                                return initialProfit * this.getNumberOfContracts();
//return applyCommissions(commissions, getTotal(initialProfit));
			}
		}

		// else if position is short
		if (position == POSITION_TYPE.SHORT) {
			//double initialProfit = purchasePrice;
			double subTotal;

			// short call
			if (type == OPTION_TYPE.CALL) {
				if (mark > strikePrice) {
					subTotal = purchasePrice - (mark - strikePrice);
				} else {
					subTotal = purchasePrice;
				}
				return subTotal*this.getNumberOfContracts();
			}

			// else short put
			if (type == OPTION_TYPE.PUT) {
				if (mark < strikePrice) {
					subTotal = purchasePrice - (strikePrice - mark);
				} else {
					subTotal = purchasePrice;
				}
                                return subTotal*this.getNumberOfContracts();
			}
		}
		throw new Exception(BAD_FLOW);
	}

	private double getTotal(double sub) {
		return (sub * (this.getNumberOfContracts() * 100));
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

	public double getNumberOfContracts() {
		return numberOfContracts;
	}

	public void setNumberOfContracts(double numberOfContracts) {
		this.numberOfContracts = numberOfContracts;
	}

}
