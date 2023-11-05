/**
 * 
 */

function LevelUpdate() {
	let Hight_Max = document.getElementsByName("Hight_Max");
	let Hight_Min = document.getElementsByName("Hight_Min");
	let Normal_Max = document.getElementsByName("Normal_Max");
	let Normal_Min = document.getElementsByName("Normal_Min");
	let Low_Max = document.getElementsByName("Low_Max");
	let Low_Min = document.getElementsByName("Low_Min");
	let parameter = "?";

	for (let i = 0; i < Hight_Max.length; i++) {

		if (i == Hight_Max.length - 1) {
			parameter += "setLevel=" + Hight_Max[i].value + "&setLevel="
				+ Hight_Min[i].value + "&setLevel="
				+ Normal_Max[i].value + "&setLevel="
				+ Normal_Min[i].value + "&setLevel="
				+ Low_Max[i].value + "&setLevel="
				+ Low_Min[i].value;
		} else {
			parameter += "setLevel=" + Hight_Max[i].value + "&setLevel="
				+ Hight_Min[i].value + "&setLevel="
				+ Normal_Max[i].value + "&setLevel="
				+ Normal_Min[i].value + "&setLevel="
				+ Low_Max[i].value + "&setLevel="
				+ Low_Min[i].value + "&"
		}

	}

	console.log(parameter);
	request.open("PUT", "./Level" + parameter, true);
	request.onreadystatechange = setLevel;
	request.send(null);

}

function setLevel() {
	if (request.readyState == 4 && request.status == 200) {
		let resultLevel = request.responseText;
		resultLevel = JSON.parse(resultLevel);
		setLevelValue(resultLevel);
		console.log(resultLevel);

	} else {
		console.log("진행 싫패	");
	}
}

function setLevelValue(data){ 
	let MaxLevelScore = document.getElementsByName("MaxLevelScore");
	let levelSet_Hight_Max = document.getElementsByName("Hight_Max");
	let levelSet_Hight_Min = document.getElementsByName("Hight_Min");
	let levelSet_Normal_Max = document.getElementsByName("Normal_Max");
	let levelSet_Normal_Min = document.getElementsByName("Normal_Min");
	let levelSet_Low_Max = document.getElementsByName("Low_Max");
	let levelSet_Low_Min = document.getElementsByName("Low_Min");
	
	
	for(let i = 0; i<data.length; i++){
		MaxLevelScore[i].setAttribute("value",data[i]["high_max"]);
	}
	
	for(let i = 0; i<data.length; i++){
		levelSet_Hight_Max[i].setAttribute("value",data[i]["high_max"]);
	}
	for(let i = 0; i<data.length; i++){
		levelSet_Hight_Min[i].setAttribute("value",data[i]["high_min"]);
	}
	for(let i = 0; i<data.length; i++){
		levelSet_Normal_Max[i].setAttribute("value",data[i]["normal_max"]);
	}
	for(let i = 0; i<data.length; i++){
		levelSet_Normal_Min[i].setAttribute("value",data[i]["normal_min"]);
	}
	for(let i = 0; i<data.length; i++){
		levelSet_Low_Max[i].setAttribute("value",data[i]["low_max"]);
	}
	for(let i = 0; i<data.length; i++){
		levelSet_Low_Min[i].setAttribute("value",data[i]["low_min"]);
	}
	
	
	
	
	
}