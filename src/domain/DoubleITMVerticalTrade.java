package domain;

import domain.Position.OPTION_TYPE;
import domain.Position.POSITION_TYPE;

public class DoubleITMVerticalTrade {
	private Position longCall;
	private Position shortCall;
	private Position longPut;
	private Position shortPut;
	public DoubleITMVerticalTrade(){
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
}
