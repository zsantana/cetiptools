package entidade;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class InstrumentoFinanceiro implements Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numIF;
	String codIF;
	String codTipoIF;
	String codSituacaoIF;
	
	
	
	public String getNumIF() {
		return numIF;
	}
	public void setNumIF(String numIF) {
		this.numIF = numIF;
	}
	public String getCodIF() {
		return codIF;
	}
	public void setCodIF(String codIF) {
		this.codIF = codIF;
	}
	public String getCodTipoIF() {
		return codTipoIF;
	}
	public void setCodTipoIF(String codTipoIF) {
		this.codTipoIF = codTipoIF;
	}
	public String getCodSituacaoIF() {
		return codSituacaoIF;
	}
	public void setCodSituacaoIF(String codSituacaoIF) {
		this.codSituacaoIF = codSituacaoIF;
	}
	
	
	
	

}
