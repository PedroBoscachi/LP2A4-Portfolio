package lp2a4;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AlunoServlet
 */
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao == null) {
			acao = "";
		}
		
		switch(acao) {
			case "consulta" : consultaAcao(request, response); break;
			default : irProIndex(request, response);
		}
		
		consultaAcao(request, response);
	}
	
	private void irProIndex(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect("index.html");
	}

	private void consultaAcao(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		final String matricula = request.getParameter("matricula");
		if(matricula == null) {
			response.getWriter().append("Digite uma matrícula para consulta");
			return;
		}
		
		final AlunoDAO dao = new AlunoPropertiesDAO();
		final AlunoPOJO aluno = dao.retrieve(matricula);
		
		request.setAttribute("aluno", aluno);
		final RequestDispatcher rd = request.getRequestDispatcher("detalhe_aluno.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
