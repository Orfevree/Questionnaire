onload = () => {
    $('#headerDivB').text('项目详情')

    let projectId = $util.getPageParam('seeProject')
    console.log(projectId, 'projectId')
    fetchProjectInfo(projectId)
    fetchQuestionnaires(projectId)
}

const fetchProjectInfo = (id) => {
    let params = {
        id
    }
    $.ajax({
        url: API_BASE_URL + '/queryProjectList',
        type: "POST",
        data: JSON.stringify(params),
        dataType: "json",
        contentType: "application/json",
        success(res) {
            let info = res.data[0]
            console.log(info, 'res')
            $('#projectName').text(info.projectName)
            $('#createTime').text(info.createDate)
            $('#projectDescription').text(info.projectContent)

        }
    })
}

const fetchQuestionnaires = (id) => {
    let params = {
        projectId: id
    };

    $.ajax({
        url: API_BASE_URL + '/queryQuestionnaireList',
        type: 'POST',
        data: JSON.stringify(params),
        dataType: 'json',
        contentType: 'application/json',
        success(res) {
            questionnaireList = res.data;
            $('#questionnaireList').html('');

            res.data.map((item, index) => {
                const row = `
          <tr>
            <td>${index + 1}</td>
            <td>${item.questionnaireName}</td>
            <td>${item.publishTime}</td>
            <td>
              <button type="button" class="btn btn-link" onclick="previewQuestionnaire('${item.questionnaireId}')">预览</button>
              <button type="button" class="btn btn-link" onclick="publishQuestionnaire('${item.questionnaireId}')">发布</button>
              <button type="button" class="btn btn-link" onclick="deleteQuestionnaire('${item.questionnaireId}',)">删除</button>
              <button type="button" class="btn btn-link" onclick="viewStatistics('${item.questionnaireId}')">统计</button>
              
            </td>
          </tr>
        `;

                $('#questionnaireList').append(row);
            });
        }
    });
};

const previewQuestionnaire = (questionnaireId) => {
    location.href = "/pages/answerSheet/index.html?questionnaireId="+questionnaireId
    $util.setItem('questionnaireId',questionnaireId)
}

const publishQuestionnaire = (questionnaireId) => {

    function getNowDate() {
        var myDate = new Date;
        var year = myDate.getFullYear(); //获取当前年
        var mon = myDate.getMonth() + 1; //获取当前月
        var date = myDate.getDate(); //获取当前日
        var hours = myDate.getHours(); //获取当前小时
        var minutes = myDate.getMinutes(); //获取当前分钟
        var seconds = myDate.getSeconds(); //获取当前秒
        var now = year + "-" + mon + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
        return now;
    }

    function getTimestamp() {
        return new Date(getNowDate()).getTime();
    }

    let projectId = $util.getPageParam('seeProject')

    let state = confirm("确认发布该问卷吗？")
    if (state) {
        let params = {
            questionnaireId: questionnaireId,
            publishTime:getTimestamp()
        };

        $.ajax({
            url: API_BASE_URL + '/publishQuestionnaire',
            type: 'POST',
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: 'application/json',
            success: (res) => {
                // 发布成功，根据需要更新页面
                console.log('发布成功');
                fetchQuestionnaires(projectId)

                // 生成答题连接的逻辑
                //构建答题链接的URL，可以使用问卷的唯一标识符作为参数
                const answerSheetURL = `http://example.com/answerSheet.html?questionnaireId=${questionnaireId}`;
                // 保存答题链接到数据库或其他持久存储中
                //saveAnswerSheetURLToDatabase(questionnaireId, answerSheetURL);

                // 显示答题链接给用户，例如在弹出窗口或模态框中展示
                showAnswerSheetLink(answerSheetURL);
            }
        });
    }

};


const showAnswerSheetLink = (answerSheetURL) => {
    // 可以使用弹出窗口、模态框、通知等方式展示答题链接给用户
    // 以下是一个简单的示例，使用浏览器的 `alert` 函数展示答题链接
    alert(`答题链接已生成：\n${answerSheetURL}`);
};


const deleteQuestionnaire = (questionnaireId) => {

    let projectId = $util.getPageParam('seeProject')

    let state = confirm("确认删除该问卷吗？")
    if (state) {
        let params = {
            questionnaireId: questionnaireId
        };

        $.ajax({
            url: API_BASE_URL + '/deleteQuestionnaireById',
            type: 'POST',
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: 'application/json',
            success: (res) => {
                // 删除成功，根据需要更新页面
                console.log('问卷删除成功');
                fetchQuestionnaires(projectId)
            }
        });
    }

};

