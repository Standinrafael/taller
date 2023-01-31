package ec.edu.uce.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.modelo.Materia;

@Service
public class GestorDocenteServiceImpl implements IGestorDocenteService {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService materiaService;

	@Autowired
	private ICursoService cursoService;

	@Override
	public boolean actualizarRegistrarNota(String email, String materia, BigDecimal notaNueva) {
		// TODO Auto-generated method stub

		boolean resultado = false;
		Estudiante estudiante = this.estudianteService.buscarEstudiantePorCorreo(email);

		if (estudiante != null) {

			if (materia.equals("Matematicas")) {
				estudiante.setMatematicas(notaNueva);
				this.estudianteService.actualizarEstudiante(estudiante);
				resultado = true;
			} else if (materia.equals("Lenguaje")) {
				estudiante.setLenguaje(notaNueva);
				this.estudianteService.actualizarEstudiante(estudiante);
				resultado = true;
			}

			else if (materia.equals("Ciencias")) {
				estudiante.setCiencias(notaNueva);
				this.estudianteService.actualizarEstudiante(estudiante);
				resultado = true;
			} else if (materia.equals("Sociales")) {
				estudiante.setSociales(notaNueva);
				this.estudianteService.actualizarEstudiante(estudiante);
				resultado = true;
			}

			else if (materia.equals("Aleman")) {
				estudiante.setAleman(notaNueva);
				this.estudianteService.actualizarEstudiante(estudiante);
				resultado = true;
			}

			else {
				resultado = false;
			}
		}

		else {
			System.out.println("No hay estudiante");
		}

		return resultado;
	}

	@Override

	public List<Estudiante> consultarCurso(String curso, String paralelo) {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteService.listaEstudiantes(curso, paralelo);
		return lista;
	}

	@Override
	public boolean actualizarRegistrarConducta(String email, String materia, String conducta) {
		// TODO Auto-generated method stub
		boolean resultado = false;
		Estudiante estudiante = this.estudianteService.buscarEstudiantePorCorreo(email);

		if (estudiante != null) {

			if (materia.equals("Matematicas")) {
				estudiante.setConductaMatematicas(conducta);
				this.estudianteService.actualizarEstudiante(estudiante);
				resultado = true;
			} else if (materia.equals("Lenguaje")) {
				estudiante.setConductaLenguaje(conducta);
				this.estudianteService.actualizarEstudiante(estudiante);
				resultado = true;
			}

			else if (materia.equals("Ciencias")) {
				estudiante.setConductaCiencias(conducta);
				this.estudianteService.actualizarEstudiante(estudiante);
				resultado = true;
			} else if (materia.equals("Sociales")) {
				estudiante.setConductaSociales(conducta);
				this.estudianteService.actualizarEstudiante(estudiante);
				resultado = true;
			}

			else if (materia.equals("Aleman")) {
				estudiante.setConductaAleman(conducta);
				this.estudianteService.actualizarEstudiante(estudiante);
				resultado = true;
			}

			else {
				resultado = false;
			}
		}

		else {
			System.out.println("No hay estudiante");
		}

		return resultado;
	}

}
