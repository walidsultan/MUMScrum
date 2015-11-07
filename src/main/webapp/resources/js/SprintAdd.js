$(document).ready(function() {

	$("#startDate").datepicker();
	$("#endDate").datepicker();

});


//function purchaseProduct(productId) {
//	$.ajax({
//		url : '/cns/products/purchaseProduct',
//		type : 'GET',
//		dataType : 'text json',
//		contentType : "application/json",
//		data : {
//			'productId' : productId
//		},
//		success : function(response) {
//		
//		},
//		error : function(error) {
//			if(error.statusText == "OK"){
//				markPurchased(productId);
//				$.unblockUI();
//			}
//		}
//	});
//}

