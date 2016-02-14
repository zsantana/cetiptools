package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidade.ConnectionFactory;
import entidade.InstrumentoFinanceiro;


/**
 * 
 * Classe responsável por conter os metodos do CRUD
 *
 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
 * @since 13/01/2016
 * @version 1.0
 */
public class InstrumentoFinanceiroDAO extends ConnectionFactory {

	private static InstrumentoFinanceiroDAO instance;
	
	
	/**
	 * 
	 * Método responsável por criar uma instancia da classe InstrumentoFinanceiroDAO
	 *
	 * @return
	 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
	 * @since 13/01/2016
	 * @version 1.0
	 */
	public static InstrumentoFinanceiroDAO getInstance(){
		if(instance == null)
			instance = new InstrumentoFinanceiroDAO();
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<InstrumentoFinanceiro> listarTodos(String dataBase){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<InstrumentoFinanceiro> iListaFinanc = null;
		
		conexao = criarConexao(dataBase);
		iListaFinanc = new ArrayList<InstrumentoFinanceiro>();
		try {
			pstmt = conexao.prepareStatement("select * from INSTRUMENTO_FINANCEIRO ");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				InstrumentoFinanceiro iFinanc = new InstrumentoFinanceiro();
				
				iFinanc.setNumIF(rs.getString("NUM_IF"));
				iFinanc.setCodIF(rs.getString("COD_IF"));
				iFinanc.setCodTipoIF(rs.getString("COD_TIPO_IF"));
				iFinanc.setCodSituacaoIF(rs.getString("COD_SITUACAO_IF"));
				
				iListaFinanc.add(iFinanc);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os InstrumentoFinanceiro : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return iListaFinanc;
	}
	
	
	
	public ArrayList<InstrumentoFinanceiro> obterIF(String codIF, String dataBase){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<InstrumentoFinanceiro> iListaFinanc = null;
		
		conexao = criarConexao(dataBase);
		iListaFinanc = new ArrayList<InstrumentoFinanceiro>();
		try {
			
			if (codIF == ""){
				pstmt = conexao.prepareStatement("select * from INSTRUMENTO_FINANCEIRO ");
			}else{
				pstmt = conexao.prepareStatement("select * from INSTRUMENTO_FINANCEIRO where cod_if = '" + codIF + "'" );
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				InstrumentoFinanceiro iFinanc = new InstrumentoFinanceiro();
				
				iFinanc.setNumIF(rs.getString("NUM_IF"));
				iFinanc.setCodIF(rs.getString("COD_IF"));
				iFinanc.setCodTipoIF(rs.getString("COD_TIPO_IF"));
				iFinanc.setCodSituacaoIF(rs.getString("COD_SITUACAO_IF"));
				
				iListaFinanc.add(iFinanc);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os InstrumentoFinanceiro : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return iListaFinanc;
	}
	
	
	public ArrayList<InstrumentoFinanceiro> obterIFporTipoIF(String codTipoIF, String dataBase){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<InstrumentoFinanceiro> iListaFinanc = null;
		
		conexao = criarConexao(dataBase);
		iListaFinanc = new ArrayList<InstrumentoFinanceiro>();
		try {
			
			if (codTipoIF == ""){
				pstmt = conexao.prepareStatement("select * from INSTRUMENTO_FINANCEIRO ");
			}else{
				pstmt = conexao.prepareStatement("select * from INSTRUMENTO_FINANCEIRO where cod_tipo_if = '" + codTipoIF + "'" );
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				InstrumentoFinanceiro iFinanc = new InstrumentoFinanceiro();
				
				iFinanc.setNumIF(rs.getString("NUM_IF"));
				iFinanc.setCodIF(rs.getString("COD_IF"));
				iFinanc.setCodTipoIF(rs.getString("COD_TIPO_IF"));
				iFinanc.setCodSituacaoIF(rs.getString("COD_SITUACAO_IF"));
				
				iListaFinanc.add(iFinanc);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os InstrumentoFinanceiro : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return iListaFinanc;
	}
	
}
