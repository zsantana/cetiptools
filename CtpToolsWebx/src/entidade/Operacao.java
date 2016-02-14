package entidade;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Operacao {
	
	
	String numIdOperacao;
	String codOperacao;
	String tipoOperacao;
	String dataOperacao;
	String dataFinanceiro;
	String valorFinanceiro;
	String valPrecoUnitario;
	String codStatusOpeacao;
	String dataUltimaAtualizacao;
	String codModalidade;
	
	
	
	public String getNumIdOperacao() {
		return numIdOperacao;
	}
	public void setNumIdOperacao(String numIdOperacao) {
		this.numIdOperacao = numIdOperacao;
	}
	public String getCodOperacao() {
		return codOperacao;
	}
	public void setCodOperacao(String codOperacao) {
		this.codOperacao = codOperacao;
	}
	public String getTipoOperacao() {
		return tipoOperacao;
	}
	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	public String getDataOperacao() {
		return dataOperacao;
	}
	public void setDataOperacao(String dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	public String getDataFinanceiro() {
		return dataFinanceiro;
	}
	public void setDataFinanceiro(String dataFinanceiro) {
		this.dataFinanceiro = dataFinanceiro;
	}
	public String getValorFinanceiro() {
		return valorFinanceiro;
	}
	public void setValorFinanceiro(String valorFinanceiro) {
		this.valorFinanceiro = valorFinanceiro;
	}
	public String getValPrecoUnitario() {
		return valPrecoUnitario;
	}
	public void setValPrecoUnitario(String valPrecoUnitario) {
		this.valPrecoUnitario = valPrecoUnitario;
	}
	public String getCodStatusOpeacao() {
		return codStatusOpeacao;
	}
	public void setCodStatusOpeacao(String codStatusOpeacao) {
		this.codStatusOpeacao = codStatusOpeacao;
	}
	public String getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}
	public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
	public String getCodModalidade() {
		return codModalidade;
	}
	public void setCodModalidade(String codModalidade) {
		this.codModalidade = codModalidade;
	}
	
	
	
}
