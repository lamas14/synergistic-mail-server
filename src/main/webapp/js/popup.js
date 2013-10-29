/***************************/
//@website: www.ZwebbieZ.com
//@license: Feel free to use it, but keep this credits please!					
/***************************/

//SETTING UP OUR POPUP
//0 means disabled; 1 means enabled;
var popupStatus = 0;

//loading popup with jQuery magic!
function loadPopup(popupId,bgPopupId){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$(bgPopupId).css({
			"opacity": "0.7"
		});
		$(bgPopupId).fadeIn("slow");
		$(popupId).fadeIn("slow");
		popupStatus = 1;
	}
}

//disabling popup with jQuery magic!
function disablePopup(popupId,bgPopupId){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$(bgPopupId).fadeOut("slow");
		$(popupId).fadeOut("slow");
		popupStatus = 0;
	}
}

//centering popup
function centerPopup(popupId,bgPopupId){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $(popupId).height();
	var popupWidth = $(popupId).width();
	//centering
	$(popupId).css({
		"position": "absolute",
		"top": windowHeight/2-popupHeight/2,
		"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$(bgPopupId).css({
		"height": windowHeight
	});
	
}


function onhref(){
	centerPopup();
	loadPopup();
	//CLOSING POPUP
	//Click the x event!
	$("#popupContactClose").click(function(){
		disablePopup();
	});
	//Click out event!
	$("#backgroundPopup").click(function(){
		disablePopup();
	});
	//Press Escape event!
	$(document).keypress(function(e){
		if(e.keyCode==27 && popupStatus==1){
			disablePopup();
		}
	});

}

//CONTROLLING EVENTS IN jQuery
$(document).ready(function(){
	
	//LOADING POPUP
	//Click the button event!
//	$("#button").click(function(){
		//centering with css
		//centerPopup();
		//load popup
		//loadPopup();
	//});
				
	//CLOSING POPUP
	//Click the x event!
	$("#popupContactClose").click(function(){
		disablePopup();
	});
	//Click out event!
	$("#backgroundPopup").click(function(){
		disablePopup();
	});
	//Press Escape event!
	$(document).keypress(function(e){
		if(e.keyCode==27 && popupStatus==1){
			disablePopup();
		}
	});

});