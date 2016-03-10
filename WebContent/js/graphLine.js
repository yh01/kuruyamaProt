/**
 *
 */
jQuery(function($) {
	var url = location.protocol;
	url += "/kuruyamaProt/itemStockGraphList";
	getitemStockGraph();

	function getitemStockGraph() {
	$.ajax({
		url : url,
		type : 'get',
		datatype : 'json'
	})
		.done(function(data) {
					var dataSet= [];
					for(i=0;i<data.length;i++){
						dataSet[i] = {
							name:data[i].itemName,
							val:data[i].itemStock,
							exp:data[i].explanation,
							price:data[i].price,
							id:data[i].itemId,
							category:data[i].category
						};
					}
					var dataMax = d3.max(dataSet,function(d){
						return d.val * 3;
					});
					var dataMin = d3.min(dataSet,function(d){
						return d.val*3;
					});

					var nameMax = d3.max(dataSet,function(d){
						return d.name.length;
					});


					//svg領域の指定
					var size = $(window).width() * 0.65;
					var margin = {
							top:20,
							bottom:20,
							right:0,
							left:200
					}
					var svgH = (35 * (data.length));
					var svgW = dataMax + (50 + 20 * nameMax);
					var h = dataSet.length;
					var svg = d3.select("#graphLine")
					            .append("svg")
						        .attr({
						    	       height: svgH + margin.top + margin.bottom,
						               width: svgW - dataMax/4 + 50
						        });


		            //棒グラフの設定
					var barchart = svg.selectAll("rect")
					         .data(dataSet)
					         .enter()
					         .append("rect")
					         .attr({
									x: 50 + 20 * nameMax,
									y: function(d,i){
								        return i * 35 + 20;
								    },
									width:0,
									height :30,
									fill: function(d, i){
										var res;
								        if(d.val <= 10){
								        	res = "red";
								        }else if(d.val > 10 && d.val < 50){
								        	res = "#2ca02c";
								        }else if(d.val >= 50){
								        	res = "#1f77b4";
								        }
								        return res;
								    }
					         })
					         .on("click", function(d) {
					        	 alert(d.name + "の在庫数： " + d.val);
					         })
					         .on("mouseover", function(d) {
								 d3.select(this).attr("fill", "orange").style("cursor","hand");
							 })
							 .on("mouseout", function(d) {
								d3.select(this).attr("fill", function(d, i){
									var res;
							        if(d.val <= 10){
							        	res = "red";
							        }else if(d.val > 10 && d.val < 50){
							        	res = "#2ca02c";
							        }else if(d.val >= 50){
							        	res = "#1f77b4";
							        }
							        return res;
							    })
							 });

					//アニメーション
					d3.select("body").on("click", function(){
						barchart
					    .transition()
					    .delay(function(d, i){
					        return d.val;
					    })
					    .attr("width", function(d){
					        return (d.val * 2 + 15);
					    })
					    .duration(3000)
					    .ease("bounce")
					})


					// 在庫数
					svg.selectAll("itemOfStock")
							.data(dataSet)
							.enter()
							.append("text")
							.text(function(d){
								return d.val
							})
							.attr({
								x:function(d,i){
									return  50 + d.val * 2 - 20 + 20 * nameMax
								},
								y: function(d,i){
							        return i * 35 + 20 + 20;
							    },
							    width:function(d,i){
							    	return  d.val* 5 + 15
							    },
								height :30,
								fill:"white",
							})
							.on("mouseover", function(d) {
								 d3.select(this).style("cursor","hand");
							});


					// 商品名
					var itemName = svg.selectAll("itemName")
							.data(dataSet)
							.enter()
							.append("text")
							.text(function(d){
								return d.name
							})
							.attr({
								x: 50 + nameMax,
								y: function(d,i){
							        return i * 35 + 20 + 20;
							    },
								fill:"black",
							})
							.style("font-size","18px")
							.style("font-family", "serif")
							.on("mouseover", function(d) {
								 d3.select(this).style("cursor","hand");
							})
							.on("click", function(d) {
					        	 alert("商品ID： " + d.id + "\n" + "価格： \\" + d.price + "\n" +"カテゴリー： " + d.category + "\n" + "備考： "+ d.exp);
					        })
		});
	};
});