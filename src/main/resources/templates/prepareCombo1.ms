<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Create Combos</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <style>
/* The container */
.container {
    display: block;
    position: relative;
    padding-left: 35px;
    margin-bottom: 12px;
    cursor: pointer;
    font-size: 22px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

/* Hide the browser's default checkbox */
.container input {
    position: absolute;
    opacity: 0;
    cursor: pointer;
}

/* Create a custom checkbox */
.checkmark {
    position: absolute;
    top: 0;
    left: 0;
    height: 25px;
    width: 25px;
    background-color: #eee;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
    background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.container input:checked ~ .checkmark {
    background-color: #2196F3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
    content: "";
    position: absolute;
    display: none;
}

/* Show the checkmark when checked */
.container input:checked ~ .checkmark:after {
    display: block;
}

/* Style the checkmark/indicator */
.container .checkmark:after {
    left: 9px;
    top: 5px;
    width: 5px;
    height: 10px;
    border: solid white;
    border-width: 0 3px 3px 0;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
}
</style>
    </head>
<body>
<form method="POST" id="itemlist" >
{{#items}}
<input type="checkbox" name="itemid" value="{{id}}">
{{name}}
{{discountedPrice}}{{currencyCode}}
{{itemType}}
{{availableTime}}
{{categoryType}}
---------------
<br>
{{/items}}
<button value="create" onclick="doSubmit()">Create</button>
</form>

<div>
{{#combos}}
{{name}} | {{description}} | {{normalPrice}}{{currencyCode}} | {{discountedPrice}}{{currencyCode}}
{{/combos}}

</div>
<script>
function doSubmit() {
    var checkedValue = new Array();
    $("input:checkbox[name=itemid]:checked").each(function(){
    checkedValue.push($(this).val());
});

console.log(checkedValue);

var formAction = "/combo/prepareCombo?itemIds="+checkedValue.join();
document.getElementById("itemlist").action=formAction;

}
</script>
</body>
<html>