<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理者画面　購入履歴</title>
<link rel="stylesheet" type="text/css" href="./css/admin_purchase_history.css">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" href="././css/bootstrap.css">
<script type="text/javascript" src="./js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="./js/jPages.js"></script>

</head>
<body>
<script>
$(function(){
	$(".List").jPages({
		containerID : "CList",
            previous : "← ", //前へのボタン
        	    next : " →", //次へのボタン
        	    	perPage : 5, //1ページに表示する個数
                    	delay : 1, //要素間の表示速度
                    		animation: "pulse" //アニメーションAnimate.cssを参考に

    });
});
</script>
<div id="backimg">
	<div id="site-box">
		<div id="a-box">
			<h2>管理者画面</h2>
			<s:form action="AdminGoEditItemProductAction" style="display: inline">
				<s:submit type="button" value="商品編集" />
			</s:form>
			<s:form action="AdminGoEditUserAction" style="display: inline">
				<s:submit type="button" value="ユーザー編集" />
			</s:form>
			<s:form action="AdminGoPurchaseHistoryAction" style="display: inline">
				<s:submit type="button" value="購入履歴" />
			</s:form>
			<s:form action="AdminGoInquiryAction" style="display: inline">
				<s:submit type="button" value="問い合わせ" />
			</s:form>
			<s:form action="AdminLogoutAction" style="display: inline">
				<s:submit type="button" value="ログアウト" />
			</s:form>
		</div>
		<div id="c-box">
			<h3>購入履歴</h3>
				<ul style="float: right; list-style: none;">
					<s:form action="SearchPurchaseHistoryWithUserAction">
					<li style="float: right;"><s:textfield name="userId" placeholder="ユーザーIDを入力してください"/><button type="submit">検索</button></li>
					</s:form>

					<s:form action="SearchPurchaseHistoryWithItemAction">
					<li style="float: right;"><s:textfield name="itemName" placeholder="商品名を入力してください"/><button type="submit">検索</button></li>
					</s:form>

					<s:form action="SearchPurchaseHistoryWithDateAction">
					<li style="float: right;">
						20
						<s:select name="year"
							list="#{'':'','2016':'16','2017':'17','2018':'18','2019':'19','2020':'20','2021':'21','2022':'22'}"/>年
						<s:select name="month"
							list="#{'':'','01':'1','02':'2','03':'3','04':'4','05':'5','06':'6','07':'7','08':'8','09':'9','10':'10','11':'11','12':'12'} " />月
						<s:select name="day"
							list="#{'':'','01':'1','02':'2','03':'3','04':'4','05':'5','06':'6','07':'7','08':'8','09':'9','10':'10','11':'11','12':'12','13':'13','14':'14','15':'15','16':'16'
									,'17':'17','18':'18','19':'19','20':'20','21':'21','22':'22','23':'23','24':'24','25':'25','26':'26','27':'27','28':'28','29':'29','30':'30','31':'31'} " />日
					<button type="submit">検索</button>
					</li>
					</s:form>
				</ul>
					<table>
						 <thead>
							<tr>
								<th>購入ID</th>
								<th>ユーザーID</th>
								<th>商品名</th>
								<th>個数</th>
								<th>購入日</th>
								<th>郵便番号</th>
								<th>住所</th>
							</tr>
						</thead>

						<tbody id="CList">
							<s:iterator value="historyList">
								<tr>
									<td><s:property value="salesId" /></td>
									<td><s:property value="userId" /></td>
									<td><s:property value="itemName" /></td>
									<td><s:property value="NumberOfItem" /></td>
									<td><s:property value="dateTime" /></td>
									<td><s:property value="postalCode" /></td>
									<td><s:property value="Address" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<br>
				<div class="List"></div>
		</div>
	</div>
</div>
</body>
</html>
