package domain.json;

public class MarkitQuoteReq {
	private String quote;
	public MarkitQuoteReq(String quote){
		setQuote(quote);
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
}
