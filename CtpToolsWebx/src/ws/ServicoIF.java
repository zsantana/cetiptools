package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.InstrumentoFinanceiroDAO;
import entidade.InstrumentoFinanceiro;


@Path("instrumentofinanceiro")
public class ServicoIF {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obtetListaIF/{dataBase}")
	public ArrayList<InstrumentoFinanceiro> obterListaIF(@PathParam("dataBase") String dataBase){
		
		return  InstrumentoFinanceiroDAO.getInstance().listarTodos(dataBase);
		
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obtetIF/{codIF}/{dataBase}")
	public ArrayList<InstrumentoFinanceiro> obtetIF(@PathParam("codIF") String codIF, @PathParam("dataBase") String dataBase){
		
		return  InstrumentoFinanceiroDAO.getInstance().obterIF(codIF, dataBase);
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterIFporTipoIF/{codTipoIF}/{dataBase}")
	public ArrayList<InstrumentoFinanceiro> obterIFporTipoIF(@PathParam("codTipoIF") String codTipoIF, @PathParam("dataBase") String dataBase){
		
		return  InstrumentoFinanceiroDAO.getInstance().obterIFporTipoIF(codTipoIF, dataBase);
		
	}
	
	
}
