<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="ROBOTS" content="NOINDEX,NOFOLLOW">
<title>管理画面 商品編集</title>
<link rel="stylesheet" href="././css/style.css">
<link rel="stylesheet" href="././css/admin_item.css">
<link rel="stylesheet" href="././css/bootstrap.min.css">
<link rel="stylesheet" href="././css/sweetalert.css">

<script type="text/javascript" src="./js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="./js/jPages.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/sweetalert-dev.js"></script>
<script type="text/javascript" src="js/sweetalert.js"></script>
<script type="text/javascript" src="js/sweetalert.min.js"></script>
<script type="text/javascript" src="js/graphLine.js"></script>
<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
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
<style>
    svg {
    	background-image:url("img/bg.jpg");
    }
    .axis text {
        font-family: sans-serif;
        font-size: 11px;
    }
    .axis path,
    .axis line {
        fill: none;
        stroke: black;
    }
    div#graphLine{
    	overflow-x: scroll;
    	background-image:url("img/bg.jpg");
    }
</style>
</head>
<body>

<div id = "backimg">
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
			<div id="c-box">
				<br>
				<h3>商品編集</h3>
				<s:iterator value="ans">
					<p><font color="#ff0000"><s:property value="ans" /></font></p>
				</s:iterator>
				<br>

				<ul>
					<li style="float:right"><input type="button" data-toggle="modal" data-target="#sampleModal" value="商品追加"/></li>
					<li style="float:right"><input type="button" data-toggle="modal" data-target="#graph" value="商品在庫一覧" ></li>
				</ul>
				<br>

				<ul>
					<s:form action="AdminUpdateStockAction">
						<li style="float:right"><s:submit type="button" value="更新" /></li>
						<li style="float:right"><input type="text" name="item_stock" size="9" placeholder="在庫数"></li>
						<li style="float:right"><input type="text" name="item_id" size="9" placeholder="ID"></li>
					</s:form>
				</ul>
				<br>

				<ul>
					<s:form action="AdminSearchItem">
						<li style="float:right"><s:submit type="button" value="検索"/></li>
						<li style="float:right"><input type="text" name="itemName" size="23" placeholder="商品名"></li>
					</s:form>
				</ul>
				<br>

				<s:form action="AdminDeleteItemAction">
					<ul>
						<li style="float:right"><s:submit type="button" value="削除"/></li>
						<li style="float:right"><s:textfield name="itemid" size="23" placeholder="商品ID"/></li>
					</ul>
				</s:form>
			</div>

			<!-- モーダル・ダイアログ -->
			<div class="modal fade" id="sampleModal" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close btn "style=font-size:40px; data-dismiss="modal">×</button>
							<div class="text-center" >
								<h3 style="font-weight:bold">商品追加画面</h3>
							</div>
						</div>

						<div class="modal-body">
							<s:form method="post" action="AdminAddItemAction">
							<div class="text-center">
								<div class="left">
									<label >商品名</label><br>
										<s:textfield maxlength='9' placeholder="商品名" name="itemName" /><br>
									<label>	商品価格（半角数字で入力してください）</label><br>
										<s:textfield type="number" min="0" step="1"  placeholder="商品価格" name="price" /><br>
									<label>商品情報</label><br>
										<s:textarea maxlength='100' cols="50" rows="5" placeholder="商品情報" name="explanation" /><br>
									<label>カテゴリー</label><br>
										<s:radio name="category" list="#{'ramen':'ramen','topping':'topping'}" value="#{'ramen'}"/><br>
										<br>
									<label>在庫</label><br>
										<s:textfield type="number" min="0" step="1" placeholder="在庫数" name="itemStock" />
										<br>
									<label>画像パス</label><br>
										<s:textfield maxlength='9' placeholder="商品名" name="imgPath" />
										<br>
								</div>
							</div>
							<hr>
							<div class="text-right">
								<s:submit cssClass="btn btn-primary" style="font-weight:bold" value="商品追加" />
								<input type="button" class="btn btn-default" data-dismiss="modal" style="font-weight:bold" value="戻る"/>
							</div>
							</s:form>
						</div>

					</div>
				</div>
			</div>

			<div class="modal fade" id="graph" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog  modal-lg">
					<div class="modal-content">

						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">在庫数一覧　*棒グラフクリックで詳細表示</h4>
						</div>
						<div class="modal-body">
							<div id = "graphLine"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">閉じる</button>
						</div>

					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
		</div>

		<table>
			<thead>
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>商品説明</th>
					<th>カテゴリー</th>
					<th>値段</th>
					<th>在庫</th>
					<th>画像パス</th>
				</tr>
			</thead>

			<tbody id="CList">
				<s:iterator value="list">
					<tr>
						<td><s:property value="itemId" /></td>
						<td><s:property value="itemName"/></td>
						<td><s:property value="explanation"/></td>
						<td><s:property value="category"/></td>
						<td><s:property value="price"/></td>
						<td><s:property value="itemStock"/></td>
						<td><s:property value="imgPath"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div class="List"></div>
</div>

<div id="modal-backdrop"></div>

</body>
</html>