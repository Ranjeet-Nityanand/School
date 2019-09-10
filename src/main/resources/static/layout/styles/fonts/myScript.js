/**
 * 
 */

$(document).ready(function(){
$("#tab").dataTable();	
$("#dialog").hide();
});

// View Student in Dialog

view=function(id){
	
	$("#dialog").dialog({
			width: 600,
	    height: 300,
	    modal: true,
	    buttons: {
            Cancel: function() {
                $(this).dialog("close");
            }
        },
      show: {
        effect: "flip",
        duration: 1000
      },
      hide: {
        effect: "flip",
        duration: 1000
      }
	});
	 $('input').attr('readonly', true);	
	$.ajax({
	type: 'POST',
	contentType: 'application/json',
	url:'/manage-student',
	data: JSON.stringify({id:id/* '${st.id}' */}),
	success: function(data){
		console.log(data);
		$("#name").val(data.name);
		$("#father").val(data.father);
		$("#address").val(data.address);
		$("#mobile").val(data.mobile);
		$("#img").attr('src', data.image);
		},
	error: function(){
		alert("Error: Something went wrong!!");
			}
	});
}
 
// Edit Student By id.

edit=function(id){
	$('input').attr('readonly', false);	
	var name,father,address,mobile;
	$("#dialog").dialog({
		width: 600,
    height: 300,
    modal: true,
    buttons: {
    	
    	 "1": { id: 'close', text: 'Close', click: function(){ $(this).dialog("close"); }, "class": "orange" },
         "2": { id: 'Update', text: 'Continue', click: function(){ $(this).dialog("close"); }, "class": "update" },
    	Update: function(){
    		name=$("#name").val();
    		father=$('#father').val();
    		address=$('#address').val();
    		mobile=$("#mobile").val();
    		$.ajax({
    			type: 'POST',
    			contentType: 'application/json',
    			url:'/edit-student',
    			data: JSON.stringify({
    				id:id,
    				name:name,
    				father:father,
    				address:address,
    				mobile:mobile
    			}),
    			success: function(e){
    				location.href="/view-students";
    				alert("success");
    				},
    			error: function(e){
    				alert("error");
    					}
    			});
    		$(this).dialog("close");
    	},
        Cancel: function() {
            $(this).dialog("close");
        }
    }
  
});
	
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url:'/manage-student',
		data: JSON.stringify({id:id/* '${st.id}' */}),
		success: function(data){
			console.log(data);
			$("#name").val(data.name);
			$("#father").val(data.father);
			$("#address").val(data.address);
			$("#mobile").val(data.mobile);
			},
		error: function(){
			alert("Error: Something went wrong!!");
				}
		});
}


// Delete By id.

delet = function(id) {
	$('input').attr('readonly', false);
	var name, father, address, mobile;
	$("#dialog").dialog({
		width : 600,
		height : 300,
		modal : true,
		buttons : {
			Delete : function() {
				name = $("#name").val();
				father = $('#father').val();
				address = $('#address').val();
				mobile = $("#mobile").val();
				$.ajax({
					type : 'POST',
					contentType : 'application/json',
					url : '/delete-student',
					data : JSON.stringify({
						id : id
					}),
					success : function(e) {
						location.href = "/view-students";
						alert("success");
					},
					error : function(e) {
						alert("error");
					}
				});
				$(this).dialog("close");
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		}
		
	});

	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : '/manage-student',
		data : JSON.stringify({
			id : id
		/* '${st.id}' */}),
		success : function(data) {
			console.log(data);
			$("#name").val(data.name);
			$("#father").val(data.father);
			$("#address").val(data.address);
			$("#mobile").val(data.mobile);
		},
		error : function() {
			alert("Error: Something went wrong!!");
		}
	});
}
