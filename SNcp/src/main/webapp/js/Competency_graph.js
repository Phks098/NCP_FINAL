/**
 * 
 */
 
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");

var center =190;






context.beginPath();
context.arc(center,center,150,0,2*Math.PI,false);
context.lineWidth = 0.5;
context.strokeStyle = "black";
context.stroke();


context.beginPath();
context.arc(center,center,120,0,2*Math.PI,false);
context.lineWidth = 0.5;
context.strokeStyle = "black";
context.stroke();

context.beginPath();
context.arc(center,center,90,0,2*Math.PI,false);
context.lineWidth = 0.5;
context.strokeStyle = "black";
context.stroke();


context.beginPath();
context.arc(center,center,60,0,2*Math.PI,false);
context.lineWidth = 0.5;
context.strokeStyle = "black";
context.stroke();

context.beginPath();
context.arc(center,center,30,0,2*Math.PI,false);
context.lineWidth = 0.5;
context.strokeStyle = "black";
context.stroke();




// 자기이해 라인 or 경력개발
context.beginPath();
context.moveTo(center,center-150);
context.lineTo(center,center+150);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();


// 맞춤취업 라인 or 진로결정
context.beginPath();
context.moveTo(center+150,center);
context.lineTo(center-150,center);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();



//구직활동 라인
context.beginPath();
context.moveTo(center-107,center-107);
context.lineTo(center,center);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();

//진로설계
context.beginPath();
context.moveTo(center+107,center+107);
context.lineTo(center,center);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();

//진로탐색
context.beginPath();
context.moveTo(center+107,center-107);
context.lineTo(center,center);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();

//실무역량
context.beginPath();
context.moveTo(center-107,center+107);
context.lineTo(center,center);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();



context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "10px arial"
context.strokeText("자기이해",center-20,center-160);

context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "10px arial"
context.strokeText("진로탐색",center+107,center-107);

context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "10px arial"
context.strokeText("진로결정",center-190,center);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "10px arial"
context.strokeText("진로설계",center+117,center+117);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "10px arial"
context.strokeText("경력개발",center-20,center+170);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "10px arial"
context.strokeText("실무역량",center-157,center+117);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "10px arial"
context.strokeText("맞춤취업",center+150,center);

context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "10px arial"
context.strokeText("구직활동",center-147,center-107);




const category = document.getElementsByClassName("level_category");
const level_score =document.getElementsByClassName("level_score");

var self_understanding   = 0;   //자기이해 
var career_search        = 0;	//진로탐색
var custom_emzier	     = 0;	//맞춤취업 
var career_design        = 0;   //진로설계 
var career_development   = 0; 	//경력개발 
var practical_competency = 0;   //실무역량 
var career_decision	     = 0;	//진로결정
var job_search           = 0;   //구직활동 





for(i=0; i<category.length; i++){
	
	console.log(category[i].innerText+","+level_score[i].innerText.replace("%",""));
	if(category[i].innerText=='자기이해'){
		self_understanding = level_score[i].innerText.replace("%","");
	}
	if(category[i].innerText=='진로탐색'){
		career_search =  level_score[i].innerText.replace("%","");
	}
	if(category[i].innerText=='맞춤취업'){
		custom_emzier =  level_score[i].innerText.replace("%","");
	}
	if(category[i].innerText=='진로설계'){
		career_design =  level_score[i].innerText.replace("%","");
	}
	if(category[i].innerText=='경력개발'){
		career_development =  level_score[i].innerText.replace("%","");
	}
	if(category[i].innerText=='실무역량'){
		practical_competency =  level_score[i].innerText.replace("%","");
	}
	if(category[i].innerText=='진로결정'){
		career_decision  =  level_score[i].innerText.replace("%","");
	}
	if(category[i].innerText=='구직활동'){
		job_search =  level_score[i].innerText.replace("%","");
	}
}





var self_understanding_line   = 1-(self_understanding/100);  //자기이해 기준선
var career_search_line        = 1-(career_search/100); //진로탐색 기준선
var career_decision_line	  =	1-(career_decision/100); //진로결정
var career_design_line        = 1-(career_design/100); //진로설계 기준선
var career_development_line   = 1-(career_development/100);	 //경력개발 기준선
var practical_competency_line = 1-(practical_competency/100); //실무역량 기준선
var custom_emzier_line	      = 1-(custom_emzier/100);	 //맞춤취업 기준선
var job_search_line           = 1-(job_search/100);  //구직활동 기준선



console.log(self_understanding_line);


// 역량별 선그리기

var diagonal = 107;
var Straight = center;

var arr = [];

//자기이해
var stat_x = center;
var start_y = (center-150) + (Straight*self_understanding_line);

// 진로 탐색 = 대각선.128 xy축 (+x,-y)
arr[0] = (center+diagonal)-(diagonal*career_search_line);
arr[1] = (center-diagonal)+(diagonal*career_search_line);

// 맞춤취업 = 직선.180 x축 (+x)
arr[2] = (center+150) - (Straight*custom_emzier_line);;
arr[3] = center;

//진로설계 = 대각선.128 xy축(+x,+y)
arr[4] = (center+diagonal) - (diagonal*career_design_line);
arr[5] = (center+diagonal) - (diagonal*career_design_line);


// 경력개발 = 직선 180 y축 (+y)
arr[6] = center;
arr[7] = (center+150) - (Straight*career_development_line);

//실무역량 = 대각선.128 xy축 (-x,+y)
arr[8] = (center-diagonal) + (diagonal*practical_competency_line);
arr[9] = (center+diagonal) - (diagonal*practical_competency_line);

//진로결정
arr[10] =(center-150) + (Straight*custom_emzier_line);
arr[11] = center;

//구직활동 = 대각선.128 xy축(-x,-y)
arr[12] = (center-diagonal) + (diagonal*job_search_line);
arr[13] = (center-diagonal) + (diagonal*job_search_line); 

context.beginPath();
context.moveTo(stat_x,start_y); // 자기이해 100% y    = 300 ~ 120(100%)
context.lineTo(arr[0],arr[1]); // 진로탐색 
context.lineTo(arr[2],arr[3]); // 진로결정
context.lineTo(arr[4],arr[5]); // 진로설계
context.lineTo(arr[6],arr[7]); // 경력개발
context.lineTo(arr[8],arr[9]); // 실무역량
context.lineTo(arr[10],arr[11]); // 맞춤취업
context.lineTo(arr[12],arr[13]); // 구직활동
context.lineTo(stat_x,start_y); // 자기이해 연결
context.globalAlpha = 0.2;
context.fillStyle="#87CEEB"
context.fill();

context.lineWidth = 4;
context.strokeStyle="red";

context.stroke();





