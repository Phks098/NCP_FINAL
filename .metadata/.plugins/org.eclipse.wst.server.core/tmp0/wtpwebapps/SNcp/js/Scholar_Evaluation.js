function checkOnly(element, thisname) {

	const checkboxes
		= document.getElementsByName(thisname);
	

	checkboxes.forEach((cb) => {
		cb.checked = false;
	})

	element.checked = true;

}


function listChekc(){
	var checkList = document.getElementsByClassName("Scolar_Evauation");
	var content = [];
	
	for(let i = 0; i<checkList.length; i++){
		if( checkList[i].checked == true){
			content.push(checkList[i].value);
		} // 해당 배열을 넣는다.
	}
	
	for(let i = 0; i<content.length; i++){
		console.log(content[i]); // 해당 배열을 넣는다.
		
	}

	
}