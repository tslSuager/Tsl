
var retg = function(url, fun) {
	var xmlhttp;
	if(window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState == 4) {
			if(xmlhttp.status == 200) {
				fun(xmlhttp.responseText);
			}
		}
	}
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
}
var get=function(e){
    var gv=document.getElementById("asds");
    gv.innerHTML=e;
    console.info(e);
}
$(function () {
   $("#get2").click(function () {
	   $.post("/doasd",{"id":"按nsa后"},function (e) {
		   $("#asds").html(e);
       },"text");
   });
	// $("#get2").click(function () {
	// 	$.ajax({"url": "/doasd",
   //          "context": document.body,
   //          "success": function(e) {
   //              $("#asds").html(e);
   //          }
	// 	}
   //      );
   //  });
})