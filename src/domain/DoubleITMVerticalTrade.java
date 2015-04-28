package domain;

import domain.Position.OPTION_TYPE;
import domain.Position.POSITION_TYPE;

public class DoubleITMVerticalTrade {
	private Position longCall;
	private Position shortCall;
	private Position longPut;
	private Position shortPut;

	public DoubleITMVerticalTrade() {
		this.setLongCall(new Position(POSITION_TYPE.LONG, OPTION_TYPE.CALL));
		this.setShortCall(new Position(POSITION_TYPE.SHORT, OPTION_TYPE.CALL));
		this.setLongPut(new Position(POSITION_TYPE.LONG, OPTION_TYPE.PUT));
		this.setShortPut(new Position(POSITION_TYPE.SHORT, OPTION_TYPE.PUT));
	}

	public Position getLongCall() {
		return longCall;
	}

	public void setLongCall(Position longCall) {
		this.longCall = longCall;
	}

	public Position getShortCall() {
		return shortCall;
	}

	public void setShortCall(Position shortCall) {
		this.shortCall = shortCall;
	}

	public Position getLongPut() {
		return longPut;
	}

	public void setLongPut(Position longPut) {
		this.longPut = longPut;
	}

	public Position getShortPut() {
		return shortPut;
	}

	public void setShortPut(Position shortPut) {
		this.shortPut = shortPut;
	}

	public double totalProfit(double mark, boolean commissions) {
		return this.getSingleSpread(mark, true, commissions) +
				this.getSingleSpread(mark, false, commissions);
	}

	public double getSingleSpread(double mark, boolean callSpread,
			boolean commissions) {
		try {
			return getSingleSpreadPrivate(mark, callSpread, commissions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	private Double getSingleSpreadPrivate(double mark, boolean callSpread,
			boolean commissions) throws Exception {
            /*System.out.println("long call: " + this.getLongCall()
					.profitAtMark(mark, commissions));
            System.out.println("short call" + this.getShortCall()
					.profitAtMark(mark, commissions));*/
		if (callSpread) {
			return this.getLongCall()
					.profitAtMark(mark, commissions) + this.getShortCall()
					.profitAtMark(mark, commissions);
		} 
		return this.getLongPut().profitAtMark(mark, commissions)+
				this.getShortPut().profitAtMark(mark, commissions);

	}
}
