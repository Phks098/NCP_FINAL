/**
 * 
 */
 const request = new XMLHttpRequest();
 
 window.onload = searchPrograms();
 
 function searchPrograms(){
	let keyword = document.getElementById("keyword").value;
	
	request.open("Get", "./Professor_Student?keyword=" + keyword, true);
	request.onreadystatechange = searchProcess;
	request.send(null);
	
}
function searchProcess() {
	const accordion = document.getElementById("accord");// id='accordion' 태그에 접근
	if (request.readyState == 4 && request.status == 200) {
		accordion.classList.add("show");
		let result = request.responseText;
		result = JSON.parse(result);
		
		console.log(result);
		
		accordion.innerHTML = "";
		for (var i = 0; i < result.length; i++) {
			createList(accordion, result[i]);
		}
		
	}else{
		console.log("진행 싫패	");
	}
}

function createList(accordion, data){


	let div = document.createElement("div");
	let table = document.createElement("table");
	let tbody = document.createElement("tbody");

	let tr01 = document.createElement("tr");
	let th01_1 = document.createElement("th");
	let td01_1 = document.createElement("td");
	let th01_2 = document.createElement("th");
	let td01_2 = document.createElement("td")
	th01_1.innerHTML = "단과대학";
	td01_1.innerHTML = "일반대학";
	th01_2.innerHTML = "소속";
	td01_2.innerHTML = data["major"];
	tr01.appendChild(th01_1);
	tr01.appendChild(td01_1);
	tr01.appendChild(th01_2);
	tr01.appendChild(td01_2);
	
	
	
	let tr02 = document.createElement("tr");
	let th02_1 = document.createElement("th");
	let td02_1 = document.createElement("td");
	let th02_2 = document.createElement("th");
	let td02_2 = document.createElement("td");
	
	
	
	th02_1.innerHTML = "지도교수";
	td02_1.innerHTML = data["possfer"];
	th02_2.innerHTML = "학년";
	td02_2.innerHTML = data["grade"];
	
	tr02.appendChild(th02_1);
	tr02.appendChild(td02_1);
	tr02.appendChild(th02_2);
	tr02.appendChild(td02_2);
	
	
	let tr03 = document.createElement("tr");
	let th03_1 = document.createElement("th");
	let td03_1 = document.createElement("td");
	let th03_2 = document.createElement("th");
	let td03_2 = document.createElement("td");
	th03_1.innerHTML = "학번";
	td03_1.innerHTML = data["university_number"];
	th03_2.innerHTML = "이름";
	td03_2.innerHTML = data["name"]+"("+data["sex"]+")";
	
	
	tr03.appendChild(th03_1);
	tr03.appendChild(td03_1);
	tr03.appendChild(th03_2);
	tr03.appendChild(td03_2);


	tbody.appendChild(tr01);
	tbody.appendChild(tr02);
	tbody.appendChild(tr03);


	table.appendChild(tbody);

	let gotoStudentInformation = document.createElement("a");
	gotoStudentInformation.setAttribute("href", "mypage?student=" + data['university_number']);
	gotoStudentInformation.innerText = "자세히보기";
	
	let gotoCompetency = document.createElement("a");
	gotoCompetency.setAttribute("href", "Professr_Career?university_number=" + data['university_number']);
	gotoCompetency.innerText = "역량평가";

	
	div.appendChild(table);
	div.appendChild(gotoStudentInformation);
	div.appendChild(gotoCompetency);

	
	accordion.appendChild(div);
	
}
