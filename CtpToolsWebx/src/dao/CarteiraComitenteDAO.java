package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidade.CarteiraComitente;
import entidade.ConnectionFactory;


/**
 * 
 * Classe responsável por conter os metodos do CRUD
 *
 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
 * @since 13/01/2016
 * @version 1.0
 */
public class CarteiraComitenteDAO extends ConnectionFactory {

	private static CarteiraComitenteDAO instance;
	
	
	/**
	 * 
	 * Método responsável por criar uma instancia da classe CarteiraComitenteDAO (Singleton)
	 *
	 * @return
	 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
	 * @since 13/01/2016
	 * @version 1.0
	 */
	public static CarteiraComitenteDAO getInstance(){
		if(instance == null)
			instance = new CarteiraComitenteDAO();
		return instance;
	}
	
		
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<CarteiraComitente> obterCustodia(String codIF, String dataBase){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CarteiraComitente> listResultDAO = new ArrayList<CarteiraComitente>();
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select c.* "); 
			str.append("  from carteira_comitente c,  ");
			str.append("       instrumento_financeiro i  ");
			str.append(" where i.num_if = c.num_if	     ");
			str.append("   and i.cod_if = '" + codIF + "'");
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CarteiraComitente dao = new CarteiraComitente();
				
				dao.setCodContaParticipante(rs.getString("cod_Conta_Participante"));
				dao.setCodTipoOpsicaoCarteira(rs.getString("cod_Tipo_Posicao_Carteira"));
				dao.setCodDocumento(rs.getString("cod_Documento"));
				dao.setQtdCarteira(rs.getString("Qtd_Carteira"));
				
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
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<CarteiraComitente> obterCustodia(String codDocumento, String codIF, String dataBase){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CarteiraComitente> listResultDAO = new ArrayList<CarteiraComitente>();
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select c.* "); 
			str.append("  from carteira_comitente c,  ");
			str.append("       instrumento_financeiro i  ");
			str.append(" where i.num_if = c.num_if	     ");
			str.append("   and i.cod_if = '" + codIF + "'");
			str.append("   and c.cod_documento = '" + codDocumento + "'");
			
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CarteiraComitente dao = new CarteiraComitente();
				
				dao.setCodContaParticipante(rs.getString("cod_Conta_Participante"));
				dao.setCodTipoOpsicaoCarteira(rs.getString("cod_Tipo_Posicao_Carteira"));
				dao.setCodDocumento(rs.getString("cod_Documento"));
				dao.setQtdCarteira(rs.getString("Qtd_Carteira"));
				
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
