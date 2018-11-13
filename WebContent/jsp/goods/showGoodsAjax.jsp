<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctxPath }/static/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctxPath }/static/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctxPath }/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${ctxPath }/static/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${ctxPath }/static/js/select-ui.min.js"></script>

<script type="text/javascript">
var barCodeArray = new Array();
var dataIndex = 0;
$(function(){
	
	$(".select3").uedSelect({
		width : 152
	});

	$("input[name='barCode']").keypress(function(e){
		if (e.keyCode == 13){
			addGoods(this.value);
			clearBarCode(this);
		}
		
	});
	
	
	//将商品提交按钮绑定点击事件
	$(".scbtn2").click(function(){
		var $barCodeInput = $("input[name='barCode']");
		addGoods($barCodeInput.val());
		clearBarCode($barCodeInput[0]);
	});
	
});

function clearBarCode(barCodeInput){
	barCodeInput.value="";
	barCodeInput.focus();
}

function addGoods(barCodeValue){
	var goodsCount = parseInt($("input[name='goodsCount']").val());
	
	var isNotExist = true;
	$.each(barCodeArray, function(){
		if(this == barCodeValue){
			isNotExist = false;
			return false;
		}
	});
	
	if(isNotExist){
		$.ajax({
			url:"${ctxPath }/getGoodsJsonInfo.do",
			data:{barCode:barCodeValue},
			type:"post",
			dataType:"JSON",
			success:function(resData){
				if(resData.resCode){
					resData.data.goodsCount = goodsCount;
					appendGoods(resData.data);
					barCodeArray[dataIndex] = barCodeValue;
					dataIndex++;
				}else{
					alert(resData.resMsg);
				}
			}
		});
	}else{
		//alert();
		$("#goodsCountTd"+barCodeValue).text(parseInt($("#goodsCountTd"+barCodeValue).text())+goodsCount);
	}
}

function appendGoods(goods){
	var $goodsTableTbody = $("tbody");
	var returnValue="<tr id='" + goods.barCode + "Tr'><td><input name='' type='checkbox' value='' /></td><td>"+goods.barCode+
	"</td><td>" +goods.goodsName + "</td><td>" +goods.price + "</td><td id='goodsCountTd" + goods.barCode + "'>" +goods.goodsCount + 
	"</td><td><a href='#' class='tablelink'> 删除</a></td></tr>";
	//alert("--------------->" + returnValue);
	$goodsTableTbody.append(returnValue);
}

</script>
</head>
<body class="sarchbody">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">收银</a></li>
    </ul>
    </div>
    <div class="formbody">
    <div id="usual1" class="usual"> 
    <div class="formtitle"><span>商品列表</span></div>
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th><input name="" type="checkbox" value="" checked="checked"/></th>
		        <th>商品编号<i class="sort"><img src="${ctxPath }/static/images/px.gif" /></i></th>
		        <th>商品名称</th>
		        <th>价格</th>
		        <th>数量</th>
		        <th>操作</th>
	        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
	</div> 
    </div>
    
    
    <div>
    	<label>商品编号</label><input name="barCode" type="text" class="scinput1" />  
    	<label>商品数量</label><input name="goodsCount" type="text" class="scinput1" value="1" />
    	<input name="" type="button" class="scbtn2" value="提交"/>
    </div>
</body>

</html>
