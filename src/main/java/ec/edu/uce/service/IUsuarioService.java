package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Usuario;

public interface IUsuarioService {

	public void insertarUsuario(Usuario usuario);

	public void actualizarUsuario(Usuario usuario);

	Usuario buscarUsuarioPorId(Integer id);

	public void eliminarUsuarioPorId(Integer id);

	public List<Usuario> listaUsuarios();
	
	String encriptarPassword(String password);
	
	boolean verificacion(String original, String hash);
}
