package data;

import java.util.ArrayList;

import data.dao.Scholar_Evaluation_DAO;
import data.vo.Student_VO;

class main {

	public static void main(String[] args) throws Exception {
		
//		Test_DAO dao = new Test_DAO();
//		ArrayList<Test_VO> list = null;
//		list = (ArrayList<Test_VO>) dao.getTest();
//		
//		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
//		
//		dao.insert_test(1);
//		
//		
//		System.out.println("변경후");
//list = (ArrayList<Test_VO>) dao.getTest();
//		
//		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
//		list.add(new Test_VO(1,"멀티입력1"));
//		list.add(new Test_VO(1,"멀티입력2"));
//		list.add(new Test_VO(1,"멀티입력3"));
//		list.add(new Test_VO(1,"멀티입력4"));
//		list.add(new Test_VO(1,"멀티입력5"));
//		list.add(new Test_VO(1,"멀티입력6"));
//		
//System.out.println("삭제 이후 출력");
//		
//		list = (ArrayList<Test_VO>) dao.getTest();
//		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
//		
//		
//		
//		Map<String,Object> map = new HashMap<>();
//		map.put("list", list);
//		
//		System.out.println(map.toString());
//		
//		dao.insert_test_ArrayList(list);
//		String student  = "201910823";
//		Integration_Score integration_Score = new Integration_Score(); //매칭 결과 Integration_Score 값들 다시 작성한다
//		Preparation_Level preparation_Level = new Preparation_Level();
//		
//
//		integration_Score.InsertInto_Integration_Score(student); //통합점수 저장		
//		preparation_Level.Leve(student);//준비수준 결과 저장 및 매칭 계산 결과
//		System.out.println("성공");
//		
//		
		
		
	//	 정체감 검사를 재검사 이후 정체감  평가 결과저장 과정이다.---------------------------------------------------------------------ㄸ
//		ArrayList<Education_identity_test_VO> list = new ArrayList();
//		MyPage_DAO2 dao = new MyPage_DAO2();
//		
//		String unver ="201710648";
//		
//		list = dao.getEducation_identity_test(unver);
//		
//		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
//		
//		int recognition_sum = 0;
//		int behavior_sum = 0;
//		int emotion_sum = 0;
//		
//		for(int i = 0; i<list.size(); i++) {
//			if(list.get(i).getTest_category() == 1) {
//				recognition_sum += list.get(i).getTest_grade();//인지 총합
//			}
//			if(list.get(i).getTest_category() == 2) {
//				behavior_sum += list.get(i).getTest_grade();//정서 총합
//			}
//			if(list.get(i).getTest_category() == 3) {
//				emotion_sum += list.get(i).getTest_grade();// 행동 총합
//			}
//			
//		}
//		
		// 인지 정서 행동 순서로 전체 합
		
		// 영역별 문제개수
		//인지 = 7
		//정소 = 7
		//행동 = 5
		
//		int recognition_count = 7;
//		int behavior_sum_count = 7;
//		int emotion_count = 5;
//		
//		
//		System.out.println(recognition_sum);
//		System.out.println(behavior_sum);
//		System.out.println(emotion_sum);
//
//		float recognition_average = recognition_sum/recognition_count;
//		float behavior_average = behavior_sum/behavior_sum_count;
//		float emotion_average = emotion_sum/emotion_count;
//		
//		System.out.println("역량 평균 점수");
//		
//		System.out.println(recognition_average); //1
//		System.out.println(behavior_average);//2
//		System.out.println(emotion_average);//3
//		
//		
////		3가지 영역에 대한 평균 결과 값을 넣자 
//// 		education_identity_test_score_VO 
////		String university_number; 학번
////		int test_number;  
////		float category_everage;
////		float professor_category_everage;
//		
//		ArrayList<Education_identity_test_score_VO> scoreList = new ArrayList();
//		
//
//		
//		float total_student_average = (recognition_average+behavior_average+emotion_average)/3;
//		
//		
//		System.out.println("역량 총 평균점수"+total_student_average);
//		
////		university_number ㅡ == 학번
////	    test_number int,  == 카테고리 번호
////	    category_everage float, == 카테고리 평균
////	    professor_category_everage float == 교수님 점수
//
//		ArrayList<Professor_education_identity_test_VO> professor = new ArrayList<>();
//		
//		
//		professor = dao.getProfessor_education_identity_test_VO(unver);
//		float professor_recognition = 0; // 인지
//		float professor_behavior = 0;//정서
//		float professor_emotion = 0;//행동
//		
//		
//		for(int i = 0; i<professor.size(); i++) {
//			System.out.println(professor.get(i).toString());
//			if(professor.get(i).getTest_category() ==1) {
//				professor_recognition = professor.get(i).getEvaluation_grade();
//			}
//			if(professor.get(i).getTest_category() ==2) {
//				professor_behavior = professor.get(i).getEvaluation_grade();
//			}
//			if(professor.get(i).getTest_category() ==3) {
//				professor_emotion = professor.get(i).getEvaluation_grade();
//			}
//			
//		}
//		int professor_total_average = (int) (professor_recognition+professor_behavior+professor_emotion)/3;
//		
//		float result = (float) (((total_student_average+professor_total_average)*10)/2);
//		float real = result/10;
//		
//		System.out.println("교수 평가와 학생 점수 정체감 점수 = "+real);
//		
//		scoreList.add(new Education_identity_test_score_VO(unver,1,recognition_average,professor_recognition));
//		scoreList.add(new Education_identity_test_score_VO(unver,2,recognition_average,professor_recognition));
//		scoreList.add(new Education_identity_test_score_VO(unver,3,recognition_average,professor_recognition));
//		
//		for(int i = 0; i<scoreList.size(); i++) {
//			System.out.println(scoreList.get(i).toString());
//		}
//		

//		System.out.println(dao.insertEducation_identity_test_score(scoreList));
		
//		boolean check = false;
//		
//		
//		
//		// 진로정체감 검사 결과 출력 3.5점 이상이면 교직 , 미만이면 비교직
//		if(real>=3.5) {
//			check = true;
//		}else {
//			check = false;
//		}
//		Education_Result_VO data = new Education_Result_VO("201710648",real,check,"now");
//		
//		
//		System.out.println(dao.insertResult_Education(data));
//		
		//false = 0 true= 1--------------------------------------------------------------------------------------------
		/*
		 * AdminMode_DAO dao = new AdminMode_DAO(); ArrayList<Matching_criteria_VO>
		 * match = dao.getAll_Matching_criteria_VO(); // 전체 매칭 비율을 가져온다
		 * ArrayList<Professor_weight_VO> weight = dao.getAll_Professor_weight_VO(); //
		 * 전체 가중치를 가져온다 ArrayList<Diagnosis_criteria_VO> level =
		 * dao.getAll_Diagnosis_criteria_VO(); // 전체 준비 수준을 가져온다
		 * 
		 * 
		 * for(int i = 0; i<match.size(); i++) {
		 * System.out.println(match.get(i).toString()); }
		 */
		
//		int a = 6;
//		int b = 6;
//		System.out.println( b % a);
		
		

//		ArrayList<ArrayList<String>> levelList = new ArrayList<ArrayList<String>>();
//		ArrayList<String> data = new ArrayList<String>();
//		
//		
//		
//		
//		int count =0;
//		for(int i =0; i<100; i++) {
//			
//			
//			data.add(Integer.toString(i));
//			
//			
//	
//			if(count == 10) {
//				
//				
//				levelList.add(data);
//				data = new ArrayList<String>();
//				count=0;
//			}
//			
//			
//			count++;
//		}
//		
////		System.out.println(levelList.toString());
//		ArrayList<String> list = new ArrayList<String>();
//		ArrayList<Integer> a = new ArrayList<Integer>();
//		try {
//			list.get(0);
//			list.get(0);
//			list.get(0);
//			list.get(0);
//			list.get(0);
//			
//		}catch(IndexOutOfBoundsException e) {
//			for(int i = 0; i<8; i++) {
//				a.add(0);
//			}
//		}
//		
//		for(int i = 0; i<a.size(); i++) {
//			System.out.println(a.get(i));
//		}
		
		Scholar_Evaluation_DAO dao = new Scholar_Evaluation_DAO();
		ArrayList<Student_VO>  list = new ArrayList<Student_VO> ();
		list = dao.getStuduent_AllList("10008");
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		
	}
		
	}
	
	

	


