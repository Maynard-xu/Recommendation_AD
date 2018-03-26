$(function () {
    initADList();
    $('#ssi-upload').ssi_uploader({url: '/dsp/upload', maxFileSize: 1, allowed: ['jpg', 'gif', 'txt', 'png', 'pdf']});
    // $("#submit").click(function () {
    //     $("")
    // });
    // $("#zwb_upload").bindUpload({
    //     url:"/dsp/upload",//上传服务器地址
    //     callbackPath:"#callbackPath2",//绑定上传成功后 图片地址的保存容器的id或者class 必须为input或者textarea等可以使用$(..).val()设置之的表单元素
    //     // ps:值返回上传成功的 默认id为#callbackPath  保存容器为位置不限制,id需要加上#号,class需要加上.
    //     // 返回格式为:
    //     // 原来的文件名,服务端保存的路径|原来的文件名,服务端保存的路径|原来的文件名,服务端保存的路径|原来的文件名,服务端保存的路径....
    //     num:10,//上传数量的限制 默认为空 无限制
    //     type:"jpg|png|gif|svg",//上传文件类型 默认为空 无限制
    //     size:3//上传文件大小的限制,默认为5单位默认为mb
    // });
});

function initADList() {
    $.getJSON("/dsp/getAllADInformation", function (data) {
        var tbody = $("#ad_list");
        for (var i in data) {
            // console.log(data[i]);
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
}