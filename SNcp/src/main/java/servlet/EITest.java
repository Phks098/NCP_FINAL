package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.MyPage_DAO2;

@WebServlet("/EITest")
public class EITest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EITest() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		List<String> list = setQuestions();
		
		
		request.setAttribute("questions", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EITestPage.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyPage_DAO2 dao =new MyPage_DAO2();
		
		String student_number = null;
		String power = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("number")) {
				student_number = cookie.getValue();
			}
			if (cookie.getName().equals("power")) {
				power = cookie.getValue();
			}
		}
		
		
		for (int i = 0; i < 19; i++) {
			System.out.println(request.getParameter("check_" + (i + 1)));
		}
		
		ArrayList<String> value = new ArrayList();
		for (int i = 0; i < 19; i++) {
			value.add(request.getParameter("check_" + (i + 1)));
		}
		
		dao.insert_Education_Identity_Test(value,student_number);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}
	public List<String> setQuestions(){
		List<String> list = new ArrayList<String>();
		list.add("나는 나의 적성을 탐색하고 교사라는 진로와 연결해 보고 싶다.");
		list.add("진로와 관련된 사항을 스스로 결정하기 위해 내가 무엇을 원하는지 나 자신에 대해 이해하는 시간을 갖고 싶다.");
		list.add("나는 교사가 된 후 나아갈 수 있는 방향에 대해 알고 교사로서의 나의 모습을 고민해 보고 싶다.");
		list.add("진로와 관련된 나의 가치관을 탐색하고 싶다.");
		list.add("내가 좋아하고 관심 있는 일이 무엇인지 고민하고 교사라는 진로에 포함되는지 생각해 보고 싶다.");
		list.add("내가 원치 않는 진로를 부모님께 강요받았을 때 나의 뜻을 분명히 전달하고 나의 의지로 진로를 선택하고 싶다.");
		list.add("나는 앞으로 진로와 관련하여 해야 할 일을 결정하고 그것을 잘 처리할 수 있을 것이라는 확신을 갖고 싶다.");
		list.add("나는 교사로서의 나의 능력이 무엇인지 몰라 생기는 막막함을 해소하고 싶다.");
		list.add("나는 진로와 관련하여 생기는 지나친 불안을 줄이고 싶다.");
		list.add("나는 교사라는 진로에 대해 잘 모르는 것 같아 생기는 막연한 걱정을 덜고 싶다.");
		list.add("나는 교사라는 진로에 대한 구체적 목표가 없어서 발생하는 고민을 줄이고 싶다.");
		list.add("나의 전공이나 앞으로의 진로에 대해 친구들과 비교하지 않고 진로와 관련된 나의 정서를 수용하고 싶다.");
		list.add("나의 흥미가 교사라는 진로와 맞지 않을까 봐 생기는 두려움에 대해 표현하고 그 두려움을 덜고 싶다.");
		list.add("나는 강점 탐색을 통해 나의 전공을 살려 취업하는데 필요한 자신감을 갖고 싶다.");
		list.add("나는 교사에 대해 알아보기 위해 책, 교재, 참고서적, 기타 필요한것 등 여러 가지 정보를 수집하고 공유하고 싶다.");
		list.add("나는 교사 이외의 여러 가지 종류의 직업을 탐색해 보고 싶다.");
		list.add("나는 교사가 되기 위해 실제로 어떻게 해야 하는지 알고 계획을 세워 보고 싶다.");
		list.add("나는 관심 있는 진로분야에 대한 나의 생각과 고민을 주변의 사람들에게 표현하고 싶다.");
		list.add("나에게 적합한 진로를 탐색하기 위해 상담이나 심리검사 등을 활용하고 싶다.");
		
		
		return list;
	}

}
