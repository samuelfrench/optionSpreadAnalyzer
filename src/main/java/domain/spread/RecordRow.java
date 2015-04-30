package domain.spread;

public abstract class RecordRow {
	private Double mark;

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public abstract Double getNetProfit();
	
	public abstract boolean isPopulated();
	
	public abstract String toString();
	
	public abstract String getRowHeader();
}
