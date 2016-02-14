package ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ResumoOperacaoDAO;


@Path("resumoOperacao")
public class ServicoResumoOperacao {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterTotMensagem/{dataBase}")
	public String obterTotMensagem(@PathParam("dataBase") String dataBase){
		
		return  ResumoOperacaoDAO.getInstance().obterTotMensagem(dataBase);
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterTotTela/{dataBase}")
	public String obterTotTela(@PathParam("dataBase") String dataBase){
		
		return  ResumoOperacaoDAO.getInstance().obterTotTela(dataBase);
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterTotArquivo/{dataBase}")
	public String obterTotarquivo(@PathParam("dataBase") String dataBase){
		
		return  ResumoOperacaoDAO.getInstance().obterTotArquivo(dataBase);
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterTotDeadLetter/{dataBase}")
	public String obterTotDeadLetter(@PathParam("dataBase") String dataBase){
		
		return  ResumoOperacaoDAO.getInstance().obterTotDeadLetter(dataBase);
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterTotFinMultLateral/{dataBase}")
	public String obterTotFinMultLateral(@PathParam("dataBase") String dataBase){
		
		return  ResumoOperacaoDAO.getInstance().obterTotCampo(dataBase, "val_mult_lateral");
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterTotFinBrutaStr/{dataBase}")
	public String obterTotFinBrutaStr(@PathParam("dataBase") String dataBase){
		
		return  ResumoOperacaoDAO.getInstance().obterTotCampo(dataBase, "val_bruta_str");
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obterTotFinBrutaBT/{dataBase}")
	public String obterTotFinBrutaBT(@PathParam("dataBase") String dataBase){
		
		return  ResumoOperacaoDAO.getInstance().obterTotCampo(dataBase, "val_mult_lateral");
		
	}
	
}
