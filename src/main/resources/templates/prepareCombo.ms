<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UBoxIt</title>
<link href="/repository/css/styles/comboboxstyle.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/repository/css/styles/style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="/repository/css/contactformcss/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">


<link href="https://fonts.googleapis.com/css?family=Patua+One" rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<style>

* {
     -webkit-box-sizing: unset;
    -moz-box-sizing: unset;
     box-sizing: unset; 
}
</style>
</head>
<body>

<div id="container">
  <header>
    <nav>
      <ul id="nav">
        <!-- <li><img src="/repository/css/images/Uboxitlogo.png"></li> -->        
        <li><a href="/repository/selectItem/showAllItems" >Items</a></li>
        <li><a href="/repository/combo/showAllItems" class="current">Combos</a></li>
    </ul>
    </nav>
  </header>
  <div class="border"></div>
<div class="alignleft" style="width: 70%; float: left; display: block;">
<form method="POST" id="itemlist" >

<div class="wrapper">
    
    <div class="allItems" style="width: 900px;">
    <h6 style="font-size: 25px;
    font-family: 'Lobster13Regular', cursive;
    color: #9c5959;
    text-shadow: 0px 1px 1px rgba(0, 0, 0, 0.2);
    font-weight: normal;
    line-height: 1.3;">Select items to create combo</h6>
{{#items}}
<div class="itembox">
<div class=" col-sm-3 nopad text-center">
    <label class="itembox image-checkbox" style="height: 120px;width: 400px;border: solid;padding: 0px; display: inline-flex; width: auto;">
      <!-- <img class="img-responsive" src="{{imageurls}}"/> -->
      <img class="img-responsive" src="https://res.cloudinary.com/your-delicacy-bv/image/upload/Combo1"/>
      <input type="checkbox" name="itemid" value="{{id}}" />
      <i class="fa fa-check hidden"></i>
    </label>
    <li>
    <ul><p style="padding: 0px;margin: 0px;">{{name}} - {{normalPrice}}{{#isEuro}}&euro;{{/isEuro}}{{^isEuro}}{{currencyCode}}{{/isEuro}}</p></ul>
    <ul><p style="padding: 0px;margin: 0px;">{{#isVegetarian}}<img src="/repository/css/images/icon_vegetarian.png" style="width: auto;" class="vegicon">{{/isVegetarian}} {{itemType}} | {{deliveryOptionType}}</p></ul>
    <ul></ul>
    </li>
</div>
</div>
{{/items}}
</div>
<a class="button" value="create" onclick="doSubmit()" style="background-color: #d3394c; position: fixed;  bottom: 0px;  left: 35%;">Create combo</a></div><br>  <div class="border3">
</div>
    
</form>
</div>
<div class="alignright" style="
    width: 25%;
    float: right;
    display: grid;
    margin-top: 5%;
    border: solid;
    background-color: #9c5959;
    border-color: darkgray;

">

<aside class="sidebar">

<h6 style="font-size: 25px;font-family: 'Lobster13Regular', cursive; color: antiquewhite; text-shadow: 0px 1px 1px rgba(0, 0, 0, 0.2); font-weight: normal; line-height: 1.3;  margin-left: 15%;  margin-bottom: 13%;">Today's Combos</h6>

<div class="itembox" style=" background-color: bisque;  width: 78%;">
<div class=" nopad text-center" style="
    border-color:  ghostwhite;
    width: 98%;
">
    <label class="itembox " style="height: 120px;width: 400px;border: solid;padding: 0px; display: inline-flex; width: auto;">
      <!-- <img class="img-responsive" src="https://www.uboxit.nl"/> -->
      <img class="img-responsive" src="https://res.cloudinary.com/your-delicacy-bv/image/upload/Combo1">
      
    </label>
    <li>
    <ul><p style="padding: 0px;margin: 0px;">Combo1 - 20EUR</p></ul>
    <ul><p style="padding: 0px;margin: 0px;">  | TAKE_AWAY</p></ul>
    <ul></ul>
    </li>
</div>
</div>

    </aside>

<aside class="sidebar">
<h6 style="font-size: 25px;font-family: 'Lobster13Regular', cursive; color: antiquewhite; text-shadow: 0px 1px 1px rgba(0, 0, 0, 0.2); font-weight: normal; line-height: 1.3;  margin-left: 15%;  margin-bottom: 13%;">Existing Combos</h6>
{{#combos}}
    <div class="itembox" style=" background-color: bisque;  width: 78%;">
<div class=" nopad text-center" style="
    border-color:  ghostwhite;
    width: 98%;
">
    <label class="itembox image-checkbox" style="height: 120px;width: 400px;border: solid;padding: 0px; display: inline-flex; width: auto;">
      <!-- <img class="img-responsive" src="{{imageurls}}"/> -->
      <img class="img-responsive" src="https://res.cloudinary.com/your-delicacy-bv/image/upload/Combo1"/>
      <input type="checkbox" name="itemid" value="60000">
      <i class="fa fa-check hidden"></i>
    </label>
    <li>
    <ul><p style="padding: 0px;margin: 0px;">{{name}} - {{normalPrice}}{{#isEuro}}&euro;{{/isEuro}}{{^isEuro}}{{currencyCode}}{{/isEuro}}</p></ul>
    <ul><p style="padding: 0px;margin: 0px;">{{#isVegetarian}}<img src="/repository/css/images/icon_vegetarian.png" style="width: auto;" class="vegicon">{{/isVegetarian}} {{itemType}} | {{deliveryOptionType}}</p></ul>
    <ul></ul>
    </li>
</div>
</div>  
<br>
      
      {{/combos}}  
      <a class="button" value="create" onclick="doSubmit()" style="background-color: #d3394c; position: fixed;  bottom: 0px;  right: 15%;">Make it today's combo</a></div><br>  <div class="border3">
    </aside>
</div>
</div>
<script src="/js/prepareCombo.js"></script>
</body>
</html>