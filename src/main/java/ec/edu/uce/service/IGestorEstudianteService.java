package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.modelo.EstudianteSencillo;
import ec.edu.uce.modelo.Promedio;

public interface IGestorEstudianteService {

	Estudiante consultarCalificacion(String email);

	List<EstudianteSencillo> consultarCurso(String curso, String paralelo);

	public Promedio obtenerPromedio(List<EstudianteSencillo> lista);
}
