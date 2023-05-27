<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <html:base />
    
    <title>addNewBank.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <html:form action="/bankError"   method="POST"  styleId="mainForm">


<logic:equal value="DisplayBankError" name="show">
<table width="100%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td class="header" colspan="4">
				<img src="images/submitcut.gif" width="25" height="26">&nbsp;&nbsp;
				<bean:message key="bankError.heading" />
			</td>	
		</tr>	
		<tr>
			<td colspan="4" align="center">			    
				<html:messages id="message" message="true">
					<li style="color: red;">
						<bean:write name="message" />
					</li>
				</html:messages>
			</td>
		</tr>		
		<tr>
			<td colspan="8">
					<table align="center" width="100%" border="0" cellspacing="0" cellpadding="5">
							<tr class="">
								<td class="">
									<display:table name="list" pagesize="10" requestURI="/bankError.do?method=newBankError" excludedParams="*" class="table" uid="row" id="record">
										<display:setProperty name="paging.banner.one_item_found"   value="" />
										<display:setProperty name="paging.banner.one_items_found"  value="" />
										<display:setProperty name="paging.banner.all_items_found"  value="" />
										<display:setProperty name="paging.banner.some_items_found" value="" />
										<display:setProperty name="paging.banner.placement" value="bottom" />
										<display:setProperty name="paging.banner.onepage" value="" />									   
										<display:column sortable="true" title="Bank Name"  property="bankid" style="width:120px;text-align:center;"/>
										<display:column sortable="true" title="Reason Description"  property="reasondesc" style="width:200px;text-align:left;"/>
										<display:column sortable="true" title="Rejection Type" property="rejectionType" style="width:90px;text-align:left;" />
										<display:column sortable="true" title="Active"  property="active" style="width:60px;text-align:center;"/>
										<display:column style="width:100px;text-align:center;" sortable="true" 	title="Action">
										<a style="color:000000" href="#" onclick="javascript: edit('<bean:write name="record" property="errorid"/>')"/>
										<input type="button" value="Edit" class="button">
										</a>
										</display:column>
									</display:table>
								</td>							
							</tr>								
							<tr>
							   <td align="center">
							   		<input type="button" value="Add New" class="button" onclick="addNewError()" /> 
						      </td>
							</tr>							
					</table>
				</td>
			</tr>		
		<tr>
			<td colspan="3">
				&nbsp;
			</td>
		</tr>
	</table>
	<script>
	
  function addNewError()
  {
     document.mainForm.action="<%=request.getContextPath()%>/bankError.do?method=addNewBankError";
     document.mainForm.submit();
     return false;
  }
	function edit(errorid)
	{
	    var page=<%=request.getParameter("d-446779-p")%>;
	    document.getElementById('page').value=page;
	    document.getElementById('errorid').value=errorid;
	    document.mainForm.action="<%=request.getContextPath()%>/bankError.do?method=getEdit";
	    document.mainForm.submit();
	    return false;
	}
	</script>
	</logic:equal>
	
	<logic:equal name="show" value="showAddPage">		
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td class="header" colspan="4">
				<img src="images/submitcut.gif" width="25" height="26">&nbsp;&nbsp;
				<bean:message key="bankError.heading" />
			</td>	
		</tr>	
		<tr>
			<td colspan="4" align="center">			    
				<html:messages id="message" message="true">
					<li style="color: red;">
						<bean:write name="message"/>
					</li>
				</html:messages>
			</td>
		</tr>		
		<tr  class="tabin">				
				
			<td class="t" align="right">
				<b><bean:message key="admin.bankerror.bankname" /> &nbsp; : </b>
			</td>
			<td align="left" class="t">
				<html:select property="bankid">
				<html:option value="Select">-Select-</html:option>
				<html:optionsCollection name="BankList" label="value" value="key" />
				</html:select>
			</td>
		</tr>
		<tr  class="tabin">
			<td class="t" align="right">
				<b><bean:message key="admin.bankerror.reasondesc" /> &nbsp; : </b>
			</td>
			<td class="t">
				<html:textarea property="reasondesc" styleId="reasondesc" />
			</td>
			
		</tr>
		<tr  class="tabin">
			<td class="t" align="right">
				<b><bean:message key="admin.bankerror.rejectiontype" /> &nbsp; : </b>
			</td>
			<td class="t">
			<html:select property="rejectionType">
				<html:option value="Select">-Select-</html:option>
				<html:optionsCollection name="RejectionTypeList" label="value" value="key" />
				</html:select>
				
			</td>
			
		</tr>
		<tr  class="tabin">
			<td class="t" align="right">
				<b><bean:message key="admin.bankerror.active" /> &nbsp; : </b>
			</td>
			<td class="t" align="left">
				<html:radio  styleId="active"  property="active" value="Y " />
					Yes
				<html:radio styleId="active" property="active" value="N " />
					No
		    </td>
			
		</tr>
        <tr class="tabin">
       		
			<td class="t" colspan="2" align="center">
			   <input type="button" value="Submit" class="button" onclick="insertBankError()" /> 
			   <input type="button" value="Back" class="button" onclick="back1()" /> 
		    </td>
			
		</tr>	
	</table>
	
