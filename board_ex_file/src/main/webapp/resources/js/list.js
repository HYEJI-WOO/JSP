$(function(){

	$('.title').on('click',function(e){
		let listForm = $('#listForm')
		e.preventDefault();
		//let bnoData = "<input type='hidden' name='bno' value='"+$(this).data('bno')+"'/>";
		let bnoData = "<input type='hidden' name='bno' value='"+$(this).attr('href')+"'/>";
		listForm.append(bnoData)
				.attr("action", `${contextPath}/board/detail`)
				.submit();
	});
});