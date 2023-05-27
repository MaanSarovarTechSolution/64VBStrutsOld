/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.maan.admin.bankAcct;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;



import com.maan.common.LogManager;
import com.maan.common.exception.CommonBaseException;


/** 
 * MyEclipse Struts
 * Creation date: 10-27-2010
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="addBankAcct" path="/WEB-INF/jsp/BankAcct/addNewBankAcct.jsp"
 */
public class BankAcctDispatchAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
	ActionForward forward;
	private final static String PATH="bankAcct";
	private final static String LIST="list";
	private final static String SHOW="show";
	
	public ActionForward newBankAcct(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws CommonBaseException
	{
		LogManager.push("Enter Into newBankAcct() Method");
		final ArrayList list;
		final BankAcctForm vbean = (BankAcctForm)form;
		final BankAcctCB sCB=new BankAcctCB();
		
		list=(ArrayList) sCB.getBankAcctDetails();
		
		request.setAttribute(LIST,list);

		request.setAttribute(SHOW,"DisplayBankAcct");
		
		forward = mapping.findForward(PATH);
				return forward;
	}
	
	
	public ActionForward addNewBankAcct(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws CommonBaseException
			{
		        LogManager.push("enter into AddNewBankAcct() method");
		        final BankAcctForm vbean = (BankAcctForm)form;
		        final BankAcctCB bCB = new BankAcctCB();
				final Map bankList = bCB.getBankList();
		        vbean.setBankid("0");
		        vbean.setBankAcctCode("");
		        vbean.setBankAcctNo(null);
		        vbean.setStatus("N ");
		    	request.setAttribute("BankList", bankList);
		        request.setAttribute(SHOW,"showAddPage");
			    forward=mapping.findForward(PATH);
		        LogManager.push("exit  AddNewBankAcct() method");
		        return forward;
		 	}
	
	public ActionForward insertNewBankAcct(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws CommonBaseException
	{
		LogManager.push("Enter into insertNewBankAcct() method");
		BankAcctForm sform=(BankAcctForm) form;
		final BankAcctVB sVB=new BankAcctVB();
		final BankAcctCB sCB=new BankAcctCB();
		final String Bankid=sform.getBankid();
		final String acctcode=sform.getBankAcctCode();
		final BigDecimal acctno=sform.getBankAcctNo();
		final String active=sform.getStatus();
		ActionErrors errors = new ActionErrors();
		errors = validation(Bankid, "bname", errors);
		errors = validation(acctcode, "acctcode", errors);
		errors = validation(acctno, "acctno", errors);
		errors = validation(active, "active", errors);
	    final Map bankList = sCB.getBankList();
	 
		request.setAttribute("BankList", bankList);
	       
		if(errors.isEmpty())
		{
			sVB.setBankid(Bankid);
			sVB.setBankAcctCode(acctcode);
			sVB.setBankAcctNo(acctno);
			sVB.setStatus(active);
			final int result=sCB.insertBankAcctDetails(sVB);
			if(result==2)
			{
				errors.add("",new ActionError("error.bankacct.exists"));
				saveMessages(request, errors);
				saveErrors(request, errors);
				request.setAttribute(SHOW,"showAddPage");
			}
			else
			{
			LogManager.push("final result------------>"+result);
			final ArrayList list;
			list=(ArrayList) sCB.getBankAcctDetails();
			request.setAttribute(LIST,list);
			request.setAttribute(SHOW,"DisplayBankAcct");
			}
			
		}
		else
		{
			
		   	saveMessages(request, errors);
			saveErrors(request, errors);
			request.setAttribute(SHOW,"showAddPage");
		}
		
		  forward=mapping.findForward(PATH);
			
		LogManager.push("end insertNewBankAcct() method");
		 
		return forward;
	}
	
	public ActionForward getEdit(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws CommonBaseException
	{

		LogManager.push("Enter into getEdit() method in Action");
		String Bankid=request.getParameter("bankAcctCode")==null?"":request.getParameter("bankAcctCode");
		BankAcctCB sCB=new BankAcctCB();
		final BankAcctVB sVB=new BankAcctVB();
		BankAcctForm sform=(BankAcctForm) form;
		final Map bankList = sCB.getBankList();
		request.setAttribute("BankList", bankList);
		final List list;
		 list=(List)sCB.getEditBankAcctDetails(Bankid);
		 Map mp;
		 mp=(Map)list.get(0);
			
		 sform.setBankid((String)mp.get("BANK_ID")+"");
		 sform.setBankAcctNo((BigDecimal)mp.get("BANK_ACCOUNT_NUMBER"));
		 sform.setBankAcctCode((String)mp.get("BANK_ACCOUNT_CODE")+"");
		 sform.setStatus((String)mp.get("STATUS"));
		 LogManager.push("Radio- acct>>>"+(String)mp.get("STATUS"));
		 request.setAttribute(SHOW,"edit");
		 mapping.findForward(PATH);
		 
		
		LogManager.push("EXIT getEdit() method in Action");
		return forward;
	}
	public ActionForward updateBankAcct(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws CommonBaseException
			{
		
				LogManager.push("enter updateBankAcct () method");
				String BankAcctid=request.getParameter("bankAcctCode")==null?"":request.getParameter("bankAcctCode");
				BankAcctForm sform =(BankAcctForm) form;
				final BankAcctVB sVB=new BankAcctVB();
				final BankAcctCB sCB=new BankAcctCB();
				final ArrayList list;
				final Map bankList = sCB.getBankList();
				request.setAttribute("BankList", bankList);
				
				final String Bankid=sform.getBankid();
				final String acctcode=sform.getBankAcctCode();
				final BigDecimal acctno=sform.getBankAcctNo();
				final String active=sform.getStatus();
				ActionErrors errors = new ActionErrors();
				errors = validation(Bankid, "bname", errors);
				errors = validation(acctcode, "acctcode", errors);
				errors = validation(acctno, "acctno", errors);
				errors = validation(active, "active", errors);
				
				if(errors.isEmpty())
				{
					sVB.setBankid(Bankid);
					sVB.setBankAcctCode(acctcode);
					sVB.setBankAcctNo(acctno);
					sVB.setStatus(active);
					final int result=sCB.updateBankAcctDetails(sVB,BankAcctid);
					LogManager.push("Update result->>>>>"+result);
					list=(ArrayList) sCB.getBankAcctDetails();
					request.setAttribute(LIST,list);
					LogManager.push("final result------------>"+result);
					request.setAttribute(SHOW,"DisplayBankAcct");
					
					
				}
				else
				{
					saveMessages(request, errors);
					saveErrors(request, errors);
					request.setAttribute(SHOW,"edit");
				}
				
				
				forward = mapping.findForward(PATH);
				LogManager.push("end insertNewBankAcct() method");
					 
	            return forward;
			}
	 private ActionErrors validation(final String value, final String field,
			final ActionErrors errors) {
		try {
			LogManager.push("BankAcctForm Controller validation method() - Enter");

			if (value == null || value.length() < 1
					|| value.equalsIgnoreCase("Select")) {
				errors.add(field, new ActionError("error.bankacct." +field+ ".required"));
			}

		} catch (Exception e) {
			LogManager.debug(e);

		} finally {
			LogManager.debug("BankAcctForm Controller validation- Exit");
			LogManager.popRemove();
		}

		return errors;
	}
	 private ActionErrors validation(final BigDecimal value, final String field,
				final ActionErrors errors) {
			try {
				LogManager.push("BankAcctForm Controller validation method() - Enter");

				if (value == null) {
					errors.add(field, new ActionError("error.bankacct." +field+ ".required"));
				}

			} catch (Exception e) {
				LogManager.debug(e);

			} finally {
				LogManager.debug("BankAcctForm Controller validation- Exit");
				LogManager.popRemove();
			}

			return errors;
		}
	
	
}