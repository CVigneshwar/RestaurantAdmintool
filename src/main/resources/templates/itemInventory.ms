<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UboxIt</title>
<link href="/repository/css/styles/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="https://fonts.googleapis.com/css?family=Patua+One" rel="stylesheet">
</head>
<body>
<div id="container">
  <header>
    <nav>
      <ul id="nav">
        <!-- <li><img src="/repository/css/images/Uboxitlogo.png"></li> -->        
        <li><a href="/repository/selectItem/showAllItems" class="current">Items</a></li>
        <li><a href="/repository/combo/showAllItems">Combos</a></li>
    </ul>
    </nav>
  </header>
  <form method="POST" id="itemSubmit" >
  <div class="wrapper">
    <div class="border"></div>
    
    
    <article class="menu">
    <ol>
   
    {{#items}}
     <li class="itemStyle">
     <div class="itemStyle-left">
        <h3>{{name}}:</h3>
        <h7>{{^discountedPrice}} {{normalPrice}}{{#isEuro}}€{{/isEuro}}{{^isEuro}}{{currencyCode}}{{/isEuro}}{{/discountedPrice}}{{#discountedPrice}}<strike>{{normalPrice}}{{#isEuro}}€{{/isEuro}}{{^isEuro}}{{currencyCode}}{{/isEuro}}</strike>{{discountedPrice}}{{#isEuro}}€{{/isEuro}}{{^isEuro}}{{currencyCode}}{{/isEuro}}{{/discountedPrice}} | {{#isVegetarian}}VEG | {{/isVegetarian}}{{itemType}} | {{categoryType}}</h7>
      </div>
      <div class="right menu-order"><a class="button" href="/repository/selectItem/editItem?itemId={{id}}">Edit</a><a class="button" href="/repository/selectItem/deleteItem?itemId={{id}}">Delete</a>{{^soldOut}}<a class="button" style="background-color: green;" href="/repository/selectItem/setAvailablity?soldOut=true&itemId={{id}}">Set SoldOut</a>{{/soldOut}}{{#soldOut}}<a class="button" style="background-color: red;" href="/repository/selectItem/setAvailablity?soldOut=false&itemId={{id}}">Set Available</a>{{/soldOut}}</div>
      <div class="border3"></div>
      </li>
      {{/items}}
      
      </ol>
      </article>
    
    <aside class="sidebar">
      <div class="menu-order"><a class="button" href="/repository/selectItem/addItem" style="background-color: #d3394c;  margin: 20%; font-size: 22px;">Create new item</a></div><br>  <div class="border3"></div>
      <div class="importFromExcel">
      
      <h6>Import items from excel</h6>
<div class="box">
					<input type="file" name="file-5[]" id="file-5" class="inputfile inputfile-4" data-multiple-caption="{count} files selected" multiple style=" display: none;" />
					<label for="file-5"><figure><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg></figure> <span>Choose a file</span></label>
				</div>
				</div>      
    </aside>
      
    <div class="border2"></div>
    <br>
  </div>
  </form>
  <script src="/repository/js/custom-file-input.js"></script>
  <script type="text/javascript">

function getActionForAddItem(){
var formAction = "/selectItem/addItem";
document.getElementById("itemSubmit").action=formAction;
document.getElementById("itemSubmit").submit;
}
function detectItemId(){
var itemId = document.getElementsByName("selectedItem");
}

function getAction(){
var selectedItem = document.getElementsByName("selectedItem");
for (var i = 0, length = selectedItem.length; i < length; i++)
{
 if (selectedItem[i].checked)
 {
  var itemId = selectedItem[i].value;
  break;
 }
}
var formAction = "/selectItem/editItem?itemId="+itemId;
document.getElementById("itemSubmit").action=formAction;
}

</script>
  <footer>
    <div class="border"></div>
    
    <span class="copyright"><span class="left"><br />
    &copy; Copyright 2018 - All Rights Reserved - <a href="#">Domain Name</a></span><span class="right"><br />
    Design by <a href=""></a><br />
    <br>
    <br />
    </span></span></footer>
</div>
</body>
</html>