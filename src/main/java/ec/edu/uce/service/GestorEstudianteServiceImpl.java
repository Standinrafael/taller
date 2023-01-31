package ec.edu.uce.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GestorEstudianteServiceImpl implements IGestorEstudianteService {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private ICursoService cursoService;

	@Override
	public Estudiante consultarCalificacion(String email) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.estudianteService.buscarEstudiantePorCorreo(email);
		return estudiante;

	}

	@Override
	public List<EstudianteSencillo> consultarCurso(String curso, String paralelo) {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteService.listaEstudiantes(curso, paralelo);

		Stream<EstudianteSencillo> listaFiltrada = lista.parallelStream().map(estudiante -> {
			EstudianteSencillo estudiantes1 = new EstudianteSencillo();
			estudiantes1.setNombre(estudiante.getNombre());
			estudiantes1.setApellido(estudiante.getApellido());

			estudiantes1.setMateria1(estudiante.getMatematicas());
			estudiantes1.setMateria2(estudiante.getLenguaje());
			estudiantes1.setMateria3(estudiante.getSociales());
			estudiantes1.setMateria4(estudiante.getCiencias());
			estudiantes1.setMateria5(estudiante.getAleman());
			estudiantes1.setConducta1(estudiante.getConductaMatematicas());
			estudiantes1.setConducta2(estudiante.getConductaLenguaje());
			estudiantes1.setConducta3(estudiante.getConductaSociales());
			estudiantes1.setConducta4(estudiante.getConductaCiencias());
			estudiantes1.setConducta5(estudiante.getConductaAleman());

			return estudiantes1;
		});

		List<EstudianteSencillo> listaSencilla = listaFiltrada.collect(Collectors.toList());

		for (EstudianteSencillo s1 : listaSencilla) {
			System.out.println(s1);

		}
		return listaSencilla;
	}

	@Override
	public Promedio obtenerPromedio(List<EstudianteSencillo> lista) {
		// TODO Auto-generated method stub

		Promedio promedioFinal = new Promedio();

		BigDecimal promedioMatematicas = new BigDecimal("0.00");
		BigDecimal promedioLenguaje = new BigDecimal("0.00");
		BigDecimal promedioSociales = new BigDecimal("0.00");
		BigDecimal promedioCiencias = new BigDecimal("0.00");
		BigDecimal promedioAleman = new BigDecimal("0.00");

		for (EstudianteSencillo estudiante : lista) {
			promedioMatematicas = promedioMatematicas.add(estudiante.getMateria1());
			promedioLenguaje = promedioLenguaje.add(estudiante.getMateria2());
			promedioSociales = promedioSociales.add(estudiante.getMateria3());
			promedioCiencias = promedioCiencias.add(estudiante.getMateria4());
			promedioAleman = promedioAleman.add(estudiante.getMateria5());

		}

		promedioMatematicas = promedioMatematicas.divide(new BigDecimal("5.00"));
		promedioLenguaje = promedioLenguaje.divide(new BigDecimal("5.00"));
		promedioSociales = promedioSociales.divide(new BigDecimal("5.00"));
		promedioCiencias = promedioCiencias.divide(new BigDecimal("5.00"));
		promedioAleman = promedioAleman.divide(new BigDecimal("5.00"));

		promedioFinal.setPromedio1(promedioMatematicas);
		promedioFinal.setPromedio2(promedioLenguaje);
		promedioFinal.setPromedio3(promedioSociales);
		promedioFinal.setPromedio4(promedioCiencias);
		promedioFinal.setPromeido5(promedioAleman);

		return promedioFinal;
	}

}
