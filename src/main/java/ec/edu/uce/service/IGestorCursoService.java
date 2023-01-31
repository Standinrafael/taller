package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Docente;
import ec.edu.uce.modelo.Estudiante;

public interface IGestorCursoService {

	List<Estudiante> buscarCursoPorParalelo(String Curso, String Paralelo);

	Docente buscarDocentePorEmail(String email);

	Estudiante buscarEstudiantePorEmail(String email);
}
