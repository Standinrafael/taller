package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.modelo.EstudianteSencillo;

public interface IEstudianteService {

	// Metodos CRUD

	public void insertarEstudiante(Estudiante estudiante);

	public void actualizarEstudiante(Estudiante estudiante);

	Estudiante buscarEstudiantePorId(Integer id);

	public void eliminarEstudiantePorId(Integer id);

	// Metodos Adicionales

	Estudiante buscarEstudiantePorCorreo(String email);

	List<Estudiante> listaEstudiantes(String curso, String paralelo);
}
