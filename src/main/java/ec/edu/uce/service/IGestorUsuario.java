package ec.edu.uce.service;

import java.util.List;

public interface IGestorUsuario {

	public List<String> filtrarUsuarios();

	public List<String> filtrarContrasenia();

	public boolean comprobarExistenciaUsuario(String correo, String contrasenia);
}
