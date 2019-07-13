$(function () {

    $("#btnRegister").click(register);

    function register() {
        var user = {};
        user.userName = $("#username").val();
        user.passWord = $("#password").val();
        user.email = $("#email").val();
        user.fullName = $("#fullname").val();
        user.phone = $("#phone").val();
        user.address = $("#address").val();

        $.post("", {"userNew": JSON.stringify(user)})
            .done(function (data) {
                var resp = JSON.parse(data);
                if (resp.userName === "") {
                    toastr["error"]("This username is exists.");
                    $("#password").val("");
                }
                else {
                    $(location).attr("href", "/profile");
                    toastr["success"](resp.userName + " is created!");
                }
            })
    }

    $(function(){
        $('.addToCart').click(function () {
            let url = $(this).attr('href');
            $.post(url).done(function(response){
                $("#num-of-items").text(response);
                toastr["success"]('Product was added successfully! Please check the cart for details.');
            });

            return false;
        });



    });

})