package domain;

import java.util.Date;

public class HistoricalDataRecord {
    
    private Long id;
    private String date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;
    private Double adjVolume;
    private String ticker;

    public HistoricalDataRecord(){
	
    }

    public HistoricalDataRecord(Long id, Double open, Double high,
	    Double low, Double close, Double volume, Double adjVolume) {
	super();
	this.id = id;
	this.open = open;
	this.high = high;
	this.low = low;
	this.close = close;
	this.volume = volume;
	this.adjVolume = adjVolume;
    }
    
    public HistoricalDataRecord(Long id, String date, Double open,
	    Double high, Double low, Double close, Double volume,
	    Double adjVolume, String ticker) {
	super();
	this.id = id;
	this.date = date;
	this.open = open;
	this.high = high;
	this.low = low;
	this.close = close;
	this.volume = volume;
	this.adjVolume = adjVolume;
	this.ticker = ticker;
    }
    
    /**
     * @return the date
     */
    public Long getId() {
	return id;
    }
    /**
     * @param l the date to set
     */
    public void setId(long l) {
	this.id = l;
    }
    /**
     * @return the date
     */
    public String getDate() {
	return date;
    }
    /**
     * @param date the date to set
     */
    public void setDate(String date) {
	this.date = date;
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
    public Double getAdjVolume() {
	return adjVolume;
    }
    /**
     * @param adjClose the adjClose to set
     */
    public void setAdjVolume(Double adjVolume) {
	this.adjVolume = adjVolume;
    }
    
    public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String toSQL(){
    	return "INSERT INTO `repo`.`daily_historical` (`date`, `open`, `high`, `low`, `close`, `volume`, `adjusted_volume`, `id`, `ticker`) "
    			+ "VALUES "
    			+ "(" + this.getDate() + ", "
    			+ this.getOpen() +  ", "
    			+ this.getHigh() + ", "
    			+ this.getLow() + ", "
    			+ this.getClose() + ", "
    			+ this.getVolume() + ", "
    			+ this.getAdjVolume() + ", "
    			+ this.getId() + ", "
    			+ "'" + this.getTicker() + "')";
    }
}
