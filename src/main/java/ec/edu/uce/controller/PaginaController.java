package ec.edu.uce.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.edu.uce.mail.EmailSenderService;
import ec.edu.uce.modelo.Curso;
import ec.edu.uce.modelo.Docente;
import ec.edu.uce.modelo.Empleado;
import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.modelo.EstudianteSencillo;
import ec.edu.uce.modelo.Promedio;
import ec.edu.uce.modelo.Representante;
import ec.edu.uce.service.ICursoService;
import ec.edu.uce.service.IDocenteService;
import ec.edu.uce.service.IEmpleadoService;
import ec.edu.uce.service.IEstudianteService;
import ec.edu.uce.service.IGestorCursoService;
import ec.edu.uce.service.IGestorDocenteService;
import ec.edu.uce.service.IGestorEstudianteService;
import ec.edu.uce.service.IGestorUsuario;
import ec.edu.uce.service.IMateriaService;
import ec.edu.uce.service.IRepresentanteService;

@Controller
@RequestMapping("/sistemas/")
public class PaginaController {

	@Autowired
	private IGestorCursoService gestorCursoService;

	@Autowired
	private IGestorDocenteService gerstorDocenteService;

	@Autowired
	private IGestorEstudianteService gestorEstudianteService;

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private ICursoService cursoService;

	@Autowired
	private IMateriaService materiaService;

	@Autowired
	private IDocenteService docenteService;

	@Autowired
	private IGestorUsuario usuarioService;

	@Autowired
	private IRepresentanteService representanteService;

	@Autowired
	private IEmpleadoService empleadoService;

	@Autowired
	private EmailSenderService senderService;

	// Variables para mostrar
	private String correoActualizar = "";

	private String materiaActualizar = "";

	// Variables Estudiante y Docente donde capturo el usuario que ingresa

	private Estudiante estudiante = new Estudiante();
	private Estudiante estudianteTemporal=new Estudiante();
	
	private Estudiante estudianteActualiza = new Estudiante();
	private Docente docente = new Docente();
	private Docente docenteTemporal = new Docente();
	private Empleado empleado = new Empleado();
	private Representante representante = new Representante();

	// -----------MENU de LOGGIN

	@GetMapping("inicio")
	public String inicio(Model modelo) {

		estudiante = null;
		docente = null;
		empleado = null;
		representante = null;

		return "inicio";
	}

	// Menus de Opciones

	// Menu Principal

	@PostMapping("inicio/principal")
	public String menuPrincipal(@RequestParam("email") String correo, @RequestParam("password") String contrasenia,
			Model modelo) {

		boolean valor = this.usuarioService.comprobarExistenciaUsuario(correo, contrasenia);

		modelo.addAttribute("valor", valor);

		estudiante = this.estudianteService.buscarEstudiantePorCorreo(correo);

		if (estudiante == null) {
			System.out.println("No se encontro estudiante");
		}

		else {
			System.out.println(estudiante);
		}

		docente = this.docenteService.buscarDocentePorEmail(correo);

		if (docente == null) {
			System.out.println("No se encontro docente");
		} else {
			System.out.println(docente);
		}

		empleado = this.empleadoService.buscarEmpleadoPorEmail(correo);

		if (empleado == null) {
			System.out.println("No se encontro empleado");
		}

		else {
			System.out.println(empleado);
		}

		representante = this.representanteService.buscarRepresentantePorEmail(correo);
		if (representante == null) {
			System.out.println("No se encontro representante");
		}

		else {
			System.out.println(representante);
		}

		modelo.addAttribute("docente", docente);
		modelo.addAttribute("estudiante", estudiante);
		modelo.addAttribute("empleado", empleado);
		modelo.addAttribute("representante", representante);

		System.out.println(estudiante);
		System.out.println(docente);
		System.out.println(representante);
		System.out.println(empleado);

		System.out.println(valor);

		if (valor == true) {
			return "menuPrincipal";
		}

		else {
			return "inicio";
		}

	}

	// Menu de Docentes

	@GetMapping("inicio/docentes")
	public String menuDocentes(Model model) {

		Estudiante estu1 = estudiante;
		Docente docen1 = docente;
		Empleado emple1 = empleado;
		Representante repre1 = representante;
		
		System.out.println(docen1);
		System.out.println(estu1);

		model.addAttribute("estu1", estu1);
		model.addAttribute("docen1", docen1);
		model.addAttribute("emple1", emple1);
		model.addAttribute("repre1", repre1);
		return "menuDocentes";
	}

