$(function(){
    $("#uploadForm").submit(upload);
});

function upload() {
    // 数据设置较多，使用ajax
    $.ajax({
        // 请求提交路径
        url: "http://upload-z1.qiniup.com",
        method: "post",
        // 不要将表单的内容转换为字符串
        processData: false,
        // 不要Jquary设置数据类型
        contentType: false,
        data: new FormData($("#uploadForm")[0]),
        success: function(data) {
            if(data && data.code == 0) {
                // 更新头像访问路径
                $.post(
                    CONTEXT_PATH + "/user/header/url",
                    {"fileName":$("input[name='key']").val()},
                    function(data) {
                        data = $.parseJSON(data);
                        if(data.code == 0) {
                            window.location.reload();
                        } else {
                            alert(data.msg);
                        }
                    }
                );
            } else {
                alert("上传失败!");
            }
        }
    });
    return false;
}