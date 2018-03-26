$(function () {
    /**
     * 初始化广告列表
     */
    initADList();

    /**
     * 提交图片
     */
    $("#ssi-upload").ssi_uploader({url: '/dsp/upload', maxFileSize: 1, allowed: ['jpg', 'gif', 'txt', 'png', 'pdf']});
    /**
     * 提交新的广告信息
     */
    $("#submit").click(function () {
        var ADInfo = {};
        var ADTitle = $("#ad_title").val().trim();
        var SelectCrowd = $("#peopleSelect").find("option:selected").text().trim();
        var SelectGender = $("#sexSelect").find("option:selected").text().trim();
        var pictureName = $("table.ssi-imgToUploadTable tbody tr td").last().text().trim();
        //获取AD类别
        //---------------------------–-----–--–-–--–-–----------
        var ADClasses = {};
        var ADClassesList = $("#ClassesOption").find("input");
        var ADClassesSelected = [];
        ADClassesList.each(function () {
            if ($(this).is(":checked")) {
                ADClassesSelected.push(this.value);
            }
        });
        ADClasses["ADClassesSelected"] = ADClassesSelected;
        //---------------------------–-----–--–-–--–-–----------
        var ADDescribe = $("#comment").val().trim();
        var RTBPrice = $("#rtbPrice").val().trim();
        //格式化请求数据
        ADInfo["ADTitle"] = ADTitle;
        ADInfo["SelectCrowd"] = SelectCrowd;
        ADInfo["SelectGender"] = SelectGender;
        ADInfo["pictureName"] = pictureName;
        ADInfo["ADClasses"] = "" + ADClasses;
        ADInfo["ADDescribe"] = ADDescribe;
        ADInfo["RTBPrice"] = RTBPrice;
        console.log(ADInfo);
        addADInfo(ADInfo);
    });
});

/**
 * 添加新的广告信息
 * @param ADInfo
 */
function addADInfo(ADInfo) {
    $.ajax({
        method: "post",
        url: "/dsp/addADInfo",
        contentType: "application/json",
        data: JSON.stringify(ADInfo),
        success: function (e) {
            if (e.code == 200) {
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
 * 初始化广告列表
 */
function initADList() {
    $.getJSON("/dsp/InitADInformation", function (data) {
        var tbody = $("#ad_list");
        for (var i in data) {
            tbody.append(
                '<tr>' +
                '<td align="center">' + data[i]["adid"] + '</td>' +
                '<td align="center" style="width:222px">' + data[i]["adtitle"] + '</td>' +
                '<td align="center">' + JSON.parse(data[i]["adclasses"])["Classes"] + '</td>' +
                '<td align="center" style="width:180px">' + data[i]["addescribe"] + '</td>' +
                '<td align="center">' + data[i]["rtbprice"] + '</td>' +
                '<td style="width:200px">' +
                '<div class="operation text-center">' +
                '<!--编辑广告部分内容-->' +
                '   <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#edit_' + i + '">编辑 </button>' +
                '<div class="modal fade text-left" id="edit_' + i + '">' +
                '<!--在modal-dialog后面设置模态框大小 modal-lg modal-sm-->' +
                '<div class="modal-dialog modal-lg">' +
                '<div class="modal-content">' +
                '<!--模态框头部-->' +
                '<div class="modal-header">' +
                '<h4 class="modal-title">Edit AD Information</h4>' +
                '</div>' +
                '<!--模态框主体-->' +
                '<div class="modal-body" style="width: 100%">' +
                '<div class="register_form">' +
                '<div class="form-group">' +
                '<label class="control-label">AD Title</label>' +
                '<input required="required" type="text" class="form-control"' +
                'placeholder="' + data[i]["adtitle"] + '"/>' +
                '</div>' +
                '<div class="form-group">' +
                '<label class="control-label">AD Classes</label>' +
                '<div id="editHobbyOption">' +
                '<div class="form-check form-check-inline">' +
                '<label class="form-check-label">' +
                '<input type="checkbox" class="form-check-input"\n' +
                'value="1"/>IT' +
                '</label>' +
                '</div>' +
                '<div class="form-check form-check-inline">' +
                '<label class="form-check-label">' +
                '<input type="checkbox" class="form-check-input"\n' +
                'value="2"/>IOT' +
                '</label>' +
                '</div>' +
                '<div class="form-check disabled form-check-inline">' +
                '<label class="form-check-label">' +
                '<input type="checkbox" class="form-check-input"\n' +
                'value="3"/>Children' +
                '</label>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="form-group">' +
                '<label class="control-label">AD Describe</label>' +
                '<textarea type="text" class="form-control" rows="5">' + data[i]["addescribe"] + '</textarea>' +
                '</div>' +
                '<div class="form-group">' +
                '<label class="control-label">RTB Price</label>' +
                '<input class="form-control input-lg" type="text" name="cat_add"' +
                'value=""' +
                'placeholder="' + data[i]["rtbprice"] + '"/>' +
                '</div>' +
                '<input type="submit" value="complete"' +
                'class="float-right bg-success text-white" id="complete"/>' +
                '<!--<button type="button" class="btn btn-primary" id="register">Register</button>-->' +
                '</div>' +
                '</div>' +
                '<!--模态框底部-->' +
                '<div class="modal-footer">' +
                '<button type="button" class="btn btn-secondary" data-dismiss="modal">' +
                '关闭' +
                '</button>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<button type="button" class="btn btn-sm btn-danger">删除</button>' +
                '</div>' +
                '</td>' +
                '</tr>'
            );
        }
    });
    $.getJSON("/profession/initprofession", function (data) {
        var ClassesOption = $("#ClassesOption");
        for (var i in data) {
            ClassesOption.append(
                '<div class="form-check form-check-inline">' +
                '<label class="form-check-label">' +
                '<input type="checkbox" class="form-check-input" value="' + data[i].professionId + '"/>' + data[i].professionName +
                '</label>' +
                '</div>'
            );
        }
    });
}