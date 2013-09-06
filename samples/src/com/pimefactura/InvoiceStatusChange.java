package com.pimefactura;

public class InvoiceStatusChange {
    private String changedate;
    private String ak;
    private String invoiceid;
    private String status;
    private String archivaluri;
    private String whoupdate;
    private String reason;
    private String timestampupdate;
    private String referenceupdate;
    
	public String getChangedate() {
		return changedate;
	}
	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}
	public String getAk() {
		return ak;
	}
	public void setAk(String ak) {
		this.ak = ak;
	}
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getArchivaluri() {
		return archivaluri;
	}
	public void setArchivaluri(String archivaluri) {
		this.archivaluri = archivaluri;
	}
	public String getWhoupdate() {
		return whoupdate;
	}
	public void setWhoupdate(String whoupdate) {
		this.whoupdate = whoupdate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getTimestampupdate() {
		return timestampupdate;
	}
	public void setTimestampupdate(String timestampupdate) {
		this.timestampupdate = timestampupdate;
	}
	public String getReferenceupdate() {
		return referenceupdate;
	}
	public void setReferenceupdate(String referenceupdate) {
		this.referenceupdate = referenceupdate;
	}
	
	public InvoiceStatusChange() {
		
	}

	public InvoiceStatusChange(
	     String changedate,
	     String ak,
	     String invoiceid,
	     String status,
	     String archivaluri,
	     String whoupdate,
	     String reason,
	     String timestampupdate,
	     String referenceupdate) {
		
	    this.changedate = changedate;
	    this.ak = ak;
	    this.invoiceid = invoiceid;
	    this.status = status;
	    this.archivaluri = archivaluri;
	    this.whoupdate = whoupdate;
	    this.reason = reason;
	    this.timestampupdate = timestampupdate;
	    this.referenceupdate = referenceupdate;

		
	}
}
