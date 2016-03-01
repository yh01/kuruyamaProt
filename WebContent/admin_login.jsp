<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<link rel="stylesheet" type="text/css" href="./css/admin_login.css" />
<title>管理者ログイン</title>
</head>
<body>

		<div class="backimg">
		<br>
			<h1>管理者ログイン</h1>




				<div class="form">
					<div class="textFeilds">
						<table>
							<tr>
								<td><h4>　　　　　　　　　　　　　　　ID　　　　　</h4></td>
								<td>：<input type="text" name="mailAddress"></td>
							</tr>
							<tr>
								<td><h4>　　　　　　　　　　　　　　　パスワード　</h4></td>
								<td>：<input type="password" name="password">
								</td>
							</tr>
						</table>
					</div>


					<div class="buttons">

							<br>
							<br>
							<br>


								<button class="btn" type="submit">ログイン</button>
					</div>
				</div>

		</div>


</body>
</html>