onload = () => {

	const questionnaireId = $util.getItem('questionnaireId')

	let params = {
		questionnaireId:questionnaireId
	}

	 $.ajax({
		 url:API_BASE_URL +'/previewQuestionnaireById',
		 type:'POST',
		 data: JSON.stringify(params),
		 dataType:'json',
		 contentType: "application/json",
		 success:(res) => {
			 $('#questionnaire-title').text(res.questionnaireName);
			 $('#questionnaire-description').val(res.questionnaireDesc);
			 displayQuestions(questionnaireId);
		 }

	 })

	 function displayQuestions(questionnaireId) {

	 	let params = {
			questionnaireId:questionnaireId
		}
		 $.ajax({
			 url: API_BASE_URL + '/previewQuestionById',
			 type: "POST",
			 data: JSON.stringify(params),
			 dataType: "json",
			 contentType: "application/json",
			 success(res) {
				 problemList = res.data;
				 $('#problem').html('');
				 res.data.map((item, index) => {
					 const row = `
              ${index + 1}.${item.questionName}
              <br>
              <input type="radio" name="option" value="${item.firstOption}">${item.firstOption}<br>
              &nbsp&nbsp&nbsp&nbsp<input type="radio" name="option1" value="${item.relativeFirstOption}">${item.relativeFirstOption}<br>
              &nbsp&nbsp&nbsp&nbsp<input type="radio" name="option1" value="${item.relativeSecondOption}">${item.relativeSecondOption}<br>
              &nbsp&nbsp&nbsp&nbsp<input type="radio" name="option1" value="${item.relativeThirdOption}">${item.relativeThirdOption}<br>
              <input type="radio" name="option" value="${item.secondOption}">${item.secondOption}<br>
              <input type="radio" name="option" value="${item.thirdOption}">${item.thirdOption}<br>
   				`;

					 $('#problem').append(row);
			 });

		 }



		})


}
}