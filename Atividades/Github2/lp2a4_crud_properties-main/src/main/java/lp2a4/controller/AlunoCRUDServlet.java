package lp2a4.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lp2a4.Logger;

/**
 * Controller
 *
 * O FrontController que recebe requisições e as delega para as devidas classes ou métodos de tratamento.
 * 
 * Referências: 
 * 	- GoF
 *  - Core J2EE Patterns
 *  - https://www.devmedia.com.br/padroes-de-projetos-introducao-aos-padroes-front-controller-e-command/30644
 *  
 */
public class AlunoCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = new Logger(AlunoCRUDServlet.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoCRUDServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		final String acaoParam = request.getParameter("acao");
		
		try {
			final CommandEnum acao = CommandEnum.valueOf( acaoParam != null? acaoParam :  CommandEnum.DESCONHECIDO.toString() );
			final Command comando = Command.commandFactory(acao);
			comando.execute(request, response);
		} catch( Exception e) {
			log.info("Não conseguiu carregar o comando referente ao parametro acao=[" + acaoParam + "]");
		}		
	}

}

/**
 * https://coderanch.com/t/349099/java/invoke-bean-servlet

SESSION

    HttpSession session = req.getSession(true);
    // Get the bean from the session
    MyBean myBean = (MyBean)session.getAttribute("myBean");
    // if the bean is not in session instantiate a new bean
    if (myBean == null)
    {
        myBean = newMyBean();
        // code for anything else you need to do
        // to initialize myBean
    }
    // rest of servlet code
    // Put the bean back in the session, since you
    // probably either instantiated a new bean,
    // or at least changed the bean in some way
    session.setAttribute("myBean", myBean);
    
APPLICATION
 
 ServletContext context = getServletContext();
// Get bean from servlet context (same as application scope)
MyBean myBean = (MyBean)context.getAttribute("myBean");
// Put bean back into context (same as application scope)
context.setAttribute("myBean", myBean);

REQUEST
// Get bean from request
MyBean myBean = (MyBean)req.getAttribute("myBean");
// Put bean back into the request if you want to forward
// the request using a RequestDispatcher for example
req.setAttribute("myBean", myBean);
*/