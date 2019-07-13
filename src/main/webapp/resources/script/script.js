$(function () {

    $("#btnRegister").click(register);

    function register() {
        var user = {};
        user.userName = $("#username").val();
        user.passWord = $("#password").val();
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
                }
                else {
                    $(location).attr("href", "/profile");
                    toastr["success"](resp.userName + " is created!");
                }
            })
    }

})