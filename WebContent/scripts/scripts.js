// created by Dipanjan
$(document).ready(function() {
		$('#dataTableExp').DataTable();
});

$(document).ready(function() {
	jQuery('#datetimepicker,#datetimepicker1').datetimepicker({
//	value: new Date(),
	format:'Y/m/d H:i',
	startDate:'+2016/11/01',
	autoclose: true,
	useCurrent: false 	
	});
});

$(function() {
    $( "#yearpicker" ).datepicker({
    	dateFormat: 'yy',
    	changeYear: true,
    	changeMonth: false,
    	yearRange: '-10:+0',
    	onClose: function(dateText, inst) { 
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, 1));
        }
    	});
});

$(document).ready(function () {
    $("#textbox").val('');
    $("#textbox").keypress(function () {
        var textLength = $("#textbox").val().length;
        if (textLength % 50 == 0) {
            var height = textLength / 50;
            $("#textbox").css('height', 20 + (height * 20));
        }
    });
    $('#textbox').keydown(function (e) {
        if (e.keyCode == 13) {
            var msg = $(this).val();
            if (msg == "") {
                alert('full the message');
            }
            else {
                $(".commentsblock").append(
                		"<div class='comments'><div class='imageicons divfloat'><img src='https://cdn1.iconfinder.com/data/icons/black-easy/32/538647-user_32x32.png' /></div><div class='commentinfo divfloat'>" + msg + "</div></div>"
                    ).fadeIn('slow');
                $("#textbox").val("");
            }
        }
    })
});

$(document).ready(function(){
	 $("#statusArchive").change(function(){
	     var status = this.value;
	     //alert(status);
	     if(status == 'true'){
	    	 alert("Please note that once you select to archive, you won't be able to see it");
	     }	
	  });
});
