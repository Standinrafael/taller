package ec.edu.uce.repository;

import ec.edu.uce.modelo.Docente;

public interface IDocenteRepository {

	// Metodos CRUD

	public void insertarDocente(Docente docente);

	public void actualizarDocente(Docente docente);

	Docente buscarDocentePorId(Integer id);

	public void eliminarDocentePorId(Integer id);

	// Metodos adicionales

	Docente buscarDocentePorEmail(String email);
}
