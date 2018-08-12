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
        <li><a href="/repository/selectItem/showAllItems" >Items</a></li>
        <li><a href="/repository/combo/getAllCombos" class="current">Combos</a></li>
    </ul>
    </nav>
  </header>
  <form method="POST" id="itemSubmit" >
  <div class="wrapper">
    <div class="border"></div>
    
    
    <article class="menu">
    <ol>
   
    {{#combos}}
     <li class="itemStyle">
     <div class="itemStyle-left">
        <h3>{{name}}:</h3>
        <h7>{{^discountedPrice}} {{normalPrice}}{{#isEuro}}€{{/isEuro}}{{^isEuro}}{{currencyCode}}{{/isEuro}}{{/discountedPrice}}{{#discountedPrice}}<strike>{{normalPrice}}{{#isEuro}}€{{/isEuro}}{{^isEuro}}{{currencyCode}}{{/isEuro}}</strike>{{discountedPrice}}{{#isEuro}}€{{/isEuro}}{{^isEuro}}{{currencyCode}}{{/isEuro}}{{/discountedPrice}} | {{#isVegetarian}}VEG | {{/isVegetarian}} | {{#categoryType}}{{categoryType}}{{/categoryType}}</h7>
      </div>
      <div class="right menu-order"><a class="button" href="/repository/combo/prepareCombo/editCombo?comboId={{id}}">Edit</a><a class="button" href="/repository/combo/deleteCombo?comboId={{id}}">Delete</a>{{^soldOut}}<a class="button" style="background-color: green;" href="/repository/selectItem/setAvailablity?soldOut=true&itemId={{id}}">Set SoldOut</a>{{/soldOut}}{{#soldOut}}<a class="button" style="background-color: red;" href="/repository/selectItem/setAvailablity?soldOut=false&itemId={{id}}">Set Available</a>{{/soldOut}}</div>
      <div class="border3"></div>
      </li>
      {{/combos}}
      
      </ol>
      </article>
    
    <aside class="sidebar">
      <div class="menu-order"><a class="button" href="/repository/combo/prepareCombo/selectStarters" style="background-color: #d3394c;  margin: 20%; font-size: 18px;">Create new combo</a></div><br>  <div class="border3"></div>
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