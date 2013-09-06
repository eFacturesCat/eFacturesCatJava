package com.pimefactura;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class WSInvoiceStatusChange {
	
	public static ArrayList<InvoiceStatusChange> getStatusChanges(boolean isPrepro, String ak, String fromTS, String toTS) {
		String defaultPassword = "2d52737b3e94b99b0f6f5a58c4a42f81"; //Siempre es el mismo

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		client.addFilter(new HTTPBasicAuthFilter(ak, defaultPassword));  
		
		WebResource service = client.resource(getBaseURIWS(isPrepro, fromTS, toTS));
		String  response = service.get(String.class);
		System.out.println(response);
		try {
			ArrayList<InvoiceStatusChange> listIsc;
			TypeFactory typeFactory = TypeFactory.defaultInstance();
			listIsc = new ObjectMapper().readValue(response, typeFactory.constructCollectionType(ArrayList.class, InvoiceStatusChange.class));
			return listIsc;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private static URI getBaseURIWS(boolean isPrepro, String fromTS, String toTS) {
		String preUrl = "http://new.pimefactura.com/statuschanges";
		String proUrl = "https://www.pimefactura.com/statuschanges";
		String baseURL = proUrl;
		if (isPrepro)
			baseURL = preUrl;

		String url;
		try {
			url = baseURL + "?fromTS=" + URLEncoder.encode(fromTS,"UTF-8");
	        if (!isStringEmptyOrNull((toTS)))
	            url = url + "&toTS=" + URLEncoder.encode(toTS,"UTF-8");
			return UriBuilder.fromUri(url).build();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private static boolean isStringEmptyOrNull(String input){
        if (input == null || input.length() == 0){
            return true;
        }
        return false;
    }
}
