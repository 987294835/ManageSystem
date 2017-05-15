// JavaScript Document

/**
 * 当在页码输入框中按了回车后，就会提交分页表单
 */
function submitPaginationFormByInput(event, pageNum) {
	if (event.keyCode == 13) {
		gotoPage(pageNum);
		return false;
	}
}

/**
 * 页面中需要有一个提交分页要求的表单元素，如果有多个form，则需要指定id为paginationForm。
 * 传递的参数中有一个表示要查看的页码的，名称为"pageNum"。
 * 
 * 需要由具体的页面定义 pageCount 变量，用于指定总页码有多少！！！
 * 
 * @param pageNum 要跳转到的页码
 * @param pageCountParam 总页码
 */
function gotoPage(pageNum) {
	if (pageNum > pageCount) {
		alert("页码超出有效范围");
		return;
	}

	// 默认找id为paginationForm的<form>元素，一个页面中有多<form>且这个表单不是第1个时使用。
	// 如果找不到指定id的<form>，就使用页面中的第1个<form>，当页面中只有一个或分页表单是第1个时这样使用，用起来方便。
	var paginationForm = document.getElementById("paginationForm");
	if (paginationForm == null) {
		paginationForm = document.forms[0];
	}
	if (paginationForm == null) {
		alert("找不到分页用的表单！");
		return;
	}

	// 修改页码值后提交表单
	paginationForm.currentPage.value = pageNum;
	paginationForm.submit();
}

/**
 * 删除前的确认提示
 */
function delConfirm(url, e) {
	var flag = window.confirm("您确定要删除一条记录码？");
	if (flag) {
		window.location.href = url;
	} else {
		if (e.type == "checkbox") {
			e.checked = false;
		}
	}

}

/**
 * （使用模式对活框）显示图片
 */
function showImage(url, width, height) {
	var sFeatures = "resizable: yes; ";
	if (width != null) {
		sFeatures += "dialogWidth:" + width + "px; ";
	}
	if (height != null) {
		sFeatures += "dialogHeight:" + height + "px; ";
	}
	window.showModalDialog(url, null, sFeatures);
}
