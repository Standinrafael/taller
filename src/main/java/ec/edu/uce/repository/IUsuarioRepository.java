package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Usuario;

public interface IUsuarioRepository {

	public void insertarUsuario(Usuario usuario);

	public void actualizarUsuario(Usuario usuario);

	Usuario buscarUsuarioPorId(Integer id);

	public void eliminarUsuarioPorId(Integer id);

	public List<Usuario> listaUsuarios();
}
