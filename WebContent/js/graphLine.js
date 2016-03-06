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
							name:data[i].itemName, val:data[i].itemStock
						};
					}
					var dataMax = d3.max(dataSet,function(d){
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
					var color = d3.scale.category20();
					var svgH = (35 * (data.length));
					var svgW = dataMax;
					var h = dataSet.length;
					var svg = d3.select("#graphLine")
					            .append('svg')
						        .attr({
						    	       height: svgH + margin.top + margin.bottom,
						               width:  size + svgW / 2
		                     });

		            //棒グラフの設定
					var barchart = svg.selectAll("rect")
					         .data(dataSet)
					         .enter()
					         .append("rect")
					         .attr({
									x: 50 + 20 * nameMax,
									y: function(d,i){
								        return i * 35 + 10;
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
								 d3.select(this).attr("fill", "orange");
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
					d3.select("body").on("mouseover", function(){
						barchart
					    .transition()
					    .delay(function(d, i){
					        return d.val;
					    })
					    .attr("width", function(d){
					        return (d.val * 2 + 15);
					    })
					    .duration(1000)
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
							        return i * 35 + 20 + 10;
							    },
							    width:function(d,i){
							    	return  d.val* 5 + 15
							    },
								height :30,
								fill:"white",
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
								x:50+nameMax,
								y:  function(d,i){
							        return i * 35 + 20 + 10;
							    },
								fill:"black",
							})
		});
	};
});