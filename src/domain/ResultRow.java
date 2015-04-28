package domain;

public class ResultRow {
	private Integer rowId;
	private Double mark;
	private Double profit;
	public Integer getRowId() {
		return rowId;
	}
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	public double getMark() {
		return mark.doubleValue();
	}
	public void setMark(double mark) {
		this.mark = new Double(mark);
	}
	public double getProfit() {
		return profit.doubleValue();
	}
	public void setProfit(double profit) {
		this.profit = new Double(profit);
	}
}
