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

/**
 * 注册请求
 * @param UserName
 * @param PassWord
 * @param Profession
 * @param Sex
 * @param Age
 * @param HobbyJson
 * @constructor
 */
function Register(UserName, PassWord, Profession, Sex, Age, HobbyJson) {
    $.ajax({
        method: 'POST',
        url: '/Register/register',
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

/**
 * 初始化注册页面的选择项
 */
function init() {
    initSelectProfession();
    initSelectHobby();
}

/**
 * 初始化职业选择项
 */
function initSelectProfession() {
    $.getJSON("/getAllProfession", function (data) {
        var ProfessionList = $("#ProfessionList");
        for (var i in data) {
            ProfessionList.options.add(new Option(i.ProfessionName, i.ProfessionID));
        }
    });
}

/**
 * 初始化爱好选择项
 */
function initSelectHobby() {
    $.getJSON("/getAllHobby", function (data) {
        var HobbyOption = $("#HobbyOption");
        for (var i in data) {
            HobbyOption.append(
                '<div class="form-check form-check-inline">' +
                '<label class="form-check-label">' +
                '<input type="checkbox" class="form-check-input" value="' + i.HobbyID + '"/>' + i.HobbyName +
                '</label>' +
                '</div>'
            );
        }
    });
}