package ec.edu.uce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Usuario;

@Service
public class GestorUsuarioImpls implements IGestorUsuario {

	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public List<String> filtrarUsuarios() {
		// TODO Auto-generated method stub

		List<Usuario> lista = this.usuarioService.listaUsuarios();

		List<String> listafiltrada = new ArrayList<>();

		for (Usuario usuario : lista) {
			String usu = usuario.getCorreo();
			listafiltrada.add(usu);
		}

		return listafiltrada;
	}

	@Override
	public List<String> filtrarContrasenia() {
		// TODO Auto-generated method stub

		List<Usuario> lista = this.usuarioService.listaUsuarios();
		List<String> listafiltrada = new ArrayList<>();

		for (Usuario usuario : lista) {
			String contrasenia = usuario.getContrasenia();
			listafiltrada.add(contrasenia);
		}

		return listafiltrada;

	}

	@Override
	public boolean comprobarExistenciaUsuario(String correo, String contrasenia) {
		// TODO Auto-generated method stub

		boolean resultado1 = false;
		boolean resultado2 = false;
		boolean resultado = false;

		List<String> usuarios = this.filtrarUsuarios();
		List<String> contrasenias = this.filtrarContrasenia();

		for (String usuario : usuarios) {
			if (usuario.equals(correo)) {

				resultado1 = true;
				break;

			} else {
				resultado1 = false;
			}
		}

		for (String contra : contrasenias) {
			if (contra.equals(contrasenia)) {

				resultado2 = true;
				break;

			} else {

				resultado2 = false;
			}
		}

		if (resultado1 == true && resultado2 == true) {
			resultado = true;
		}
		return resultado;
	}

}
