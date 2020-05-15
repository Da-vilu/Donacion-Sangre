package Modelo;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

	public class BBDDdonantes {

		private String url= "";
		private   String user = "";
		private String pwd = "";
		private   String usr = "";
		private   Connection conexion;

		public BBDDdonantes()  {


			Properties propiedades = new Properties();
			InputStream entrada = null;
			try {
				File miFichero = new File("src/Modelo/datos.ini");
				if (miFichero.exists()){
					entrada = new FileInputStream(miFichero);
					propiedades.load(entrada);
					url=propiedades.getProperty("url");
					user=propiedades.getProperty("user");
					pwd=propiedades.getProperty("pwd");
					usr=propiedades.getProperty("usr");
				}

				else
					System.out.println("Fichero no encontrado");
			} catch (IOException ex) {
				ex.printStackTrace();
			}finally {
				if (entrada != null) {
					try {
						entrada.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(url, user, pwd);

				if(conexion.isClosed())
					System.out.println("Fallo en Conexión con la Base de Datos");


			}catch (Exception e) {
				System.out.println("ERROR en conexión con ORACLE");
				e.printStackTrace();
			}
		}
		
		
		public void NuevoDonante(String ndonante, String nombre, String apellido_1, String apellido_2, String foto,
				String dNI_Pasaporte, String fecha_naci, String tLF, String movil, String email, String sexo,
				String tipo_sanguineo, String direccion, String t_residencia, String poblacion, String provinvia,
				String cP, String pais_naci, String aptitud) throws SQLException{

			//Preparo la conexion para ejecutar sentencias SQL de tipo update
			Statement stm = conexion.createStatement();

			// Preparo la sentencia SQL CrearTablaPersonas
			String insertsql = "INSERT INTO "+usr+".DONANTES VALUES (?,?,?,?,NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,'NO')";
			
			PreparedStatement pstmt = conexion.prepareStatement(insertsql);
			pstmt.setString(1, ndonante);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellido_1);
			pstmt.setString(4, apellido_2);
			pstmt.setString(5, dNI_Pasaporte);
			pstmt.setString(6, fecha_naci);
			pstmt.setString(7, tLF);
			pstmt.setString(8, movil);
			pstmt.setString(9, email);
			pstmt.setString(10, sexo);
			pstmt.setString(11, tipo_sanguineo);
			pstmt.setString(12, direccion);
			pstmt.setString(13, t_residencia);
			pstmt.setString(14, poblacion);
			pstmt.setString(15, provinvia);
			pstmt.setString(16, cP);
			pstmt.setString(17, pais_naci);
		
			
			//ejecuto la sentencia
			try{
				pstmt.executeUpdate();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("DONANTE INTRODUCIDA");
			alert.setHeaderText("Un donante ha sido introducido con exito");
			alert.setContentText("El donante ha sido guardado con exito en la Base de Datos");
			alert.showAndWait();

			}
			catch(SQLException sqle) {
				
				int pos = sqle.getMessage().indexOf(":");
				String sqlerror = sqle.getMessage().substring(0,pos);
				
				if (sqlerror.equals("ORA-00001")) {
					System.out.println("Ya existe ese numero de donante en la BBDD");
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error!!!");
					alert.setHeaderText("Este numero de donante ya existe en la base de datos");
					alert.setContentText("¡No se puede guardar un numero de donante que ya existe!");
					alert.showAndWait();
					
				}else {
					System.out.println(sqle.getMessage());
					System.out.println("Un error ha ocurrido");
					
				}
			}
		}
		
		public void UpdateDonante(String ndonante, String nombre, String apellido_1, String apellido_2, String foto,
				String dNI_Pasaporte, String fecha_naci, String tLF, String movil, String email, String sexo,
				String tipo_sanguineo, String direccion, String t_residencia, String poblacion, String provinvia,
				String cP, String pais_naci) throws SQLException{

			//Preparo la conexion para ejecutar sentencias SQL de tipo update
			Statement stm = conexion.createStatement();

			// Preparo la sentencia SQL CrearTablaPersonas
			String insertsql = "UPDATE "+usr+".DONANTES SET NOMBRE=?, APELLIDO_1=?, APELLIDO_2=?, DNI_pasaporte=?, FECHA_NACI=?, "
					+ "TLF=?, TLF_mov=?, EMAIL=?,SEXO=?, TIPO_SANGUINEO=?, DIRECCION=?, T_residencia=?, "
					+ "POBLACION=?, PROVINVIA=?, CP=?, Pais_naci=? WHERE ndonante=?";
			
			
			PreparedStatement pstmt = conexion.prepareStatement(insertsql);
			
			
			pstmt.setString(1, nombre);
			pstmt.setString(2, apellido_1);
			pstmt.setString(3, apellido_2);
			pstmt.setString(4, dNI_Pasaporte);
			pstmt.setString(5, fecha_naci);
			pstmt.setString(6, tLF);
			pstmt.setString(7, movil);
			pstmt.setString(8, email);
			pstmt.setString(9, sexo);
			pstmt.setString(10, tipo_sanguineo);
			pstmt.setString(11, direccion);
			pstmt.setString(12, t_residencia);
			pstmt.setString(13, poblacion);
			pstmt.setString(14, provinvia);
			pstmt.setString(15, cP);
			pstmt.setString(16, pais_naci);
			pstmt.setString(17, ndonante);
			
			
			//ejecuto la sentencia
			try{
				pstmt.executeUpdate();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("DONANTE ACTUALIZADA");
			alert.setHeaderText("Un donante ha sido actualizada con exito");
			alert.setContentText("El donante ha sido actualizado en la base de datos");
			alert.showAndWait();

			}
			catch(SQLException sqle) {
				
				int pos = sqle.getMessage().indexOf(":");
				String sqlerror = sqle.getMessage().substring(0,pos);
				
				if (sqlerror.equals("ORA-00001")) {
					System.out.println("Ya existe ese numero de donante en la BBDD");
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("NO SE PUEDEN ACTUALIZAR LOS NUMEROS DE DONANTE!!!");
					alert.setHeaderText("HA ");
					alert.setContentText("¡No se puede guardar un Numero de donante que NO existe!");
					alert.showAndWait();
					
				}else {
					System.out.println(sqle.getMessage());
					System.out.println("Un error ha ocurrido");
					
				}
			}
		}
		
		
		public void EliminarDonante(String ndonante) throws SQLException{

			//Preparo la conexion para ejecutar sentencias SQL de tipo update
			Statement stm = conexion.createStatement();

			// Preparo la sentencia SQL CrearTablaPersonas
			String insertsql = "DELETE FROM "+usr+".DONANTES WHERE ndonante=?";
			
			
			
			PreparedStatement pstmt = conexion.prepareStatement(insertsql);
			
			pstmt.setString(1, ndonante);
		
			//ejecuto la sentencia
			try{
				pstmt.executeUpdate();
				
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("DONANTE ELIMINADO CON EXITO");
			alert.setHeaderText("HAS ELIMINADO A UN DONANTE");
			alert.setContentText("El donante ha sido eliminado de la base de datos");
			alert.showAndWait();

			}
			catch(SQLException sqle) {
				
				int pos = sqle.getMessage().indexOf(":");
				String sqlerror = sqle.getMessage().substring(0,pos);
				
				if (sqlerror.equals("ORA-00001")) {
				System.out.println(sqle.getMessage());
					
				}else {
					System.out.println(sqle.getMessage());
					System.out.println("Un error ha ocurrido");
					
				}
			}
		}

		
		
		

		
		public ObservableList<Donantes>buscarDonante(String ndonante) throws SQLException{

			
			ObservableList<Donantes> listacliente =  FXCollections.observableArrayList();

			//Preparo la conexión para ejecutar sentencias SQL de tipo update
			Statement stm = conexion.createStatement();

			// Preparo la sentencia SQL CrearTablaPersonas
			String selectsql = "SELECT * FROM "+usr+".DONANTES WHERE ndonante=?";
			
			PreparedStatement pstmt = conexion.prepareStatement(selectsql);
			
			pstmt.setString(1, ndonante);
			
			//ejecuto la sentencia
					try{
						ResultSet resultado = pstmt.executeQuery();

						while(resultado.next()){
							Donantes donante = new Donantes(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), null, resultado.getString(6),
									resultado.getString(7), resultado.getInt(8), resultado.getInt(9), resultado.getString(10), resultado.getString(11), resultado.getString(12), resultado.getString(13), resultado.getString(14), 
									resultado.getString(15), resultado.getString(16), resultado.getString(17), resultado.getString(18), resultado.getString(19));
							listacliente.add(donante);
						}

					}catch(SQLException sqle){

					

						System.out.println(sqle.getMessage());
					}

					return listacliente;
				}
		
		public ObservableList<Donantes>  ConsultaDonantes() throws SQLException{

		
			ObservableList<Donantes> ListaDonantes =  FXCollections.observableArrayList();

			//Preparo la conexión para ejecutar sentencias SQL de tipo update
			Statement stm = conexion.createStatement();

			// Preparo la sentencia SQL CrearTablaPersonas
			String selectsql = "SELECT * FROM "+usr+".DONANTES";
			PreparedStatement pstmt = conexion.prepareStatement(selectsql);
			//ejecuto la sentencia
			try{
				ResultSet resultado = pstmt.executeQuery();

				while(resultado.next()){
					Donantes person = new Donantes(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getBlob(5), resultado.getString(6),
							resultado.getString(7), resultado.getInt(8), resultado.getInt(9), resultado.getString(10), resultado.getString(11), resultado.getString(12), resultado.getString(13), resultado.getString(14),
							resultado.getString(15), resultado.getString(16), resultado.getString(17), resultado.getString(18), resultado.getString(19));
					ListaDonantes.add(person);
				}

			}catch(SQLException sqle){

			

				System.out.println(sqle.getMessage());
			}

			return ListaDonantes;
		}
		
	}

