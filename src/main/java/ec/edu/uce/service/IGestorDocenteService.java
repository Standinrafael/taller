package ec.edu.uce.service;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.modelo.Estudiante;

public interface IGestorDocenteService {

	public boolean actualizarRegistrarNota(String email, String materia, BigDecimal notaNueva);
	
	public boolean actualizarRegistrarConducta(String email, String materia, String conducta);

	List<Estudiante> consultarCurso(String curso, String paralelo);
}
