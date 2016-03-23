<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="ROBOTS" content="NOINDEX,NOFOLLOW">
<title><s:text name ="%{getText('admin_item.title')}"/></title>
<link rel="stylesheet" href="./css/animate.css">
<link rel="stylesheet" href="././css/style.css">
<link rel="stylesheet" href="././css/admin_item.css">
<link rel="stylesheet" href="././css/bootstrap.min.css">

<script type="text/javascript" src="./js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="./js/jPages.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/graphLine.js"></script>
<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/j5Pages.js"></script>
<style>
    svg {
    	background-color:#fff;
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
    }
</style>
</head>
<body>

<div id = "backimg">
	<div id="site-box">

		<div id="a-box">
			<h2><s:text name = "%{getText('admin.display')}"/></h2>
            <s:form action="GoAdminItemAction" style="display: inline">
                <s:submit type="button" value="%{getText('admin.item')}" />
            </s:form>
            <s:form action="GoAdminUserAction" style="display: inline">
                <s:submit type="button" value="%{getText('admin.user')}" />
            </s:form>
            <s:form action="GoAdminPurchaseHistoryAction" style="display: inline">
                <s:submit type="button" value="%{getText('admin.history')}" />
            </s:form>
            <s:form action="GoAdminInquiryAction" style="display: inline">
                <s:submit type="button" value="%{getText('admin.contact')}" />
            </s:form>
            <s:form action="AdminLogoutAction" style="display: inline">
                <s:submit type="button" value="%{getText('admin.logout')}" />
            </s:form>
		</div>

		<div id="c-box">
			<div id="c-box">
			<s:property value="updateMessage"/>
				<br>
				<h3><s:text name ="%{getText('admin_item.title')}"/></h3>
				<p><font color="#ff0000"><s:property value="ans" /></font></p>
				<br>

				<ul>
					<li style="float:right"><s:submit type="button" data-toggle="modal" data-target="#sampleModal" value="%{getText('admin_item.add')}"/></li>
					<li style="float:right"><s:submit type="button" data-toggle="modal" data-target="#graph" value="%{getText('admin_item.inventory')}"/></li>
				</ul>
				<br>

				<ul>
					<s:form action="AdminUpdateItemStockAction">
						<li style="float:right"><s:submit type="button"  value ="%{getText('admin_item.btnUpdate')}" /></li>
						<li style="float:right"><s:textfield name="itemStock" size="9" placeholder="%{getText('admin_item.txtStockNum')}" onKeyup="this.value=this.value.replace(/[^0-9]+/,'')"/></li>
						<li style="float:right"><s:textfield name="itemId" size="9" placeholder="%{getText('admin_item.txtId')}" onKeyup="this.value=this.value.replace(/[^0-9]+/,'')"/></li>
					</s:form>
				</ul>
				<br>

				<ul>
					<s:form action="AdminSelectItemsAction">
						<li style="float:right"><s:submit type="button" value="%{getText('admin_item.btnSearch')}" /></li>
						<li style="float:right"><s:textfield name="itemName" size="23" placeholder="%{getText('admin_item.txtItemName')}" /></li>
					</s:form>
				</ul>
				<br>

				<s:form action="AdminDeleteItemsAction">
					<ul>
						<li style="float:right"><s:submit type="button" value="%{getText('admin_item.btnDelete')}" /></li>
						<li style="float:right"><s:textfield name="itemId" size="23" placeholder="%{getText('admin_item.txtItemId')}" onKeyup="this.value=this.value.replace(/[^0-9]+/,'')" maxlength='9'/></li>
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
								<h3 style="font-weight:bold"><s:text name ="%{getText('admin_item.AddItemDisplayTitle')}"/></h3>
							</div>
						</div>

						<div class="modal-body">
							<s:form method="post" action="AdminAddItemsAction">
							<div class="text-center">
								<div class="left">
									<label ><s:text name="%{getText('admin_item.txtItemName')}" /></label><br>
										<s:textfield maxlength='9' placeholder="%{getText('admin_item.txtItemName')}" name="itemName" />
										<br>
									<label><s:text name="%{getText('admin_item.lblItemPrice')}" /></label><br>
										<s:textfield type="number" maxlength="9" min="0" step="1"  placeholder="%{getText('admin_item.txtItemPrice')}" name="price" onKeyup="this.value=this.value.replace(/[^0-9]+/,'')"/><br>
									<label><s:text name="%{getText('admin_item.iteminf')}" /></label><br>
										<s:textarea maxlength='100' cols="50" rows="5" placeholder="%{getText('admin_item.iteminf')}" name="explanation" /><br>
									<label><s:text name="%{getText('admin_item.lblCategory')}" /></label><br>
										<s:radio name="category" list="#{'ramen':'ramen','topping':'topping'}" value="#{'ramen'}"/><br>
										<br>
									<label><s:text name="%{getText('admin_item.lblStock')}" /></label><br>
										<s:textfield type="number" maxlength='9' min="0" step="1" placeholder="%{getText('admin_item.txtStockNum')}" name="itemStock" onKeyup="this.value=this.value.replace(/[^0-9]+/,'')"/>
										<br>
									<label><s:text name="%{getText('admin_item.imgPath')}" /></label><br>
										<s:textfield placeholder="%{getText('admin_item.imgPath')}" name="imgPath" />
										<br>
								</div>
							</div>
							<hr>
							<div class="text-right">
								<s:submit cssClass="btn btn-primary" style="font-weight:bold" value="%{getText('admin_item.add')}" />
								<input type="button" class="btn btn-default" data-dismiss="modal" style="font-weight:bold" value = <s:text name ="%{getText('admin_item.return')}"/>>
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
							<h4 class="modal-title" id="myModalLabel"><s:text name ="%{getText('admin_item.inventoryTitle')}"/></h4>
						</div>
						<div class="modal-body">
							<div id = "graphLine"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal"><s:text name ="%{getText('admin_item.return')}"/></button>
						</div>

					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
		</div>

		<table>
			<thead>
				<tr>
					<th><s:text name ="%{getText('admin_item.itemID')}"/></th>
					<th><s:text name ="%{getText('admin_item.itemname')}"/></th>
					<th><s:text name ="%{getText('admin_item.iteminf')}"/></th>
					<th><s:text name ="%{getText('admin_item.category')}"/></th>
					<th><s:text name ="%{getText('admin_item.price')}"/></th>
					<th><s:text name ="%{getText('admin_item.invent')}"/></th>
					<th><s:text name ="%{getText('admin_item.img')}"/></th>
				</tr>
			</thead>

			<tbody id="CList">
				<s:iterator value="itemList">
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
		<div class="List"></div>
	</div>
</div>
</body>
</html>