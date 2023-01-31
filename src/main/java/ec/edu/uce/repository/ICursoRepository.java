package ec.edu.uce.repository;

import ec.edu.uce.modelo.Curso;

public interface ICursoRepository {

	// Metodos CRUD

	public void insertarCurso(Curso curso);

	public void actualizarCurso(Curso curso);

	Curso buscarCursoPorId(Integer id);

	public void eliminarCursoPorId(Integer id);

	// Metodos Adicionales

	Curso buscarCursoPorParalelo(String nombre, String paralelo);

}
