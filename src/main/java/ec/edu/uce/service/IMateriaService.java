package ec.edu.uce.service;

import ec.edu.uce.modelo.Materia;

public interface IMateriaService {

	// Metodos CRUD

	public void insertarMateria(Materia materia);

	public void actualizarMateria(Materia materia);

	Materia buscarMateriaPorId(Integer id);

	public void eliminarMateriaPorId(Integer id);

}
