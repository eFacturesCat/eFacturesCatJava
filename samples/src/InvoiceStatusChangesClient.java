import java.util.ArrayList;

import com.pimefactura.InvoiceStatusChange;
import com.pimefactura.WSInvoiceStatusChange;


public class InvoiceStatusChangesClient {

	private static String akPruebas = "73352031754535436142623350332036413142314c366944643849317231493075322032703863446f344c436e387232503441416e396f32453334413b393435422d315073632d65322d3b3a524d3a336541";
	private static String fromTimeStamp = "2013-01-01";


	public static void main(String[] args) {
		ArrayList<InvoiceStatusChange> listIsc = WSInvoiceStatusChange.getStatusChanges(true,akPruebas,fromTimeStamp, null);
		for (InvoiceStatusChange isc : listIsc) {
			System.out.println(isc.getChangedate() + " - " + isc.getInvoiceid() + " - " + isc.getStatus());			
		}
	}
	
}

