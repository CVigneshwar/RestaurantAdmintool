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
        <li><a href="/repository/selectItem/showAllItems" >Items</a></li>
        <li><a href="/repository/combo/getAllCombos" class="current">Combos</a></li>
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
    line-height: 1.3;">Select items to create combo :</h6>
    
    
<ol class="progress progress--counter" id="progress" style="display: table; overflow:auto;background-color:transparent ;   margin: 25px; height: 1rem;    font-size: .75rem;    border-radius: .25rem; " >
  <li class="progress__step {{#stepSelectStarters}}progress__step--active{{/stepSelectStarters}}">Starters</li>
  <li class="progress__step {{#stepSelectMainCourse}}progress__step--active{{/stepSelectMainCourse}}">Main Course</li>
  <li class="progress__step {{#stepSelectDesserts}}progress__step--active{{/stepSelectDesserts}}">Desserts</li>
</ol>
{{#items}}
<div class="itembox">
      
    </label>
    <li>
    <ul> <p style="padding: 0px;margin: 0px;"><input type="checkbox" name="itemid" value="{{id}}" > {{name}} - {{normalPrice}}{{#isEuro}}&euro;{{/isEuro}}{{^isEuro}}{{currencyCode}}{{/isEuro}}</p></input></ul>
    <ul></ul>
    </li>
</div>
{{/items}}
</div>
<input type="hidden" id="nextAction" value={{nextAction}}>
<a class="button" value="create" onclick="doSubmit()" style="background-color: #d3394c; position: fixed;  bottom: 0px;  color: white;left: 45%;">{{^stepSelectDesserts}}Continue{{/stepSelectDesserts}}{{#stepSelectDesserts}}Create combo{{/stepSelectDesserts}}</a></div><br>  <div class="border3">
</div>
    
</form>
</div>

</div>
</div>
<script src="/repository/js/prepareCombo.js"></script>
</body>
</html>