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
        <li><a href="/repository/selectItem/showAllItems" >Items</a></li>
        <li><a href="/repository/combo/getAllCombos" class="current">Combos</a></li>
    </ul>
    </nav>
  </header>
<body>
  <div class="wrapper">
    <div class="border"></div>
    
    <div class="wrap-contact100">
    
    <form method="POST" name="comboForm" action="{{nextAction}}" modelAttribute="combo" class="contact100-form validate-form">
    {{#combo}}
    <input type='hidden' name="id" {{#id}} value="{{id}}" {{/id}}>
				<span class="contact100-form-title">
					Enter Combo Details
				</span>

				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100"> Name</span>
					<input class="input100" type="text" name="name" placeholder="Enter combo name" {{#name}} value="{{name}}" {{/name}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Description is required">
					<span class="label-input100"> Description </span>
					<input class="input100" type="text" name="description" placeholder="Enter description" {{#description}}value="{{description}}"{{/description}}>
					<span class="focus-input100"></span>
				</div>
				
		
				<div class="wrap-input100 input100-select">
					<span class="label-input100">Delivery Option Type</span>
					<div>
						<select class="custom-select sources" name="deliveryOptionType" {{#deliveryOptionType}}value="{{deliveryOptionType}}"{{/deliveryOptionType}}>
							<option>Take Away</option>
							<option>Dine in</option>
						</select>
					</div>
				</div>

<div class="wrap-input100 validate-input" data-validate="Imageurls is required">
					<span class="label-input100"> Image Url</span>
					<input class="input100" type="text" name="imageurls" placeholder="Enter image url" {{#imageurls}}value="{{imageurls}}"{{/imageurls}}>
					<span class="focus-input100"></span>
				</div>
				
	<div class="wrap-input100 validate-input" data-validate="NormalPrice is required">
					<span class="label-input100"> Normal Price</span>
					<input class="input100" type="text" name="normalPrice" placeholder="Enter normal Price " {{#normalPrice}}value="{{normalPrice}}"{{/normalPrice}}>
					<span class="focus-input100"></span>
				</div>
	
				<div class="wrap-input100 validate-input" data-validate="DiscountedPrice is required">
					<span class="label-input100"> Discounted Price</span>
					<input class="input100" type="text" name="imageurls" placeholder="Enter discounted Price " {{#discountedPrice}}value="{{discountedPrice}}"{{/discountedPrice}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="CurrencyCode is required">
					<span class="label-input100"> Currency Code</span>
					<input class="input100" type="text" name="currencyCode" placeholder="Enter discounted Price " {{#currencyCode}}value="{{currencyCode}}"{{/currencyCode}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Available Days is required">
					<span class="label-input100"> Available Days</span>
					<input class="input100" type="text" name="availableDays" placeholder="Enter Available Days " {{#availableDays}}value="{{availableDays}}"{{/availableDays}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Available Time required">
					<span class="label-input100"> Available Time</span>
					<input class="input100" type="text" name="availableTime" placeholder="Enter Available Time  " {{#availableTime}}value="{{availableTime}}"{{/availableTime}}>
					<span class="focus-input100"></span>
				</div>
				
	
	<div class="wrap-input100 validate-input" data-validate="Quantity Value required">
					<span class="label-input100"> Quantity Value</span>
					<input class="input100" type="text" name="quantityValue" placeholder="Enter Quantity Value" {{#quantityValue}} value="{{quantityValue}}" {{/quantityValue}}>
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" data-validate="Quantity Unit required">
					<span class="label-input100"> Quantity Unit</span>
					<input class="input100" type="text" name="quantityUnit" placeholder="Enter Quantity Unit" {{#quantityUnit}}value="{{quantityUnit}}"{{/quantityUnit}}>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Rating  required">
					<span class="label-input100"> Rating</span>
					<input class="input100" type="text" name="rating" placeholder="Enter Rating" {{#rating}}value="{{rating}}"{{/rating}}>
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" data-validate="Prepared At required">
					<span class="label-input100"> Prepared At</span>
					<input class="input100" type="text" name="preparedAt" placeholder="Enter Prepared At value" {{#preparedAt}}value="{{preparedAt}}"{{/preparedAt}}>
					<span class="focus-input100"></span>
				</div>
				<input type="hidden" name=itemIds {{#itemIds}}value="{{itemIds}}"{{/itemIds}}>
				<input type="hidden" name=nextAction id=nextAction {{#nextAction}}value="{{nextAction}}"{{/nextAction}}>
				
				
				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn" >
							<span>
							{{#isItemToBeEdited}}Update Combo{{/isItemToBeEdited}}
							{{^isItemToBeEdited}}Create Combo{{/isItemToBeEdited}}
								<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
							</span>
						</button>
					</div>
				</div>
				{{/combo}}
			</form>
		</div>
    
    
    
    
    
    
    
    



<div class="border2"></div>
    <br>
  </div>

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
	</script>
<!--===============================================================================================-->
	<script src="/repository/css/contactformcss/vendor/daterangepicker/moment.min.js"></script>
	<script src="/repository/css/contactformcss/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/repository/css/contactformcss/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/repository/js/main.js"></script>

<script>

</script>

<!--Form Sprit Ends -->
</body>
<html>