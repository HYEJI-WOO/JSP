function get_content(content) {
	console.log(content.data("content"));
}

$(function(){
	let boardList = null;
	$.ajax({
		type : 'post',
		url : "/pro16_/board",
		success : function(list) {
			boardList = list;
			let output = "";
			for(let b of list) {
				output += `
			    <tr>
			        <td>${b.bno}</td>
			        <td><a href="#" onclick="get_content($(this))" data-content="${b.content}">${b.title}</a></td>
			        <td>${b.writer}</td>
			        <td>${b.writeDate}</td>
			    </tr>`;
			}
			$('table').append(output);
		}, 
		error : function() {
			alert('에러');
		}
	}); // ajax end
}); // end