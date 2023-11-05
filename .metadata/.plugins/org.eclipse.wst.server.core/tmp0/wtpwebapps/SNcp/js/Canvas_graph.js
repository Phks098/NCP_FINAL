var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");

var center =300;





context.beginPath();
context.arc(center,center,180,0,2*Math.PI,false);
context.lineWidth = 2;
context.strokeStyle = "black";
context.stroke();

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
context.moveTo(300,120);
context.lineTo(300,480);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();


// 맞춤취업 라인 or 진로결정
context.beginPath();
context.moveTo(480,300);
context.lineTo(120,300);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();



//구직활동 라인
context.beginPath();
context.moveTo(172,172);
context.lineTo(300,300);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();

//진로설계
context.beginPath();
context.moveTo(428,428);
context.lineTo(300,300);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();

//진로탐색
context.beginPath();
context.moveTo(428,172);
context.lineTo(300,300);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();

//실무역량
context.beginPath();
context.moveTo(172,428);
context.lineTo(300,300);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();



context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("자기이해",260,100);

context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("진로탐색",440,170);

context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("진로결정",490,300);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("진로설계",440,440);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("경력개발",260,510);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("실무역량",80,440);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("맞춤취업",30,300);

context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("구직활동",80,170);



var self_understanding_line = 480;  //자기이해 기준선
var career_search =300;				//진로탐색 기준선
var career_decision_line			//진로결정 기준선
var career_design_line				//진로설계 기준선
var career_development_line 		//진로개발 기준선
var practical_competency_line 		//실무역량 기준선
var custom_emzier_line				//맞춤취업 기준선
var job_search_line 				//구직활동 기준선


// 역량별 선그리기

var stat_x = 300;
var start_y = 120;

var arr = [];


var diagonal = 128;
var Straight = 180;

// 진로 탐색 = 대각선.128 xy축 (+x,-y)
arr[0] = 428 - (diagonal*(1-0.22));
arr[1] = 172 + (diagonal*(1-0.22));


// 진로 결정 = 직선.180 x축 (+x)
arr[2] = 480;
arr[3] = 300;

//  진로설계 = 대각선.128 xy축(+x,+y)
arr[4] = 428;
arr[5] = 428;


// 경력개발 = 직선 180 y축 (+y)
arr[6] = 300;
arr[7] = 480;

//실무역량 = 대각선.128 xy축 (-x,+y)
arr[8] = 172;
arr[9] = 428;


//맞춤취업 = 직선.180 x축(-x)
arr[10] = 120;
arr[11] = 300;

//구직활동 = 대각선.128 xy축(-x,-y)
arr[12] = 172;
arr[13] = 172;



context.beginPath();
context.moveTo(stat_x,start_y); // 자기이해 100% y    = 300 ~ 120(100%)
context.lineTo(arr[0],arr[1]); // 진로탐색 
context.lineTo(arr[2],arr[3]); // 진로결정
context.lineTo(arr[4],arr[5]); // 진로설계
context.lineTo(arr[6],arr[7]); // 경력개발
context.lineTo(arr[8],arr[9]); // 실무역량
context.lineTo(arr[10],arr[11]); // 맞춤취업
context.lineTo(172,172); // 구직활동
context.lineTo(stat_x,start_y); // 자기이해 연결
context.globalAlpha = 0.2;
context.fillStyle="#87CEEB"
context.fill();

context.lineWidth = 4;
context.strokeStyle="red";

context.stroke();





