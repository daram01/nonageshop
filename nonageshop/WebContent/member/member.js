function go_save(){
	
}

function idcheck(){
	if(document.formm.id.value==""){
		alert('아이디를 입력해주세요.');
		document.formm.id.focus();
		return;
	}
	let url = "NonageServlet?command=id_check_form&id=" + document.formm.id.value;
	window.open(url, "_blank_1", "width=430, height=300, top=300, left=300");
}

function post_zip(){
	let url = "NonageServlet?command=find_zip_num";
	window.open(url, "_blank_1", "width=550, height=400, top=300, left=300");
}

/*약관 동의 처리*/
function go_next(){
	if (document.formm.okon1[0].checked == true) {
		document.formm.action = "NonageServlet?command=join_form";
		document.formm.submit();
	} else if (document.formm.okon1[1].checked == true) {
 		alert('약관에 동의하셔야만 합니다.');
	}
}