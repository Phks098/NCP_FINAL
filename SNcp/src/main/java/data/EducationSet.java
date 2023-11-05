package data;

import java.util.ArrayList;

import data.dao.MyPage_DAO2;
import data.vo.Education_Result_VO;
import data.vo.Education_identity_test_VO;
import data.vo.Education_identity_test_score_VO;
import data.vo.Professor_education_identity_test_VO;




public class EducationSet {
	public EducationSet() {}
	
	
	public void setEducation(String unver) {
		ArrayList<Education_identity_test_VO> list =new ArrayList<>();
		
		MyPage_DAO2 dao = new MyPage_DAO2();
		
		
		list = dao.getEducation_identity_test(unver);
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		int recognition_sum = 0;
		int behavior_sum = 0;
		int emotion_sum = 0;
		
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getTest_category() == 1) {
				recognition_sum += list.get(i).getTest_grade();
			}
			if(list.get(i).getTest_category() == 2) {
				behavior_sum += list.get(i).getTest_grade();
			}
			if(list.get(i).getTest_category() == 3) {
				emotion_sum += list.get(i).getTest_grade();
			}
			
		}
		
		int recognition_count = 7;
		int behavior_sum_count = 7;
		int emotion_count = 5;
		
		
		System.out.println(recognition_sum);
		System.out.println(behavior_sum);
		System.out.println(emotion_sum);
		
		
		
		
		
		float recognition_average = recognition_sum/recognition_count;
		float behavior_average = behavior_sum/behavior_sum_count;
		float emotion_average = emotion_sum/emotion_count;
		
		System.out.println("���� ��� ����");
		
		System.out.println(recognition_average); //1
		System.out.println(behavior_average);//2
		System.out.println(emotion_average);//3
		
		
		

		
		ArrayList<Education_identity_test_score_VO> scoreList = new ArrayList();
		
		
		
		
		
		float total_student_average = (recognition_average+behavior_average+emotion_average)/3;
		

		

		ArrayList<Professor_education_identity_test_VO> professor = new ArrayList<>();
		
		
		professor = dao.getProfessor_education_identity_test_VO(unver);
		float professor_recognition = 0;
		float professor_behavior = 0;
		float professor_emotion = 0;
		
		
		for(int i = 0; i<professor.size(); i++) {
			System.out.println(professor.get(i).toString());
			if(professor.get(i).getTest_category() ==1) {
				professor_recognition = professor.get(i).getEvaluation_grade();
			}
			if(professor.get(i).getTest_category() ==2) {
				professor_behavior = professor.get(i).getEvaluation_grade();
			}
			if(professor.get(i).getTest_category() ==3) {
				professor_emotion = professor.get(i).getEvaluation_grade();
			}
			
		}
		int professor_total_average = (int) (professor_recognition+professor_behavior+professor_emotion)/3;
		
		int result = (int) (((total_student_average+professor_total_average)*10)/2);
		float real = result/10;
		

		scoreList.add(new Education_identity_test_score_VO(unver,1,recognition_average,professor_recognition));
		scoreList.add(new Education_identity_test_score_VO(unver,2,recognition_average,professor_recognition));
		scoreList.add(new Education_identity_test_score_VO(unver,3,recognition_average,professor_recognition));
		
		for(int i = 0; i<scoreList.size(); i++) {
			System.out.println(scoreList.get(i).toString());
		}

		System.out.println(dao.insertEducation_identity_test_score(scoreList));
		
//		System.out.println(dao.insertEducation_identity_test_score(scoreList));
		
		boolean check = false;
		
		
		
		// ������ü�� �˻� ��� ��� 3.5�� �̻��̸� ���� , �̸��̸� ����
		if(real>=3.5) {
			check = true;
		}else {
			check = false;
		}
		Education_Result_VO data = new Education_Result_VO(unver,(float)real,check,"now");
		
		
		System.out.println(dao.insertResult_Education(data));
		
		//false = 0 true= 1
		
		
	}
	
	
	
}
