package ec.edu.uce.repository;

import ec.edu.uce.modelo.Materia;

public interface IMateriaRepository {

	// Metodos CRUD

	public void insertarMateria(Materia materia);

	public void actualizarMateria(Materia materia);

	Materia buscarMateriaPorId(Integer id);

	public void eliminarMateriaPorId(Integer id);
}
