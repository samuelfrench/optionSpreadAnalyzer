package domain;

import java.util.Date;

public class HistoricalDataRecord {
    
    private Long id;
    private Date dateTime;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;
    private Double adjClose;
    
    public HistoricalDataRecord(Long id, Double open, Double high,
	    Double low, Double close, Double volume, Double adjClose) {
	super();
	this.id = id;
	this.open = open;
	this.high = high;
	this.low = low;
	this.close = close;
	this.volume = volume;
	this.adjClose = adjClose;
    }
    
    public HistoricalDataRecord(Long id, Date dateTime, Double open,
	    Double high, Double low, Double close, Double volume,
	    Double adjClose) {
	super();
	this.id = id;
	this.dateTime = dateTime;
	this.open = open;
	this.high = high;
	this.low = low;
	this.close = close;
	this.volume = volume;
	this.adjClose = adjClose;
    }
    
    /**
     * @return the date
     */
    public Long getId() {
	return id;
    }
    /**
     * @param date the date to set
     */
    public void setId(Long date) {
	this.id = date;
    }
    /**
     * @return the dateTime
     */
    public Date getDateTime() {
	return dateTime;
    }
    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(Date dateTime) {
	this.dateTime = dateTime;
    }
    /**
     * @return the open
     */
    public Double getOpen() {
	return open;
    }
    /**
     * @param open the open to set
     */
    public void setOpen(Double open) {
	this.open = open;
    }
    /**
     * @return the high
     */
    public Double getHigh() {
	return high;
    }
    /**
     * @param high the high to set
     */
    public void setHigh(Double high) {
	this.high = high;
    }
    /**
     * @return the low
     */
    public Double getLow() {
	return low;
    }
    /**
     * @param low the low to set
     */
    public void setLow(Double low) {
	this.low = low;
    }
    /**
     * @return the close
     */
    public Double getClose() {
	return close;
    }
    /**
     * @param close the close to set
     */
    public void setClose(Double close) {
	this.close = close;
    }
    /**
     * @return the volume
     */
    public Double getVolume() {
	return volume;
    }
    /**
     * @param volume the volume to set
     */
    public void setVolume(Double volume) {
	this.volume = volume;
    }
    /**
     * @return the adjClose
     */
    public Double getAdjClose() {
	return adjClose;
    }
    /**
     * @param adjClose the adjClose to set
     */
    public void setAdjClose(Double adjClose) {
	this.adjClose = adjClose;
    }
}
