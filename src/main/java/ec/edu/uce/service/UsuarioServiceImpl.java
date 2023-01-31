package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Usuario;
import ec.edu.uce.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepo;

	@Override
	public void insertarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		this.usuarioRepo.insertarUsuario(usuario);
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		this.usuarioRepo.actualizarUsuario(usuario);
	}

	@Override
	public Usuario buscarUsuarioPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.buscarUsuarioPorId(id);
	}

	@Override
	public void eliminarUsuarioPorId(Integer id) {
		// TODO Auto-generated method stub
		this.usuarioRepo.eliminarUsuarioPorId(id);
	}

	@Override
	public List<Usuario> listaUsuarios() {
		// TODO Auto-generated method stub
		return this.usuarioRepo.listaUsuarios();
	}

	@Override
	public String encriptarPassword(String password) {
		// TODO Auto-generated method stub
		
		//Encriptacion en codigo alfanumerico
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public boolean verificacion(String original, String hash) {
		// TODO Auto-generated method stub
		
		boolean valor=false;
		
		
		hash=BCrypt.hashpw(original, BCrypt.gensalt());
		
		
		if(hash==BCrypt.hashpw(original, hash)) {
			valor=true;
			return valor;
		}		
		
		return valor;
	}

}
