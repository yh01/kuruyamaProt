/**
 *
 */
jQuery(function($) {
	var url = location.protocol;
	url += "/kuruyamaProt/D3GraphList";
	var dataSet= [];
	getSalesGraph();

function getSalesGraph() {
$.ajax({
	url : url,
	type : 'get',
	datatype : 'json'
		}).done(function(data) {
			for(i=0;i<data.length;i++){
				dataSet[i] = {name:data[i].itemName, val:data[i].salesAmount};
			}
			var dataMax = d3.max(dataSet,function(d){
				return d.val*3;
			});

			//svg領域の指定
			var size = $(window).width() * 0.65;
			var margin = {top:20, bottom:20, right:0, left:200}
			var Margin = 20;
			var svgH = (35 * (data.length));
			var svgW = dataMax;
			var h = dataSet.length;
			var svg = d3.select("#graphLine")
			            .append('svg')
				        .attr({
				    	       height: svgH + margin.top + margin.bottom,
				               width:  svgW + svgW
                     });

            //棒グラフの生成
			var barchart = svg.selectAll("rect")
			         .data(dataSet)
			         .enter()
			         .append("rect")
			         .attr({
							x: 150,
							y: function(d,i){
						        return i * 35;
						    },
							width:function(d,i){ return  d.val* 2 + 15},
							height :30,
							fill: "blue"
			         })
			         .on("click", function(d) {
			        	 alert(d.val);
			         });


			// 在庫数記載
			svg.selectAll("itemOfStock")
					.data(dataSet)
					.enter()
					.append("text")
					.text(function(d){return d.val})
					.attr({
						x:function(d,i){ return  d.val* 2-20+150},
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
						x:30,
						y:  function(d,i){
					        return i * 35+25;
					    },
						fill:"black",
					})
		});
	};
});