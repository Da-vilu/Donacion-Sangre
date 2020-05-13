package Vista;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import Controlador.Main;

public class MainMenuControler implements Initializable{
	
	@FXML
	private Button btnDonantes;
	
	@FXML
	private Button btnDonaciones;

	@FXML
	private Button btnInformes;

	
	private  Main ProgramaPrincipal;
	 
	 

    public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    @FXML
    private void Donantes() {
       	this.ProgramaPrincipal.mostrarDonantes();
    }
	


	
		

	public void Donaciones() throws SQLException{
		
	

		}
	

	public void Informes() throws SQLException{
		
	

		}
	
	

}
