function loadCategoryLevel(pid, cl, categoryLevel, i) {
    $.ajax({
        type: "GET",//请求类型
        url: "/dev/levelMenu" + i,//请求的url
        data: {pid: pid},//请求参数
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
            $("#" + categoryLevel).html("");
            var options = "<option value=\"\">--请选择--</option>";
            for (var i = 0; i < data.length; i++) {
                if (cl != null && cl != undefined && data[i].id == cl) {
                    options += "<option selected=\"selected\" value=\"" + data[i].id + "\" >" + data[i].categoryName + "</option>";
                } else {
                    options += "<option value=\"" + data[i].id + "\">" + data[i].categoryName + "</option>";
                }
            }
            $("#" + categoryLevel).html(options);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {//当访问时候，404，500 等非200的错误状态码
            // alert(i+"     "+cl);
            // alert(XMLHttpRequest.status);
            // alert(XMLHttpRequest.readyState);
            // alert(textStatus);
            alert("加载分类列表失败！");
        }
    });
}

$(function () {
    //动态加载所属平台列表
    $.ajax({
        type: "GET",//请求类型
        data: "",
        url: "/doDeveloper/dictionary.json",//请求的url
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
            var fid = $("#fid").val();
            $("#flatformId").html("");
            var options = "";
            for (var i = 0; i < data.length; i++) {
                if (fid != null && fid != undefined && data[i].valueId == fid) {
                    options += "<option selected=\"selected\" value=\"" + data[i].valueId + "\" >" + data[i].valueName + "</option>";
                } else {
                    options += "<option value=\"" + data[i].valueId + "\">" + data[i].valueName + "</option>";
                }
            }
            $("#flatformId").html(options);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {//当访问时候，404，500 等非200的错误状态码
            // alert(XMLHttpRequest.status);
            // alert(XMLHttpRequest.readyState);
            // alert(textStatus);
            alert("加载平台列表失败！");
        }
    });

    var cl1 = $("#cl1").val();
    var cl2 = $("#cl2").val();
    var cl3 = $("#cl3").val();
    //动态加载一级分类列表
    loadCategoryLevel(null, cl1, "categoryLevel1", "1");
    //动态加载二级分类列表
    loadCategoryLevel(cl1, cl2, "categoryLevel2", "2");
    //动态加载三级分类列表
    loadCategoryLevel(cl2, cl3, "categoryLevel3", "3");

    //联动效果：动态加载二级分类列表
    $("#categoryLevel1").change(function () {
        var categoryLevel1 = $("#categoryLevel1").val();
        if (categoryLevel1 != '' && categoryLevel1 != null) {
            loadCategoryLevel(categoryLevel1, cl2, "categoryLevel2", 2);
        } else {
            $("#categoryLevel2").html("");
            var options = "<option value=\"\">--请选择--</option>";
            $("#categoryLevel2").html(options);
        }
        $("#categoryLevel3").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#categoryLevel3").html(options);
    });
    //联动效果：动态加载三级分类列表
    $("#categoryLevel2").change(function () {
        var categoryLevel2 = $("#categoryLevel2").val();
        if (categoryLevel2 != '' && categoryLevel2 != null) {
            loadCategoryLevel(categoryLevel2, cl3, "categoryLevel3", 3);
        } else {
            $("#categoryLevel3").html("");
            var options = "<option value=\"\">--请选择--</option>";
            $("#categoryLevel3").html(options);
        }
    });

    $("#back").on("click", function () {
        window.location.href = "list";
    });


    //LOGO图片---------------------
    var logoPicPath = $("#logoPicPath").val();
    var id = $("#id").val();
    if (logoPicPath == null || logoPicPath == "") {
        $("#uploadfile").show();
    } else {
        $("#logoFile").append("<p><img src=\"" + logoPicPath + "?m=" + Math.random() + "\" width=\"100px;\"/> &nbsp;&nbsp;" +
            "<span id='delete'>删除</span></p>");

    }

    //点击删除，提示删除成功，隐藏图片，显示上传
    $("#delete").click(function () {
        if (confirm("是否确认删除？")) {
            alert("删除成功")
            $("#logoFile").hide();
            $("#uploadfile").show();
        }
    })

    //点击返回
    $("#back").click(function () {
        window.location = "/dev/applist";
    })

});
      
      
      