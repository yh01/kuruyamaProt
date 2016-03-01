<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>ユーザー編集</title>
	 <link rel="stylesheet" type="text/css" href="./css/admin_custmor.css">
     <link rel="stylesheet" href="././css/animate.css">
     <link rel="stylesheet" href="././css/style.css">
 </head>
	<body>
	<div id="site-box">
	<div id="backimg">
	<div id="title">

	<h2>管理者画面</h2>
		 <input type="button" value="商品編集" onclick="history.back()">
		 <input type="button" value="ユーザー編集" onclick="history.back()">
		 <input type="button" value="購入履歴" onclick="history.back()">
		  <input type="button" value="問い合わせ" onclick="history.back()">
		 <input type="button" value="ログアウト" onclick="history.back()">
   <div id="c-box">
      <h3>ユーザー編集</h3>
      <ul style="list-style:none">
      </ul><br>
      <ul style="list-style:none">
          <li style="float:right"> <input type="button" value="検索" onclick="history.back()"> </li>
          <li style="float:right"> <input type="text" name="cardonum" size="23" value="ユーザー名"></li>
      </ul><br>
      <ul style="list-style:none">
          <li style="float:right"> <input type="button" value="削除" onclick="history.back()"> </li>
          <li style="float:right"> <input type="text" name="cardonum" size="23" value="ID"></li>
            <br>
        </div>
            <br>
     <table>
         <thead>
          <tr>
            <th>ユーザーID</th>
            <th>パスワード</th>
            <th>氏名</th>
            <th>メールアドレス</th>
            <th>住所</th>
            <th>電話番号</th>
         </tr>
         </thead>
         <tbody>
          <tr>
            <td>1</td>
            <td>tanakatarou</td>
            <td>田中太郎</td>
            <td>×××@gmail.com</td>
            <td>東京都×××市0-0-0×××マンション109号室</td>
            <td>×××-×××-×××</td>
			</tr>
           </tbody>
        </table>
        <div id="List1">← 1 2 3 4 →</div>
      </div>
    </div>
    </div>
</body>
</html>