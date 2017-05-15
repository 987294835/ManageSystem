/**
 * 显示或隐藏预定人名称
 */
function showOrHideBookTimeTr() {
	var isBook = $("#isBook option:selected"); // 获取选中的项
	var val = isBook.val();
	if (1 == val) {
		// 显示预定人名称
		$("#bookTimeTr").show();
		$("#bookNameTr").show();
	} else {
		// 隐藏预定人名称
		$("#bookTimeTr").hide();
		$("#bookNameTr").hide();
		$("input[name=bookTime]").val("");
		$("input[name=bookName]").val("");
	}

}
