<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="site-box">

		<div id="a-box">

			<h4><s:text name="%{getText('admin_purchase_history_kannri')}"/></h4>

			<s:form action="AdminGoodsDelete" style="display: inline"><s:submit type="button" value="%{getText('admin_purchase_history_goods')}"/></s:form>

            <s:form action="AdminCustomerAction" style="display: inline"><s:submit type="button" value="%{getText('admin_purchase_history_user')}"/></s:form>

			<s:form action="ShowHistoryAction" style="display: inline"><s:submit label="%{getText('admin_purchase_history_buyhistry')}" type="button" /></s:form>
		</div>

		<div id="b-box">

			<s:form action="AdminLogoutAction" style="display: inline"><s:submit label="%{getText('admin_purchase_history_Logout')}" type="button" /></s:form>

		</div>
		<div id="c-box">

			<h2><s:text name="%{getText('admin_purchase_history_buyhis')}"/></h2>

			<ul style="list-style: none">

				<li style="float: right"><s:form action="FindHistoryAction">

						<li style="float: right"><s:select label="select"
								list="#{

										'sales_id':'購入ID',

										 'user_id':'ユーザーID',

										  'item_id':'商品ID',

										     'date':'購入日'
								}"
								name="select" /></li>

						<li style="float: right"><s:textfield name="selectData"
							placeholder="%{getText('admin_purchase_history_input')}">
							</s:textfield></li>
						<br>
						<br>
						<li style="float: right"><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>

						</li>

							<li style="float: right"><s:submit type="button"  value="%{getText('admin_purchase_history_search')}"  />

						</li>
					</s:form></li>
			</ul>
			<br>
			<table>
				<thead>
					<tr>
						<th><s:text name="%{getText('admin_purchase_history_buyid')}"/></th>
						<th><s:text name="%{getText('admin_purchase_history_useid')}"/></th>
						<th><s:text name="%{getText('admin_purchase_history_goodsID')}"/></th>
						<th><s:text name="%{getText('admin_purchase_history_buynum')}"/></th>
						<th><s:text name="%{getText('admin_purchase_history_allsim')}"/></th>
						<th><s:text name="%{getText('admin_purchase_history_date')}"/></th>
					</tr>
				</thead>
				<tbody id="CList">
					<s:iterator value="historyList">
						<tr>
							<td><s:property value="sales_id"></s:property></td>
							<td><s:property value="user_id"></s:property></td>
							<td><s:property value="item_id"></s:property></td>
							<td><s:property value="num_of_tickets"></s:property></td>
							<td><s:property value="amount"></s:property></td>
							<td><s:property value="date"></s:property></td>
						</tr>
					</s:iterator>

				</tbody>
			</table>
		</div>
	</div>
	<div class="List"></div>
</body>
</html>