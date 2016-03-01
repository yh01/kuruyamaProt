<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ユーザー編集</title>
<link rel="stylesheet" href="././css/admin_inquiry.css">
<link rel="stylesheet" href="././css/style.css">
</head>
<body>
<div id="backimg">

    <div id = "site-box">

         <h2>管理者画面</h2>
         <input type="button" value="商品編集" onclick="history.back()">
         <input type="button" value="ユーザー編集" onclick="history.back()">
         <input type="button" value="購入履歴" onclick="history.back()">
         <input type="button" value="ログアウト" onclick="history.back()">

        <div id="c-box"></div>
        <h3>問い合わせ</h3>

        <div id="#">

            <ul style="list-style:none"> </ul>
            <br>

            <ul style="list-style: none">
                <li style="float: right"><input type="button" value="ユーザーの検索" onclick="history.back()"></li>
                <li style="float: right"><input type="text" name="cardonum" size="23" placeholder="ユーザー名を入力"></li>
            </ul>
            <br>

            <ul style="list-style: none">
                <li style="float: right"><input type="button" value="ユーザーの削除" onclick="history.back()"></li>
                <li style="float: right"><input type="text" name="cardonum" size="23" placeholder="IDを入力"></li>
            </ul>
            <ul style="list-style:none">
            </ul>
            <br>
            <br>

            <div class = "Center" >
                <table class = "situmonn" >
                <thead>
                    <tr class = "#" >
                        <th class = "neutral" >ユーザーID</th>
                        <th class = "neutral" >名前</th>
                        <th class = "neutral" >メールアドレス</th>
                        <th class = "long" >内容</th>
                        <th class = "neutral" >登録日</th>
                    </tr>
                </thead>
                    <tr id= "Column_Tr" class="1">
                        <td>10</td>
                        <td>赤坂　一郎</td>
                        <td>
                            ○○○○○○○○○○○○○○○○@gmail.com
                        </td>
                        <td id= "d_left">

                            大変お世話になっております。 株式会社●●●の赤坂です。
                            先日注文につきまして、質問がございます。
                            注文において必要な項目は何がありますでしょうか。
                            以上、お手数をおかけしますが、
                            何卒ご回答の程よろしくお願いいたします。
-->
                        </td>
                        <td>2016/2/4</td>
                    </tr>
                    <tr id= "Column_Tr"class="2" >
                        <td>11</td>
                        <td>井上　太郎</td>
                        <td>●●●●●●●●●●●●●●●●@gmail.com</td>
                        <td id= "d_left">内容</td>
                        <td>2016/2/4</td>
                    </tr>
                    <tr id= "Column_Tr"class="3" >
                        <td>12</td>
                        <td>内田　三郎</td>
                        <td>□□□□□□□□□□□□□□□□@gmail.com</td>
                        <td id= "d_left">内容</td>
                        <td>2016/2/5</td>
                    </tr>
                    <tr id= "Column_Tr" class="4" >
                        <td></td>
                        <td></td>
                        <td></td>
                        <td id= "d_left"></td>
                        <td></td>
                    </tr>
                </table>
                <br>

                <div class="List1">← 1 2 3 4 →</div>
            </div>
        </div>

    </div>
    </div>
</body>
</html>
