package domain;

import java.util.Map;

public class HistoricalDataWrapper {
    private Map<Integer,HistoricalDataRecord> dataCollection;
    private String header;
    /**
     * @return the dataCollection
     */
    protected Map<Integer,HistoricalDataRecord> getDataCollection() {
	return dataCollection;
    }

    /**
     * @param dataCollection the dataCollection to set
     */
    protected void setDataCollection(Map<Integer,HistoricalDataRecord> dataCollection) {
	this.dataCollection = dataCollection;
    }
    
    public HistoricalDataRecord getRecordByDateInteger(Integer date){
	if(dataCollection!=null){
	    return getDataCollection().get(date);
	}
	return null;
    }
    
    /**
     * 
     * @param date
     * @param record
     * @param overWrite
     * @return true if exists, false otherwise
     */
    public boolean putRecordById(Integer id, HistoricalDataRecord record, Boolean overWrite){
	if(overWrite){
	    if(getDataCollection().put(id, record)==null){
		return false;
	    }
	    return true;
	}
	if(getDataCollection().get(id)!=null){
	    return true;
	}
	getDataCollection().put(id, record);
	return false;
    }
}
