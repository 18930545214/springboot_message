function refresh() {
    $("#imgCode").attr("src","code.jsp?timestamp=" + new Date().getTime())
}
function login() {
    if (code()) {
        $.ajaxSettings.async = false;
        $.get("login", {
            "name": $("#name").val(),
            "pwd": $("#pwd").val()
        }, function (data) {
            if (data.info === "success") {
                window.location = "main.jsp";
            } else {
                refresh();
            }
        }, "json")
    }
}
function code() {
    var code = $("#code").val();
    var flag = true;
    $.ajaxSettings.async = false;
    $.get("Code", {
        "code": code
    }, function (data) {
        if (data.info === "success") {
            $("#error").html("");
        } else {
            $("#error").html("验证码错误").css("color", "red");
            refresh();
            flag = false;
        }
    },"json");
    return flag
}