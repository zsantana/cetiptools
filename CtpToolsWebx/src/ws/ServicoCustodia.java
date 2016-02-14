package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AgendaEventoDAO;
import dao.CarteiraComitenteDAO;
import dao.CarteiraParticipanteDAO;
import entidade.AgendaEvento;
import entidade.CarteiraComitente;
import entidade.CarteiraParticipante;


@Path("custodia")
public class ServicoCustodia {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterCarteiraParticipante/{codIF}/{dataBase}")
	public ArrayList<CarteiraParticipante> obterCarteiraParticipante(@PathParam("codIF") String codIF, @PathParam("dataBase") String dataBase){
		
		return  CarteiraParticipanteDAO.getInstance().obterCustodia(codIF, dataBase);
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterCarteiraComitente/{codIF}/{dataBase}")
	public ArrayList<CarteiraComitente> obterCarteiraComitente(@PathParam("codIF") String codIF, @PathParam("dataBase") String dataBase){
		
		return  CarteiraComitenteDAO.getInstance().obterCustodia(codIF, dataBase);
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterComitente/{codDocumento}/{codIF}/{dataBase}")
	public ArrayList<CarteiraComitente>obterComitente(@PathParam("codDocumento") String codDocumento, @PathParam("codIF") String codIF, @PathParam("dataBase") String dataBase){
		
		return  CarteiraComitenteDAO.getInstance().obterCustodia(codDocumento, codIF, dataBase);
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterAgendaEvento/{codIF}/{dataBase}")
	public ArrayList<AgendaEvento>obterAgendaEvento(@PathParam("codIF") String codIF, @PathParam("dataBase") String dataBase){
		
		return  AgendaEventoDAO.getInstance().obterAgendaEvento(codIF, dataBase);
		
	}
	
}
