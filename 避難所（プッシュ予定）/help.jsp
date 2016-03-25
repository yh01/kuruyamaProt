<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<title><s:text name = "%{getText('help.title')}"/></title>
<link rel="stylesheet" type="text/css" href="./css/style.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="./css/help.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="js/jquery.bxslider.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/jquery.js"></script>
<script src="js/login.js"></script>
</head>
<body>
	<div id="backimg">
<%-- 	<jsp:include page="/header.jsp" /> --%>
		<div class="main-form">
			<br> <br>
			<h1><s:text name = "help.disply"/></h1>
			<table>
				<tr>
					<th>
						<div
							onclick="obj=document.getElementById('open').style; obj.display=(obj.display=='none')?'block':'none';">
							<a><s:text name = "%{getText('help.question1')}"/></a>
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<div id="open">
							<s:text name = "%{getText('help.answer1')}"/>
							<br>
							<s:text name = "%{getText('help.answer2')}"/>
						</div>
					</td>
				</tr>
				<tr>
					<th>
						<div
							onclick="obj=document.getElementById('open1').style; obj.display=(obj.display=='none')?'block':'none';">
							<a><s:text name = "%{getText('help.question2')}"/></a>
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<div id="open1"><s:text name = "%{getText('help.answer3')}"/></div>
					</td>
				</tr>
				<tr>
					<th>
						<div
							onclick="obj=document.getElementById('open2').style; obj.display=(obj.display=='none')?'block':'none';">
							<a><s:text name = "%{getText('help.question3')}"/></a>
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<div id="open2">
							<s:text name = "%{getText('help.answer4')}"/>
							<br>
							<s:text name = "%{getText('help.answer5')}"/>
						</div>
					</td>
				</tr>
				<tr>
					<th>
						<div
							onclick="obj=document.getElementById('open3').style; obj.display=(obj.display=='none')?'block':'none';">
							<a><s:text name = "%{getText('help.question5')}"/></a>
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<div id="open3"><s:text name = "%{getText('help.answer6')}"/></div>
					</td>
				</tr>
				<tr>
					<th>
						<div
							onclick="obj=document.getElementById('open4').style; obj.display=(obj.display=='none')?'block':'none';">
							<a><s:text name = "help.question6"/></a>
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<div id="open4">
							<s:text name="%{getText('help.answer7')}" />
							<br>
							<s:text name="%{getText('help.answer8')}" />
						</div>
					</td>
				</tr>
				<tr>
					<th>
						<div
							onclick="obj=document.getElementById('open5').style; obj.display=(obj.display=='none')?'block':'none';">
							<a><s:text name = "%{getText('help.question7')}"/></a>
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<div id="open5"><s:text name = "%{getText('help.answer9')}"/></div>
					</td>
				</tr>
				<tr>
					<th>
						<div
							onclick="obj=document.getElementById('open6').style; obj.display=(obj.display=='none')?'block':'none';">
							<a><s:text name = "%{getText('help.question8')}"/></a>
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<div id="open6"><s:text name = "%{getText('help.answer10')}"/></div>
					</td>
				</tr>
			</table>
		</div>
		<s:form action="ContactAction" style="display: inline">
			<div class="fields">
				<h2><s:text name = "%{getText('help.form')}"/></h2>
				<font color="red"><s:text name = "%{getText('help.form_ans')}"/><br>
				<s:property value="insertCheckMessage" />
				<s:fielderror><s:param value="%{'formAddress'}"/></s:fielderror>
				<s:fielderror><s:param value="%{'formContents'}"/></s:fielderror>
				</font>
				<table>
					<tr>
						<td><label for="name"><s:text name="%{getText('help.form_name')}"></s:text></label></td>
						<td><s:textfield name="formName" cssClass="textarea"></s:textfield>
						</td>
					</tr>
					<tr>
						<td><label for="mail"><s:text name="%{getText('help.form_mail')}"></s:text></label></td>
						<td><s:textfield name="formAddress" cssClass="textarea"></s:textfield>
						</td>
					<tr>
						<td><label for="msg"><s:text name="%{getText('help.form_content')}"></s:text></label></td>
						<td><s:textarea name="formContents" cssClass="textarea1" cols="30" wrap="hard"></s:textarea>
						</td>
				</table>
			</div>
			<div align="center">
				<s:submit cssClass="btn" type="button" value="%{getText('help.transmission')}" />
			</div>
		</s:form>
		<br> <br> <br>
<%-- 	<jsp:include page="/footer.jsp" /> --%>
	</div>
	<br>
	<br>
</body>
</html>
