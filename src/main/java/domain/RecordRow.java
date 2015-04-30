package domain;

public abstract class RecordRow {
	private Double mark;

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}
	
	public abstract String toString();
	
	public abstract boolean isPopulated();
}
