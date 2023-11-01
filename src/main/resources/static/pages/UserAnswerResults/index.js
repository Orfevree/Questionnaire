const resultData = {
  answers: [
    {
      question: '问题1',
      options: ['选项1', '选项2', '选项3'],
      choice: '选项2'
    },
    {
      question: '问题2',
      options: ['选项A', '选项B', '选项C'],
      choice: '选项B'
    },
    // 添加更多的问题和答案...
  ]
};

$(document).ready(() => {

  const respondent = $util.getItem('respondent');
  $('.respondent-title').text(`答卷人：${respondent}`);
  renderResultData(resultData);
});

// 渲染答卷结果数据
function renderResultData(resultData) {

  const problemDiv = $('#problem');
  problemDiv.empty();

  resultData.answers.forEach(answer => {
    const problem = `
      <div class="problem-item">
        <h4>${answer.question}</h4>
        <ul class="options-list">
          ${answer.options.map(option => {
      const checked = option === answer.choice ? 'checked' : '';
      return `<li><span class="checkmark ${checked}"></span>${option}</li>`;
    }).join('')}
        </ul>
      </div>
    `;
    problemDiv.append(problem);
  });
}