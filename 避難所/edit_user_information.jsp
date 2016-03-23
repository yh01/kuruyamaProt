
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><s:text name="%{getText('edit_user.title')}" /></title>
<link rel="stylesheet" type="text/css" href="./css/style.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="./css/edit_user.css">
</head>
<body>

	<script>
		function checkPassword(e) {
			pass = document.getElementById("password");
			pass1 = document.getElementById("reTypePassword");
			if (e.checked) {
				pass.setAttribute("type", "text");
				pass1.setAttribute("type", "text");
			} else {
				pass.setAttribute("type", "password");
				pass1.setAttribute("type", "password")
			}
		}
	</script>
	<div id="backimg">
<%-- 	<jsp:include page="/header.jsp" /> --%>
		<br> <br> <br>
		<h1>
			<s:text name="%{getText('edit_user.title')}" />
		</h1>
		<br> <br>
		<s:form action="EditUserInformationAction">
			<div class="form">

				<p>
					<span>※</span>
					<s:text name="%{getText('edit_user.indispensable')}" />
					<br>
					<s:text name="%{getText('edit_user.impossible_name')}" />
				</p>
				<br> <br><br> <br>
				<table>
					<tr>
						<td><span>※</span> <s:text
								name="%{getText('edit_user.password1')}" /></td>
					</tr>
					<tr>
						<td><s:password type="password" id="password" name="password" /></td>
						<s:fielderror>
							<s:param value="%{'password'}" />
						</s:fielderror>
					</tr>
				</table>
				<br>
				<table>
					<tr>
						<td><span>※</span> <s:text
								name="%{getText('edit_user.password2')}" /></td>
					</tr>
					<tr>
						<td><s:password type="password" id="reTypePassword"
								name="reTypePassword" /><br></td>
						<s:fielderror>
							<s:param value="%{'reTypePassword'}" />
						</s:fielderror>
					</tr>

				</table>
				<br> <input type="checkbox" onclick="checkPassword(this)" />
				<s:text name="%{getText('edit_user.indicated')}" />
				<br>
				<table>
					<tr>
						<td><h4>
								<s:text name="%{getText('edit_user.used_ID')}" />
							</h4></td>
					</tr>
				</table>
				<table>
					<tr>
						<td><span>※</span>
						<s:text name="%{getText('edit_user.mail_address1')}" /></td>
					</tr>
					<tr>
						<td><s:textfield name="email" /></td>
						<s:fielderror>
							<s:param value="%{'email'}" />
						</s:fielderror>
					</tr>
				</table>
				<br>
				<table>
					<tr>
						<td><span>※</span>
						<s:text name="%{getText('edit_user.mail_address2')}" /></td>
					</tr>
					<tr>
						<td><s:textfield name="reTypeEmail" /></td>
						<s:fielderror>
							<s:param value="%{'reTypeEmail'}" />
						</s:fielderror>
					</tr>

				</table>
				<table>
					<tr>
						<td><span>※</span>
						〒 <s:text name="%{getText('edit_user.address1')}" /></td>
					</tr>
					<tr>
						<td><s:textfield name="postalCode" /></td>
						<s:fielderror>
							<s:param value="%{'postalCode'}" />
						</s:fielderror>

					</tr>
				</table>
				<table>
					<tr>
						<td><span>※</span>
						<s:text name="%{getText('edit_user.address2')}" /></td>
					</tr>
					<tr>
						<td><s:textfield name="address" /></td>
						<s:fielderror>
							<s:param value="%{'address'}" />
						</s:fielderror>
					</tr>
				</table>
			</div>
			<br>
			<br>
			<br>
			<div align="center">

				<button class="btn" type="submit"><s:text name="%{getText('edit_user.fixation')}" /></button>

			</div>
			<br>
			<br>
			<br>
		</s:form>
<%-- 	<jsp:include page="/footer.jsp" /> --%>
	</div>
</body>
</html>
