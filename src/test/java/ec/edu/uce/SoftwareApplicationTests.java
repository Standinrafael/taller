package ec.edu.uce;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.service.IDocenteService;
import ec.edu.uce.service.IEstudianteService;
import ec.edu.uce.service.IGestorCursoService;
import ec.edu.uce.service.IGestorDocenteService;
import ec.edu.uce.service.IGestorEstudianteService;
import ec.edu.uce.service.IGestorUsuario;
import ec.edu.uce.service.IUsuarioService;

@SpringBootTest
class SoftwareApplicationTests {

	@Autowired
	private IDocenteService docenteService;

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IGestorCursoService gestorCurso;

	@Autowired
	private IGestorDocenteService gestorDocente;

	@Autowired
	private IGestorEstudianteService gestorEstudiante;

	@Autowired
	private IGestorUsuario gestorUsuario;

	// Metodo para encontrar un curso especifico
	@Test
	void pruebaUnitarioUno() {

		assertNotNull(this.gestorDocente.consultarCurso("Primero", "A"));
	}

	// Método para no encuentre un curso especifico
	@Test
	void pruebaUnitarioDos() {

		List<Estudiante> lista = this.gestorDocente.consultarCurso("Primero", "D");
		int valor = 0;
		assertEquals(lista.size(), valor);

	}

	// Metodo para que encuentre un docente
	@Test
	void pruebaUnitarioTres() {

		assertNotNull(this.docenteService.buscarDocentePorEmail("sefal@gutemberg.edu.ec"));
	}

	// Metodo para que no encuentre un docente
	@Test
	void pruebaUnitarioCuatro() {

		assertNull(this.docenteService.buscarDocentePorEmail("sefals@gutemberg.edu.ec"));
	}

	// Metodo para que encuentre un estudiante
	@Test
	void pruebaUnitarioCinco() {

		assertNotNull(this.estudianteService.buscarEstudiantePorCorreo("gus@gutemberg.edu.ec"));
	}

	// Método cuando No encuentre un estudiante
	@Test
	void pruebaUnitarioSeis() {

		assertNull(this.estudianteService.buscarEstudiantePorCorreo("gusss@gutemberg.edu.ec"));
	}

	// Método para buscar docente
	@Test
	void pruebaUnitarioSiete() {

		assertNotNull(this.gestorCurso.buscarDocentePorEmail("sefal@gutemberg.edu.ec"));
	}

	// Método para buscar alumno
	@Test
	void pruebaUnitarioOcho() {

		assertNotNull(this.gestorCurso.buscarEstudiantePorEmail("gus@gutemberg.edu.ec"));
	}

	// Método para obtener notas de un estudiantee
	@Test
	void pruebaUnitarioNueve() {

		assertNotNull(this.gestorEstudiante.consultarCalificacion("mausi@gutemberg.edu.ec"));
	}

	// Metodo para la actualizacion de calificacion
	@Test
	void pruebaUnitarioDiez() {
		BigDecimal nota = new BigDecimal("8.00");

		Estudiante e1 = this.estudianteService.buscarEstudiantePorCorreo("mausi@gutemberg.edu.ec");
		e1.setAleman(nota);

		this.estudianteService.actualizarEstudiante(e1);

		assertEquals(nota, e1.getAleman());

	}

	// Método para comprobar que el usuario está registrado en el sistema
	@Test
	void pruebaUnitarioOnce() {

		boolean valor = this.gestorUsuario.comprobarExistenciaUsuario("sefal@gutemberg.edu.ec", "12345");

		assertEquals(valor, true);

	}

	// Método para comprobar que el usuario no está registrado en el sistema
	@Test
	void pruebaUnitarioDoce() {

		boolean valor = this.gestorUsuario.comprobarExistenciaUsuario("sefassl@gutemberg.edu.ec", "12345");

		assertEquals(valor, false);

	}

}
