$(function () {
    $("#register").click(function () {
        var UserName = $("#UserName").val().trim();
        var PassWord = $("#pwd").val().trim();
        var Profession = $("#Profession").val().trim();
        var Sex = $("#Sex").val().trim();
        var Age = $("#Age").val().trim();
        var Hobby = $("#Hobby").val().trim();
        //获取选择中爱好项
        //————————————————————————————————————————————————————
        var HobbyOptionList = $("#HobbyOption").find("input");
        var HobbyJson = {};
        var HobbySelected = [];
        HobbySelected.push(Hobby);
        HobbyOptionList.each(function () {
            if ($(this).is(":checked")) {
                HobbySelected.push(this.value);
            }
        });
        //————————————————————————————————————————————————————
        //进行ajax请求
        console.log(HobbySelected);
        console.log(PassWord);
        HobbyJson["HobbySelected"] = HobbySelected;
        Register(UserName, PassWord, Profession, Sex, Age, HobbyJson);
    });


});

function Register(UserName, PassWord, Profession, Sex, Age, HobbyJson) {
    $.ajax({
        method: 'POST',
        url: '/register',
        data: {
            'UserName': UserName,
            'PassWord': PassWord,
            'Profession': Profession,
            'Sex': Sex,
            'Age': Age,
            'Hobby': JSON.stringify(HobbyJson)
        },
        success: function (e) {
            if (e.code == 200) {
                window.location.href = "/login";
                console.log("进来了，没跳转！");
                alert(e.message);
            } else {
                alert(e.message);
            }
        },
        error: function () {
            alert("Error!");
        }
    });
}