package entidade;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarteiraParticipante {
	
	
	String codTipoOpsicaoCarteira;
	String codContaParticipante;
	String qtdCarteira;
	
	
	public String getCodTipoOpsicaoCarteira() {
		return codTipoOpsicaoCarteira;
	}
	public void setCodTipoOpsicaoCarteira(String codTipoOpsicaoCarteira) {
		this.codTipoOpsicaoCarteira = codTipoOpsicaoCarteira;
	}
	public String getCodContaParticipante() {
		return codContaParticipante;
	}
	public void setCodContaParticipante(String codContaParticipante) {
		this.codContaParticipante = codContaParticipante;
	}
	public String getQtdCarteira() {
		return qtdCarteira;
	}
	public void setQtdCarteira(String qtdCarteira) {
		this.qtdCarteira = qtdCarteira;
	}
	
	
	
	
	
	
}
