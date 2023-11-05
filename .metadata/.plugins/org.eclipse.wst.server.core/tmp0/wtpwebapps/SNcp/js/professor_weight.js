
function WeightUdate() {

	const weigttest = document.getElementsByName("setweight");
	
	
	
	let weigt_1 = weigttest[0].value;
	let weigt_2 = weigttest[1].value;
	let weigt_3 = weigttest[2].value;
	let weigt_4 = weigttest[3].value;
	let weigt_5 = weigttest[4].value;

	let parameter = "?weigt_1=" + weigt_1 + "&weigt_2=" + weigt_2+ "&weigt_3=" + weigt_3 + "&weigt_4=" + weigt_4 + "&weigt_5=" + weigt_5;

	console.log(weigttest[0].value);

	request.open("Put", "./Professor_Weight" + parameter, true);
	request.onreadystatechange = setWeightPage;
	request.send(null);


}

function setWeightPage(){
	if (request.readyState == 4 && request.status == 200) {
		
		let resultWeight = request.responseText;
		resultWeight = JSON.parse(resultWeight);
		
		console.log("가중치값 비동기 실행");
		console.log(resultWeight);
		setWeightValue(resultWeight);
		
	} else {
		console.log("진행 싫패	");
	}
}

function setWeightValue(data){
	
	let td05 = document.getElementById("td05");
	let td04 = document.getElementById("td04");
	let td03 = document.getElementById("td03");
	let td02 = document.getElementById("td02");
	let td01 = document.getElementById("td01");
	
	let weightIn05 = document.getElementById("input05");
	let weightIn04 = document.getElementById("input04");
	let weightIn03 = document.getElementById("input03");
	let weightIn02 = document.getElementById("input02");
	let weightIn01 = document.getElementById("input01");
	
	
	weightIn05.setAttribute("value", data[4]["weight"]);
	weightIn04.setAttribute("value", data[3]["weight"]);
	weightIn03.setAttribute("value", data[2]["weight"]);
	weightIn02.setAttribute("value", data[1]["weight"]);
	weightIn01.setAttribute("value", data[0]["weight"]);
	
	td05.innerText= data[4]["weight"];
	td04.innerText= data[3]["weight"];
	td03.innerText= data[2]["weight"];
	td02.innerText= data[1]["weight"];
	td01.innerText= data[0]["weight"];
}



