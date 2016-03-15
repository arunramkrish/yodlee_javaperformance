package com.yodlee.oldio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionLog {
	private static final SimpleDateFormat TXN_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	private Date timestamp;
	private String txnId;
	private String txnType;
	private Double amount;
	private String remarks;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public TransactionLog(Date timestamp, String txnId, String txnType, Double amount, String remarks) {
		super();
		this.timestamp = timestamp;
		this.txnId = txnId;
		this.txnType = txnType;
		this.amount = amount;
		this.remarks = remarks;
	}
	public TransactionLog() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return TXN_DATE_FORMAT.format(timestamp) + ", " + txnId + ", " + txnType + ", " + amount + ", " + remarks;
	}

	public static TransactionLog readCsv(String csvTxnLog) {
		String[] fields = csvTxnLog.split(",");
		try {
			return parseFields(fields);
		} catch (NumberFormatException | ParseException e) {
			e.printStackTrace();
			return new TransactionLog();
		}
	}
	public static TransactionLog parseFields(String[] fields) throws ParseException {
		return new TransactionLog(TXN_DATE_FORMAT.parse(fields[0]), fields[1], fields[2], Double.parseDouble(fields[3]), fields[4]);
	}
}
