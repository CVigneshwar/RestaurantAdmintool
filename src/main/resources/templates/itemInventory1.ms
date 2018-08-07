<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" /> 
    <title>Items Inventory</title>
    </head>
<body>
<script>


</script>
<form method="POST" id="itemSubmit" >
<table style="width:100%" cellpadding="1" cellspacing="1" border="1" id="itemTable">
  <tr>
  <th>Select</th>
  <th>Id</th>
    <th>Name</th> 
    <th>Caption</th>
	<th>Description</th>
	<th>Delivery Option Type</th>
	<th>Diet Type</th>
	<th>Item Type</th>
	<th>Image Urls</th>
	<th>Normal Price</th>
	<th>Discounted Price</th>
	<th>Currency Code</th>
    <th>Available Days</th> 
    <th>Available Time</th>
	<th>Ingredients</th>
	<th>Category type</th>
	<th>Combo Id</th>
	<th>Quantity Value</th>
	<th>Quantity Unit</th>
	<th>Rating</th>
	<th>Prepared at</th>
	<th>Coverage Distance</th>
	<th>Actions</th>
  </tr>
  {{#items}}
  <tr>
   <td><input type="radio" name="selectedItem" value="{{id}}" onclick="getAction()"/></td>
    <td><input type='text' name="id" value="{{id}}"></td>
    <td><input type='text' name="name" value="{{name}}"></td> 
    <td><input type='text' name="caption" value="{{caption}}"></td>
	<td><input type='text' name="description" value="{{description}}"></td>
	<td><input type='text' name="deliveryOptionType" value="{{deliveryOptionType}}"></td>
	<td><input type='text' name="dietType" value="{{dietType}}"></td>
	<td><input type='text' name="itemType" value="{{itemType}}"></td>
	<td><input type='text' name="imageurls" value="{{imageurls}}"></td>
	 <td><input type='text' name="normalPrice" value="{{normalPrice}}"></td>
    <td><input type='text' name="discountedPrice" value="{{discountedPrice}}"></td> 
    <td><input type='text' name="currencyCode" value="{{currencyCode}}"></td>
	<td><input type='text' name="availableDays" value="{{availableDays}}"></td>
	<td><input type='text' name="availableTime" value="{{availableTime}}"></td>
	<td><input type='text' name="ingredients" value="{{ingredients}}"></td>
	<td><input type='text' name="categoryType" value="{{categoryType}}"></td>
	<td><input type='text' name="comboId" value="{{comboId}}"></td>
	<td><input type='text' name="quantityValue" value="{{quantityValue}}"></td>
    <td><input type='text' name="quantityUnit" value="{{quantityUnit}}"></td> 
    <td><input type='text' name="rating" value="{{rating}}"></td>
	<td><input type='text' name="preparedAt" value="{{preparedAt}}"></td>
	<td><input type='text' name="coverageDistance" value="{{coverageDistance}}"></td>
  </tr>
  {{/items}}
</table>
<input type="submit" value="Update Item">
<input type="submit" value="Create Item" onclick="getActionForAddItem()">
</form>
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


 

</body>
<html>