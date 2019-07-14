
$(function () {

    $("#btnRegister").click(register);

    function register() {
        var user = {};
        user.userName = $("#username").val();
        user.password = $("#password").val();
        user.fullName = $("#fullname").val();
        user.email = $("#email").val();
        user.phone = $("#phone").val();
        user.address = $("#address").val();

        $.post("", {"userNew": JSON.stringify(user)})
            .done(function (data) {
                var resp = JSON.parse(data);
                if (resp.userName === "") {
                    toastr["error"]("This username is exists.");
                    $("#password").val("");
                } else {
                    $(location).attr("href", "/profile");
                    toastr["success"](resp.userName + " is created!");
                }
            })
    }

    $('.addToCart').click(function () {
        var url = $(this).attr('href');
        $.post(url).done(function (response) {
            $("#num-of-items").text(response);
            toastr["success"]('Product was added successfully! Please check the cart for details.');
        }).fail(function () {
            toastr["error"]('Error! Please contact Administrator');

        });

        return false;
    });

    $('#btnContinueShopping').click(function () {
        $(location).attr("href", "/");
    });

    $('#btnRemove, #btnUpdate').click(function () {

        let action = $(this).val();
        let productIds = "";
        let product = {};
        let data = {"product": product};
        $('input[type=checkbox]').each(function () {
            if (this.checked) {
                let productId = $(this).val();
                productIds += productId + ",";
                product[""+productId] = $("#quantity_"+productId).val();

            }
        });
        let url = "shopping-cart?ids=" + productIds + "&action=" + action;

        $.ajax({
            url: url,
            type: 'put',
            data: JSON.stringify(product),
            success: location.reload(),
            contentType: 'json'
        });
    });

    $("#btnCheckout").click(()=>{
        console.log("checkout click");
        if ($(".item").length > 0) {
            $(location).attr("href", "checkout");
            $("#num-of-items").text(0);
        } else {
            $("#alertBody").html("Please add item in your cart before doing checkout.")
            $("#myModal").modal("show");
        }
    });



})