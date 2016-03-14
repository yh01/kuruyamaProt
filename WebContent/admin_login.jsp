<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<link rel="stylesheet" type="text/css" href="./css/admin_login.css" />
<title><s:text name = "%{getText('admin_login.title')}"/></title>
</head>
<body>
	<div class="backimg">
		<div id="site-box">
			<br>
			<h1><s:text name = "%{getText('admin_login.title')}"/></h1>
			<s:form action="AdminLoginAction" style="display: inline">
				<div id="form">
					<div class="textFeilds">
						<table>
							<tr>
								<td><h4><s:text name = "%{getText('admin_login.ID')}"/></h4></td>
								<td><s:textfield name="adminId" placeholder="%{getText('admin_login.USERNAME')}">：</s:textfield></td>
							</tr>
							<tr>
								<td><h4><s:text name = "%{getText('admin_login.PASSWORD')}"/></h4></td>
								<td><s:textfield name="password" placeholder="%{getText('admin_login.PASSWORD')}">：</s:textfield>
								</td>
							</tr>
						</table>
					</div>
					<div class="buttons">
						<br> <br> <br>
						<s:submit type="button" class="btn btn-default" value="%{getText('admin_login.LOGIN')}" />
					</div>
				</div>
			</s:form>
		</div>
	</div>
</body>
</html>