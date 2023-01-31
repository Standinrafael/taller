package ec.edu.uce.service;

import ec.edu.uce.modelo.Curso;

public interface ICursoService {

	// Metodos CRUD

	public void insertarCurso(Curso curso);

	public void actualizarCurso(Curso curso);

	Curso buscarCursoPorId(Integer id);

	public void eliminarCursoPorId(Integer id);

	// Metodos Adicionales

	Curso buscarCursoPorParalelo(String nombre, String paralelo);
}
