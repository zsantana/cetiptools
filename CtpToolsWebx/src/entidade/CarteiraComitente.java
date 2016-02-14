package entidade;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarteiraComitente {
	
	String codTipoOpsicaoCarteira;
	String codContaParticipante;
	String codDocumento;
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
	public String getCodDocumento() {
		return codDocumento;
	}
	public void setCodDocumento(String codDocumento) {
		this.codDocumento = codDocumento;
	}
	public String getQtdCarteira() {
		return qtdCarteira;
	}
	public void setQtdCarteira(String qtdCarteira) {
		this.qtdCarteira = qtdCarteira;
	}
	
}
