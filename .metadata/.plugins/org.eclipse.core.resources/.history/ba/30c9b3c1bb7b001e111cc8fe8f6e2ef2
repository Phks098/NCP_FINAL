/**
 * 
 */

function MatchUpdate() {
	let matchGet = document.getElementsByName("matchGet");
	let parameter = "?";


	for (i = 0; i < matchGet.length; i++) {
		if (i == matchGet.length - 1) {
			parameter += "setMatch=" + matchGet[i].value;
		} else {
			parameter += "setMatch=" + matchGet[i].value + "&";
		}
	}
	console.log(parameter);
	request.open("PUT", "./Match" + parameter, true);
	request.onreadystatechange = setMatch;
	request.send(null);

}
function setMatch() {
	if (request.readyState == 4 && request.status == 200) {
		let resultMatch = request.responseText;
		resultMatch = JSON.parse(resultMatch);
		setMatchValue(resultMatch);
		console.log(resultMatch);

	} else {
		console.log("진행 싫패	");
	}
}

function setMatchValue(data) {
	let matchGet = document.getElementsByName("matchGet");
	let matchSum = document.getElementsByName("matchSum");
	let sum = 0.0;
	let count = 0;


	for (i = 0; i < matchGet.length; i++) {
		matchGet[i].setAttribute("value", data[i]["matching_rate"]);
		sum += data[i]["matching_rate"];
		if (data[i]["category_number"] == 6) {
			matchSum[count].setAttribute("value", sum);
			sum = 0;
			count++;
		}
	}

}