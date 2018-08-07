<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UBoxIt</title>
<link href="/repository/css/styles/style.css" rel="stylesheet" type="text/css" media="screen" />


<!--Form CSS starts-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>

	<link rel="stylesheet" type="text/css" href="/repository/css/contactformcss/util.css">
	<link rel="stylesheet" type="text/css" href="/repository/css/contactformcss/main.css">
<!--Form CSS ends-->

</head>
<body>
<div id="container">
  <header>
    <nav>
      <ul id="nav">
        <li><a href="/repository/selectItem/showAllItems" class="current">Items</a></li>
        <li><a href="/repository/combo/showAllItems">Combos</a></li>
    </ul>
    </nav>
  </header>
<body>
  <div class="wrapper">
    <div class="border"></div>
    
    <div class="wrap-contact100">
    <form method="POST" id="updateItemSubmit" modelAttribute="item" name="item" class="contact100-form validate-form">
    {{#item}}
    <input type='hidden' name="id" {{#id}} value="{{id}}" {{/id}}>
				<span class="contact100-form-title">
					Enter Item Details
				</span>

				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100"> Name</span>
					<input class="input100" type="text" name="name" placeholder="Enter item name" {{#name}} value="{{name}}" {{/name}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Caption is required">
					<span class="label-input100"> Caption </span>
					<input class="input100" type="text" name="caption" placeholder="Enter caption" {{#caption}} value="{{caption}}" {{/caption}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Description is required">
					<span class="label-input100"> Description </span>
					<input class="input100" type="text" name="description" placeholder="Enter description" {{#description}} value="{{description}}" {{/description}}>
					<span class="focus-input100"></span>
				</div>
				
   
	<div class="wrap-input100 input100-select">
					<span class="label-input100">Item Type </span>
					<div >
						<select class="custom-select sources" id="itemType" name="itemType" {{#itemType}} value="{{itemType}}" {{/itemType}}>
							<option value="STARTERS">STARTERS</option>
							<option value="MAIN_COURSE">MAIN_COURSE</option>
							<option value="DESSERTS">DESSERTS</option>
						</select>
					</div>
					
				</div>
	
				<div class="wrap-input100 input100-select">
					<span class="label-input100">Diet Type</span>
					<div>
						<select class="custom-select sources" id="dietType" name="dietType" {{#dietType}} value="{{dietType}}" {{/dietType}}>
							<option value="NON_VEGETARIAN">NON_VEGETARIAN</option>
							<option value="VEGETARIAN">VEGETARIAN</option>
						</select>
					</div>
				</div>

	
				<div class="wrap-input100 input100-select">
					<span class="label-input100">Delivery Option Type</span>
					<div>
						<select class="custom-select sources" id="deliveryOptionType"name="deliveryOptionType" {{#deliveryOptionType}} value="{{deliveryOptionType}}" {{/deliveryOptionType}}>
							<option>TAKE_AWAY</option>
							<option>DINE_IN</option>
						</select>
					</div>
				</div>

<div class="wrap-input100 validate-input" data-validate="Imageurls is required">
					<span class="label-input100"> Image Url</span>
					<input class="input100" type="text" name="imageurls" placeholder="Enter image url" {{#imageurls}} value="{{imageurls}}" {{/imageurls}}>
					<span class="focus-input100"></span>
				</div>
				
	<div class="wrap-input100 validate-input" data-validate="NormalPrice is required">
					<span class="label-input100"> Normal Price</span>
					<input class="input100" type="text" name="normalPrice" placeholder="Enter normal Price " {{#normalPrice}} value="{{normalPrice}}" {{/normalPrice}} required>
					<span class="focus-input100"></span>
				</div>
	
				<div class="wrap-input100 validate-input" data-validate="DiscountedPrice is required">
					<span class="label-input100"> Discounted Price</span>
					<input class="input100" type="text" name="discountedPrice" placeholder="Enter discounted Price " {{#discountedPrice}} value="{{discountedPrice}}" {{/discountedPrice}} value="" required>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="CurrencyCode is required">
					<span class="label-input100"> Currency Code</span>
					<input class="input100" type="text" name="currencyCode" placeholder="Enter Currencycode " {{#currencyCode}} value="{{currencyCode}}" {{/currencyCode}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Available Days is required">
					<span class="label-input100"> Available Days</span>
					<input class="input100" type="text" name="availableDays" placeholder="Enter Available Days. Ex:Monday,Tuesday " {{#availableDays}} value="{{availableDays}}" {{/availableDays}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Available Time required">
					<span class="label-input100"> Available Time</span>
					<input class="input100" type="text" name="availableTime" placeholder="Enter Available Time. Ex:10-12,16-20 " {{#availableTime}} value="{{availableTime}}" {{/availableTime}}>
					<span class="focus-input100"></span>
				</div>
				
	
	<div class="wrap-input100 validate-input" data-validate="Ingredients required">
					<span class="label-input100"> Ingredients</span>
					<input class="input100" type="text" name="ingredients" placeholder="Enter Ingredients  " {{#ingredients}}value="{{ingredients}}" {{/ingredients}}>
					<span class="focus-input100"></span>
				</div>
				
					<div class="wrap-input100 validate-input" data-validate="Category Type required">
					<span class="label-input100"> Category Type</span>
					<input class="input100" type="text" name="categoryType" placeholder="Enter Category Type" {{#categoryType}} value="{{categoryType}}" {{/categoryType}}>
					<span class="focus-input100"></span>
				</div>
				
	
	<div class="wrap-input100 validate-input" data-validate="Quantity Value required">
					<span class="label-input100"> Quantity Value</span>
					<input class="input100" type="text" name="quantityValue" placeholder="Enter Quantity Value" {{#quantityValue}}value="{{quantityValue}}" {{/quantityValue}}>
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" data-validate="Quantity Unit required">
					<span class="label-input100"> Quantity Unit</span>
					<input class="input100" type="text" name="quantityUnit" placeholder="Enter Quantity Unit" {{#quantityUnit}} value="{{quantityUnit}}" {{/quantityUnit}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Rating  required">
					<span class="label-input100"> Rating</span>
					<input class="input100" type="text" name="rating" placeholder="Enter Rating" {{#rating}} value="{{rating}}" {{/rating}} >
					<span class="focus-input100"></span>
				</div>
	<div class="wrap-input100 validate-input" data-validate="Prepared At required">
					<span class="label-input100"> Prepared At</span>
					<input class="input100" type="text" name="preparedAt" placeholder="Enter Prepared At value" {{#preparedAt}} value="{{preparedAt}}" {{/preparedAt}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Coverage Distance required">
					<span class="label-input100"> Coverage Distance</span>
					<input class="input100" type="text" name="coverageDistance" placeholder="Enter Coverage Distance " {{#coverageDistance}} value="{{coverageDistance}}" {{/coverageDistance}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="normalPriceForCustomcombo  required">
					<span class="label-input100">Normal price for custom combo</span>
					<input class="input100" type="text" name="normalPriceForCustomcombo" placeholder="Enter normal price for custom combo" {{#normalPriceForCustomcombo}} value="{{normalPriceForCustomcombo}}" {{/normalPriceForCustomcombo}} required>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="discountedPriceForCustomcombo  required">
					<span class="label-input100">Discounted price for custom combo</span>
					<input class="input100" type="text" name="discountedPriceForCustomcombo" placeholder="Enter discounted price for custom combo" {{#normalPriceForCustomcombo}} value="{{normalPriceForCustomcombo}}" {{/normalPriceForCustomcombo}} required>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 input100-select">
					<span class="label-input100">Is it allowed for Custom Combo ?</span>
					<div>
						<select class="custom-select sources" id="allowedForCustomcombo" name="allowedForCustomcombo" >
							<option value="false">NO</option>
							<option value="true">YES</option>
						</select>
					</div>
				</div>
				
				<div class="wrap-input100 input100-select">
					<span class="label-input100">Is it allowed for Individual Sale ?</span>
					<div>
						<select class="custom-select sources" id="allowedForIndividualSale" name="allowedForIndividualSale" >
							<option value="true">YES</option>
							<option value="false">NO</option>
						</select>
					</div>
				</div>
				
				<div class="wrap-input100 input100-select">
					<span class="label-input100">Is it soldOut ?</span>
					<div>
						<select class="custom-select sources" id="soldOut" name="soldOut" >
							<option value="false">NO</option>
							<option value="true">YES</option>
						</select>
					</div>
				</div>
				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn" onClick="document.getElementById('updateItemSubmit').submit">
							<span>
							{{#isItemToBeEdited}}Update Item{{/isItemToBeEdited}}
							{{^isItemToBeEdited}}Create Item{{/isItemToBeEdited}}
								<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
							</span>
						</button>
					</div>
				</div>
<script>

	{{#itemType}}
	var itemType="{{itemType}}";
	var itemID = "#itemType";
	{{/itemType}}
	
	{{#dietType}}
	var dietType="{{dietType}}";
	var dietTypeId = "#dietType";
	{{/dietType}}
	
	{{#deliveryOptionType}}
	var deliveryOptionType = "{{deliveryOptionType}}";
	var deliveryOptionTypeId = "#deliveryOptionType";
	{{/deliveryOptionType}}
	
	{{#allowedForCustomcombo}}
	var allowedForCustomcombo = "{{allowedForCustomcombo}}";
	var allowedForCustomcomboId = "#allowedForCustomcombo";
	{{/allowedForCustomcombo}}
	
	{{#allowedForIndividualSale}}
	var allowedForIndividualSale = "{{allowedForIndividualSale}}";
	var allowedForIndividualSaleId = "#allowedForIndividualSale";
	{{/allowedForIndividualSale}}
	
	{{#soldOut}}
	var soldOut = "{{soldOut}}";
	var soldOutId = "#soldOut";
	{{/soldOut}}
	</script>				
				{{/item}}
			</form>
		</div>
    
    
    
    
    
    
    
    



<div class="border2"></div>
    <br>
  </div>
<script type="text/javascript">
var isItemToBeEdited = {{isItemToBeEdited}}
document.getElementById('updateItemSubmit').action="addOrUpdateItem?isItemToBeEdited="+isItemToBeEdited;
</script>

<!--Form Script Starts -->
	<script src="/repository/css/contactformcss/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/repository/css/contactformcss/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="/repository/css/contactformcss/vendor/bootstrap/js/popper.js"></script>
	<script src="/repository/css/contactformcss/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/repository/css/contactformcss/vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
		
		$(document).ready(function() {
    	
    	$(itemID).val(itemType);
	$(dietTypeId).val(dietType);
	$(deliveryOptionTypeId).val(deliveryOptionType);
	$(allowedForCustomcomboId).val(allowedForCustomcombo);
	$(allowedForIndividualSaleId).val(allowedForIndividualSale);
	$(soldOutId).val(soldOut);
    
});
	
	</script>
<!--===============================================================================================-->
	<script src="/repository/css/contactformcss/vendor/daterangepicker/moment.min.js"></script>
	<script src="/repository/css/contactformcss/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/repository/css/contactformcss/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/repository/js/main.js"></script>

<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>

<!--Form Sprit Ends -->


</body>
<html>