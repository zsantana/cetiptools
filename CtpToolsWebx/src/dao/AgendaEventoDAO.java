package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidade.AgendaEvento;
import entidade.ConnectionFactory;


/**
 * 
 * Classe responsável por conter os metodos do CRUD
 *
 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
 * @since 13/01/2016
 * @version 1.0
 */
public class AgendaEventoDAO extends ConnectionFactory {

	private static AgendaEventoDAO instance;
	
	
	/**
	 * 
	 * Método responsável por criar uma instancia da classe AgendaEventoDAO (Singleton)
	 *
	 * @return
	 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
	 * @since 13/01/2016
	 * @version 1.0
	 */
	public static AgendaEventoDAO getInstance(){
		if(instance == null)
			instance = new AgendaEventoDAO();
		return instance;
	}
	
		
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<AgendaEvento> obterAgendaEvento(String codIF, String dataBase){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<AgendaEvento> listResultDAO = new ArrayList<AgendaEvento>();
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select e.* "); 
			str.append("  from evento e,  ");
			str.append("       instrumento_financeiro i  ");
			str.append(" where i.num_if = e.num_if	     ");
			str.append("   and i.cod_if = '" + codIF + "'");
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				AgendaEvento dao = new AgendaEvento();
				
				dao.setDataOcorrenciaEvento(rs.getString("dat_ocorrencia_evento"));
				dao.setTipoEvento(rs.getString("tipo_evento"));
				dao.setValorPuEvento(rs.getString("val_pu_evento"));
				dao.setValorEvento(rs.getString("val_evento"));
				dao.setStatusEvento(rs.getString("status_evento"));
				dao.setStatusFinalEvento(rs.getString("status_final_evento"));
				
				listResultDAO.add(dao);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar as Carteira CarteiraComitente : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return listResultDAO;
	}
		
}