</logic:equal>
	
<logic:equal name="show" value="edit">
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td class="header" colspan="4">
				<img src="images/submitcut.gif" width="25" height="26">&nbsp;&nbsp;
				<bean:message key="bankError.heading" />
			</td>	
		</tr>	
		<tr>
			<td colspan="4" align="center">			    
				<html:messages id="message" message="true">
					<li style="color: red;">
						<bean:write name="message" />
					</li>
				</html:messages>
			</td>
		</tr>		
		<tr  class="tabin">				
				
			<td class="t" align="right">
				<b><bean:message key="admin.bankerror.bankname" /> &nbsp; : </b>
			</td>
			<td align="left" class="t">
				<html:select property="bankid">
				<html:option value="Select">-Select-</html:option>
				<html:optionsCollection name="BankList" label="value" value="key" />
				</html:select>
			</td>
		</tr>
		<tr  class="tabin">
			<td class="t" align="right">
				<b><bean:message key="admin.bankerror.reasondesc" /> &nbsp; : </b>
			</td>
			<td class="t">
				<html:textarea property="reasondesc" styleId="reasondesc" />
			</td>
			
		</tr>
		<tr  class="tabin">
			<td class="t" align="right">
				<b><bean:message key="admin.bankerror.rejectiontype" /> &nbsp; : </b>
			</td>
			<td class="t">
			<html:select property="rejectionType">
				<html:option value="Select">-Select-</html:option>
				<html:optionsCollection name="RejectionTypeList" label="value" value="key" />
				</html:select>
				
			</td>
			
		</tr>
		<tr  class="tabin">
			<td class="t" align="right">
				<b><bean:message key="admin.bankerror.active" /> &nbsp; : </b>
			</td>
			<td class="t" align="left">
				<html:radio  styleId="active"  property="active" value="Y " />
					Yes
				<html:radio styleId="active" property="active" value="N " />
					No
		    </td>
			
		</tr>
		     <tr class="tabin">
	   			<td class="t" colspan="2" align="center">
							   <input type="button" value="Update" class="button" onclick="updateBankError('<bean:write name='bankErrorForm'   property="errorid"/>')" /> 
							   <input type="button" value="Back" class="button" onclick="back2()" /> 
				    </td>
				</tr>
		</table>
			
	</logic:equal>

	<html:hidden property="errorid" styleId="errorid"/>
	<html:hidden property="page" styleId="page"/>
	</html:form>
  </body>
</html:html>

<script>

 function updateBankError(errorid)
  {
    document.getElementById('errorid').value=errorid;
   //alert(document.getElementById('errorid').value);
     document.mainForm.action="<%=request.getContextPath()%>/bankError.do?method=updateBankError";
     //alert(document.mainForm.action);
     document.mainForm.submit();
     return false;
  }
  function addNewError()
  {
    //alert('hi');
    document.mainForm.action="<%=request.getContextPath()%>/bankError.do?method=insertNewBankError";
    document.mainForm.submit();
    return false;
  }
  function insertBankError()
  {
    //alert('hi');
    document.mainForm.action="<%=request.getContextPath()%>/bankError.do?method=insertNewBankError";
    document.mainForm.submit();
    return false;
  }
function fnCancel(){
document.getElementById("bankid").value="";

document.getElementById("bankname").value="";
document.getElementById("banktable").value="";
document.getElementById("edate").value="";
document.getElementById("active").value="";

}
function back1()
{
window.history.forward();
 document.mainForm.action="<%=request.getContextPath()%>/bankError.do?method=newBankError";
 document.mainForm.submit();
     return false;
}
function back2()
{
 var pageval=document.getElementById('page').value;
window.history.forward();
// alert(pageval);
 document.mainForm.action="<%=request.getContextPath()%>/bankError.do?method=newBankError&d-446779-p="+pageval;
 document.mainForm.submit();
    return false;
}
</script>
