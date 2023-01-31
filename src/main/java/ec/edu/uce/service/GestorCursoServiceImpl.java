package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Curso;
import ec.edu.uce.modelo.Docente;
import ec.edu.uce.modelo.Estudiante;

@Service
public class GestorCursoServiceImpl implements IGestorCursoService {

	@Autowired
	private ICursoService cursoService;

	@Autowired
	private IDocenteService docenteService;

	@Autowired
	private IEstudianteService estudianteService;

	@Override
	public Docente buscarDocentePorEmail(String email) {
		// TODO Auto-generated method stub
		Docente docente = this.docenteService.buscarDocentePorEmail(email);
		return docente;
	}

	@Override
	public Estudiante buscarEstudiantePorEmail(String email) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.estudianteService.buscarEstudiantePorCorreo(email);
		return estudiante;
	}

	@Override
	public List<Estudiante> buscarCursoPorParalelo(String Curso, String Paralelo) {
		// TODO Auto-generated method stub

		List<Estudiante> lista = this.estudianteService.listaEstudiantes(Curso, Paralelo);
		return lista;
	}

}
