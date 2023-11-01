 // 定义静态数据
    const staticData = [
      {
        questionnaire: '问卷1',
        respondent: '用户1',
        time: '2023-06-01'
      },
      {
        questionnaire: '问卷2',
        respondent: '用户2',
        time: '2023-06-02'
      },
      // 添加更多的数据项...
    ];

    // 定义全局变量
    const pageSize = 10; // 每页显示的数据条数
    let currentPage = 1; // 当前页码
    let searchKeyword = ''; // 搜索关键字

    // 页面加载完成后执行的函数
    $(document).ready(() => {
      fetchResults();
    });

    // 根据当前页码和搜索关键字获取数据
    function fetchData() {
      // 根据搜索关键字过滤数据
      const filteredData = staticData.filter(item =>
        item.respondent.includes(searchKeyword)
      );

      // 计算起始索引
      const startIndex = (currentPage - 1) * pageSize;

      // 获取当前页的数据
      return filteredData.slice(startIndex, startIndex + pageSize);
    }

    // 生成表格
    function generateTable() {
      const tableBody = $('#resultsTableBody');
      tableBody.empty();

      const data = fetchData();

      data.forEach((item, index) => {
        const row = `<tr>
          <td>${item.questionnaire}</td>
          <td>${item.respondent}</td>
          <td>${item.time}</td>
          <td>
            <button type="button" class="btn btn-link" onclick="viewDetails(${index})">明细</button>
          </td>
        </tr>`;
        tableBody.append(row);
      });
    }

    // 更新表格和分页
    function fetchResults() {
      generateTable();
      updatePagination();
    }

    // 搜索按钮点击事件处理
    function search() {
      searchKeyword = $('#searchInput').val();
      currentPage = 1;
      fetchResults();
    }

    // 上一页按钮点击事件处理
    function previousPage() {
      if (currentPage > 1) {
        currentPage--;
        fetchResults();
      }
    }

    // 下一页按钮点击事件处理
    function nextPage() {
      currentPage++;
      fetchResults();
    }

    // 明细按钮点击事件处理
    function viewDetails(index) {
      // 根据索引获取选中的静态数据项
      const selectedResult = fetchData()[index];
      let respondent = selectedResult.respondent
        console.log(respondent)

      location.href = "/pages/UserAnswerResults/index.html?respondent="+respondent;
	  $util.setItem('respondent',respondent)
    }

    // 更新分页按钮状态
    function updatePagination() {
      const prevButton = document.querySelector('.pagination .btn:first-child');
      const nextButton = document.querySelector('.pagination .btn:last-child');

      prevButton.disabled = currentPage === 1;
      nextButton.disabled = (currentPage * pageSize) >= staticData.length;
    }
  