	// Actualizar Calificacion

	@GetMapping("buscar/estudiante/nota")
	public String actualizarNota(Model modelo) {

		materiaActualizar = docente.getMateria().getNombre();
		return "docenteActualizarNota";
	}

	@GetMapping("mostrar/estudiante/nota")
	public String mostrarNotaEstudiante(@RequestParam("emailestu") String emailEstudiante, Model modelo) {

		Estudiante estudianteRetorna = this.gestorCursoService.buscarEstudiantePorEmail(emailEstudiante);
		estudianteTemporal = estudianteRetorna;

		correoActualizar = estudianteRetorna.getCorreo();

		BigDecimal calificacion = new BigDecimal("0.00");

		if (materiaActualizar.equals("Matematicas")) {
			calificacion = estudianteRetorna.getMatematicas();

		} else if (materiaActualizar.equals("Lenguaje")) {
			calificacion = estudianteRetorna.getLenguaje();
		} else if (materiaActualizar.equals("Sociales")) {
			calificacion = estudianteRetorna.getSociales();
		} else if (materiaActualizar.equals("Ciencias")) {
			calificacion = estudianteRetorna.getCiencias();
		} else if (materiaActualizar.equals("Aleman")) {
			calificacion = estudianteRetorna.getAleman();
		} else {
			System.out.println("No hay resultado");
		}

		modelo.addAttribute("materiaActualizar", materiaActualizar);
		modelo.addAttribute("calificacion", calificacion);

		modelo.addAttribute("estudianteRetorna", estudianteRetorna);
		
		System.out.println(docente);
		return "docenteActualizarNota";
	}

