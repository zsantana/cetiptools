package ws;

import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;


@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {
	
	
	public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        
        s.add(ServicoIF.class);
        s.add(ServicoOperacao.class);
        s.add(ServicoCustodia.class);
        s.add(ServicoEvento.class);
        
        s.add(ServicoResumoOperacao.class);
        
        return s;
    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
