package entidade;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AgendaEvento {
	
	String dataOcorrenciaEvento;
	String tipoEvento;
	String valorPuEvento;
	String valorEvento;
	String statusEvento;
	String statusFinalEvento;
	
	
	public String getDataOcorrenciaEvento() {
		return dataOcorrenciaEvento;
	}
	public void setDataOcorrenciaEvento(String dataOcorrenciaEvento) {
		this.dataOcorrenciaEvento = dataOcorrenciaEvento;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getValorPuEvento() {
		return valorPuEvento;
	}
	public void setValorPuEvento(String valorPuEvento) {
		this.valorPuEvento = valorPuEvento;
	}
	public String getValorEvento() {
		return valorEvento;
	}
	public void setValorEvento(String valorEvento) {
		this.valorEvento = valorEvento;
	}
	public String getStatusEvento() {
		return statusEvento;
	}
	public void setStatusEvento(String statusEvento) {
		this.statusEvento = statusEvento;
	}
	public String getStatusFinalEvento() {
		return statusFinalEvento;
	}
	public void setStatusFinalEvento(String statusFinalEvento) {
		this.statusFinalEvento = statusFinalEvento;
	}
	
		
}
