/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.maan.admin.bankAcct;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 10-27-2010
 * 
 * XDoclet definition:
 * @struts.form name="bankForm"
 */
public class BankAcctForm extends ActionForm {
	
	private String bankid;
	private String bankname;
	private String bankAcctCode;
	private BigDecimal bankAcctNo;
	private String status;
	private int bankID;
	private String page;
	
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getBankAcctCode() {
		return bankAcctCode;
	}
	public void setBankAcctCode(String bankAcctCode) {
		this.bankAcctCode = bankAcctCode.toUpperCase();
	}

	

	public BigDecimal getBankAcctNo() {
		return bankAcctNo;
	}
	public void setBankAcctNo(BigDecimal bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
	public String getBankid() {
		return bankid;
	}

	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	public int getBankID() {
		return bankID;
	}

	public void setBankID(int bankID) {
		this.bankID = bankID;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
	
}