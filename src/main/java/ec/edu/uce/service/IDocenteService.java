package ec.edu.uce.service;

import ec.edu.uce.modelo.Docente;

public interface IDocenteService {

	// Metodos CRUD

	public void insertarDocente(Docente docente);

	public void actualizarDocente(Docente docente);

	Docente buscarDocentePorId(Integer id);

	public void eliminarDocentePorId(Integer id);

	// Metodos adicionales
	Docente buscarDocentePorEmail(String email);

}