	@PutMapping("actualizar/nota")
	public String actualizacion(@RequestParam("nota") BigDecimal nota, Model modelo) {

		Boolean valor;
		BigDecimal minimo = new BigDecimal("0.00");
		BigDecimal maximo = new BigDecimal("10.00");

		String mensaje = "Valor Invalido. Calificacion debe estar entre 0.00 y 10.00";

		if (nota.compareTo(minimo) >= 0 && nota.compareTo(maximo) <= 0) {
			valor = this.gerstorDocenteService.actualizarRegistrarNota(correoActualizar, materiaActualizar, nota);
			modelo.addAttribute("valor", valor);
			BigDecimal maximo1 = new BigDecimal("6.99");

			if (nota.compareTo(minimo) >= 0 && nota.compareTo(maximo1) <= 0) {
				// Recipient's email ID needs to be mentioned.
				String to = "jlsanchezi@uce.edu.ec";

				// Sender's email ID needs to be mentioned
				String from = "standinsenescence@gmail.com";

				// Assuming you are sending email from through gmails smtp
				String host = "smtp.gmail.com";

				// Get system properties
				Properties properties = System.getProperties();

				// Setup mail server
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "465");
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.auth", "true");

				// Get the Session object.// and pass username and password
				Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication("standinsenescence@gmail.com", "ydypnlmwrggwmshh");

					}

				});

				// Used to debug SMTP issues
				session.setDebug(true);

				try {
					// Create a default MimeMessage object.
					MimeMessage message = new MimeMessage(session);

					// Set From: header field of the header.
					message.setFrom(new InternetAddress(from));

					// Set To: header field of the header.
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

					// Set Subject: header field
					message.setSubject("Bajo rendimiento de su representado");

					// Now set the actual message
					message.setText("Buenos dias. Su representado/a: " + estudianteTemporal.getNombre() + " "
							+ estudianteTemporal.getApellido() + " tiene baja calificacion en la materia " + materiaActualizar
							+ " . Por favor acercase a conversar con el docente: " + docente.getNombre() + " "
							+ docente.getApellido() + " en el horario de: " + docente.getHoraAtencion() + ":00 el dia: "
							+ docente.getDiaAtencion() + ". Saludos");

					System.out.println("sending...");
					// Send message
					Transport.send(message);
					System.out.println("Sent message successfully....");
				} catch (MessagingException mex) {
					mex.printStackTrace();
				}

			}

		} else {
			valor = false;
			modelo.addAttribute("valor", valor);
			modelo.addAttribute("mensaje", mensaje);
		}
		
		

		return "docenteActualizarNota";
	}

	// Actualizar Conducta
	@GetMapping("buscar/estudiante/conducta")
	public String actualizarConducta(Model modelo) {

		materiaActualizar = docente.getMateria().getNombre();
		return "docenteActualizarConducta";
	}

	@GetMapping("mostrar/estudiante/conducta")
	public String mostrarConductaEstudiante(@RequestParam("emailestu") String emailEstudiante, Model modelo) {

		Estudiante estudianteRetorna = this.gestorCursoService.buscarEstudiantePorEmail(emailEstudiante);

		correoActualizar = estudianteRetorna.getCorreo();

		String conducta = "";

		if (materiaActualizar.equals("Matematicas")) {
			conducta = estudianteRetorna.getConductaMatematicas();

		} else if (materiaActualizar.equals("Lenguaje")) {
			conducta = estudianteRetorna.getConductaLenguaje();
		} else if (materiaActualizar.equals("Sociales")) {
			conducta = estudianteRetorna.getConductaSociales();
		} else if (materiaActualizar.equals("Ciencias")) {
			conducta = estudianteRetorna.getConductaCiencias();
		} else if (materiaActualizar.equals("Aleman")) {
			conducta = estudianteRetorna.getConductaAleman();
		} else {
			System.out.println("No hay resultado");
		}

		modelo.addAttribute("materiaActualizar", materiaActualizar);
		modelo.addAttribute("conducta", conducta);

		modelo.addAttribute("estudianteRetorna", estudianteRetorna);
		return "docenteActualizarConducta";
	}

	@PutMapping("actualizar/conducta")
	public String actualizacionConducta(@RequestParam("conducta") String conducta, Model modelo) {

		Boolean valor;
		String mensaje = "Valor Invalido. Conducta se califica con los siguientes valores: A,B,C,D, E";
		if (conducta.toUpperCase().equals("B") || conducta.toUpperCase().equals("A")
				|| conducta.toUpperCase().equals("C") || conducta.toUpperCase().equals("D")
				|| conducta.toUpperCase().equals("E")) {
			valor = this.gerstorDocenteService.actualizarRegistrarConducta(correoActualizar, materiaActualizar,
					conducta.toUpperCase());
			modelo.addAttribute("valor", valor);
		} else {
			valor = false;
			modelo.addAttribute("valor", valor);
			modelo.addAttribute("mensaje", mensaje);
		}

		return "docenteActualizarConducta";
	}

	// Mostar cursos

	@GetMapping("buscar/cursos/docente")
	public String buscarCursosDocente(Model modelo) {
		return "docenteCursos";
	}

	@GetMapping("encontrar/cursos/docente")
	public String obtenerCursosDocente(@RequestParam("curso") String curso, @RequestParam("paralelo") String paralelo,
			Model modelo) {

		List<EstudianteSencillo> listaEstudiantes = this.gestorEstudianteService.consultarCurso(curso, paralelo);

		Promedio promedio = this.gestorEstudianteService.obtenerPromedio(listaEstudiantes);

		modelo.addAttribute("promedio", promedio);
		modelo.addAttribute("estudiantes", listaEstudiantes);

		return "docenteCursos";
	}

	// Menu de Estudiantes

	@GetMapping("inicio/estudiantes")
	public String menuEstudiantes(Model model) {

		Estudiante estu1 = estudiante;
		Docente docen1 = docente;
		Empleado emple1 = empleado;
		Representante repre1 = representante;

		model.addAttribute("estu1", estu1);
		model.addAttribute("docen1", docen1);
		model.addAttribute("emple1", emple1);
		model.addAttribute("repre1", repre1);

		return "menuEstudiantes";
	}

	// Calificacion del Estudiante

	@GetMapping("inicio/estudiante")
	public String estudianteCalificacion(Model modelo) {

		Estudiante estu1 = estudiante;
		System.out.println(estu1.getNombre());

		modelo.addAttribute("estu1", estu1);
		return "estudianteCalificacion";
	}

	// Curso del Estudiante

	@GetMapping("inicio/estudiante/curso")
	public String estudianteCurso(Model modelo) {

		Estudiante estu1 = estudiante;

		Curso curso = estu1.getCurso();

		String nombre = curso.getNombre();
		String paralelo = curso.getParalelo();

		List<EstudianteSencillo> listaEstudiantes = this.gestorEstudianteService.consultarCurso(nombre, paralelo);

		Promedio promedio = this.gestorEstudianteService.obtenerPromedio(listaEstudiantes);

		modelo.addAttribute("promedio", promedio);

		modelo.addAttribute("estudiantes", listaEstudiantes);

		return "estudianteCurso";

	}

	// Menu de Reportes

	@GetMapping("inicio/reportes")
	public String menuReportes(Model model) {

		Estudiante estu1 = estudiante;
		Docente docen1 = docente;
		Empleado emple1 = empleado;
		Representante repre1 = representante;

		model.addAttribute("estu1", estu1);
		model.addAttribute("docen1", docen1);
		model.addAttribute("emple1", emple1);
		model.addAttribute("repre1", repre1);
		return "menuReportes";
	}

	// Buscar Docente

	@GetMapping("buscar/docente")
	public String buscarDocente(Model modelo) {

		return "docenteResultado";
	}

	@GetMapping("encontrar/docente")
	public String buscarDocente(@RequestParam("email") String emailDocente, Model modelo) {

		Docente docenteRetorna = this.gestorCursoService.buscarDocentePorEmail(emailDocente);
		docenteTemporal = docenteRetorna;
		Representante repre1 = representante;

		if (docenteRetorna != null) {
			String hora = docenteRetorna.getHoraAtencion().toString() + ":00";
			modelo.addAttribute("hora", hora);
		}

		modelo.addAttribute("docenteRetorna", docenteRetorna);
		modelo.addAttribute("repre1", repre1);

		return "docenteResultado";
	}

	@PutMapping("cupo/docente")
	public String buscarCupoDocente(Model modelo) {

		String mensaje = "Ya no hay cupos de atencion a padres de familia para el docente:"
				+ docenteTemporal.getNombre() + " " + docenteTemporal.getApellido();
		Boolean valor;
		Integer contador = 0;
		Integer horario = docenteTemporal.getHoraAtencion();
		Integer horario2 = docenteTemporal.getHoraAtencion() + 1;
		String mensaje1 = "Su cupo de atencion fue generado para el dia: " + docenteTemporal.getDiaAtencion()
				+ " a las: " + horario.toString() + ":00";
		String mensaje2 = "Su cupo de atencion fue generado para el dia: " + docenteTemporal.getDiaAtencion()
				+ " a las: " + horario2.toString() + ":00";
		if (docenteTemporal != null) {
			horario = horario + 1;

			if (docenteTemporal.getHorasLibres() == 2) {
				modelo.addAttribute("mensaje1", mensaje1);
			} else {
				modelo.addAttribute("mensaje2", mensaje2);
			}

			docenteTemporal.setHorasLibres(docenteTemporal.getHorasLibres() - 1);

			if (docenteTemporal.getHorasLibres() >= 0) {
				this.docenteService.actualizarDocente(docenteTemporal);

				valor = true;

				modelo.addAttribute("valor", valor);

			} else {
				valor = false;
				modelo.addAttribute("valor", valor);
				modelo.addAttribute("mensaje", mensaje);
			}

		}
		horario = horario + 1;

		return "docenteResultado";
	}

	// Buscar Estudiante

	@GetMapping("buscar/estudiante")
	public String buscarEstudiante(Model modelo) {
		Representante repre1 = representante;

		List<Estudiante> lista = repre1.getEstudiantes();

		Estudiante estudiante1 = lista.get(0);

		System.out.println(estudiante1);

		modelo.addAttribute("estudiante1", estudiante1);
		return "estudianteResultado";
	}

	@GetMapping("encontrar/estudiante")
	public String buscarEstudiante(@RequestParam("emailestu") String emailEstudiante, Model modelo) {

		Representante repre1 = representante;

		List<Estudiante> lista = repre1.getEstudiantes();

		Estudiante estudiante1 = lista.get(0);

		System.out.println(estudiante1);

		modelo.addAttribute("estudiante1", estudiante1);
		return "estudianteResultado";
	}

	// Mostrar Cursos
	@GetMapping("buscar/cursos")
	public String buscarCursos(Model modelo) {
		return "cursosReportes";
	}

	@GetMapping("encontrar/cursos")
	public String obtenerCursos(@RequestParam("curso") String curso, @RequestParam("paralelo") String paralelo,
			Model modelo) {

		List<EstudianteSencillo> listaEstudiantes = this.gestorEstudianteService.consultarCurso(curso, paralelo);

		Promedio promedio = this.gestorEstudianteService.obtenerPromedio(listaEstudiantes);

		modelo.addAttribute("promedio", promedio);

		modelo.addAttribute("estudiantes", listaEstudiantes);

		return "cursosReportes";
	}

	// -------Mensajes----------

	@GetMapping("inicio/datos/olvidados")
	public String cuentaOlvidada(Model model) {

		return "cuentaOlvidada";
	}
	// Recuperacion

	@GetMapping("inicio/recuperacion")
	public String recuperacion(Model model) {

		return "mensajeRecuperacion";
	}

}
