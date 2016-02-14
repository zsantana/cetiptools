package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AgendaEventoDAO;
import entidade.AgendaEvento;


@Path("evento")
public class ServicoEvento {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterAgendaEvento/{codIF}/{dataBase}")
	public ArrayList<AgendaEvento>obterAgendaEvento(@PathParam("codIF") String codIF, @PathParam("dataBase") String dataBase){
		
		return  AgendaEventoDAO.getInstance().obterAgendaEvento(codIF, dataBase);
		
	}
	
}
