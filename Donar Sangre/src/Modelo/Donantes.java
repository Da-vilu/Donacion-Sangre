package Modelo;

import java.sql.Blob;

public class Donantes {
	
		private String Ndonante; 
		private String  Nombre; 
		private String Apellido_1;  
		private String Apellido_2; 
		private Blob Foto; 
		private String DNI_Pasaporte; 
		private String Fecha_naci; 
		private int TLF; 
		private int TLF_mov; 
		private String Email; 
		private String Sexo; 
		private String Tipo_sanguineo; 
		private String Direccion; 
		private String T_residencia; 
		private String Poblacion;
		private String Provinvia; 
		private String CP; 
		private String Pais_naci;
		private String Aptitud;
		
		public Donantes(String ndonante, String nombre, String apellido_1, String apellido_2, Blob foto,
				String dNI_Pasaporte, String fecha_naci, int tLF, int tLF_mov, String email, String sexo,
				String tipo_sanguineo, String direccion, String t_residencia, String poblacion, String provinvia,
				String cP, String pais_naci, String aptitud) {
			super();
			Ndonante = ndonante;
			Nombre = nombre;
			Apellido_1 = apellido_1;
			Apellido_2 = apellido_2;
			Foto = foto;
			DNI_Pasaporte = dNI_Pasaporte;
			Fecha_naci = fecha_naci;
			TLF = tLF;
			TLF_mov = tLF_mov;
			Email = email;
			Sexo = sexo;
			Tipo_sanguineo = tipo_sanguineo;
			Direccion = direccion;
			T_residencia = t_residencia;
			Poblacion = poblacion;
			Provinvia = provinvia;
			CP = cP;
			Pais_naci = pais_naci;
			Aptitud = aptitud;
		}

		public String getNdonante() {
			return Ndonante;
		}

		public void setNdonante(String ndonante) {
			Ndonante = ndonante;
		}

		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}

		public String getApellido_1() {
			return Apellido_1;
		}

		public void setApellido_1(String apellido_1) {
			Apellido_1 = apellido_1;
		}

		public String getApellido_2() {
			return Apellido_2;
		}

		public void setApellido_2(String apellido_2) {
			Apellido_2 = apellido_2;
		}

		public Blob getFoto() {
			return Foto;
		}

		public void setFoto(Blob foto) {
			Foto = foto;
		}

		public String getDNI_Pasaporte() {
			return DNI_Pasaporte;
		}

		public void setDNI_Pasaporte(String dNI_Pasaporte) {
			DNI_Pasaporte = dNI_Pasaporte;
		}

		public String getFecha_naci() {
			return Fecha_naci;
		}

		public void setFecha_naci(String fecha_naci) {
			Fecha_naci = fecha_naci;
		}

		public int getTLF() {
			return TLF;
		}

		public void setTLF(int tLF) {
			TLF = tLF;
		}

		public int getTLF_mov() {
			return TLF_mov;
		}

		public void setTLF_mov(int tLF_mov) {
			TLF_mov = tLF_mov;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getSexo() {
			return Sexo;
		}

		public void setSexo(String sexo) {
			Sexo = sexo;
		}

		public String getTipo_sanguineo() {
			return Tipo_sanguineo;
		}

		public void setTipo_sanguineo(String tipo_sanguineo) {
			Tipo_sanguineo = tipo_sanguineo;
		}

		public String getDireccion() {
			return Direccion;
		}

		public void setDireccion(String direccion) {
			Direccion = direccion;
		}

		public String getT_residencia() {
			return T_residencia;
		}

		public void setT_residencia(String t_residencia) {
			T_residencia = t_residencia;
		}

		public String getPoblacion() {
			return Poblacion;
		}

		public void setPoblacion(String poblacion) {
			Poblacion = poblacion;
		}

		public String getProvinvia() {
			return Provinvia;
		}

		public void setProvinvia(String provinvia) {
			Provinvia = provinvia;
		}

		public String getCP() {
			return CP;
		}

		public void setCP(String cP) {
			CP = cP;
		}

		public String getPais_naci() {
			return Pais_naci;
		}

		public void setPais_naci(String pais_naci) {
			Pais_naci = pais_naci;
		}

		public String getAptitud() {
			return Aptitud;
		}

		public void setAptitud(String aptitud) {
			Aptitud = aptitud;
		} 


	
	
	
	
}
