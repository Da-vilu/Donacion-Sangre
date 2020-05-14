package Vista;

import java.sql.SQLException;

import Controlador.Main;
import Modelo.BBDDdonantes;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NuevoDonante {
	
	@FXML
	private TextField txtNdonante;
	
	@FXML
	private TextField txtNonmbre;
	
	@FXML
	private TextField txtApellido1;
	
	@FXML
	private TextField txtApellido2;
	
	@FXML
	private Button btnFoto;
	
	@FXML
	private TextField txtDNI;
	
	@FXML
	private TextField txtFecha_nacimiento;
	
	@FXML
	private TextField txtTlf;
	
	@FXML
	private TextField txtTlfMovil;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	RadioButton hombre;

	@FXML
	RadioButton mujer;

	@FXML
	ToggleGroup sexo;

	
	@FXML
	private TextField txtTipoSangre;
	
	@FXML
	private TextField txtDireccion;
	
	@FXML
	private TextField txtTipoResidencia;
	
	@FXML
	private TextField txtPoblacion;
	
	@FXML
	private TextField txtProvincia;
	
	@FXML
	private TextField txtCP;
	
	@FXML
	private TextField txtPaisNatal;

	
	@FXML
	RadioButton No;

	@FXML
	RadioButton Si;

	@FXML
	ToggleGroup aptitud;
	
	@FXML
	private Button btnAceptar;
	
	@FXML
	private Button btnBorrar;
	
	private  Main ProgramaPrincipal;
	
	private Stage ventana;
	
	BBDDdonantes con;
	
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	
	public void aceptar () throws SQLException {
		
		con = new BBDDdonantes();
		
		
		String Ndonante = txtNdonante.getText();
		String Nombre = txtNonmbre.getText();
		String Apellido1 = txtApellido1.getText();
		String Apellido2 = txtApellido2.getText();
		String foto = "NULL";
		String DNI = txtDNI.getText();
		String Fnaci = txtFecha_nacimiento.getText();
		String TLF = txtTlf.getText();
		String movil = txtTlfMovil.getText();
		String Email = txtEmail.getText();
		String Tsangre = txtTipoSangre.getText();
		String Direccion = txtDireccion.getText();
		String Tresidencia = txtTipoResidencia.getText();
		String Poblacion = txtPoblacion.getText();
		String Provincia =  txtProvincia.getText();
		String CP = txtCP.getText();
		String PaisNatal = txtPaisNatal.getText();
		String sexo;
		String Aptitud;
		
		if(Si.isSelected()) {
			Aptitud = "S";
		}else {
			Aptitud = "N";
		}
		
		
		
		if(hombre.isSelected()) {
			sexo = "H";
		}else {
			sexo = "M";}
		
		
		
	

		// Añadir un chequeo de campos vacíos o de validación de formato como el email
		if(txtNdonante.getText().equals("") || txtNonmbre.getText().equals("") || txtApellido1.getText().equals("") || txtApellido2.getText().equals("") || txtDNI.getText().equals("") ||txtFecha_nacimiento.getText().equals("") ||
		txtTlf.getText().equals("") || txtTlfMovil.getText().equals("") || txtEmail.getText().equals("") || txtTipoSangre.getText().equals("") || txtDireccion.getText().equals("") || txtTipoResidencia.getText().equals("") ||
		txtProvincia.getText().equals("") || txtCP.getText().equals("") || txtPaisNatal.getText().equals("")){
			
			
			
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("FALTAN DATOS");
			alert.setHeaderText("Observa que hayas introducido todos los datos");
			alert.setContentText("¡Es necesario llenar todos los huecos!");
			alert.showAndWait();
		}
		else{
			con.NuevoDonante(Ndonante, Nombre, Apellido1, Apellido2, foto, DNI, Fnaci, TLF, movil, Email, sexo, Tsangre, Direccion, Tresidencia, Poblacion, Provincia, CP, PaisNatal, Aptitud);	
		}
	}	
	
	public void Borrar () {
		
		txtNdonante.setText("");
		txtNonmbre.setText("");
		txtApellido1.setText("");
		txtApellido2.setText("");
		txtDNI.setText("");
		txtFecha_nacimiento.setText("");
		txtTlf.setText("");
		txtTlfMovil.setText("");
		txtEmail.setText("");
		txtDireccion.setText("");
		txtTipoResidencia.setText("");
		txtProvincia.setText("");
		txtCP.setText("");
		txtPaisNatal.setText("");
		txtTipoSangre.setText("");
		
		
	}
	
}
