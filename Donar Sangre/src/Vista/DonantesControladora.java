package Vista;

import java.sql.SQLException;
import java.util.Optional;

import Modelo.BBDDdonantes;
import Modelo.Donantes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DonantesControladora {
	
	@FXML
	private Button btnNuevaDonacion;
	
	@FXML
	private Button btnActualizarDonacion;
	
	@FXML
	private Button btnEliminarDonacion;
	
	@FXML
	private Button MostrarDonacion;
	
	@FXML
	private Button btnVolver;
	
	@FXML
	private TextField txtBuscar;
	
	@FXML
	private ScrollBar scrl_donantes;
	
	@FXML
	private TableView<Donantes> TablaDonantes;

	@FXML
	private TableColumn<Donantes,String> Ndonante;

	@FXML
	private TableColumn<Donantes,String> Nombre;

	@FXML
	private TableColumn<Donantes,String> Apellido_1;

	@FXML
	private TableColumn<Donantes,String> Apellido_2;

	@FXML
	private TableColumn<Donantes,String> Foto;
	
	@FXML
	private TableColumn<Donantes,String> DNI_Pasaporte;
	
	@FXML
	private TableColumn<Donantes,String> Fecha_naci;
	
	@FXML
	private TableColumn<Donantes,String> TLF;
	
	@FXML
	private TableColumn<Donantes,String> TLF_mov;
	
	@FXML
	private TableColumn<Donantes,String> Email;
	
	@FXML
	private TableColumn<Donantes,String> Sexo;
	
	@FXML
	private TableColumn<Donantes,String> Tipo_sanguineo;
	
	@FXML
	private TableColumn<Donantes,String> Direccion;
	
	@FXML
	private TableColumn<Donantes,String> T_residencia;
	
	@FXML
	private TableColumn<Donantes,String> Poblacion;
	
	@FXML
	private TableColumn<Donantes,String> Provincia;
	
	@FXML
	private TableColumn<Donantes,String> CP;
	
	@FXML
	private TableColumn<Donantes,String> Pais_nacimiento;
	
	@FXML
	private TableColumn<Donantes,String> Aptitud;
	
	
	
	BBDDdonantes con;

	private ObservableList<Donantes> datosseleccion = FXCollections.observableArrayList();

	

	
	
	public void initialize() throws SQLException{
		
		con = new BBDDdonantes();
		
		datosseleccion = con.ConsultaDonantes();
		TablaDonantes.setItems(datosseleccion);

		
		Ndonante.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Ndonante"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Nombre"));
		Apellido_1.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Apellido_1"));
		Apellido_2.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Apellido_2"));
		Foto.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Foto"));
		DNI_Pasaporte.setCellValueFactory(new PropertyValueFactory<Donantes,String>("DNI_Pasaporte"));
		Fecha_naci.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Fecha_naci"));
		TLF.setCellValueFactory(new PropertyValueFactory<Donantes,String>("TLF"));
		TLF_mov.setCellValueFactory(new PropertyValueFactory<Donantes,String>("TLF_mov"));
		Email.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Email"));
		Sexo.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Sexo"));
		Tipo_sanguineo.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Tipo_sanguineo"));
		Direccion.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Direccion"));
		T_residencia.setCellValueFactory(new PropertyValueFactory<Donantes,String>("T_residencia"));
		Poblacion.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Poblacion"));
		Provincia.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Provincia"));
		CP.setCellValueFactory(new PropertyValueFactory<Donantes,String>("CP"));
		Pais_nacimiento.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Pais_nacimiento"));
		Aptitud.setCellValueFactory(new PropertyValueFactory<Donantes,String>("Aptitud"));
	}
			
	
				public void BuscarDonante() throws SQLException {
		
					datosseleccion = con.buscarDonante(txtBuscar.getText());
					TablaDonantes.setItems(datosseleccion);
					
					if(txtBuscar.getText()=="") {
						datosseleccion = con.ConsultaDonantes();
						TablaDonantes.setItems(datosseleccion);
					}
		
			}
		
				public void NuevoDonante() throws SQLException {
		
					//Hay que realizar la UI de las donaciones para realizar este metodo
		
			}
	
				
				public void EliminarDonante() throws SQLException {
		
					int index = TablaDonantes.getSelectionModel().getSelectedIndex();
					if( index >= 0){

						Donantes seleccionada = TablaDonantes.getSelectionModel().getSelectedItem();

						// Se abre un dialog box de confirmacion de eliminar
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("CONFIRMACION");
						alert.setHeaderText("Por favor confirme el borrado");
						alert.setContentText("�Desea borrar la donaci�n con c�digo: "+ seleccionada.getNdonante() +" ?");

						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK){
						    // ... user chose OK
							datosseleccion.remove(seleccionada);
							TablaDonantes.setItems(this.datosseleccion);
							
							con.EliminarDonante(seleccionada.getNdonante());
						
						}

					}else{

						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("Error en selecci�n de datos");
						alert.setContentText("NO HAY NINGUN ELEMENTO SELECCIONADO!");
						alert.showAndWait();

					}
		
			}
	
				
				public void ActualizarDonante() {
	
	
	
			}

				
				public void MostrarDonante() {
	
	
	
			}
				
				
				public void Volver() {
					
			
					
			}
				
				public void mover() {
					
					
					
			}

}