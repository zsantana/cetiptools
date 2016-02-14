package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidade.CarteiraParticipante;
import entidade.ConnectionFactory;


/**
 * 
 * Classe responsável por conter os metodos do CRUD
 *
 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
 * @since 13/01/2016
 * @version 1.0
 */
public class CarteiraParticipanteDAO extends ConnectionFactory {

	private static CarteiraParticipanteDAO instance;
	
	
	/**
	 * 
	 * Método responsável por criar uma instancia da classe CarteiraParticipanteDAO (Singleton)
	 *
	 * @return
	 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
	 * @since 13/01/2016
	 * @version 1.0
	 */
	public static CarteiraParticipanteDAO getInstance(){
		if(instance == null)
			instance = new CarteiraParticipanteDAO();
		return instance;
	}
	
		
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<CarteiraParticipante> obterCustodia(String codIF, String dataBase){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CarteiraParticipante> listResultDAO = new ArrayList<CarteiraParticipante>();
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select c.* "); 
			str.append("  from carteira_participante c,  ");
			str.append("       instrumento_financeiro i  ");
			str.append(" where i.num_if = c.num_if	     ");
			str.append("   and i.cod_if = '" + codIF + "'");
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CarteiraParticipante dao = new CarteiraParticipante();
				
				dao.setCodContaParticipante(rs.getString("cod_Conta_Participante"));
				dao.setCodTipoOpsicaoCarteira(rs.getString("cod_Tipo_Posicao_Carteira"));
				dao.setQtdCarteira(rs.getString("Qtd_Carteira"));
				
				listResultDAO.add(dao);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar as Carteira Participante : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return listResultDAO;
	}
	
}
