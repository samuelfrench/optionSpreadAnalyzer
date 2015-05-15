package core.json;

import org.apache.commons.httpclient.HttpClient;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import domain.json.MarkitQuoteReq;

public class QuoteRequestFactory {
	final static String uri = "http://dev.markitondemand.com/Api/v2/Quote";
	public static String createRequestObj(String quote){
		Gson gson = new Gson();
		return gson.toJson(new MarkitQuoteReq(quote));
	}
}
