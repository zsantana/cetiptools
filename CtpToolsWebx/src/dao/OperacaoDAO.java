package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidade.ConnectionFactory;
import entidade.Operacao;


/**
 * 
 * Classe responsável por conter os metodos do CRUD
 *
 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
 * @since 13/01/2016
 * @version 1.0
 */
public class OperacaoDAO extends ConnectionFactory {

	private static OperacaoDAO instance;
	
	
	/**
	 * 
	 * Método responsável por criar uma instancia da classe OperacaoDAO (Singleton)
	 *
	 * @return
	 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
	 * @since 13/01/2016
	 * @version 1.0
	 */
	public static OperacaoDAO getInstance(){
		if(instance == null)
			instance = new OperacaoDAO();
		return instance;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Operacao> obterOperacao(String codIF, String dataBase){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Operacao> listresultDAO = new ArrayList<Operacao>();
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select op.* ");
			str.append("  from operacao op, ");
			str.append(" 	   instrumento_financeiro i ");
			str.append(" where op.num_if = i.num_if ");
			str.append("   and i.cod_if = '" + codIF + "'");
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Operacao dao = new Operacao();
				
				dao.setNumIdOperacao(rs.getString("numIdOperacao"));
				dao.setCodOperacao(rs.getString("codOperacao"));
				dao.setTipoOperacao(rs.getString("tipoOperacao"));
				dao.setDataOperacao(rs.getString("dataOperacao"));
				dao.setDataFinanceiro(rs.getString("dataFinanceiro"));
				dao.setCodStatusOpeacao(rs.getString("codStatusOpeacao"));
				dao.setCodModalidade(rs.getString("codModalidade"));
				
				listresultDAO.add(dao);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar as OPERACOES : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return listresultDAO;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Operacao> obterModalidadeOperacao(String modalidade, String codIF, String dataBase){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Operacao> listresultDAO = new ArrayList<Operacao>();
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select op.* ");
			str.append("  from operacao op, ");
			str.append(" 	   instrumento_financeiro i ");
			str.append(" where op.num_if = i.num_if ");
			str.append("   and i.cod_if = '" + codIF + "'");
			str.append("   and op.codModalidade = '" + modalidade + "'");
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Operacao dao = new Operacao();
				
				dao.setNumIdOperacao(rs.getString("numIdOperacao"));
				dao.setCodOperacao(rs.getString("codOperacao"));
				dao.setTipoOperacao(rs.getString("tipoOperacao"));
				dao.setDataOperacao(rs.getString("dataOperacao"));
				dao.setDataFinanceiro(rs.getString("dataFinanceiro"));
				dao.setCodStatusOpeacao(rs.getString("codStatusOpeacao"));
				dao.setCodModalidade(rs.getString("codModalidade"));
				
				listresultDAO.add(dao);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar as OPERACOES : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return listresultDAO;
	}
	
}
