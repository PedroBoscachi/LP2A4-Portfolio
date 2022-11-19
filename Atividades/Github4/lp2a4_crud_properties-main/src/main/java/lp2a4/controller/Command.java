package lp2a4.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public interface Command {
	/**
	 * Método que executará o comando solicitado pelo cliente.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * Este método factory possui o escopo default, pois só deve ser utilizado dentro do pacote controller.
	 * 
	 * Caso utilizasse reflection, não seria necessário o switch e isso traria mais flexibilidade
	 * para a implementação de novas funcionalidades.
	 * 
	 * Porém, por se tratar de um caso de estudo bem simplificado, a abordagem com switch foi preferida.
	 * @param tipoComando
	 * @return
	 */
	static Command commandFactory(CommandEnum tipoComando) {
		
		final Command comando;
		switch( tipoComando ) {
		case CREATE : comando = new CreateCommand(); break;
		case RETRIEVE : comando = new RetrieveCommand(); break;
		case UPDATE : comando = new UpdateCommand(); break;
		case NAVIGATE_UPDATE : comando = new NavigateUpdateCommand(); break;
		case DELETE : comando = new DeleteCommand(); break;
		default : comando = new UnknowedCommand(); break;
		}
		
		return comando;
	}
}
