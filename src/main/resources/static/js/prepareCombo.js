function doSubmit() {
    var checkedValue = new Array();
    $("input:checkbox[name=itemid]:checked").each(function(){
    checkedValue.push($(this).val());
});

console.log(checkedValue);

var formAction = "/repository/combo/prepareCombo?itemIds="+checkedValue.join();
document.getElementById("itemlist").action=formAction;
document.getElementById("itemlist").submit();
}

$( document ).ready(function() {
   
        console.log( "document loaded" );
//image gallery
//init the state from the input
$(".image-checkbox").each(function () {
if ($(this).find('input[type="checkbox"]').first().attr("checked")) {
 $(this).addClass('image-checkbox-checked');
}
else {
 $(this).removeClass('image-checkbox-checked');
}
});

//sync the state to the input
$(".image-checkbox").on("click", function (e) {
$(this).toggleClass('image-checkbox-checked');
var $checkbox = $(this).find('input[type="checkbox"]');
$checkbox.prop("checked",!$checkbox.prop("checked"))

e.preventDefault();
});

});