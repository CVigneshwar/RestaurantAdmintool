<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>UBoxIt</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
    </head>
    <body>
    <form method="POST" modelAttribute="combo" action="/combo/createCombo">
<table style="width:100%" cellpadding="1" cellspacing="1" border="1" id="comboTable" >
{{#combo}}
  <tr>
    <td>Name</td><td><input type="text" name="name" value="{{name}}"></td>
   </tr>
   <tr>
	<td>Description</td><td><input type="text" name="description" value="{{description}}"></td>
	</tr>
   <tr>
	<td>Delivery Option Type</td><td><input type="text" name="deliveryOptionType" value="{{deliveryOptionType}}"></td>
	</tr>
   <tr>
	<td>Image Urls</td><td><input type="text" name="imageurls" value="{{imageurls}}"></td>
	</tr>
   <tr>
	<td>Normal Price</td><td><input type="text" name="normalPrice" value="{{normalPrice}}"></td>
	</tr>
   <tr>
	<td>Discounted Price</td><td><input type="text" name="discountedPrice" value="{{discountedPrice}}"></td> 
	</tr>
   <tr>
	<td>Currency Code</td><td><input type="text" name="currencyCode" value="{{currencyCode}}"></td>
	</tr>
   <tr>
    <td>Available Days</td><td><input type="text" name="availableDays" value="{{availableDays}}"></td>
    </tr>
   <tr> 
    <td>Available Time</td><td><input type="text" name="availableTime" value="{{availableTime}}"></td>
    </tr>
   <tr>
	<td>Quantity Value</td><td><input type="text" name="quantityValue" value="{{quantityValue}}"></td>
	</tr>
   <tr>
	<td>Quantity Unit</td><td><input type="text" name="quantityUnit" value="{{quantityUnit}}"></td>
	</tr>
   <tr>
	<td>Rating</td><td><input type="text" name="rating" value="{{rating}}"></td>
	</tr>
  {{/combo}}
</table>
<input type="submit" value="Submit Combo Details">
</form>
    </body>