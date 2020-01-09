function change(img){
	img.src="getcode?"+new Date().getTime();
}


function FocusItem(obj){
	if($(obj).attr("name")=="code"){
		$(obj).next().next().removeClass("error").html("");
	}else{
		$(obj).next().removeClass("error").html("");
	}
	
	
	
}

function CheckItem(obj){
	
	switch ($(obj).attr("name")){
	case "userId":
		if($(obj).val()==""){
			$(obj).next().addClass("error").html("用户名不能为空");
			
		}else{
			var url="usercheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
			
			$.get(url,function(date){
				if(date=="false"){
					$(obj).next().addClass("error").html("此用户名已被使用");
				}else{
					$(obj).next().removeClass("error").html("");
				}
			});
		}
		break;
	case "password":
		if($(obj).val()==""){
			$(obj).next().addClass("error").html("密码不能为空");
		}
		break;
	
	case "code":
		if($(obj).val()==""){
			$(obj).next().next("span").addClass("error").html("请输入验证码");
		}else{
			var url="checkcode?code="+encodeURI($(obj).val())+"&"+new Date().getTime();
			$.get(url,function(date){
				if(date=="false"){
					$(obj).next().next("span").addClass("error").html("验证码错误");
				}else{
					$(obj).next().next().removeClass("error").html("");
				}
			});
		}
		break;
	case "UserName":
		if($(obj).val()==""){
			$(obj).next().addClass("error").html("姓名不能为空");
		}
		break;
	case "rePassword":
		if(document.getElementsByName("password")[0].value!=$(obj).val()){
			$(obj).next().addClass("error").html("两次输入的密码不一致，请重新输入");
			
		}
		break;

}
}


function checkForm(form){
	
	$("input").each(function(i){
		if($(this).attr("onblur")!=""){
			CheckItem(this);
		}
		CheckItem(this);
	});
	//console.log($(".error"));
	//return false;
	if($(".error").length==0){
		//alert("a");
		return true;
		
	}else{
		//alert("b");
		return false;
		
	}
	
	
	
	
	
}