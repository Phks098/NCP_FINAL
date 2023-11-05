/**
 * 
 */

const request = new XMLHttpRequest();


window.addEventListener('load', function() {
  initAdminPage();
});

function initAdminPage() {
	request.open("Get", "./AdminMode", true);
	request.onreadystatechange = setAdminPage;
	request.send(null);
	
}

function setAdminPage() {
	
	if (request.readyState == 4 && request.status == 200) {
		
		let result = request.responseText;
		result = JSON.parse(result);

		console.log(result);

		
		createAdmin(result);
		
	} else {
		console.log("페이지 업데이트");
	}



}

function createAdmin(data) {
	
	//data[4] = 5점 가중치값 
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
	
	
	weightIn05.setAttribute("value", data["weight"][4]["weight"]);
	weightIn04.setAttribute("value", data["weight"][3]["weight"]);
	weightIn03.setAttribute("value", data["weight"][2]["weight"]);
	weightIn02.setAttribute("value", data["weight"][1]["weight"]);
	weightIn01.setAttribute("value", data["weight"][0]["weight"]);
	
	td05.innerText= data["weight"][4]["weight"];
	td04.innerText= data["weight"][3]["weight"];
	td03.innerText= data["weight"][2]["weight"];
	td02.innerText= data["weight"][1]["weight"];
	td01.innerText= data["weight"][0]["weight"];

	// 매칭 비율 설정
	//자기이해
	match01_1 = document.getElementById("match01_1");
	match01_2 = document.getElementById("match01_2");
	match01_3 = document.getElementById("match01_3");
	match01_4 = document.getElementById("match01_4");
	match01_5 = document.getElementById("match01_5");
	match01_6 = document.getElementById("match01_6");
	match01_7 = document.getElementById("match01_7");
	
	let sum = 0;
		
	match01_1.setAttribute("value",data["match"][0]["matching_rate"]);
	match01_2.setAttribute("value",data["match"][1]["matching_rate"]);
	match01_3.setAttribute("value",data["match"][2]["matching_rate"]);
	match01_4.setAttribute("value",data["match"][3]["matching_rate"]);
	match01_5.setAttribute("value",data["match"][4]["matching_rate"]);
	match01_6.setAttribute("value",data["match"][5]["matching_rate"]);
	
	sum =data["match"][0]["matching_rate"] +data["match"][1]["matching_rate"]+data["match"][2]["matching_rate"]+data["match"][3]["matching_rate"]+data["match"][4]["matching_rate"]+data["match"][5]["matching_rate"];
	
	match01_7.setAttribute("value",sum);
	
	match02_1 = document.getElementById("match02_1");
	match02_2 = document.getElementById("match02_2");
	match02_3 = document.getElementById("match02_3");
	match02_4 = document.getElementById("match02_4");
	match02_5 = document.getElementById("match02_5");
	match02_6 = document.getElementById("match02_6");
	match02_7 = document.getElementById("match02_7");
	
	sum = 0;
		
	match02_1.setAttribute("value",data["match"][6]["matching_rate"]);
	match02_2.setAttribute("value",data["match"][7]["matching_rate"]);
	match02_3.setAttribute("value",data["match"][8]["matching_rate"]);
	match02_4.setAttribute("value",data["match"][9]["matching_rate"]);
	match02_5.setAttribute("value",data["match"][10]["matching_rate"]);
	match02_6.setAttribute("value",data["match"][11]["matching_rate"]);
	
	sum =data["match"][6]["matching_rate"] +data["match"][7]["matching_rate"]+data["match"][8]["matching_rate"]+data["match"][9]["matching_rate"]+data["match"][10]["matching_rate"]+data["match"][11]["matching_rate"];
	
	
	
	match02_7.setAttribute("value",sum);
	
	
	
	//진로탐색
	match03_1 = document.getElementById("match03_1");
	match03_2 = document.getElementById("match03_2");
	match03_3 = document.getElementById("match03_3");
	match03_4 = document.getElementById("match03_4");
	match03_5 = document.getElementById("match03_5");
	match03_6 = document.getElementById("match03_6");
	match03_7 = document.getElementById("match03_7");
	
	sum = 0;
		
	match03_1.setAttribute("value",data["match"][12]["matching_rate"]);
	match03_2.setAttribute("value",data["match"][13]["matching_rate"]);
	match03_3.setAttribute("value",data["match"][14]["matching_rate"]);
	match03_4.setAttribute("value",data["match"][15]["matching_rate"]);
	match03_5.setAttribute("value",data["match"][16]["matching_rate"]);
	match03_6.setAttribute("value",data["match"][17]["matching_rate"]);
	
	sum =data["match"][12]["matching_rate"] +data["match"][13]["matching_rate"]+data["match"][14]["matching_rate"]+data["match"][15]["matching_rate"]+data["match"][16]["matching_rate"]+data["match"][17]["matching_rate"];
	
	
	
	match03_7.setAttribute("value",sum);
	
	//진로결정
	match03_1 = document.getElementById("match03_1");
	match03_2 = document.getElementById("match03_2");
	match03_3 = document.getElementById("match03_3");
	match03_4 = document.getElementById("match03_4");
	match03_5 = document.getElementById("match03_5");
	match03_6 = document.getElementById("match03_6");
	match03_7 = document.getElementById("match03_7");
	
	sum = 0;
		
	match03_1.setAttribute("value",data["match"][12]["matching_rate"]);
	match03_2.setAttribute("value",data["match"][13]["matching_rate"]);
	match03_3.setAttribute("value",data["match"][14]["matching_rate"]);
	match03_4.setAttribute("value",data["match"][15]["matching_rate"]);
	match03_5.setAttribute("value",data["match"][16]["matching_rate"]);
	match03_6.setAttribute("value",data["match"][17]["matching_rate"]);
	
	sum =data["match"][12]["matching_rate"] +data["match"][13]["matching_rate"]+data["match"][14]["matching_rate"]+data["match"][15]["matching_rate"]+data["match"][16]["matching_rate"]+data["match"][17]["matching_rate"];
	
	
	//진로설계 초기화
	match03_7.setAttribute("value",sum);
	
	match04_1 = document.getElementById("match04_1");
	match04_2 = document.getElementById("match04_2");
	match04_3 = document.getElementById("match04_3");
	match04_4 = document.getElementById("match04_4");
	match04_5 = document.getElementById("match04_5");
	match04_6 = document.getElementById("match04_6");
	match04_7 = document.getElementById("match04_7");
	
	sum = 0;
		
	match04_1.setAttribute("value",data["match"][18]["matching_rate"]);
	match04_2.setAttribute("value",data["match"][19]["matching_rate"]);
	match04_3.setAttribute("value",data["match"][20]["matching_rate"]);
	match04_4.setAttribute("value",data["match"][21]["matching_rate"]);
	match04_5.setAttribute("value",data["match"][22]["matching_rate"]);
	match04_6.setAttribute("value",data["match"][23]["matching_rate"]);
	
	sum =data["match"][18]["matching_rate"] +data["match"][19]["matching_rate"]+data["match"][20]["matching_rate"]+data["match"][21]["matching_rate"]+data["match"][22]["matching_rate"]+data["match"][23]["matching_rate"];
	
	match04_7.setAttribute("value",sum);
	
	
	//진로설계 초기화
	match03_7.setAttribute("value",sum);
	
	match05_1 = document.getElementById("match05_1");
	match05_2 = document.getElementById("match05_2");
	match05_3 = document.getElementById("match05_3");
	match05_4 = document.getElementById("match05_4");
	match05_5 = document.getElementById("match05_5");
	match05_6 = document.getElementById("match05_6");
	match05_7 = document.getElementById("match05_7");
	
	sum = 0;
		
	match05_1.setAttribute("value",data["match"][24]["matching_rate"]);
	match05_2.setAttribute("value",data["match"][25]["matching_rate"]);
	match05_3.setAttribute("value",data["match"][26]["matching_rate"]);
	match05_4.setAttribute("value",data["match"][27]["matching_rate"]);
	match05_5.setAttribute("value",data["match"][28]["matching_rate"]);
	match05_6.setAttribute("value",data["match"][29]["matching_rate"]);
	
	sum =data["match"][24]["matching_rate"] +data["match"][25]["matching_rate"]+data["match"][26]["matching_rate"]
	+data["match"][27]["matching_rate"]+data["match"][28]["matching_rate"]+data["match"][29]["matching_rate"];
	
	match05_7.setAttribute("value",sum);
	
	//실무역량 초기화
	match06_1 = document.getElementById("match06_1");
	match06_2 = document.getElementById("match06_2");
	match06_3 = document.getElementById("match06_3");
	match06_4 = document.getElementById("match06_4");
	match06_5 = document.getElementById("match06_5");
	match06_6 = document.getElementById("match06_6");
	match06_7 = document.getElementById("match06_7");
	
	sum = 0;
		
	match06_1.setAttribute("value",data["match"][30]["matching_rate"]);
	match06_2.setAttribute("value",data["match"][31]["matching_rate"]);
	match06_3.setAttribute("value",data["match"][32]["matching_rate"]);
	match06_4.setAttribute("value",data["match"][33]["matching_rate"]);
	match06_5.setAttribute("value",data["match"][34]["matching_rate"]);
	match06_6.setAttribute("value",data["match"][35]["matching_rate"]);
	
	sum =data["match"][30]["matching_rate"] +data["match"][31]["matching_rate"]+data["match"][32]["matching_rate"]
	+data["match"][33]["matching_rate"]+data["match"][34]["matching_rate"]+data["match"][35]["matching_rate"];
	
	match06_7.setAttribute("value",sum);
	
	//맞춤취업 초기화
	match07_1 = document.getElementById("match07_1");
	match07_2 = document.getElementById("match07_2");
	match07_3 = document.getElementById("match07_3");
	match07_4 = document.getElementById("match07_4");
	match07_5 = document.getElementById("match07_5");
	match07_6 = document.getElementById("match07_6");
	match07_7 = document.getElementById("match07_7");
	
	sum = 0;
		
	match07_1.setAttribute("value",data["match"][36]["matching_rate"]);
	match07_2.setAttribute("value",data["match"][37]["matching_rate"]);
	match07_3.setAttribute("value",data["match"][38]["matching_rate"]);
	match07_4.setAttribute("value",data["match"][39]["matching_rate"]);
	match07_5.setAttribute("value",data["match"][40]["matching_rate"]);
	match07_6.setAttribute("value",data["match"][41]["matching_rate"]);
	
	sum =data["match"][36]["matching_rate"] +data["match"][37]["matching_rate"]+data["match"][38]["matching_rate"]
	+data["match"][39]["matching_rate"]+data["match"][40]["matching_rate"]+data["match"][41]["matching_rate"];
	
	match07_7.setAttribute("value",sum);
	
	//구직활동 초기화
	match08_1 = document.getElementById("match08_1");
	match08_2 = document.getElementById("match08_2");
	match08_3 = document.getElementById("match08_3");
	match08_4 = document.getElementById("match08_4");
	match08_5 = document.getElementById("match08_5");
	match08_6 = document.getElementById("match08_6");
	match08_7 = document.getElementById("match08_7");
	
	sum = 0;
		
	match08_1.setAttribute("value",data["match"][42]["matching_rate"]);
	match08_2.setAttribute("value",data["match"][43]["matching_rate"]);
	match08_3.setAttribute("value",data["match"][44]["matching_rate"]);
	match08_4.setAttribute("value",data["match"][45]["matching_rate"]);
	match08_5.setAttribute("value",data["match"][46]["matching_rate"]);
	match08_6.setAttribute("value",data["match"][47]["matching_rate"]);
	
	sum =data["match"][42]["matching_rate"] +data["match"][43]["matching_rate"]+data["match"][44]["matching_rate"]
	+data["match"][45]["matching_rate"]+data["match"][46]["matching_rate"]+data["match"][47]["matching_rate"];
	
	match08_7.setAttribute("value",sum);
	
	
	let MaxLevelScore = document.getElementsByName("MaxLevelScore");
	let levelSet_Hight_Max = document.getElementsByName("Hight_Max");
	let levelSet_Hight_Min = document.getElementsByName("Hight_Min");
	let levelSet_Normal_Max = document.getElementsByName("Normal_Max");
	let levelSet_Normal_Min = document.getElementsByName("Normal_Min");
	let levelSet_Low_Max = document.getElementsByName("Low_Max");
	let levelSet_Low_Min = document.getElementsByName("Low_Min");
	
	
	for(let i = 0; i<data["leve"].length; i++){
		MaxLevelScore[i].setAttribute("value",data["leve"][i]["high_max"]);
	}
	
	for(let i = 0; i<data["leve"].length; i++){
		levelSet_Hight_Max[i].setAttribute("value",data["leve"][i]["high_max"]);
	}
	for(let i = 0; i<data["leve"].length; i++){
		levelSet_Hight_Min[i].setAttribute("value",data["leve"][i]["high_min"]);
	}
	for(let i = 0; i<data["leve"].length; i++){
		levelSet_Normal_Max[i].setAttribute("value",data["leve"][i]["normal_max"]);
	}
	for(let i = 0; i<data["leve"].length; i++){
		levelSet_Normal_Min[i].setAttribute("value",data["leve"][i]["normal_min"]);
	}
	for(let i = 0; i<data["leve"].length; i++){
		levelSet_Low_Max[i].setAttribute("value",data["leve"][i]["low_max"]);
	}
	for(let i = 0; i<data["leve"].length; i++){
		levelSet_Low_Min[i].setAttribute("value",data["leve"][i]["low_min"]);
	}
	
	
}













