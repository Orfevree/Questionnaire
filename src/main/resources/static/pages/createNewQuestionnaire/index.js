onload = () => {
    $('#headerUsername').text($util.getItem('userInfo').username)
    $('#headerDivB').text('创建调查问卷')

    $('#startTime').datetimepicker({
        language: 'zh-CN', // 显示中文
        format: 'yyyy-mm-dd', // 显示格式
        minView: "month", // 设置只显示到月份
        initialDate: new Date(), // 初始化当前日期
        autoclose: true, // 选中自动关闭
        todayBtn: true // 显示今日按钮
    })
    $('#endTime').datetimepicker({
        language: 'zh-CN', // 显示中文
        format: 'yyyy-mm-dd', // 显示格式
        minView: "month", // 设置只显示到月份
        initialDate: new Date(), // 初始化当前日期
        autoclose: true, // 选中自动关闭
        todayBtn: true // 显示今日按钮
    })


}

const onDesignQuestionnaire = () => {

    var surveyName = document.getElementById("surveyName").value;
    var surveyDescription = document.getElementById("surveyDescription").value;

    const projectId = $util.getItem('projectId')
    const selectLeo = $util.getItem('selectLeo')

    console.log(API_BASE_URL)

    let params = {
        projectId:projectId,
        type:selectLeo,
        questionnaireName:surveyName,
        questionnaireDesc:surveyDescription
    }
    $.ajax({
        url: API_BASE_URL + '/creatQuestionnaire',
        type: "POST",
        data: JSON.stringify(params),
        dataType: "json",
        contentType: "application/json",
        success(res) {
            if (res.code === '1') {
                location.href = "/pages/designQuestionnaire/index.html"
                $util.setItem('surveyName', surveyName)
                $util.setItem('surveyDescription', surveyDescription)
                $util.setItem('questionnaireId', res.data)
                $util.setItem('flag', 0)
            }else {
                alert(res.message)
            }
        }
    })


}