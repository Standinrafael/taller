package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.modelo.EstudianteSencillo;

public interface IEstudianteRepository {

	// Metodos CRUD

	public void insertarEstudiante(Estudiante estudiante);

	public void actualizarEstudiante(Estudiante estudiante);

	Estudiante buscarEstudiantePorId(Integer id);

	public void eliminarEstudiantePorId(Integer id);

	// Metodos adicionales

	Estudiante buscarEstudiantePorCorreo(String email);

	List<Estudiante> listaEstudiantes(String curso, String paralelo);
}
