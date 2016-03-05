/**
 *
 */
jQuery(function($) {
	var url = location.protocol;
	url += "/kuruyamaProt/D3GraphList";
	var dataSet= [];
	getitemStockGraph();

	function getitemStockGraph() {
	$.ajax({
		url : url,
		type : 'get',
		datatype : 'json'
	})
		.done(function(data) {
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

					var svgH = (35 * (data.length));
					var svgW = dataMax;
					var h = dataSet.length;
					var svg = d3.select("#graphLine")
					            .append('svg')
						        .attr({
						    	       height: svgH + margin.top + margin.bottom,
						               width:  svgW + 10
		                     });

		            //棒グラフの生成
					var barchart = svg.selectAll("rect")
					         .data(dataSet)
					         .enter()
					         .append("rect")
					         .attr({
									x: 15 * nameMax,
									y: function(d,i){
								        return i * 35;
								    },
									width:function(d,i){ return  d.val* 2 + 15},
									height :30,
									fill: "blue"
					         })
					         .on("click", function(d) {
					        	 alert(d.name + "の在庫数： " + d.val);
					         })
					         .on("mouseover", function(d) {
								 d3.select(this).attr("fill", "orange");
							 })
							 .on("mouseout", function(d) {
								d3.select(this).attr("fill", "blue");
							 });


					// 在庫数記載
					svg.selectAll("itemOfStock")
							.data(dataSet)
							.enter()
							.append("text")
							.text(function(d){return d.val})
							.attr({
								x:function(d,i){ return  d.val* 2 - 20 + 15 * nameMax},
								y: function(d,i){
							        return i * 35+20;
							    },
							    width:function(d,i){ return  d.val* 5 + 15},
								height :30,
								fill:"white",
							});

					// 商品の名前の記載
					svg.selectAll("itemName")
							.data(dataSet)
							.enter()
							.append("text")
							.text(function(d){return d.name})
							.attr({
								x:nameMax,
								y:  function(d,i){
							        return i * 35+20;
							    },
								fill:"black",
							})

		});
	};
});