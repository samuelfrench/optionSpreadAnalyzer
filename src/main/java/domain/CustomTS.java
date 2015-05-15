package domain;

public class CustomTS {
	private int minute;
	private int hour;
	private int day;
	private int year;
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public CustomTS(long l, long m, long n, long o) {
		super();
		this.minute = (int) l;
		this.hour = (int)m;
		this.day =(int) n;
		this.year = (int)o;
	}
}
