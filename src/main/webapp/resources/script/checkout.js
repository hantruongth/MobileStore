"use strict";

$(function(){
    var success = false;
    $(".payment-form").submit( (e) => {
        console.log(e);
        e.preventDefault();
        var order = {};
        order.fullName = $("#fullName").val();
        order.shippingAddress = $("#address").val();
        order.paymentMethod = $("[name='payment']:checked").val();
        order.comment = $("#comment").val();

        console.log("order", order);

        $.post("checkout", {
            order: JSON.stringify(order)
        }).done(orderSuccess).fail(error);
    });

    function orderSuccess(data) {
        if (data == "success") {
            success = true;
            $("#myModal").modal("show");
        } else {
            success = false;
            $("#alertBody").html("There are some errors from our system. Please try again.")
            $("#myModal").modal("show");
        }
        console.log(data);
    }

    function error(err) {
        console.log(err);
        success = false;
    }

    $('#myModal').on('hidden.bs.modal', function (e) {
        console.log("Hide");
        if(success) {
            $(location).attr("href", "/");
        }
    });

});
