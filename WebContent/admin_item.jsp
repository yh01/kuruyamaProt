<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<title>管理画面 商品編集</title>
<link rel="stylesheet" href="././css/style.css">
<link rel="stylesheet" href="././css/admin_item.css">

<script type="text/javascript" src="./js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="./js/jPages.js"></script>
<script>
$(function(){
	$(".List").jPages({
		containerID : "CList",
            previous : "←", //前へのボタン
        	    next : "→", //次へのボタン
        	    	perPage : 5, //1ページに表示する個数
                    	delay : 1, //要素間の表示速度
                    		animation: "pulse" //アニメーションAnimate.cssを参考に

      });
});
</script>






</head>

<body>
<div id = "backimg">
<div id="site-box">
	<div id="a-box">
<h2>管理者画面</h2>
<li style="float: left"><input type="button" value="商品編集" onclick="history.back()"></li>
<li style="float: left"><input type="button" value="ユーザー編集" onclick="history.back()"></li>
<li style="float: left"><input type="button" value="購入履歴" onclick="history.back()"></li>
<li style="float: left"><input type="button" value="問い合わせ" onclick="history.back()"></li>
<li style="float: left"><input type="button" value="ログアウト" onclick="history.back()"></li>
</div>





		<div id="c-box">



			<div id="c-box">
							<br>
				<h3>商品編集</h3>



				<ul style="list-style: none">
				</ul>
				<ul style="list-style: none">
					<li style="float: right"><input type="button" value="商品追加" onclick="history.back()"></li>
				</ul>

				<br>
				<ul style="list-style: none">
					<li style="float: right"><input type="button" value="更新" onclick="history.back()"></li>
					<li style="float: right"><input type="text" name="cardonum" size="9" placeholder="在庫数"></li>
					<li style="float: right"><input type="text" name="cardonum" size="9" placeholder="ID"></li>
				</ul>
				<br>
				<ul style="list-style: none">
					<li style="float: right"><input type="button" value="検索" onclick="history.back()"></li>
					<li style="float: right"><input type="text" name="cardonum" size="23" placeholder="商品名"></li>

				</ul>

				<br>
				<ul style="list-style: none">
					<li style="float: right"><input type="button" value="削除" onclick="history.back()"></li>
					<li style="float: right"><input type="text" name="cardonum" size="23" placeholder="商品ID"></li>
				</ul>

			</div>



			<table>
				<thead>
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>カテゴリー</th>
						<th>商品説明</th>
						<th>値段</th>
						<th>在庫</th>
					</tr>
				</thead>

				<tbody id="CList">

						<tr>

								<td>3</td>
								<td>最強厚切りチャーシュー</td>
								<td>トッピング</td>
								<td>自家製最強チャーシューです</td>
								<td>200</td>
								<td>20</td>
						</tr>
												<tr>

								<td>1</td>
								<td>最強とんこつラーメン</td>
								<td>ラーメン</td>
								<td>最強のとんこつラーメンです</td>
								<td>700</td>
								<td>20</td>
						</tr>


				</tbody>
			</table>
		</div>


	<div class="List1">← 1 2 3 4 →</div>
</div>
</div>
</body>
</html>