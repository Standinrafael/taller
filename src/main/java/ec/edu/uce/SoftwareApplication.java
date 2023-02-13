package ec.edu.uce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import ec.edu.uce.mail.EmailSenderService;
import ec.edu.uce.modelo.Curso;
import ec.edu.uce.modelo.Docente;
import ec.edu.uce.modelo.Empleado;
import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.modelo.Horario;
import ec.edu.uce.modelo.Materia;
import ec.edu.uce.modelo.Representante;
import ec.edu.uce.modelo.Usuario;
import ec.edu.uce.service.ICursoService;
import ec.edu.uce.service.IDocenteService;
import ec.edu.uce.service.IEmpleadoService;
import ec.edu.uce.service.IEstudianteService;
import ec.edu.uce.service.IGestorDocenteService;
import ec.edu.uce.service.IGestorEstudianteService;
import ec.edu.uce.service.IGestorUsuario;
import ec.edu.uce.service.IHorarioService;
import ec.edu.uce.service.IMateriaService;
import ec.edu.uce.service.IRepresentanteService;
import ec.edu.uce.service.IUsuarioService;



@SpringBootApplication
public class SoftwareApplication implements CommandLineRunner {

	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IHorarioService horarioService;
	
	@Autowired
	private IRepresentanteService representanteService;
	
	@Autowired
	private IDocenteService docenteService;
	
	@Autowired
	private ICursoService cursoService;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private IGestorEstudianteService gestorEstudiante;
	
	@Autowired
	private IGestorDocenteService gestorDocente; 
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IGestorUsuario gestorUsuario;
	
	@Autowired
	private EmailSenderService senderService;
	
	
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(SoftwareApplication.class, args);
	}

	

	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//------------------------------------------Insertar Curso------------------------------------------------------------------------
//		Curso curso1= new Curso();
//		curso1.setNombre("Primero");
//		curso1.setParalelo("A");
//		
//		Curso curso2=new Curso();
//		curso2.setNombre("Primero");
//		curso2.setParalelo("B");
//		
//		Curso curso3= new Curso();
//		curso3.setNombre("Segundo");
//		curso3.setParalelo("A");
//		
//		Curso curso4=new Curso();
//		curso4.setNombre("Segundo");
//		curso4.setParalelo("B");
//		
//		Curso curso5= new Curso();
//		curso5.setNombre("Tercero");
//		curso5.setParalelo("A");
//		
//		Curso curso6=new Curso();
//		curso6.setNombre("Tercero");
//		curso6.setParalelo("B");
//		
//		Curso curso7= new Curso();
//		curso7.setNombre("Cuarto");
//		curso7.setParalelo("A");
//		
//		Curso curso8=new Curso();
//		curso8.setNombre("Cuarto");
//		curso8.setParalelo("B");
//		
//		Curso curso9= new Curso();
//		curso9.setNombre("Quinto");
//		curso9.setParalelo("A");
//		
//		Curso curso10=new Curso();
//		curso10.setNombre("Quinto");
//		curso10.setParalelo("B");
//		
//		Curso curso11= new Curso();
//		curso11.setNombre("Sexto");
//		curso11.setParalelo("A");
//		
//		Curso curso12=new Curso();
//		curso12.setNombre("Sexto");
//		curso12.setParalelo("B");
//		
//		Curso curso13= new Curso();
//		curso13.setNombre("Septimo");
//		curso13.setParalelo("A");
//		
//		Curso curso14=new Curso();
//		curso14.setNombre("Septimo");
//		curso14.setParalelo("B");
//		
//		
//		
//		this.cursoService.insertarCurso(curso1);
//		this.cursoService.insertarCurso(curso2);
//		this.cursoService.insertarCurso(curso3);
//		this.cursoService.insertarCurso(curso4);
//		this.cursoService.insertarCurso(curso5);
//		this.cursoService.insertarCurso(curso6);
//		this.cursoService.insertarCurso(curso7);
//		this.cursoService.insertarCurso(curso8);
//		this.cursoService.insertarCurso(curso9);
//		this.cursoService.insertarCurso(curso10);
//		this.cursoService.insertarCurso(curso11);
//		this.cursoService.insertarCurso(curso12);
//		this.cursoService.insertarCurso(curso13);
//		this.cursoService.insertarCurso(curso14);
//		
//		//-------------------------------------------------------------Insertar Materia------------------------------------------------------
//		
//		Materia materia1= new Materia();
//		materia1.setNombre("Matematicas");
//		
//		Materia materia2=new Materia();
//		materia2.setNombre("Lenguaje");
//		
//		Materia materia3= new Materia();
//		materia3.setNombre("Sociales");
//		
//		Materia materia4=new Materia();
//		materia4.setNombre("Ciencias");
//		
//		Materia materia5= new Materia();
//		materia5.setNombre("Aleman");
//		
//		
//		
//		this.materiaService.insertarMateria(materia1);
//		this.materiaService.insertarMateria(materia2);
//		this.materiaService.insertarMateria(materia3);
//		this.materiaService.insertarMateria(materia4);
//		this.materiaService.insertarMateria(materia5);
//		
//		
//		
//		
//		//------------------------------------------Insertar Estudiantes-------------------------------------------------------------------
//		Estudiante estudiante1= new Estudiante();
//		estudiante1.setNombre("Julissa Stefania");
//		estudiante1.setApellido("Jaramillo Hidalgo");
//		estudiante1.setCorreo("jusjh@gutemberg.edu.ec");
//		estudiante1.setContrasenia("67890");
//		estudiante1.setDireccion("Alameda y Perez Hidalgo");
//		estudiante1.setEdad(5);
//		estudiante1.setNumeroMateria(5);
//		estudiante1.setTelefono("0225633");
//		estudiante1.setMatematicas(new BigDecimal("8.00"));
//		estudiante1.setLenguaje(new BigDecimal("8.00"));
//		estudiante1.setSociales(new BigDecimal("8.00"));
//		estudiante1.setCiencias(new BigDecimal("8.00"));
//		estudiante1.setAleman(new BigDecimal("8.00"));
//		estudiante1.setIsAdministrador(false);
//		estudiante1.setConductaMatematicas("A");
//		estudiante1.setConductaLenguaje("A");
//		estudiante1.setConductaCiencias("A");
//		estudiante1.setConductaSociales("A");
//		estudiante1.setConductaAleman("A");
//		
//		Estudiante estudiante2= new Estudiante();
//		estudiante2.setNombre("Julian Rafael");
//		estudiante2.setApellido("Sanchez Iñiguez");
//		estudiante2.setCorreo("jurai@gutemberg.edu.ec");
//		estudiante2.setContrasenia("67890");
//		estudiante2.setDireccion("Esmeraldas y napo");
//		estudiante2.setEdad(5);
//		estudiante2.setNumeroMateria(5);
//		estudiante2.setTelefono("022555");
//		estudiante2.setMatematicas(new BigDecimal("0.00"));
//		estudiante2.setLenguaje(new BigDecimal("9.00"));
//		estudiante2.setSociales(new BigDecimal("9.00"));
//		estudiante2.setCiencias(new BigDecimal("9.00"));
//		estudiante2.setAleman(new BigDecimal("9.00"));
//		estudiante2.setIsAdministrador(false);
//		estudiante2.setConductaMatematicas("");
//		estudiante2.setConductaLenguaje("");
//		estudiante2.setConductaCiencias("");
//		estudiante2.setConductaSociales("");
//		estudiante2.setConductaAleman("");
//		
//		
//		Estudiante estudiante3= new Estudiante();
//		estudiante3.setNombre("Felipe Alexander");
//		estudiante3.setApellido("Suing Bailon");
//		estudiante3.setCorreo("fesuba@gutemberg.edu.ec");
//		estudiante3.setContrasenia("67890");
//		estudiante3.setDireccion("Alameda y Perez Hidalgo");
//		estudiante3.setEdad(5);
//		estudiante3.setNumeroMateria(5);
//		estudiante3.setTelefono("0225633");
//		estudiante3.setMatematicas(new BigDecimal("10.00"));
//		estudiante3.setLenguaje(new BigDecimal("10.00"));
//		estudiante3.setSociales(new BigDecimal("10.00"));
//		estudiante3.setCiencias(new BigDecimal("10.00"));
//		estudiante3.setAleman(new BigDecimal("10.00"));
//		estudiante3.setIsAdministrador(false);
//		estudiante3.setConductaAleman("C");
//		estudiante3.setConductaCiencias("C");
//		estudiante3.setConductaLenguaje("C");
//		estudiante3.setConductaMatematicas("C");
//		estudiante3.setConductaSociales("C");
//		
//		Estudiante estudiante4= new Estudiante();
//		estudiante4.setNombre("Paulina Yahaira");
//		estudiante4.setApellido("Andrade Sanchez");
//		estudiante4.setCorreo("payan@gutemberg.edu.ec");
//		estudiante4.setContrasenia("67890");
//		estudiante4.setDireccion("Esmeraldas y napo");
//		estudiante4.setEdad(5);
//		estudiante4.setNumeroMateria(5);
//		estudiante4.setTelefono("022555");
//		estudiante4.setMatematicas(new BigDecimal("8.00"));
//		estudiante4.setLenguaje(new BigDecimal("8.00"));
//		estudiante4.setSociales(new BigDecimal("8.00"));
//		estudiante4.setCiencias(new BigDecimal("8.00"));
//		estudiante4.setAleman(new BigDecimal("8.00"));
//		estudiante4.setIsAdministrador(false);
//		estudiante4.setConductaAleman("A");
//		estudiante4.setConductaCiencias("A");
//		estudiante4.setConductaLenguaje("A");
//		estudiante4.setConductaMatematicas("A");
//		estudiante4.setConductaSociales("A");
//		
//		Estudiante estudiante5= new Estudiante();
//		estudiante5.setNombre("Victor Manuel");
//		estudiante5.setApellido("Monroy Abendaño");
//		estudiante5.setCorreo("vimoa@gutemberg.edu.ec");
//		estudiante5.setContrasenia("67890");
//		estudiante5.setDireccion("Alameda y Perez Hidalgo");
//		estudiante5.setEdad(5);
//		estudiante5.setNumeroMateria(5);
//		estudiante5.setTelefono("0225633");
//		estudiante5.setMatematicas(new BigDecimal("0.00"));
//		estudiante5.setLenguaje(new BigDecimal("9.00"));
//		estudiante5.setSociales(new BigDecimal("9.00"));
//		estudiante5.setCiencias(new BigDecimal("9.00"));
//		estudiante5.setAleman(new BigDecimal("9.00"));
//		estudiante5.setIsAdministrador(false);
//		estudiante5.setConductaAleman("B");
//		estudiante5.setConductaCiencias("B");
//		estudiante5.setConductaLenguaje("B");
//		estudiante5.setConductaMatematicas("B");
//		estudiante5.setConductaSociales("B");
//		
//		Estudiante estudiante6= new Estudiante();
//		estudiante6.setNombre("Pedro Pablo");
//		estudiante6.setApellido("Velasco Ibarra");
//		estudiante6.setCorreo("pepai@gutemberg.edu.ec");
//		estudiante6.setContrasenia("67890");
//		estudiante6.setDireccion("Esmeraldas y napo");
//		estudiante6.setEdad(5);
//		estudiante6.setNumeroMateria(5);
//		estudiante6.setTelefono("022555");
//		estudiante6.setMatematicas(new BigDecimal("10.00"));
//		estudiante6.setLenguaje(new BigDecimal("10.00"));
//		estudiante6.setSociales(new BigDecimal("10.00"));
//		estudiante6.setCiencias(new BigDecimal("10.00"));
//		estudiante6.setAleman(new BigDecimal("10.00"));
//		estudiante6.setIsAdministrador(false);
//		estudiante6.setConductaAleman("C");
//		estudiante6.setConductaCiencias("C");
//		estudiante6.setConductaLenguaje("C");
//		estudiante6.setConductaMatematicas("C");
//		estudiante6.setConductaSociales("C");
//		
//		Estudiante estudiante7= new Estudiante();
//		estudiante7.setNombre("William Rigoberto");
//		estudiante7.setApellido("Mayorga Montaño");
//		estudiante7.setCorreo("wimam@gutemberg.edu.ec");
//		estudiante7.setContrasenia("67890");
//		estudiante7.setDireccion("Alameda y Perez Hidalgo");
//		estudiante7.setEdad(6);
//		estudiante7.setNumeroMateria(5);
//		estudiante7.setTelefono("0225633");
//		estudiante7.setMatematicas(new BigDecimal("8.00"));
//		estudiante7.setLenguaje(new BigDecimal("0.00"));
//		estudiante7.setSociales(new BigDecimal("8.00"));
//		estudiante7.setCiencias(new BigDecimal("8.00"));
//		estudiante7.setAleman(new BigDecimal("8.00"));
//		estudiante7.setIsAdministrador(false);
//		estudiante7.setConductaAleman("D");
//		estudiante7.setConductaCiencias("D");
//		estudiante7.setConductaLenguaje("D");
//		estudiante7.setConductaMatematicas("D");
//		estudiante7.setConductaSociales("D");
//		
//		Estudiante estudiante8= new Estudiante();
//		estudiante8.setNombre("Andy Esteban");
//		estudiante8.setApellido("Chiriboga Villacres");
//		estudiante8.setCorreo("achivi@gutemberg.edu.ec");
//		estudiante8.setContrasenia("67890");
//		estudiante8.setDireccion("Esmeraldas y napo");
//		estudiante8.setEdad(6);
//		estudiante8.setNumeroMateria(5);
//		estudiante8.setTelefono("022555");
//		estudiante8.setMatematicas(new BigDecimal("9.00"));
//		estudiante8.setLenguaje(new BigDecimal("9.00"));
//		estudiante8.setSociales(new BigDecimal("9.00"));
//		estudiante8.setCiencias(new BigDecimal("9.00"));
//		estudiante8.setAleman(new BigDecimal("9.00"));
//		estudiante8.setIsAdministrador(false);
//		estudiante8.setConductaAleman("A");
//		estudiante8.setConductaCiencias("A");
//		estudiante8.setConductaLenguaje("A");
//		estudiante8.setConductaMatematicas("A");
//		estudiante8.setConductaSociales("A");
//		
//		Estudiante estudiante9= new Estudiante();
//		estudiante9.setNombre("Richard Ramiro");
//		estudiante9.setApellido("Ramirez Rosales");
//		estudiante9.setCorreo("rirales@gutemberg.edu.ec");
//		estudiante9.setContrasenia("67890");
//		estudiante9.setDireccion("Alameda y Perez Hidalgo");
//		estudiante9.setEdad(6);
//		estudiante9.setNumeroMateria(5);
//		estudiante9.setTelefono("0225633");
//		estudiante9.setMatematicas(new BigDecimal("10.00"));
//		estudiante9.setLenguaje(new BigDecimal("10.00"));
//		estudiante9.setSociales(new BigDecimal("10.00"));
//		estudiante9.setCiencias(new BigDecimal("10.00"));
//		estudiante9.setAleman(new BigDecimal("10.00"));
//		estudiante9.setIsAdministrador(false);
//		estudiante9.setConductaAleman("D");
//		estudiante9.setConductaCiencias("D");
//		estudiante9.setConductaLenguaje("D");
//		estudiante9.setConductaMatematicas("D");
//		estudiante9.setConductaSociales("D");
//		
//		Estudiante estudiante10= new Estudiante();
//		estudiante10.setNombre("Anthony Alexander");
//		estudiante10.setApellido("Calvache Molina");
//		estudiante10.setCorreo("ancamo@gutemberg.edu.ec");
//		estudiante10.setContrasenia("67890");
//		estudiante10.setDireccion("Esmeraldas y napo");
//		estudiante10.setEdad(6);
//		estudiante10.setNumeroMateria(5);
//		estudiante10.setTelefono("022555");
//		estudiante10.setMatematicas(new BigDecimal("8.00"));
//		estudiante10.setLenguaje(new BigDecimal("0.00"));
//		estudiante10.setSociales(new BigDecimal("8.00"));
//		estudiante10.setCiencias(new BigDecimal("8.00"));
//		estudiante10.setAleman(new BigDecimal("8.00"));
//		estudiante10.setIsAdministrador(false);
//		estudiante10.setConductaAleman("A");
//		estudiante10.setConductaCiencias("A");
//		estudiante10.setConductaLenguaje("A");
//		estudiante10.setConductaMatematicas("A");
//		estudiante10.setConductaSociales("A");
//		
//		Estudiante estudiante11= new Estudiante();
//		estudiante11.setNombre("Miriam del Rocio");
//		estudiante11.setApellido("Velazquez Ibarra");
//		estudiante11.setCorreo("mivi@gutemberg.edu.ec");
//		estudiante11.setContrasenia("67890");
//		estudiante11.setDireccion("Alameda y Perez Hidalgo");
//		estudiante11.setEdad(6);
//		estudiante11.setNumeroMateria(5);
//		estudiante11.setTelefono("0225633");
//		estudiante11.setMatematicas(new BigDecimal("9.00"));
//		estudiante11.setLenguaje(new BigDecimal("9.00"));
//		estudiante11.setSociales(new BigDecimal("9.00"));
//		estudiante11.setCiencias(new BigDecimal("9.00"));
//		estudiante11.setAleman(new BigDecimal("9.00"));
//		estudiante11.setIsAdministrador(false);
//		estudiante11.setConductaAleman("B");
//		estudiante11.setConductaCiencias("B");
//		estudiante11.setConductaLenguaje("B");
//		estudiante11.setConductaMatematicas("B");
//		estudiante11.setConductaSociales("B");
//		
//		Estudiante estudiante12= new Estudiante();
//		estudiante12.setNombre("Oscar Manuel");
//		estudiante12.setApellido("Correa Correa");
//		estudiante12.setCorreo("oscor@gutemberg.edu.ec");
//		estudiante12.setContrasenia("67890");
//		estudiante12.setDireccion("Esmeraldas y napo");
//		estudiante12.setEdad(6);
//		estudiante12.setNumeroMateria(5);
//		estudiante12.setTelefono("022555");
//		estudiante12.setMatematicas(new BigDecimal("10.00"));
//		estudiante12.setLenguaje(new BigDecimal("10.00"));
//		estudiante12.setSociales(new BigDecimal("10.00"));
//		estudiante12.setCiencias(new BigDecimal("10.00"));
//		estudiante12.setAleman(new BigDecimal("10.00"));
//		estudiante12.setIsAdministrador(false);
//		estudiante12.setConductaAleman("D");
//		estudiante12.setConductaCiencias("D");
//		estudiante12.setConductaLenguaje("D");
//		estudiante12.setConductaMatematicas("D");
//		estudiante12.setConductaSociales("D");
//		
//		Estudiante estudiante13= new Estudiante();
//		estudiante13.setNombre("Carlos Alexander");
//		estudiante13.setApellido("Diaz Diaz");
//		estudiante13.setCorreo("cadiaz@gutemberg.edu.ec");
//		estudiante13.setContrasenia("67890");
//		estudiante13.setDireccion("Alameda y Perez Hidalgo");
//		estudiante13.setEdad(7);
//		estudiante13.setNumeroMateria(5);
//		estudiante13.setTelefono("0225633");
//		estudiante13.setMatematicas(new BigDecimal("8.00"));
//		estudiante13.setLenguaje(new BigDecimal("8.00"));
//		estudiante13.setSociales(new BigDecimal("8.00"));
//		estudiante13.setCiencias(new BigDecimal("8.00"));
//		estudiante13.setAleman(new BigDecimal("8.00"));
//		estudiante13.setIsAdministrador(false);
//		estudiante13.setConductaAleman("C");
//		estudiante13.setConductaCiencias("C");
//		estudiante13.setConductaLenguaje("C");
//		estudiante13.setConductaMatematicas("C");
//		estudiante13.setConductaSociales("C");
//		
//		Estudiante estudiante14= new Estudiante();
//		estudiante14.setNombre("Luis Leonel");
//		estudiante14.setApellido("Cervantes Ontaneda");
//		estudiante14.setCorreo("luico@gutemberg.edu.ec");
//		estudiante14.setContrasenia("67890");
//		estudiante14.setDireccion("Esmeraldas y napo");
//		estudiante14.setEdad(7);
//		estudiante14.setNumeroMateria(5);
//		estudiante14.setTelefono("022555");
//		estudiante14.setMatematicas(new BigDecimal("9.00"));
//		estudiante14.setLenguaje(new BigDecimal("9.00"));
//		estudiante14.setSociales(new BigDecimal("9.00"));
//		estudiante14.setCiencias(new BigDecimal("9.00"));
//		estudiante14.setAleman(new BigDecimal("9.00"));
//		estudiante14.setIsAdministrador(false);
//		estudiante14.setConductaAleman("E");
//		estudiante14.setConductaCiencias("E");
//		estudiante14.setConductaLenguaje("E");
//		estudiante14.setConductaMatematicas("E");
//		estudiante14.setConductaSociales("E");
//		
//		Estudiante estudiante15= new Estudiante();
//		estudiante15.setNombre("Mayra Elizabeth");
//		estudiante15.setApellido("Hernandez Molina");
//		estudiante15.setCorreo("mayher@gutemberg.edu.ec");
//		estudiante15.setContrasenia("67890");
//		estudiante15.setDireccion("Alameda y Perez Hidalgo");
//		estudiante15.setEdad(7);
//		estudiante15.setNumeroMateria(5);
//		estudiante15.setTelefono("0225633");
//		estudiante15.setMatematicas(new BigDecimal("10.00"));
//		estudiante15.setLenguaje(new BigDecimal("10.00"));
//		estudiante15.setSociales(new BigDecimal("0.00"));
//		estudiante15.setCiencias(new BigDecimal("10.00"));
//		estudiante15.setAleman(new BigDecimal("10.00"));
//		estudiante15.setIsAdministrador(false);
//		estudiante15.setConductaAleman("A");
//		estudiante15.setConductaCiencias("A");
//		estudiante15.setConductaLenguaje("A");
//		estudiante15.setConductaMatematicas("A");
//		estudiante15.setConductaSociales("A");
//		
//		Estudiante estudiante16= new Estudiante();
//		estudiante16.setNombre("Jimy Alexander");
//		estudiante16.setApellido("Carcelen Moraloes");
//		estudiante16.setCorreo("jicama@gutemberg.edu.ec");
//		estudiante16.setContrasenia("67890");
//		estudiante16.setDireccion("Esmeraldas y napo");
//		estudiante16.setEdad(7);
//		estudiante16.setNumeroMateria(5);
//		estudiante16.setTelefono("022555");
//		estudiante16.setMatematicas(new BigDecimal("8.00"));
//		estudiante16.setLenguaje(new BigDecimal("8.00"));
//		estudiante16.setSociales(new BigDecimal("8.00"));
//		estudiante16.setCiencias(new BigDecimal("8.00"));
//		estudiante16.setAleman(new BigDecimal("8.00"));
//		estudiante16.setIsAdministrador(false);
//		estudiante16.setConductaAleman("B");
//		estudiante16.setConductaCiencias("B");
//		estudiante16.setConductaLenguaje("B");
//		estudiante16.setConductaMatematicas("B");
//		estudiante16.setConductaSociales("B");
//		
//		Estudiante estudiante17= new Estudiante();
//		estudiante17.setNombre("Jessica Carolina");
//		estudiante17.setApellido("Quichimbo Pino");
//		estudiante17.setCorreo("jequin@gutemberg.edu.ec");
//		estudiante17.setContrasenia("67890");
//		estudiante17.setDireccion("Alameda y Perez Hidalgo");
//		estudiante17.setEdad(7);
//		estudiante17.setNumeroMateria(5);
//		estudiante17.setTelefono("0225633");
//		estudiante17.setMatematicas(new BigDecimal("9.00"));
//		estudiante17.setLenguaje(new BigDecimal("9.00"));
//		estudiante17.setSociales(new BigDecimal("9.00"));
//		estudiante17.setCiencias(new BigDecimal("9.00"));
//		estudiante17.setAleman(new BigDecimal("9.00"));
//		estudiante17.setIsAdministrador(false);
//		estudiante17.setConductaAleman("C");
//		estudiante17.setConductaCiencias("C");
//		estudiante17.setConductaLenguaje("C");
//		estudiante17.setConductaMatematicas("C");
//		estudiante17.setConductaSociales("C");
//		
//		Estudiante estudiante18= new Estudiante();
//		estudiante18.setNombre("Dennis Alexander");
//		estudiante18.setApellido("Pilco Rosales");
//		estudiante18.setCorreo("depiro@gutemberg.edu.ec");
//		estudiante18.setContrasenia("67890");
//		estudiante18.setDireccion("Esmeraldas y napo");
//		estudiante18.setEdad(7);
//		estudiante18.setNumeroMateria(5);
//		estudiante18.setTelefono("022555");
//		estudiante18.setMatematicas(new BigDecimal("10.00"));
//		estudiante18.setLenguaje(new BigDecimal("10.00"));
//		estudiante18.setSociales(new BigDecimal("0.00"));
//		estudiante18.setCiencias(new BigDecimal("10.00"));
//		estudiante18.setAleman(new BigDecimal("10.00"));
//		estudiante18.setIsAdministrador(false);
//		estudiante18.setConductaAleman("D");
//		estudiante18.setConductaCiencias("D");
//		estudiante18.setConductaLenguaje("D");
//		estudiante18.setConductaMatematicas("D");
//		estudiante18.setConductaSociales("D");
//		
//		Estudiante estudiante19= new Estudiante();
//		estudiante19.setNombre("Juan Pablo");
//		estudiante19.setApellido("Valdivieso Perez");
//		estudiante19.setCorreo("juvupe@gutemberg.edu.ec");
//		estudiante19.setContrasenia("67890");
//		estudiante19.setDireccion("Alameda y Perez Hidalgo");
//		estudiante19.setEdad(8);
//		estudiante19.setNumeroMateria(5);
//		estudiante19.setTelefono("0225633");
//		estudiante19.setMatematicas(new BigDecimal("8.00"));
//		estudiante19.setLenguaje(new BigDecimal("8.00"));
//		estudiante19.setSociales(new BigDecimal("8.00"));
//		estudiante19.setCiencias(new BigDecimal("8.00"));
//		estudiante19.setAleman(new BigDecimal("8.00"));
//		estudiante19.setIsAdministrador(false);
//		estudiante19.setConductaAleman("A");
//		estudiante19.setConductaCiencias("A");
//		estudiante19.setConductaLenguaje("A");
//		estudiante19.setConductaMatematicas("A");
//		estudiante19.setConductaSociales("A");
//		
//		Estudiante estudiante20= new Estudiante();
//		estudiante20.setNombre("Juan Fernando");
//		estudiante20.setApellido("Ramon Carcelen");
//		estudiante20.setCorreo("juralen@gutemberg.edu.ec");
//		estudiante20.setContrasenia("67890");
//		estudiante20.setDireccion("Esmeraldas y napo");
//		estudiante20.setEdad(8);
//		estudiante20.setNumeroMateria(5);
//		estudiante20.setTelefono("022555");
//		estudiante20.setMatematicas(new BigDecimal("9.00"));
//		estudiante20.setLenguaje(new BigDecimal("9.00"));
//		estudiante20.setSociales(new BigDecimal("9.00"));
//		estudiante20.setCiencias(new BigDecimal("0.00"));
//		estudiante20.setAleman(new BigDecimal("9.00"));
//		estudiante20.setIsAdministrador(false);
//		estudiante20.setConductaAleman("A");
//		estudiante20.setConductaCiencias("A");
//		estudiante20.setConductaLenguaje("A");
//		estudiante20.setConductaMatematicas("A");
//		estudiante20.setConductaSociales("A");
//		
//		Estudiante estudiante21= new Estudiante();
//		estudiante21.setNombre("Johan Andres");
//		estudiante21.setApellido("Zea Carpio");
//		estudiante21.setCorreo("jozea@gutemberg.edu.ec");
//		estudiante21.setContrasenia("67890");
//		estudiante21.setDireccion("Alameda y Perez Hidalgo");
//		estudiante21.setEdad(8);
//		estudiante21.setNumeroMateria(5);
//		estudiante21.setTelefono("0225633");
//		estudiante21.setMatematicas(new BigDecimal("10.00"));
//		estudiante21.setLenguaje(new BigDecimal("10.00"));
//		estudiante21.setSociales(new BigDecimal("10.00"));
//		estudiante21.setCiencias(new BigDecimal("10.00"));
//		estudiante21.setAleman(new BigDecimal("10.00"));
//		estudiante21.setIsAdministrador(false);
//		estudiante21.setConductaAleman("");
//		estudiante21.setConductaCiencias("");
//		estudiante21.setConductaLenguaje("");
//		estudiante21.setConductaMatematicas("");
//		estudiante21.setConductaSociales("");
//		
//		Estudiante estudiante22= new Estudiante();
//		estudiante22.setNombre("Cristian David");
//		estudiante22.setApellido("Carrera Lopez");
//		estudiante22.setCorreo("crisloca@gutemberg.edu.ec");
//		estudiante22.setContrasenia("67890");
//		estudiante22.setDireccion("Esmeraldas y napo");
//		estudiante22.setEdad(8);
//		estudiante22.setNumeroMateria(5);
//		estudiante22.setTelefono("022555");
//		estudiante22.setMatematicas(new BigDecimal("8.00"));
//		estudiante22.setLenguaje(new BigDecimal("8.00"));
//		estudiante22.setSociales(new BigDecimal("8.00"));
//		estudiante22.setCiencias(new BigDecimal("8.00"));
//		estudiante22.setAleman(new BigDecimal("8.00"));
//		estudiante22.setIsAdministrador(false);
//		estudiante22.setConductaAleman("");
//		estudiante22.setConductaCiencias("");
//		estudiante22.setConductaLenguaje("");
//		estudiante22.setConductaMatematicas("");
//		estudiante22.setConductaSociales("");
//		
//		Estudiante estudiante23= new Estudiante();
//		estudiante23.setNombre("Luis Maximiliano");
//		estudiante23.setApellido("Montalvo Ortiz");
//		estudiante23.setCorreo("lumono@gutemberg.edu.ec");
//		estudiante23.setContrasenia("67890");
//		estudiante23.setDireccion("Alameda y Perez Hidalgo");
//		estudiante23.setEdad(8);
//		estudiante23.setNumeroMateria(5);
//		estudiante23.setTelefono("0225633");
//		estudiante23.setMatematicas(new BigDecimal("9.00"));
//		estudiante23.setLenguaje(new BigDecimal("9.00"));
//		estudiante23.setSociales(new BigDecimal("9.00"));
//		estudiante23.setCiencias(new BigDecimal("0.00"));
//		estudiante23.setAleman(new BigDecimal("9.00"));
//		estudiante23.setIsAdministrador(false);
//		estudiante23.setConductaAleman("");
//		estudiante23.setConductaCiencias("");
//		estudiante23.setConductaLenguaje("");
//		estudiante23.setConductaMatematicas("");
//		estudiante23.setConductaSociales("");
//		
//		Estudiante estudiante24= new Estudiante();
//		estudiante24.setNombre("Jorge Rafael");
//		estudiante24.setApellido("Villamar Flores");
//		estudiante24.setCorreo("jorvis@gutemberg.edu.ec");
//		estudiante24.setContrasenia("67890");
//		estudiante24.setDireccion("Esmeraldas y napo");
//		estudiante24.setEdad(8);
//		estudiante24.setNumeroMateria(5);
//		estudiante24.setTelefono("022555");
//		estudiante24.setMatematicas(new BigDecimal("10.00"));
//		estudiante24.setLenguaje(new BigDecimal("10.00"));
//		estudiante24.setSociales(new BigDecimal("10.00"));
//		estudiante24.setCiencias(new BigDecimal("10.00"));
//		estudiante24.setAleman(new BigDecimal("10.00"));
//		estudiante24.setIsAdministrador(false);
//		estudiante24.setConductaAleman("");
//		estudiante24.setConductaCiencias("");
//		estudiante24.setConductaLenguaje("");
//		estudiante24.setConductaMatematicas("");
//		estudiante24.setConductaSociales("");
//		
//		Estudiante estudiante25= new Estudiante();
//		estudiante25.setNombre("Luz Maria");
//		estudiante25.setApellido("Borja Abad");
//		estudiante25.setCorreo("luboa@gutemberg.edu.ec");
//		estudiante25.setContrasenia("67890");
//		estudiante25.setDireccion("Alameda y Perez Hidalgo");
//		estudiante25.setEdad(9);
//		estudiante25.setNumeroMateria(5);
//		estudiante25.setTelefono("0225633");
//		estudiante25.setMatematicas(new BigDecimal("8.00"));
//		estudiante25.setLenguaje(new BigDecimal("8.00"));
//		estudiante25.setSociales(new BigDecimal("8.00"));
//		estudiante25.setCiencias(new BigDecimal("8.00"));
//		estudiante25.setAleman(new BigDecimal("0.00"));
//		estudiante25.setIsAdministrador(false);
//		estudiante25.setConductaAleman("");
//		estudiante25.setConductaCiencias("");
//		estudiante25.setConductaLenguaje("");
//		estudiante25.setConductaMatematicas("");
//		estudiante25.setConductaSociales("");
//		
//		Estudiante estudiante26= new Estudiante();
//		estudiante26.setNombre("Helen Cristina");
//		estudiante26.setApellido("Espinoza Fernandez");
//		estudiante26.setCorreo("hefer@gutemberg.edu.ec");
//		estudiante26.setContrasenia("67890");
//		estudiante26.setDireccion("Esmeraldas y napo");
//		estudiante26.setEdad(9);
//		estudiante26.setNumeroMateria(5);
//		estudiante26.setTelefono("022555");
//		estudiante26.setMatematicas(new BigDecimal("9.00"));
//		estudiante26.setLenguaje(new BigDecimal("9.00"));
//		estudiante26.setSociales(new BigDecimal("9.00"));
//		estudiante26.setCiencias(new BigDecimal("9.00"));
//		estudiante26.setAleman(new BigDecimal("9.00"));
//		estudiante26.setIsAdministrador(false);
//		estudiante26.setConductaAleman("");
//		estudiante26.setConductaCiencias("");
//		estudiante26.setConductaLenguaje("");
//		estudiante26.setConductaMatematicas("");
//		estudiante26.setConductaSociales("");
//		
//		Estudiante estudiante27= new Estudiante();
//		estudiante27.setNombre("Mario Fernando");
//		estudiante27.setApellido("Carrillo Chavez");
//		estudiante27.setCorreo("macavez@gutemberg.edu.ec");
//		estudiante27.setContrasenia("67890");
//		estudiante27.setDireccion("Alameda y Perez Hidalgo");
//		estudiante27.setEdad(9);
//		estudiante27.setNumeroMateria(5);
//		estudiante27.setTelefono("0225633");
//		estudiante27.setMatematicas(new BigDecimal("10.00"));
//		estudiante27.setLenguaje(new BigDecimal("10.00"));
//		estudiante27.setSociales(new BigDecimal("10.00"));
//		estudiante27.setCiencias(new BigDecimal("10.00"));
//		estudiante27.setAleman(new BigDecimal("10.00"));
//		estudiante27.setIsAdministrador(false);
//		estudiante27.setConductaAleman("");
//		estudiante27.setConductaCiencias("");
//		estudiante27.setConductaLenguaje("");
//		estudiante27.setConductaMatematicas("");
//		estudiante27.setConductaSociales("");
//		
//		Estudiante estudiante28= new Estudiante();
//		estudiante28.setNombre("Veronica Cristina");
//		estudiante28.setApellido("Tapia Castillo");
//		estudiante28.setCorreo("vetallo@gutemberg.edu.ec");
//		estudiante28.setContrasenia("67890");
//		estudiante28.setDireccion("Esmeraldas y napo");
//		estudiante28.setEdad(9);
//		estudiante28.setNumeroMateria(5);
//		estudiante28.setTelefono("022555");
//		estudiante28.setMatematicas(new BigDecimal("8.00"));
//		estudiante28.setLenguaje(new BigDecimal("8.00"));
//		estudiante28.setSociales(new BigDecimal("8.00"));
//		estudiante28.setCiencias(new BigDecimal("8.00"));
//		estudiante28.setAleman(new BigDecimal("0.00"));
//		estudiante28.setIsAdministrador(false);
//		estudiante28.setConductaAleman("");
//		estudiante28.setConductaCiencias("");
//		estudiante28.setConductaLenguaje("");
//		estudiante28.setConductaMatematicas("");
//		estudiante28.setConductaSociales("");
//		
//		Estudiante estudiante29= new Estudiante();
//		estudiante29.setNombre("Noelia Stefany");
//		estudiante29.setApellido("Veintimilla Rios");
//		estudiante29.setCorreo("noe@gutemberg.edu.ec");
//		estudiante29.setContrasenia("67890");
//		estudiante29.setDireccion("Alameda y Perez Hidalgo");
//		estudiante29.setEdad(9);
//		estudiante29.setNumeroMateria(5);
//		estudiante29.setTelefono("0225633");
//		estudiante29.setMatematicas(new BigDecimal("9.00"));
//		estudiante29.setLenguaje(new BigDecimal("9.00"));
//		estudiante29.setSociales(new BigDecimal("9.00"));
//		estudiante29.setCiencias(new BigDecimal("9.00"));
//		estudiante29.setAleman(new BigDecimal("9.00"));
//		estudiante29.setIsAdministrador(false);
//		estudiante29.setConductaAleman("");
//		estudiante29.setConductaCiencias("");
//		estudiante29.setConductaLenguaje("");
//		estudiante29.setConductaMatematicas("");
//		estudiante29.setConductaSociales("");
//		
//		Estudiante estudiante30= new Estudiante();
//		estudiante30.setNombre("Diego Dario");
//		estudiante30.setApellido("Tapia Palacios");
//		estudiante30.setCorreo("dietapia@gutemberg.edu.ec");
//		estudiante30.setContrasenia("67890");
//		estudiante30.setDireccion("Esmeraldas y napo");
//		estudiante30.setEdad(9);
//		estudiante30.setNumeroMateria(5);
//		estudiante30.setTelefono("022555");
//		estudiante30.setMatematicas(new BigDecimal("10.00"));
//		estudiante30.setLenguaje(new BigDecimal("10.00"));
//		estudiante30.setSociales(new BigDecimal("10.00"));
//		estudiante30.setCiencias(new BigDecimal("10.00"));
//		estudiante30.setAleman(new BigDecimal("10.00"));
//		estudiante30.setIsAdministrador(false);
//		estudiante30.setConductaAleman("");
//		estudiante30.setConductaCiencias("");
//		estudiante30.setConductaLenguaje("");
//		estudiante30.setConductaMatematicas("");
//		estudiante30.setConductaSociales("");
//		
//		Estudiante estudiante31= new Estudiante();
//		estudiante31.setNombre("Stefany Carolina");
//		estudiante31.setApellido("Arciniega Aguilar");
//		estudiante31.setCorreo("scalar@gutemberg.edu.ec");
//		estudiante31.setContrasenia("67890");
//		estudiante31.setDireccion("Alameda y Perez Hidalgo");
//		estudiante31.setEdad(10);
//		estudiante31.setNumeroMateria(5);
//		estudiante31.setTelefono("0225633");
//		estudiante31.setMatematicas(new BigDecimal("8.00"));
//		estudiante31.setLenguaje(new BigDecimal("8.00"));
//		estudiante31.setSociales(new BigDecimal("8.00"));
//		estudiante31.setCiencias(new BigDecimal("8.00"));
//		estudiante31.setAleman(new BigDecimal("8.00"));
//		estudiante31.setIsAdministrador(false);
//		estudiante31.setConductaAleman("");
//		estudiante31.setConductaCiencias("");
//		estudiante31.setConductaLenguaje("");
//		estudiante31.setConductaMatematicas("");
//		estudiante31.setConductaSociales("");
//		
//		Estudiante estudiante32= new Estudiante();
//		estudiante32.setNombre("Valeria Fatima");
//		estudiante32.setApellido("Valladarez Gonzales");
//		estudiante32.setCorreo("vavago@gutemberg.edu.ec");
//		estudiante32.setContrasenia("67890");
//		estudiante32.setDireccion("Esmeraldas y napo");
//		estudiante32.setEdad(10);
//		estudiante32.setNumeroMateria(5);
//		estudiante32.setTelefono("022555");
//		estudiante32.setMatematicas(new BigDecimal("9.00"));
//		estudiante32.setLenguaje(new BigDecimal("9.00"));
//		estudiante32.setSociales(new BigDecimal("9.00"));
//		estudiante32.setCiencias(new BigDecimal("9.00"));
//		estudiante32.setAleman(new BigDecimal("9.00"));
//		estudiante32.setIsAdministrador(false);
//		estudiante32.setConductaAleman("");
//		estudiante32.setConductaCiencias("");
//		estudiante32.setConductaLenguaje("");
//		estudiante32.setConductaMatematicas("");
//		estudiante32.setConductaSociales("");
//		
//		Estudiante estudiante33= new Estudiante();
//		estudiante33.setNombre("Katherine Viviana");
//		estudiante33.setApellido("Maza Maza");
//		estudiante33.setCorreo("kamaza@gutemberg.edu.ec");
//		estudiante33.setContrasenia("67890");
//		estudiante33.setDireccion("Alameda y Perez Hidalgo");
//		estudiante33.setEdad(10);
//		estudiante33.setNumeroMateria(5);
//		estudiante33.setTelefono("0225633");
//		estudiante33.setMatematicas(new BigDecimal("0.00"));
//		estudiante33.setLenguaje(new BigDecimal("10.00"));
//		estudiante33.setSociales(new BigDecimal("10.00"));
//		estudiante33.setCiencias(new BigDecimal("10.00"));
//		estudiante33.setAleman(new BigDecimal("10.00"));
//		estudiante33.setIsAdministrador(false);
//		estudiante33.setConductaAleman("");
//		estudiante33.setConductaCiencias("");
//		estudiante33.setConductaLenguaje("");
//		estudiante33.setConductaMatematicas("");
//		estudiante33.setConductaSociales("");
//		
//		Estudiante estudiante34= new Estudiante();
//		estudiante34.setNombre("Dario Esteban");
//		estudiante34.setApellido("Arevalo Donoso");
//		estudiante34.setCorreo("dadolo@gutemberg.edu.ec");
//		estudiante34.setContrasenia("67890");
//		estudiante34.setDireccion("Esmeraldas y napo");
//		estudiante34.setEdad(10);
//		estudiante34.setNumeroMateria(5);
//		estudiante34.setTelefono("022555");
//		estudiante34.setMatematicas(new BigDecimal("8.00"));
//		estudiante34.setLenguaje(new BigDecimal("8.00"));
//		estudiante34.setSociales(new BigDecimal("8.00"));
//		estudiante34.setCiencias(new BigDecimal("8.00"));
//		estudiante34.setAleman(new BigDecimal("8.00"));
//		estudiante34.setIsAdministrador(false);
//		estudiante34.setConductaAleman("");
//		estudiante34.setConductaCiencias("");
//		estudiante34.setConductaLenguaje("");
//		estudiante34.setConductaMatematicas("");
//		estudiante34.setConductaSociales("");
//		
//		Estudiante estudiante35= new Estudiante();
//		estudiante35.setNombre("Carolina del Rocio");
//		estudiante35.setApellido("Juca Lopez");
//		estudiante35.setCorreo("caroju@gutemberg.edu.ec");
//		estudiante35.setContrasenia("67890");
//		estudiante35.setDireccion("Alameda y Perez Hidalgo");
//		estudiante35.setEdad(10);
//		estudiante35.setNumeroMateria(5);
//		estudiante35.setTelefono("0225633");
//		estudiante35.setMatematicas(new BigDecimal("9.00"));
//		estudiante35.setLenguaje(new BigDecimal("9.00"));
//		estudiante35.setSociales(new BigDecimal("9.00"));
//		estudiante35.setCiencias(new BigDecimal("9.00"));
//		estudiante35.setAleman(new BigDecimal("9.00"));
//		estudiante35.setIsAdministrador(false);
//		estudiante35.setConductaAleman("");
//		estudiante35.setConductaCiencias("");
//		estudiante35.setConductaLenguaje("");
//		estudiante35.setConductaMatematicas("");
//		estudiante35.setConductaSociales("");
//		
//		Estudiante estudiante36= new Estudiante();
//		estudiante36.setNombre("Walter Fernando");
//		estudiante36.setApellido("Cevallos Arias");
//		estudiante36.setCorreo("wacea@gutemberg.edu.ec");
//		estudiante36.setContrasenia("67890");
//		estudiante36.setDireccion("Esmeraldas y napo");
//		estudiante36.setEdad(10);
//		estudiante36.setNumeroMateria(5);
//		estudiante36.setTelefono("022555");
//		estudiante36.setMatematicas(new BigDecimal("10.00"));
//		estudiante36.setLenguaje(new BigDecimal("10.00"));
//		estudiante36.setSociales(new BigDecimal("10.00"));
//		estudiante36.setCiencias(new BigDecimal("10.00"));
//		estudiante36.setAleman(new BigDecimal("0.00"));
//		estudiante36.setIsAdministrador(false);
//		estudiante36.setConductaAleman("");
//		estudiante36.setConductaCiencias("");
//		estudiante36.setConductaLenguaje("");
//		estudiante36.setConductaMatematicas("");
//		estudiante36.setConductaSociales("");
//		
//		Estudiante estudiante37= new Estudiante();
//		estudiante37.setNombre("Jose Alexander");
//		estudiante37.setApellido("Arias Andrade");
//		estudiante37.setCorreo("joara@gutemberg.edu.ec");
//		estudiante37.setContrasenia("67890");
//		estudiante37.setDireccion("Alameda y Perez Hidalgo");
//		estudiante37.setEdad(11);
//		estudiante37.setNumeroMateria(5);
//		estudiante37.setTelefono("0225633");
//		estudiante37.setMatematicas(new BigDecimal("8.00"));
//		estudiante37.setLenguaje(new BigDecimal("8.00"));
//		estudiante37.setSociales(new BigDecimal("8.00"));
//		estudiante37.setCiencias(new BigDecimal("8.00"));
//		estudiante37.setAleman(new BigDecimal("8.00"));
//		estudiante37.setIsAdministrador(false);
//		estudiante37.setConductaAleman("");
//		estudiante37.setConductaCiencias("");
//		estudiante37.setConductaLenguaje("");
//		estudiante37.setConductaMatematicas("");
//		estudiante37.setConductaSociales("");
//		
//		Estudiante estudiante38= new Estudiante();
//		estudiante38.setNombre("Gustavo Rafael");
//		estudiante38.setApellido("Sanchez Iñiguez");
//		estudiante38.setCorreo("gus@gutemberg.edu.ec");
//		estudiante38.setContrasenia("67890");
//		estudiante38.setDireccion("Esmeraldas y napo");
//		estudiante38.setEdad(11);
//		estudiante38.setNumeroMateria(5);
//		estudiante38.setTelefono("022555");
//		estudiante38.setMatematicas(new BigDecimal("9.00"));
//		estudiante38.setLenguaje(new BigDecimal("0.00"));
//		estudiante38.setSociales(new BigDecimal("9.00"));
//		estudiante38.setCiencias(new BigDecimal("9.00"));
//		estudiante38.setAleman(new BigDecimal("9.00"));
//		estudiante38.setIsAdministrador(false);
//		estudiante38.setConductaAleman("");
//		estudiante38.setConductaCiencias("");
//		estudiante38.setConductaLenguaje("");
//		estudiante38.setConductaMatematicas("");
//		estudiante38.setConductaSociales("");
//		
//		Estudiante estudiante39= new Estudiante();
//		estudiante39.setNombre("Maria Eugenia");
//		estudiante39.setApellido("Suing Bailon");
//		estudiante39.setCorreo("mausi@gutemberg.edu.ec");
//		estudiante39.setContrasenia("67890");
//		estudiante39.setDireccion("Alameda y Perez Hidalgo");
//		estudiante39.setEdad(11);
//		estudiante39.setNumeroMateria(5);
//		estudiante39.setTelefono("0225633");
//		estudiante39.setMatematicas(new BigDecimal("10.00"));
//		estudiante39.setLenguaje(new BigDecimal("10.00"));
//		estudiante39.setSociales(new BigDecimal("10.00"));
//		estudiante39.setCiencias(new BigDecimal("10.00"));
//		estudiante39.setAleman(new BigDecimal("10.00"));
//		estudiante39.setIsAdministrador(false);
//		estudiante39.setConductaAleman("");
//		estudiante39.setConductaCiencias("");
//		estudiante39.setConductaLenguaje("");
//		estudiante39.setConductaMatematicas("");
//		estudiante39.setConductaSociales("");
//		
//		Estudiante estudiante40= new Estudiante();
//		estudiante40.setNombre("Milton Alexander");
//		estudiante40.setApellido("Morales Perez");
//		estudiante40.setCorreo("mimopeza@gutemberg.edu.ec");
//		estudiante40.setContrasenia("67890");
//		estudiante40.setDireccion("Esmeraldas y napo");
//		estudiante40.setEdad(11);
//		estudiante40.setNumeroMateria(5);
//		estudiante40.setTelefono("022555");
//		estudiante40.setMatematicas(new BigDecimal("8.00"));
//		estudiante40.setLenguaje(new BigDecimal("8.00"));
//		estudiante40.setSociales(new BigDecimal("8.00"));
//		estudiante40.setCiencias(new BigDecimal("8.00"));
//		estudiante40.setAleman(new BigDecimal("8.00"));
//		estudiante40.setIsAdministrador(false);
//		estudiante40.setConductaAleman("");
//		estudiante40.setConductaCiencias("");
//		estudiante40.setConductaLenguaje("");
//		estudiante40.setConductaMatematicas("");
//		estudiante40.setConductaSociales("");
//		
//		Estudiante estudiante41= new Estudiante();
//		estudiante41.setNombre("Giselle Estefania");
//		estudiante41.setApellido("Guarnizo Ordoñez");
//		estudiante41.setCorreo("giguas@gutemberg.edu.ec");
//		estudiante41.setContrasenia("67890");
//		estudiante41.setDireccion("Alameda y Perez Hidalgo");
//		estudiante41.setEdad(11);
//		estudiante41.setNumeroMateria(5);
//		estudiante41.setTelefono("0225633");
//		estudiante41.setMatematicas(new BigDecimal("9.00"));
//		estudiante41.setLenguaje(new BigDecimal("0.00"));
//		estudiante41.setSociales(new BigDecimal("9.00"));
//		estudiante41.setCiencias(new BigDecimal("9.00"));
//		estudiante41.setAleman(new BigDecimal("9.00"));
//		estudiante41.setIsAdministrador(false);
//		estudiante41.setConductaAleman("");
//		estudiante41.setConductaCiencias("");
//		estudiante41.setConductaLenguaje("");
//		estudiante41.setConductaMatematicas("");
//		estudiante41.setConductaSociales("");
//		
//		Estudiante estudiante42= new Estudiante();
//		estudiante42.setNombre("Melissa Fernanda");
//		estudiante42.setApellido("Cajas Jaramillo");
//		estudiante42.setCorreo("mecaja@gutemberg.edu.ec");
//		estudiante42.setContrasenia("67890");
//		estudiante42.setDireccion("Esmeraldas y napo");
//		estudiante42.setEdad(11);
//		estudiante42.setNumeroMateria(5);
//		estudiante42.setTelefono("022555");
//		estudiante42.setMatematicas(new BigDecimal("10.00"));
//		estudiante42.setLenguaje(new BigDecimal("10.00"));
//		estudiante42.setSociales(new BigDecimal("10.00"));
//		estudiante42.setCiencias(new BigDecimal("10.00"));
//		estudiante42.setAleman(new BigDecimal("10.00"));
//		estudiante42.setIsAdministrador(false);
//		estudiante42.setConductaAleman("");
//		estudiante42.setConductaCiencias("");
//		estudiante42.setConductaLenguaje("");
//		estudiante42.setConductaMatematicas("");
//		estudiante42.setConductaSociales("");
//		
//		
//		
//		this.estudianteService.insertarEstudiante(estudiante1);
//		this.estudianteService.insertarEstudiante(estudiante2);
//		this.estudianteService.insertarEstudiante(estudiante3);
//		this.estudianteService.insertarEstudiante(estudiante4);
//		this.estudianteService.insertarEstudiante(estudiante5);
//		this.estudianteService.insertarEstudiante(estudiante6);
//		this.estudianteService.insertarEstudiante(estudiante7);
//		this.estudianteService.insertarEstudiante(estudiante8);
//		this.estudianteService.insertarEstudiante(estudiante9);
//		this.estudianteService.insertarEstudiante(estudiante10);
//		this.estudianteService.insertarEstudiante(estudiante11);
//		this.estudianteService.insertarEstudiante(estudiante12);
//		this.estudianteService.insertarEstudiante(estudiante13);
//		this.estudianteService.insertarEstudiante(estudiante14);
//		this.estudianteService.insertarEstudiante(estudiante15);
//		this.estudianteService.insertarEstudiante(estudiante16);
//		this.estudianteService.insertarEstudiante(estudiante17);
//		this.estudianteService.insertarEstudiante(estudiante18);
//		this.estudianteService.insertarEstudiante(estudiante19);
//		this.estudianteService.insertarEstudiante(estudiante20);
//		this.estudianteService.insertarEstudiante(estudiante21);
//		this.estudianteService.insertarEstudiante(estudiante22);
//		this.estudianteService.insertarEstudiante(estudiante23);
//		this.estudianteService.insertarEstudiante(estudiante24);
//		this.estudianteService.insertarEstudiante(estudiante25);
//		this.estudianteService.insertarEstudiante(estudiante26);
//		this.estudianteService.insertarEstudiante(estudiante27);
//		this.estudianteService.insertarEstudiante(estudiante28);
//		this.estudianteService.insertarEstudiante(estudiante29);
//		this.estudianteService.insertarEstudiante(estudiante30);
//		this.estudianteService.insertarEstudiante(estudiante31);
//		this.estudianteService.insertarEstudiante(estudiante32);
//		this.estudianteService.insertarEstudiante(estudiante33);
//		this.estudianteService.insertarEstudiante(estudiante34);
//		this.estudianteService.insertarEstudiante(estudiante35);
//		this.estudianteService.insertarEstudiante(estudiante36);
//		this.estudianteService.insertarEstudiante(estudiante37);
//		this.estudianteService.insertarEstudiante(estudiante38);
//		this.estudianteService.insertarEstudiante(estudiante39);
//		this.estudianteService.insertarEstudiante(estudiante40);
//		this.estudianteService.insertarEstudiante(estudiante41);
//		this.estudianteService.insertarEstudiante(estudiante42);
//		
//		
//		
//		//----------------------------------------------Insertar Docente----------------------------------------------------------------------
//		Docente docente1= new Docente ();
//		docente1.setNombre("Blanca Mariana");
//		docente1.setApellido("Perez Idrovo");
//		docente1.setContrasenia("12345");
//		docente1.setCorreo("bmapi@gutemberg.edu.ec");
//		docente1.setDireccion("La Alborada");
//		docente1.setEdad(29);
//		docente1.setNumeroCurso(2);
//		docente1.setTelefono("02626996");
//		docente1.setIsAdministrador(false);
//		docente1.setHorasLibres(2);
//		docente1.setDiaAtencion("Lunes");
//		docente1.setHoraAtencion(11);
//		
//		Docente docente2= new Docente ();
//		docente2.setNombre("Segundo Fernando");
//		docente2.setApellido("Arevalo Lopez");
//		docente2.setContrasenia("12345");
//		docente2.setCorreo("sefal@gutemberg.edu.ec");
//		docente2.setDireccion("La Armenia");
//		docente2.setEdad(35);
//		docente2.setNumeroCurso(2);
//		docente2.setTelefono("02555555");
//		docente2.setIsAdministrador(false);
//		docente2.setHorasLibres(2);
//		docente2.setDiaAtencion("Martes");
//		docente2.setHoraAtencion(10);
//		
//		Docente docente3= new Docente ();
//		docente3.setNombre("Maria Fernanda");
//		docente3.setApellido("Andrade Pazmiño");
//		docente3.setContrasenia("12345");
//		docente3.setCorreo("mafep@gutemberg.edu.ec");
//		docente3.setDireccion("Comite del Pueblo");
//		docente3.setEdad(27);
//		docente3.setNumeroCurso(3);
//		docente3.setTelefono("02555998");
//		docente3.setIsAdministrador(false);
//		docente3.setHorasLibres(2);
//		docente3.setDiaAtencion("Miercoles");
//		docente3.setHoraAtencion(8);
//		
//		Docente docente4= new Docente ();
//		docente4.setNombre("Daniel Alexander");
//		docente4.setApellido("Carrillo Perez");
//		docente4.setContrasenia("12345");
//		docente4.setCorreo("daecp@gutemberg.edu.ec");
//		docente4.setDireccion("Santo Domingo");
//		docente4.setEdad(45);
//		docente4.setNumeroCurso(2);
//		docente4.setTelefono("025478999");
//		docente4.setIsAdministrador(false);
//		docente4.setHorasLibres(2);
//		docente4.setDiaAtencion("Jueves");
//		docente4.setHoraAtencion(8);
//		
//		Docente docente5= new Docente ();
//		docente5.setNombre("Ana Cristina");
//		docente5.setApellido("Sanchez Abad");
//		docente5.setContrasenia("12345");
//		docente5.setCorreo("acsa@gutemberg.edu.ec");
//		docente5.setDireccion("El Zoologico");
//		docente5.setEdad(25);
//		docente5.setNumeroCurso(2);
//		docente5.setTelefono("02888999");
//		docente5.setIsAdministrador(false);
//		docente5.setHorasLibres(2);
//		docente5.setDiaAtencion("Viernes");
//		docente5.setHoraAtencion(12);
//		
//		Docente docente6= new Docente ();
//		docente6.setNombre("Karolain Anahi");
//		docente6.setApellido("Calva Calva");
//		docente6.setContrasenia("12345");
//		docente6.setCorreo("kacal@gutemberg.edu.ec");
//		docente6.setDireccion("Mercado Mayorista");
//		docente6.setEdad(31);
//		docente6.setNumeroCurso(3);
//		docente6.setTelefono("0267896");
//		docente6.setIsAdministrador(false);
//		docente6.setHorasLibres(2);
//		docente6.setDiaAtencion("Lunes");
//		docente6.setHoraAtencion(9);
//		
//		Docente docente7= new Docente ();
//		docente7.setNombre("Pablo Andres");
//		docente7.setApellido("Carrera Carpio");
//		docente7.setContrasenia("12345");
//		docente7.setCorreo("pacc@gutemberg.edu.ec");
//		docente7.setDireccion("18 de Noviembre");
//		docente7.setEdad(37);
//		docente7.setNumeroCurso(2);
//		docente7.setTelefono("0254444");
//		docente7.setIsAdministrador(false);
//		docente7.setHorasLibres(2);
//		docente7.setDiaAtencion("Martes");
//		docente7.setHoraAtencion(10);
//		
//		Docente docente8= new Docente ();
//		docente8.setNombre("Luis Fernando");
//		docente8.setApellido("Quizhpe Espinoza");
//		docente8.setContrasenia("12345");
//		docente8.setCorreo("lufeqe@gutemberg.edu.ec");
//		docente8.setDireccion("Jipiro Alto");
//		docente8.setEdad(36);
//		docente8.setNumeroCurso(2);
//		docente8.setTelefono("0251111");
//		docente8.setIsAdministrador(false);
//		docente8.setHorasLibres(2);
//		docente8.setDiaAtencion("Miercoles");
//		docente8.setHoraAtencion(8);
//		
//		Docente docente9= new Docente ();
//		docente9.setNombre("Stefany Anahi");
//		docente9.setApellido("Patiño Espinoza");
//		docente9.setContrasenia("12345");
//		docente9.setCorreo("stapes@gutemberg.edu.ec");
//		docente9.setDireccion("La Armenia");
//		docente9.setEdad(35);
//		docente9.setNumeroCurso(3);
//		docente9.setTelefono("02555555");
//		docente9.setIsAdministrador(false);
//		docente9.setHorasLibres(2);
//		docente9.setDiaAtencion("Jueves");
//		docente9.setHoraAtencion(11);
//		
//		Docente docente10= new Docente ();
//		docente10.setNombre("Josselyn Anahi");
//		docente10.setApellido("Calva Cueva");
//		docente10.setContrasenia("12345");
//		docente10.setCorreo("josaca@gutemberg.edu.ec");
//		docente10.setDireccion("La Armenia");
//		docente10.setEdad(35);
//		docente10.setNumeroCurso(2);
//		docente10.setTelefono("02555555");
//		docente10.setIsAdministrador(false);
//		docente10.setHorasLibres(2);
//		docente10.setDiaAtencion("Viernes");
//		docente10.setHoraAtencion(12);
//		
//		
//		Docente docente11= new Docente ();
//		docente11.setNombre("Andrea Nataly");
//		docente11.setApellido("Jumbo Jumbo");
//		docente11.setContrasenia("12345");
//		docente11.setCorreo("anjuju@gutemberg.edu.ec");
//		docente11.setDireccion("La Alborada");
//		docente11.setEdad(29);
//		docente11.setNumeroCurso(2);
//		docente11.setTelefono("0266996");
//		docente11.setIsAdministrador(false);
//		docente11.setHorasLibres(2);
//		docente11.setDiaAtencion("Lunes");
//		docente11.setHoraAtencion(10);
//		
//		Docente docente12= new Docente ();
//		docente12.setNombre("Fredy Alexander");
//		docente12.setApellido("Crespo Montaño");
//		docente12.setContrasenia("12345");
//		docente12.setCorreo("felemon@gutemberg.edu.ec");
//		docente12.setDireccion("La Armenia");
//		docente12.setEdad(35);
//		docente12.setNumeroCurso(3);
//		docente12.setTelefono("02555555");
//		docente12.setIsAdministrador(false);
//		docente12.setHorasLibres(2);
//		docente12.setDiaAtencion("Martes");
//		docente12.setHoraAtencion(12);
//		
//		Docente docente13= new Docente ();
//		docente13.setNombre("Luis Roberto");
//		docente13.setApellido("Machado Obando");
//		docente13.setContrasenia("12345");
//		docente13.setCorreo("fido@gutemberg.edu.ec");
//		docente13.setDireccion("La Armenia");
//		docente13.setEdad(35);
//		docente13.setNumeroCurso(2);
//		docente13.setTelefono("02555555");
//		docente13.setIsAdministrador(false);
//		docente13.setHorasLibres(2);
//		docente13.setDiaAtencion("Miercoles");
//		docente13.setHoraAtencion(9);
//		
//		
//		Docente docente14= new Docente ();
//		docente14.setNombre("Leonardo Isaac");
//		docente14.setApellido("Ordoñez Espinoza");
//		docente14.setContrasenia("12345");
//		docente14.setCorreo("isaaco@gutemberg.edu.ec");
//		docente14.setDireccion("La Armenia");
//		docente14.setEdad(35);
//		docente14.setNumeroCurso(2);
//		docente14.setTelefono("02555555");
//		docente14.setIsAdministrador(false);
//		docente14.setHorasLibres(2);
//		docente14.setDiaAtencion("Jueves");
//		docente14.setHoraAtencion(11);
//		
//		Docente docente15= new Docente ();
//		docente15.setNombre("Michelle Anahi");
//		docente15.setApellido("Villacres Vera");
//		docente15.setContrasenia("12345");
//		docente15.setCorreo("mivive@gutemberg.edu.ec");
//		docente15.setDireccion("La Armenia");
//		docente15.setEdad(35);
//		docente15.setNumeroCurso(3);
//		docente15.setTelefono("02555555");
//		docente15.setIsAdministrador(false);
//		docente15.setHorasLibres(2);
//		docente15.setDiaAtencion("Viernes");
//		docente15.setHoraAtencion(10);
//		
//		
//		this.docenteService.insertarDocente(docente1);
//		this.docenteService.insertarDocente(docente2);
//		this.docenteService.insertarDocente(docente3);
//		this.docenteService.insertarDocente(docente4);
//		this.docenteService.insertarDocente(docente5);
//		this.docenteService.insertarDocente(docente6);
//		this.docenteService.insertarDocente(docente7);
//		this.docenteService.insertarDocente(docente8);
//		this.docenteService.insertarDocente(docente9);
//		this.docenteService.insertarDocente(docente10);
//		this.docenteService.insertarDocente(docente11);
//		this.docenteService.insertarDocente(docente12);
//		this.docenteService.insertarDocente(docente13);
//		this.docenteService.insertarDocente(docente14);
//		this.docenteService.insertarDocente(docente15);
//		
//		
//		//--------------------------Insertar Horario-----------------------------------------------------------
//		
//		// Lunes
//		Horario h1=new Horario();
//		h1.setMateria("Matematicas");
//		h1.setDia("Lunes");
//		h1.setHora(8);
//		
//		Horario h2=new Horario();
//		h2.setMateria("Lenguaje");
//		h2.setDia("Lunes");
//		h2.setHora(9);
//		
//		Horario h3=new Horario();
//		h3.setMateria("Sociales");
//		h3.setDia("Lunes");
//		h3.setHora(10);
//		
//		Horario h4=new Horario();
//		h4.setMateria("Ciencias");
//		h4.setDia("Lunes");
//		h4.setHora(12);
//		
//		Horario h5=new Horario();
//		h5.setMateria("Aleman");
//		h5.setDia("Lunes");
//		h5.setHora(13);
//		
//				
//		// Martes
//		
//		Horario h6=new Horario();
//		h6.setMateria("Lenguaje");
//		h6.setDia("Martes");
//		h6.setHora(8);
//		
//		Horario h7=new Horario();
//		h7.setMateria("Sociales");
//		h7.setDia("Martes");
//		h7.setHora(9);
//		
//		Horario h8=new Horario();
//		h8.setMateria("Ciencias");
//		h8.setDia("Martes");
//		h8.setHora(10);
//		
//		Horario h9=new Horario();
//		h9.setMateria("Aleman");
//		h9.setDia("Martes");
//		h9.setHora(12);
//		
//		Horario h10=new Horario();
//		h10.setMateria("Matematicas");
//		h10.setDia("Martes");
//		h10.setHora(13);
//		
//		// Miercoles
//		
//		Horario h11=new Horario();
//		h11.setMateria("Sociales");
//		h11.setDia("Miercoles");
//		h11.setHora(8);
//		
//		Horario h12=new Horario();
//		h12.setMateria("Ciencias");
//		h12.setDia("Miercoles");
//		h12.setHora(9);
//		
//		Horario h13=new Horario();
//		h13.setMateria("Aleman");
//		h13.setDia("Miercoles");
//		h13.setHora(10);
//		
//		Horario h14=new Horario();
//		h14.setMateria("Matematicas");
//		h14.setDia("Miercoles");
//		h14.setHora(12);
//		
//		Horario h15=new Horario();
//		h15.setMateria("Lenguaje");
//		h15.setDia("Miercoles");
//		h15.setHora(13);
//		
//		
//		
//		// Jueves
//		
//		Horario h16=new Horario();
//		h16.setMateria("Ciencias");
//		h16.setDia("Jueves");
//		h16.setHora(8);
//		
//		Horario h17=new Horario();
//		h17.setMateria("Aleman");
//		h17.setDia("Jueves");
//		h17.setHora(9);
//		
//		Horario h18=new Horario();
//		h18.setMateria("Matematicas");
//		h18.setDia("Jueves");
//		h18.setHora(10);
//		
//		Horario h19=new Horario();
//		h19.setMateria("Lenguaje");
//		h19.setDia("Jueves");
//		h19.setHora(12);
//		
//		Horario h20=new Horario();
//		h20.setMateria("Sociales");
//		h20.setDia("Jueves");
//		h20.setHora(13);
//		
//		//Viernes
//		
//		Horario h21=new Horario();
//		h21.setMateria("Aleman");
//		h21.setDia("Viernes");
//		h21.setHora(8);
//		
//		Horario h22=new Horario();
//		h22.setMateria("Matematicas");
//		h22.setDia("Viernes");
//		h22.setHora(9);
//		
//		Horario h23=new Horario();
//		h23.setMateria("Lenguaje");
//		h23.setDia("Viernes");
//		h23.setHora(10);
//		
//		Horario h24=new Horario();
//		h24.setMateria("Sociales");
//		h24.setDia("Viernes");
//		h24.setHora(12);
//		
//		Horario h25=new Horario();
//		h25.setMateria("Ciencias");
//		h25.setDia("Viernes");
//		h25.setHora(13);
//		
//		this.horarioService.insertarHorario(h1);
//		this.horarioService.insertarHorario(h2);
//		this.horarioService.insertarHorario(h3);
//		this.horarioService.insertarHorario(h4);
//		this.horarioService.insertarHorario(h5);
//		this.horarioService.insertarHorario(h6);
//		this.horarioService.insertarHorario(h7);
//		this.horarioService.insertarHorario(h8);
//		this.horarioService.insertarHorario(h9);
//		this.horarioService.insertarHorario(h10);
//		this.horarioService.insertarHorario(h11);
//		this.horarioService.insertarHorario(h12);
//		this.horarioService.insertarHorario(h13);
//		this.horarioService.insertarHorario(h14);
//		this.horarioService.insertarHorario(h15);
//		this.horarioService.insertarHorario(h16);
//		this.horarioService.insertarHorario(h17);
//		this.horarioService.insertarHorario(h18);
//		this.horarioService.insertarHorario(h19);
//		this.horarioService.insertarHorario(h20);
//		this.horarioService.insertarHorario(h21);
//		this.horarioService.insertarHorario(h22);
//		this.horarioService.insertarHorario(h23);
//		this.horarioService.insertarHorario(h24);
//		this.horarioService.insertarHorario(h25);
//		
//		
//		//------------------------Insertar Representante-------------------------------------------------------
//		
//		Representante repre1= new Representante();
//		repre1.setNombre("Jorge Luis");
//		repre1.setApellido("Sanchez Iniguez");
//		repre1.setCorreo("jlsanchezi@uce.edu.ec");
//		repre1.setContrasenia("11111");
//		repre1.setIsAdministrador(false);
//		
//		Representante repre2= new Representante();
//		repre2.setNombre("Cristhian Daniel");
//		repre2.setApellido("Cedeno Santos");
//		repre2.setCorreo("cdcedenos@uce.edu.ec");
//		repre2.setContrasenia("11111");
//		repre2.setIsAdministrador(false);
//		
//		
//		this.representanteService.insertarRepresentante(repre1);
//		this.representanteService.insertarRepresentante(repre2);
//		
//		
//		
//		
//		// ----------------------Insertar Empleado--------------------------------------------------------------
//		
//		Empleado empleado1= new Empleado();
//		empleado1.setNombre("Nicolas Alexander");
//		empleado1.setApellido("Carrera Chavez");
//		empleado1.setCargo("Administrador");
//		empleado1.setCorreo("nacarrera@uce.edu.ec");
//		empleado1.setContrasenia("11111");
//		empleado1.setIsAdministrador(true);
//		
//		this.empleadoService.insertarEmpleado(empleado1);
//		
//		
//		
//		
//		//----------------------------------Unir docente con materia---------------------------------------------------------------------
//		
//		List<Docente> listaDocentes1= new ArrayList<>();
//		List<Docente> listaDocentes2= new ArrayList<>();
//		List<Docente> listaDocentes3= new ArrayList<>();
//		List<Docente> listaDocentes4= new ArrayList<>();
//		List<Docente> listaDocentes5= new ArrayList<>();
//		
//		
//		Materia materiab1= this.materiaService.buscarMateriaPorId(1);
//		Materia materiab2= this.materiaService.buscarMateriaPorId(2);
//		Materia materiab3= this.materiaService.buscarMateriaPorId(3);
//		Materia materiab4= this.materiaService.buscarMateriaPorId(4);
//		Materia materiab5= this.materiaService.buscarMateriaPorId(5);
//		
//				
//				
//		Docente docenteb1=this.docenteService.buscarDocentePorId(1);
//		docenteb1.setMateria(materiab1);
//		Docente docenteb2=this.docenteService.buscarDocentePorId(2);
//		docenteb2.setMateria(materiab1);
//		Docente docenteb3=this.docenteService.buscarDocentePorId(3);
//		docenteb3.setMateria(materiab1);
//		Docente docenteb4=this.docenteService.buscarDocentePorId(4);
//		docenteb4.setMateria(materiab2);
//		Docente docenteb5=this.docenteService.buscarDocentePorId(5);
//		docenteb5.setMateria(materiab2);
//		Docente docenteb6=this.docenteService.buscarDocentePorId(6);
//		docenteb6.setMateria(materiab2);
//		Docente docenteb7=this.docenteService.buscarDocentePorId(7);
//		docenteb7.setMateria(materiab3);
//		Docente docenteb8=this.docenteService.buscarDocentePorId(8);
//		docenteb8.setMateria(materiab3);
//		Docente docenteb9=this.docenteService.buscarDocentePorId(9);
//		docenteb9.setMateria(materiab3);
//		Docente docenteb10=this.docenteService.buscarDocentePorId(10);
//		docenteb10.setMateria(materiab4);
//		Docente docenteb11=this.docenteService.buscarDocentePorId(11);
//		docenteb11.setMateria(materiab4);
//		Docente docenteb12=this.docenteService.buscarDocentePorId(12);
//		docenteb12.setMateria(materiab4);
//		Docente docenteb13=this.docenteService.buscarDocentePorId(13);
//		docenteb13.setMateria(materiab5);
//		Docente docenteb14=this.docenteService.buscarDocentePorId(14);
//		docenteb14.setMateria(materiab5);
//		Docente docenteb15=this.docenteService.buscarDocentePorId(15);
//		docenteb15.setMateria(materiab5);
//		
//				
//		listaDocentes1.add(docenteb1);
//		listaDocentes1.add(docenteb2);		
//		listaDocentes1.add(docenteb3);
//		
//		listaDocentes2.add(docenteb4);
//		listaDocentes2.add(docenteb5);
//		listaDocentes2.add(docenteb6);
//		
//		listaDocentes3.add(docenteb7);
//		listaDocentes3.add(docenteb8);
//		listaDocentes3.add(docenteb9);
//		
//		listaDocentes4.add(docenteb10);
//		listaDocentes4.add(docenteb11);
//		listaDocentes4.add(docenteb12);
//		
//		listaDocentes5.add(docenteb13);
//		listaDocentes5.add(docenteb14);
//		listaDocentes5.add(docenteb15);
//		
//		
//		materiab1.setDocentes(listaDocentes1);
//		materiab2.setDocentes(listaDocentes2);
//		materiab3.setDocentes(listaDocentes3);
//		materiab4.setDocentes(listaDocentes4);
//		materiab5.setDocentes(listaDocentes5);
//		
//		this.materiaService.actualizarMateria(materiab1);
//		this.materiaService.actualizarMateria(materiab2);
//		this.materiaService.actualizarMateria(materiab3);
//		this.materiaService.actualizarMateria(materiab4);
//		this.materiaService.actualizarMateria(materiab5);
//		
//		this.docenteService.actualizarDocente(docenteb1);
//		this.docenteService.actualizarDocente(docenteb2);
//		this.docenteService.actualizarDocente(docenteb3);
//		this.docenteService.actualizarDocente(docenteb4);
//		this.docenteService.actualizarDocente(docenteb5);
//		this.docenteService.actualizarDocente(docenteb6);
//		this.docenteService.actualizarDocente(docenteb7);
//		this.docenteService.actualizarDocente(docenteb8);
//		this.docenteService.actualizarDocente(docenteb9);
//		this.docenteService.actualizarDocente(docenteb10);
//		this.docenteService.actualizarDocente(docenteb11);
//		this.docenteService.actualizarDocente(docenteb12);
//		this.docenteService.actualizarDocente(docenteb13);
//		this.docenteService.actualizarDocente(docenteb14);
//		this.docenteService.actualizarDocente(docenteb15);
//		
//		
//
//		//-------------------------------- Unir estudiante con curso-------------------------------------------------------------------
//		
//		
//		
//		List<Estudiante> lista1= new ArrayList<>();
//		List<Estudiante> lista2= new ArrayList<>();
//		List<Estudiante> lista3= new ArrayList<>();
//		List<Estudiante> lista4= new ArrayList<>();
//		List<Estudiante> lista5= new ArrayList<>();
//		List<Estudiante> lista6= new ArrayList<>();
//		List<Estudiante> lista7= new ArrayList<>();
//		List<Estudiante> lista8= new ArrayList<>();
//		List<Estudiante> lista9= new ArrayList<>();
//		List<Estudiante> lista10= new ArrayList<>();
//		List<Estudiante> lista11= new ArrayList<>();
//		List<Estudiante> lista12= new ArrayList<>();
//		List<Estudiante> lista13= new ArrayList<>();
//		List<Estudiante> lista14= new ArrayList<>();
//		
//		
//		Curso cursob1= this.cursoService.buscarCursoPorId(1);
//		Curso cursob2= this.cursoService.buscarCursoPorId(2);
//		Curso cursob3= this.cursoService.buscarCursoPorId(3);
//		Curso cursob4= this.cursoService.buscarCursoPorId(4);
//		Curso cursob5= this.cursoService.buscarCursoPorId(5);
//		Curso cursob6= this.cursoService.buscarCursoPorId(6);
//		Curso cursob7= this.cursoService.buscarCursoPorId(7);
//		Curso cursob8= this.cursoService.buscarCursoPorId(8);
//		Curso cursob9= this.cursoService.buscarCursoPorId(9);
//		Curso cursob10= this.cursoService.buscarCursoPorId(10);
//		Curso cursob11= this.cursoService.buscarCursoPorId(11);
//		Curso cursob12= this.cursoService.buscarCursoPorId(12);
//		Curso cursob13= this.cursoService.buscarCursoPorId(13);
//		Curso cursob14= this.cursoService.buscarCursoPorId(14);
//		
//					
//				
//		Estudiante estudianteb1= this.estudianteService.buscarEstudiantePorId(1);
//		estudianteb1.setCurso(cursob1);
//		
//		Estudiante estudianteb2= this.estudianteService.buscarEstudiantePorId(2);
//		estudianteb2.setCurso(cursob1);
//		
//		Estudiante estudianteb3= this.estudianteService.buscarEstudiantePorId(3);
//		estudianteb3.setCurso(cursob1);
//		
//
//		Estudiante estudianteb4= this.estudianteService.buscarEstudiantePorId(4);
//		estudianteb4.setCurso(cursob2);
//		
//		Estudiante estudianteb5= this.estudianteService.buscarEstudiantePorId(5);
//		estudianteb5.setCurso(cursob2);
//		
//		Estudiante estudianteb6= this.estudianteService.buscarEstudiantePorId(6);
//		estudianteb6.setCurso(cursob2);
//		
//
//		Estudiante estudianteb7= this.estudianteService.buscarEstudiantePorId(7);
//		estudianteb7.setCurso(cursob3);
//		
//		Estudiante estudianteb8= this.estudianteService.buscarEstudiantePorId(8);
//		estudianteb8.setCurso(cursob3);
//		
//		Estudiante estudianteb9= this.estudianteService.buscarEstudiantePorId(9);
//		estudianteb9.setCurso(cursob3);
//		
//
//		Estudiante estudianteb10= this.estudianteService.buscarEstudiantePorId(10);
//		estudianteb10.setCurso(cursob4);
//		
//		Estudiante estudianteb11= this.estudianteService.buscarEstudiantePorId(11);
//		estudianteb11.setCurso(cursob4);
//		
//		Estudiante estudianteb12= this.estudianteService.buscarEstudiantePorId(12);
//		estudianteb12.setCurso(cursob4);
//		
//
//		Estudiante estudianteb13= this.estudianteService.buscarEstudiantePorId(13);
//		estudianteb13.setCurso(cursob5);
//		
//		Estudiante estudianteb14= this.estudianteService.buscarEstudiantePorId(14);
//		estudianteb14.setCurso(cursob5);
//		
//		Estudiante estudianteb15= this.estudianteService.buscarEstudiantePorId(15);
//		estudianteb15.setCurso(cursob5);
//		
//
//		Estudiante estudianteb16= this.estudianteService.buscarEstudiantePorId(16);
//		estudianteb16.setCurso(cursob6);
//		
//		Estudiante estudianteb17= this.estudianteService.buscarEstudiantePorId(17);
//		estudianteb17.setCurso(cursob6);
//		
//		Estudiante estudianteb18= this.estudianteService.buscarEstudiantePorId(18);
//		estudianteb18.setCurso(cursob6);
//		
//
//		Estudiante estudianteb19= this.estudianteService.buscarEstudiantePorId(19);
//		estudianteb19.setCurso(cursob7);
//		
//		Estudiante estudianteb20= this.estudianteService.buscarEstudiantePorId(20);
//		estudianteb20.setCurso(cursob7);
//		
//		Estudiante estudianteb21= this.estudianteService.buscarEstudiantePorId(21);
//		estudianteb21.setCurso(cursob7);
//		
//
//		Estudiante estudianteb22= this.estudianteService.buscarEstudiantePorId(22);
//		estudianteb22.setCurso(cursob8);
//		
//		Estudiante estudianteb23= this.estudianteService.buscarEstudiantePorId(23);
//		estudianteb23.setCurso(cursob8);
//		
//		Estudiante estudianteb24= this.estudianteService.buscarEstudiantePorId(24);
//		estudianteb24.setCurso(cursob8);
//		
//
//		Estudiante estudianteb25= this.estudianteService.buscarEstudiantePorId(25);
//		estudianteb25.setCurso(cursob9);
//		
//		Estudiante estudianteb26= this.estudianteService.buscarEstudiantePorId(26);
//		estudianteb26.setCurso(cursob9);
//		
//		Estudiante estudianteb27= this.estudianteService.buscarEstudiantePorId(27);
//		estudianteb27.setCurso(cursob9);
//		
//
//		Estudiante estudianteb28= this.estudianteService.buscarEstudiantePorId(28);
//		estudianteb28.setCurso(cursob10);
//		
//		Estudiante estudianteb29= this.estudianteService.buscarEstudiantePorId(29);
//		estudianteb29.setCurso(cursob10);
//		
//		Estudiante estudianteb30= this.estudianteService.buscarEstudiantePorId(30);
//		estudianteb30.setCurso(cursob10);
//		
//
//		Estudiante estudianteb31= this.estudianteService.buscarEstudiantePorId(31);
//		estudianteb31.setCurso(cursob11);
//		
//		Estudiante estudianteb32= this.estudianteService.buscarEstudiantePorId(32);
//		estudianteb32.setCurso(cursob11);
//		
//		Estudiante estudianteb33= this.estudianteService.buscarEstudiantePorId(33);
//		estudianteb33.setCurso(cursob11);
//		
//
//		Estudiante estudianteb34= this.estudianteService.buscarEstudiantePorId(34);
//		estudianteb34.setCurso(cursob12);
//		
//		Estudiante estudianteb35= this.estudianteService.buscarEstudiantePorId(35);
//		estudianteb35.setCurso(cursob12);
//		
//		Estudiante estudianteb36= this.estudianteService.buscarEstudiantePorId(36);
//		estudianteb36.setCurso(cursob12);
//		
//
//		Estudiante estudianteb37= this.estudianteService.buscarEstudiantePorId(37);
//		estudianteb37.setCurso(cursob13);
//		
//		Estudiante estudianteb38= this.estudianteService.buscarEstudiantePorId(38);
//		estudianteb38.setCurso(cursob13);
//		
//		Estudiante estudianteb39= this.estudianteService.buscarEstudiantePorId(39);
//		estudianteb39.setCurso(cursob13);
//		
//
//		Estudiante estudianteb40= this.estudianteService.buscarEstudiantePorId(40);
//		estudianteb40.setCurso(cursob14);
//		
//		Estudiante estudianteb41= this.estudianteService.buscarEstudiantePorId(41);
//		estudianteb41.setCurso(cursob14);
//		
//		Estudiante estudianteb42= this.estudianteService.buscarEstudiantePorId(42);
//		estudianteb42.setCurso(cursob14);
//	
//		
//		lista1.add(estudianteb1);
//		lista1.add(estudianteb2);
//		lista1.add(estudianteb3);
//		
//		
//		lista2.add(estudianteb4);
//		lista2.add(estudianteb5);
//		lista2.add(estudianteb6);
//		
//		lista3.add(estudianteb7);
//		lista3.add(estudianteb8);
//		lista3.add(estudianteb9);
//		
//		lista4.add(estudianteb10);
//		lista4.add(estudianteb11);
//		lista4.add(estudianteb12);
//		
//		lista5.add(estudianteb13);
//		lista5.add(estudianteb14);
//		lista5.add(estudianteb15);
//		
//		lista6.add(estudianteb16);
//		lista6.add(estudianteb17);
//		lista6.add(estudianteb18);
//		
//		lista7.add(estudianteb19);
//		lista7.add(estudianteb20);
//		lista7.add(estudianteb21);
//		
//		lista8.add(estudianteb22);
//		lista8.add(estudianteb23);
//		lista8.add(estudianteb24);
//		
//		lista9.add(estudianteb25);
//		lista9.add(estudianteb26);
//		lista9.add(estudianteb27);
//		
//		lista10.add(estudianteb28);
//		lista10.add(estudianteb29);
//		lista10.add(estudianteb30);
//		
//		lista11.add(estudianteb31);
//		lista11.add(estudianteb32);
//		lista11.add(estudianteb33);
//		
//		lista12.add(estudianteb34);
//		lista12.add(estudianteb35);
//		lista12.add(estudianteb36);
//		
//		lista13.add(estudianteb33);
//		lista13.add(estudianteb38);
//		lista13.add(estudianteb39);
//		
//		lista14.add(estudianteb40);
//		lista14.add(estudianteb41);
//		lista14.add(estudianteb42);
//		
//		cursob1.setEstudiantes(lista1);
//		cursob2.setEstudiantes(lista2);
//		cursob3.setEstudiantes(lista3);
//		cursob4.setEstudiantes(lista4);
//		cursob5.setEstudiantes(lista5);
//		cursob6.setEstudiantes(lista6);
//		cursob7.setEstudiantes(lista7);
//		cursob8.setEstudiantes(lista8);
//		cursob9.setEstudiantes(lista9);
//		cursob10.setEstudiantes(lista10);
//		cursob11.setEstudiantes(lista11);
//		cursob12.setEstudiantes(lista12);
//		cursob13.setEstudiantes(lista13);
//		cursob14.setEstudiantes(lista14);
//		
//		this.cursoService.actualizarCurso(cursob1);
//		this.cursoService.actualizarCurso(cursob2);
//		this.cursoService.actualizarCurso(cursob3);
//		this.cursoService.actualizarCurso(cursob4);
//		this.cursoService.actualizarCurso(cursob5);
//		this.cursoService.actualizarCurso(cursob6);
//		this.cursoService.actualizarCurso(cursob7);
//		this.cursoService.actualizarCurso(cursob8);
//		this.cursoService.actualizarCurso(cursob9);
//		this.cursoService.actualizarCurso(cursob10);
//		this.cursoService.actualizarCurso(cursob11);
//		this.cursoService.actualizarCurso(cursob12);
//		this.cursoService.actualizarCurso(cursob13);
//		this.cursoService.actualizarCurso(cursob14);
//		
//		this.estudianteService.actualizarEstudiante(estudianteb1);
//		this.estudianteService.actualizarEstudiante(estudianteb2);
//		this.estudianteService.actualizarEstudiante(estudianteb3);
//		this.estudianteService.actualizarEstudiante(estudianteb4);
//		this.estudianteService.actualizarEstudiante(estudianteb5);
//		this.estudianteService.actualizarEstudiante(estudianteb6);
//		this.estudianteService.actualizarEstudiante(estudianteb7);
//		this.estudianteService.actualizarEstudiante(estudianteb8);
//		this.estudianteService.actualizarEstudiante(estudianteb9);
//		this.estudianteService.actualizarEstudiante(estudianteb10);
//		this.estudianteService.actualizarEstudiante(estudianteb11);
//		this.estudianteService.actualizarEstudiante(estudianteb12);
//		this.estudianteService.actualizarEstudiante(estudianteb13);
//		this.estudianteService.actualizarEstudiante(estudianteb14);
//		this.estudianteService.actualizarEstudiante(estudianteb15);
//		this.estudianteService.actualizarEstudiante(estudianteb16);
//		this.estudianteService.actualizarEstudiante(estudianteb17);
//		this.estudianteService.actualizarEstudiante(estudianteb18);
//		this.estudianteService.actualizarEstudiante(estudianteb19);
//		this.estudianteService.actualizarEstudiante(estudianteb20);
//		this.estudianteService.actualizarEstudiante(estudianteb21);
//		this.estudianteService.actualizarEstudiante(estudianteb22);
//		this.estudianteService.actualizarEstudiante(estudianteb23);
//		this.estudianteService.actualizarEstudiante(estudianteb24);
//		this.estudianteService.actualizarEstudiante(estudianteb25);
//		this.estudianteService.actualizarEstudiante(estudianteb26);
//		this.estudianteService.actualizarEstudiante(estudianteb27);
//		this.estudianteService.actualizarEstudiante(estudianteb28);
//		this.estudianteService.actualizarEstudiante(estudianteb29);
//		this.estudianteService.actualizarEstudiante(estudianteb30);
//		this.estudianteService.actualizarEstudiante(estudianteb31);
//		this.estudianteService.actualizarEstudiante(estudianteb32);
//		this.estudianteService.actualizarEstudiante(estudianteb33);
//		this.estudianteService.actualizarEstudiante(estudianteb34);
//		this.estudianteService.actualizarEstudiante(estudianteb35);
//		this.estudianteService.actualizarEstudiante(estudianteb36);
//		this.estudianteService.actualizarEstudiante(estudianteb37);
//		this.estudianteService.actualizarEstudiante(estudianteb38);
//		this.estudianteService.actualizarEstudiante(estudianteb39);
//		this.estudianteService.actualizarEstudiante(estudianteb40);
//		this.estudianteService.actualizarEstudiante(estudianteb41);
//		this.estudianteService.actualizarEstudiante(estudianteb42);
//		
//		
//		// --------------------------------------Unir docente curso--------------------------------------------------------------
//		
//		List<Curso> listaCurso1= new ArrayList<>();		
//		List<Curso> listaCurso2= new ArrayList<>();
//		List<Curso> listaCurso3= new ArrayList<>();
//		
//		
//		List<Docente> listaDocente12= new ArrayList<>();		
//		List<Docente> listaDocente34= new ArrayList<>();
//		List<Docente> listaDocente567= new ArrayList<>();
//		
//		
//		Curso cursobb1= this.cursoService.buscarCursoPorId(1);
//		Curso cursobb2= this.cursoService.buscarCursoPorId(2);
//		Curso cursobb3= this.cursoService.buscarCursoPorId(3);
//		Curso cursobb4= this.cursoService.buscarCursoPorId(4);
//		Curso cursobb5= this.cursoService.buscarCursoPorId(5);
//		Curso cursobb6= this.cursoService.buscarCursoPorId(6);
//		Curso cursobb7= this.cursoService.buscarCursoPorId(7);
//		Curso cursobb8= this.cursoService.buscarCursoPorId(8);
//		Curso cursobb9= this.cursoService.buscarCursoPorId(9);
//		Curso cursobb10= this.cursoService.buscarCursoPorId(10);
//		Curso cursobb11= this.cursoService.buscarCursoPorId(11);
//		Curso cursobb12= this.cursoService.buscarCursoPorId(12);
//		Curso cursobb13= this.cursoService.buscarCursoPorId(13);
//		Curso cursobb14= this.cursoService.buscarCursoPorId(14);
//		
//		Docente docentebb1=this.docenteService.buscarDocentePorId(1);
//		Docente docentebb2=this.docenteService.buscarDocentePorId(2);
//		Docente docentebb3=this.docenteService.buscarDocentePorId(3);
//		Docente docentebb4=this.docenteService.buscarDocentePorId(4);
//		Docente docentebb5=this.docenteService.buscarDocentePorId(5);
//		Docente docentebb6=this.docenteService.buscarDocentePorId(6);
//		Docente docentebb7=this.docenteService.buscarDocentePorId(7);
//		Docente docentebb8=this.docenteService.buscarDocentePorId(8);
//		Docente docentebb9=this.docenteService.buscarDocentePorId(9);
//		Docente docentebb10=this.docenteService.buscarDocentePorId(10);
//		Docente docentebb11=this.docenteService.buscarDocentePorId(11);
//		Docente docentebb12=this.docenteService.buscarDocentePorId(12);
//		Docente docentebb13=this.docenteService.buscarDocentePorId(13);
//		Docente docentebb14=this.docenteService.buscarDocentePorId(14);
//		Docente docentebb15=this.docenteService.buscarDocentePorId(15);
//
//		
//		listaDocente12.add(docentebb1);
//		listaDocente12.add(docentebb4);
//		listaDocente12.add(docentebb7);
//		listaDocente12.add(docentebb10);
//		listaDocente12.add(docentebb13);
//		
//		listaDocente34.add(docentebb2);
//		listaDocente34.add(docentebb5);
//		listaDocente34.add(docentebb8);
//		listaDocente34.add(docentebb11);
//		listaDocente34.add(docentebb14);
//		
//		listaDocente567.add(docentebb3);
//		listaDocente567.add(docentebb6);
//		listaDocente567.add(docentebb9);
//		listaDocente567.add(docentebb12);
//		listaDocente567.add(docentebb15);
//		
//	
//		listaCurso1.add(cursobb1);
//		listaCurso1.add(cursobb2);
//		listaCurso1.add(cursobb3);
//		listaCurso1.add(cursobb4);
//		
//		listaCurso2.add(cursobb5);
//		listaCurso2.add(cursobb6);
//		listaCurso2.add(cursobb7);
//		listaCurso2.add(cursobb8);
//		
//		listaCurso3.add(cursobb9);
//		listaCurso3.add(cursobb10);
//		listaCurso3.add(cursobb11);
//		listaCurso3.add(cursobb12);
//		listaCurso3.add(cursobb13);
//		listaCurso3.add(cursobb14);
//		
//		cursobb1.setListaDocente(listaDocente12);
//		cursobb2.setListaDocente(listaDocente12);
//		cursobb3.setListaDocente(listaDocente12);
//		cursobb4.setListaDocente(listaDocente12);
//		cursobb5.setListaDocente(listaDocente34);
//		cursobb6.setListaDocente(listaDocente34);
//		cursobb7.setListaDocente(listaDocente34);
//		cursobb8.setListaDocente(listaDocente34);
//		cursobb9.setListaDocente(listaDocente567);
//		cursobb10.setListaDocente(listaDocente567);
//		cursobb11.setListaDocente(listaDocente567);
//		cursobb12.setListaDocente(listaDocente567);
//		cursobb13.setListaDocente(listaDocente567);
//		cursobb14.setListaDocente(listaDocente567);
//		
//		
//		docentebb1.setListaCurso(listaCurso1);
//		docentebb2.setListaCurso(listaCurso2);
//		docentebb3.setListaCurso(listaCurso3);
//		docentebb4.setListaCurso(listaCurso1);
//		docentebb5.setListaCurso(listaCurso2);
//		docentebb6.setListaCurso(listaCurso3);
//		docentebb7.setListaCurso(listaCurso1);
//		docentebb8.setListaCurso(listaCurso2);
//		docentebb9.setListaCurso(listaCurso3);
//		docentebb10.setListaCurso(listaCurso1);
//		docentebb11.setListaCurso(listaCurso2);
//		docentebb12.setListaCurso(listaCurso3);
//		docentebb13.setListaCurso(listaCurso1);
//		docentebb14.setListaCurso(listaCurso2);
//		docentebb15.setListaCurso(listaCurso3);
//		
//		
//		this.cursoService.actualizarCurso(cursobb1);
//		this.cursoService.actualizarCurso(cursobb2);
//		this.cursoService.actualizarCurso(cursobb3);
//		this.cursoService.actualizarCurso(cursobb4);
//		this.cursoService.actualizarCurso(cursobb5);
//		this.cursoService.actualizarCurso(cursobb6);
//		this.cursoService.actualizarCurso(cursobb7);
//		this.cursoService.actualizarCurso(cursobb8);
//		this.cursoService.actualizarCurso(cursobb9);
//		this.cursoService.actualizarCurso(cursobb10);
//		this.cursoService.actualizarCurso(cursobb11);
//		this.cursoService.actualizarCurso(cursobb12);
//		this.cursoService.actualizarCurso(cursobb13);
//		this.cursoService.actualizarCurso(cursobb14);
//		
//		this.docenteService.actualizarDocente(docentebb1);
//		this.docenteService.actualizarDocente(docentebb2);
//		this.docenteService.actualizarDocente(docentebb3);
//		this.docenteService.actualizarDocente(docentebb4);
//		this.docenteService.actualizarDocente(docentebb5);
//		this.docenteService.actualizarDocente(docentebb6);
//		this.docenteService.actualizarDocente(docentebb7);
//		this.docenteService.actualizarDocente(docentebb8);
//		this.docenteService.actualizarDocente(docentebb9);
//		this.docenteService.actualizarDocente(docentebb10);
//		this.docenteService.actualizarDocente(docentebb11);
//		this.docenteService.actualizarDocente(docentebb12);
//		this.docenteService.actualizarDocente(docentebb13);
//		this.docenteService.actualizarDocente(docentebb14);
//		this.docenteService.actualizarDocente(docentebb15);
//		
//		
//		
//		//--------------------------Unir estudiante con materia--------------------------------------------------------
//		
//		List<Estudiante> listaEstudiante1= new ArrayList<>();
//		
//		
//		List<Materia> listaMateria1= new ArrayList<>();
//		
//		
//		
//		Estudiante estudiantebb1=this.estudianteService.buscarEstudiantePorId(1);
//		Estudiante estudiantebb2=this.estudianteService.buscarEstudiantePorId(2);
//		Estudiante estudiantebb3=this.estudianteService.buscarEstudiantePorId(3);
//		Estudiante estudiantebb4=this.estudianteService.buscarEstudiantePorId(4);
//		Estudiante estudiantebb5=this.estudianteService.buscarEstudiantePorId(5);
//		Estudiante estudiantebb6=this.estudianteService.buscarEstudiantePorId(6);
//		Estudiante estudiantebb7=this.estudianteService.buscarEstudiantePorId(7);
//		Estudiante estudiantebb8=this.estudianteService.buscarEstudiantePorId(8);
//		Estudiante estudiantebb9=this.estudianteService.buscarEstudiantePorId(9);
//		Estudiante estudiantebb10=this.estudianteService.buscarEstudiantePorId(10);
//		Estudiante estudiantebb11=this.estudianteService.buscarEstudiantePorId(11);
//		Estudiante estudiantebb12=this.estudianteService.buscarEstudiantePorId(12);
//		Estudiante estudiantebb13=this.estudianteService.buscarEstudiantePorId(13);
//		Estudiante estudiantebb14=this.estudianteService.buscarEstudiantePorId(14);
//		Estudiante estudiantebb15=this.estudianteService.buscarEstudiantePorId(15);
//		Estudiante estudiantebb16=this.estudianteService.buscarEstudiantePorId(16);
//		Estudiante estudiantebb17=this.estudianteService.buscarEstudiantePorId(17);
//		Estudiante estudiantebb18=this.estudianteService.buscarEstudiantePorId(18);
//		Estudiante estudiantebb19=this.estudianteService.buscarEstudiantePorId(19);
//		Estudiante estudiantebb20=this.estudianteService.buscarEstudiantePorId(20);
//		Estudiante estudiantebb21=this.estudianteService.buscarEstudiantePorId(21);
//		Estudiante estudiantebb22=this.estudianteService.buscarEstudiantePorId(22);
//		Estudiante estudiantebb23=this.estudianteService.buscarEstudiantePorId(23);
//		Estudiante estudiantebb24=this.estudianteService.buscarEstudiantePorId(24);
//		Estudiante estudiantebb25=this.estudianteService.buscarEstudiantePorId(25);
//		Estudiante estudiantebb26=this.estudianteService.buscarEstudiantePorId(26);
//		Estudiante estudiantebb27=this.estudianteService.buscarEstudiantePorId(27);
//		Estudiante estudiantebb28=this.estudianteService.buscarEstudiantePorId(28);
//		Estudiante estudiantebb29=this.estudianteService.buscarEstudiantePorId(29);
//		Estudiante estudiantebb30=this.estudianteService.buscarEstudiantePorId(30);
//		Estudiante estudiantebb31=this.estudianteService.buscarEstudiantePorId(31);
//		Estudiante estudiantebb32=this.estudianteService.buscarEstudiantePorId(32);
//		Estudiante estudiantebb33=this.estudianteService.buscarEstudiantePorId(33);
//		Estudiante estudiantebb34=this.estudianteService.buscarEstudiantePorId(34);
//		Estudiante estudiantebb35=this.estudianteService.buscarEstudiantePorId(35);
//		Estudiante estudiantebb36=this.estudianteService.buscarEstudiantePorId(36);
//		Estudiante estudiantebb37=this.estudianteService.buscarEstudiantePorId(37);
//		Estudiante estudiantebb38=this.estudianteService.buscarEstudiantePorId(38);
//		Estudiante estudiantebb39=this.estudianteService.buscarEstudiantePorId(39);
//		Estudiante estudiantebb40=this.estudianteService.buscarEstudiantePorId(40);
//		Estudiante estudiantebb41=this.estudianteService.buscarEstudiantePorId(41);
//		Estudiante estudiantebb42=this.estudianteService.buscarEstudiantePorId(42);
//		
//		
//		
//		Materia materiabb1=this.materiaService.buscarMateriaPorId(1);		
//		Materia materiabb2=this.materiaService.buscarMateriaPorId(2);
//		Materia materiabb3=this.materiaService.buscarMateriaPorId(3);
//		Materia materiabb4=this.materiaService.buscarMateriaPorId(4);
//		Materia materiabb5=this.materiaService.buscarMateriaPorId(5);
//		
//		
//		
//		listaMateria1.add(materiabb1);
//		listaMateria1.add(materiabb2);
//		listaMateria1.add(materiabb3);
//		listaMateria1.add(materiabb4);
//		listaMateria1.add(materiabb5);
//		
//		listaEstudiante1.add(estudiantebb1);
//		listaEstudiante1.add(estudiantebb2);
//		listaEstudiante1.add(estudiantebb3);
//		listaEstudiante1.add(estudiantebb4);
//		listaEstudiante1.add(estudiantebb5);
//		listaEstudiante1.add(estudiantebb6);
//		listaEstudiante1.add(estudiantebb7);
//		listaEstudiante1.add(estudiantebb8);
//		listaEstudiante1.add(estudiantebb9);
//		listaEstudiante1.add(estudiantebb10);
//		listaEstudiante1.add(estudiantebb11);
//		listaEstudiante1.add(estudiantebb12);
//		listaEstudiante1.add(estudiantebb13);
//		listaEstudiante1.add(estudiantebb14);
//		listaEstudiante1.add(estudiantebb15);
//		listaEstudiante1.add(estudiantebb16);
//		listaEstudiante1.add(estudiantebb17);
//		listaEstudiante1.add(estudiantebb18);
//		listaEstudiante1.add(estudiantebb19);
//		listaEstudiante1.add(estudiantebb20);
//		listaEstudiante1.add(estudiantebb21);
//		listaEstudiante1.add(estudiantebb22);
//		listaEstudiante1.add(estudiantebb23);
//		listaEstudiante1.add(estudiantebb24);
//		listaEstudiante1.add(estudiantebb25);
//		listaEstudiante1.add(estudiantebb26);
//		listaEstudiante1.add(estudiantebb27);
//		listaEstudiante1.add(estudiantebb28);
//		listaEstudiante1.add(estudiantebb29);
//		listaEstudiante1.add(estudiantebb30);
//		listaEstudiante1.add(estudiantebb31);
//		listaEstudiante1.add(estudiantebb32);
//		listaEstudiante1.add(estudiantebb33);
//		listaEstudiante1.add(estudiantebb34);
//		listaEstudiante1.add(estudiantebb35);
//		listaEstudiante1.add(estudiantebb36);
//		listaEstudiante1.add(estudiantebb37);
//		listaEstudiante1.add(estudiantebb38);
//		listaEstudiante1.add(estudiantebb39);
//		listaEstudiante1.add(estudiantebb40);
//		listaEstudiante1.add(estudiantebb41);
//		listaEstudiante1.add(estudiantebb42);
//		
//	
//
//		
//		
//		
//		estudiantebb1.setListaMateria(listaMateria1);
//		estudiantebb2.setListaMateria(listaMateria1);
//		estudiantebb3.setListaMateria(listaMateria1);
//		estudiantebb4.setListaMateria(listaMateria1);
//		estudiantebb5.setListaMateria(listaMateria1);
//		estudiantebb6.setListaMateria(listaMateria1);
//		estudiantebb7.setListaMateria(listaMateria1);
//		estudiantebb8.setListaMateria(listaMateria1);
//		estudiantebb9.setListaMateria(listaMateria1);
//		estudiantebb10.setListaMateria(listaMateria1);
//		estudiantebb11.setListaMateria(listaMateria1);
//		estudiantebb12.setListaMateria(listaMateria1);
//		estudiantebb13.setListaMateria(listaMateria1);
//		estudiantebb14.setListaMateria(listaMateria1);
//		estudiantebb15.setListaMateria(listaMateria1);
//		estudiantebb16.setListaMateria(listaMateria1);
//		estudiantebb17.setListaMateria(listaMateria1);
//		estudiantebb18.setListaMateria(listaMateria1);
//		estudiantebb19.setListaMateria(listaMateria1);
//		estudiantebb20.setListaMateria(listaMateria1);
//		estudiantebb21.setListaMateria(listaMateria1);
//		estudiantebb22.setListaMateria(listaMateria1);
//		estudiantebb23.setListaMateria(listaMateria1);
//		estudiantebb24.setListaMateria(listaMateria1);
//		estudiantebb25.setListaMateria(listaMateria1);
//		estudiantebb26.setListaMateria(listaMateria1);
//		estudiantebb27.setListaMateria(listaMateria1);
//		estudiantebb28.setListaMateria(listaMateria1);
//		estudiantebb29.setListaMateria(listaMateria1);
//		estudiantebb30.setListaMateria(listaMateria1);
//		estudiantebb31.setListaMateria(listaMateria1);
//		estudiantebb32.setListaMateria(listaMateria1);
//		estudiantebb33.setListaMateria(listaMateria1);
//		estudiantebb34.setListaMateria(listaMateria1);
//		estudiantebb35.setListaMateria(listaMateria1);
//		estudiantebb36.setListaMateria(listaMateria1);
//		estudiantebb37.setListaMateria(listaMateria1);
//		estudiantebb38.setListaMateria(listaMateria1);
//		estudiantebb39.setListaMateria(listaMateria1);
//		estudiantebb40.setListaMateria(listaMateria1);
//		estudiantebb41.setListaMateria(listaMateria1);
//		estudiantebb42.setListaMateria(listaMateria1);
//		
//
//		materiabb1.setListaEstudiante(listaEstudiante1);
//		materiabb2.setListaEstudiante(listaEstudiante1);
//		materiabb3.setListaEstudiante(listaEstudiante1);
//		materiabb4.setListaEstudiante(listaEstudiante1);
//		materiabb5.setListaEstudiante(listaEstudiante1);
//		
//		
//		//actualiza la entidad dodne se crea la tabla
//		
//		this.materiaService.actualizarMateria(materiabb1);
//		this.materiaService.actualizarMateria(materiabb2);
//		this.materiaService.actualizarMateria(materiabb3);
//		this.materiaService.actualizarMateria(materiabb4);
//		this.materiaService.actualizarMateria(materiabb5);
//	
//		this.estudianteService.actualizarEstudiante(estudiantebb1);
//		this.estudianteService.actualizarEstudiante(estudiantebb2);
//		this.estudianteService.actualizarEstudiante(estudiantebb3);
//		this.estudianteService.actualizarEstudiante(estudiantebb4);
//		this.estudianteService.actualizarEstudiante(estudiantebb5);
//		this.estudianteService.actualizarEstudiante(estudiantebb6);
//		this.estudianteService.actualizarEstudiante(estudiantebb7);
//		this.estudianteService.actualizarEstudiante(estudiantebb8);
//		this.estudianteService.actualizarEstudiante(estudiantebb9);
//		this.estudianteService.actualizarEstudiante(estudiantebb10);
//		this.estudianteService.actualizarEstudiante(estudiantebb11);
//		this.estudianteService.actualizarEstudiante(estudiantebb12);
//		this.estudianteService.actualizarEstudiante(estudiantebb13);
//		this.estudianteService.actualizarEstudiante(estudiantebb14);
//		this.estudianteService.actualizarEstudiante(estudiantebb15);
//		this.estudianteService.actualizarEstudiante(estudiantebb16);
//		this.estudianteService.actualizarEstudiante(estudiantebb17);
//		this.estudianteService.actualizarEstudiante(estudiantebb18);
//		this.estudianteService.actualizarEstudiante(estudiantebb19);
//		this.estudianteService.actualizarEstudiante(estudiantebb20);
//		this.estudianteService.actualizarEstudiante(estudiantebb21);
//		this.estudianteService.actualizarEstudiante(estudiantebb22);
//		this.estudianteService.actualizarEstudiante(estudiantebb23);
//		this.estudianteService.actualizarEstudiante(estudiantebb24);
//		this.estudianteService.actualizarEstudiante(estudiantebb25);
//		this.estudianteService.actualizarEstudiante(estudiantebb26);
//		this.estudianteService.actualizarEstudiante(estudiantebb27);
//		this.estudianteService.actualizarEstudiante(estudiantebb28);
//		this.estudianteService.actualizarEstudiante(estudiantebb29);
//		this.estudianteService.actualizarEstudiante(estudiantebb30);
//		this.estudianteService.actualizarEstudiante(estudiantebb31);
//		this.estudianteService.actualizarEstudiante(estudiantebb32);
//		this.estudianteService.actualizarEstudiante(estudiantebb33);
//		this.estudianteService.actualizarEstudiante(estudiantebb34);
//		this.estudianteService.actualizarEstudiante(estudiantebb35);
//		this.estudianteService.actualizarEstudiante(estudiantebb36);
//		this.estudianteService.actualizarEstudiante(estudiantebb37);
//		this.estudianteService.actualizarEstudiante(estudiantebb38);
//		this.estudianteService.actualizarEstudiante(estudiantebb39);
//		this.estudianteService.actualizarEstudiante(estudiantebb40);
//		this.estudianteService.actualizarEstudiante(estudiantebb41);
//		this.estudianteService.actualizarEstudiante(estudiantebb42);
//		
//		//---------------------------------------Unir Representante con Estudiante-------------------------------------------
//		
//		Representante representante1=this.representanteService.buscarRepresentantePorId(1);
//		Representante representante2=this.representanteService.buscarRepresentantePorId(2);
//		
//		Estudiante estudiante101=this.estudianteService.buscarEstudiantePorId(1);	
//		estudiante101.setRepresentate(representante2);
//		Estudiante estudiante201=this.estudianteService.buscarEstudiantePorId(2);
//		estudiante201.setRepresentate(representante1);
//		Estudiante estudiante301=this.estudianteService.buscarEstudiantePorId(36);
//		estudiante301.setRepresentate(representante2);
//		Estudiante estudiante401=this.estudianteService.buscarEstudiantePorId(37);
//		estudiante401.setRepresentate(representante1);
//		
//		List <Estudiante> listaEs1= new ArrayList<>();
//		List <Estudiante> listaEs2= new ArrayList<>();
//				
//				
//		listaEs1.add(estudiante101);
//		listaEs1.add(estudiante301);
//		
//		listaEs2.add(estudiante201);
//		listaEs2.add(estudiante401);
//		
//		representante1.setEstudiantes(listaEs2);
//		representante2.setEstudiantes(listaEs1);
//		
//		this.representanteService.actualizarRepresentante(representante1);
//		this.representanteService.actualizarRepresentante(representante2);
//		
//		this.estudianteService.actualizarEstudiante(estudiante101);
//		this.estudianteService.actualizarEstudiante(estudiante201);
//		this.estudianteService.actualizarEstudiante(estudiante301);
//		this.estudianteService.actualizarEstudiante(estudiante401);
//		
//		//--------------------------------------Unir Horario con Curso---------------------------------------
//	
//		Curso ccurso1=this.cursoService.buscarCursoPorId(1);
//		Curso ccurso2=this.cursoService.buscarCursoPorId(2);
//		Curso ccurso3=this.cursoService.buscarCursoPorId(3);
//		Curso ccurso4=this.cursoService.buscarCursoPorId(4);
//		Curso ccurso5=this.cursoService.buscarCursoPorId(5);
//		Curso ccurso6=this.cursoService.buscarCursoPorId(6);
//		Curso ccurso7=this.cursoService.buscarCursoPorId(7);
//		Curso ccurso8=this.cursoService.buscarCursoPorId(8);
//		Curso ccurso9=this.cursoService.buscarCursoPorId(9);
//		Curso ccurso10=this.cursoService.buscarCursoPorId(10);
//		Curso ccurso11=this.cursoService.buscarCursoPorId(11);
//		Curso ccurso12=this.cursoService.buscarCursoPorId(12);
//		Curso ccurso13=this.cursoService.buscarCursoPorId(13);
//		Curso ccurso14=this.cursoService.buscarCursoPorId(14);
//		
//		
//		
//		Horario hor1=this.horarioService.buscarHorarioPorId(1);
//		Horario hor2=this.horarioService.buscarHorarioPorId(2);
//		Horario hor3=this.horarioService.buscarHorarioPorId(3);
//		Horario hor4=this.horarioService.buscarHorarioPorId(4);
//		Horario hor5=this.horarioService.buscarHorarioPorId(5);
//		Horario hor6=this.horarioService.buscarHorarioPorId(6);
//		Horario hor7=this.horarioService.buscarHorarioPorId(7);
//		Horario hor8=this.horarioService.buscarHorarioPorId(8);
//		Horario hor9=this.horarioService.buscarHorarioPorId(9);
//		Horario hor10=this.horarioService.buscarHorarioPorId(10);
//		Horario hor11=this.horarioService.buscarHorarioPorId(11);
//		Horario hor12=this.horarioService.buscarHorarioPorId(12);
//		Horario hor13=this.horarioService.buscarHorarioPorId(13);
//		Horario hor14=this.horarioService.buscarHorarioPorId(14);
//		
//		ccurso1.setHorario(hor1);
//		ccurso2.setHorario(hor2);
//		ccurso3.setHorario(hor3);
//		ccurso4.setHorario(hor4);
//		ccurso5.setHorario(hor5);
//		ccurso6.setHorario(hor6);
//		ccurso7.setHorario(hor7);
//		ccurso8.setHorario(hor8);
//		ccurso9.setHorario(hor9);
//		ccurso10.setHorario(hor10);
//		ccurso11.setHorario(hor11);
//		ccurso12.setHorario(hor12);
//		ccurso13.setHorario(hor13);
//		ccurso14.setHorario(hor14);
//		
//		this.cursoService.actualizarCurso(ccurso1);
//		this.cursoService.actualizarCurso(ccurso2);
//		this.cursoService.actualizarCurso(ccurso3);
//		this.cursoService.actualizarCurso(ccurso4);
//		this.cursoService.actualizarCurso(ccurso5);
//		this.cursoService.actualizarCurso(ccurso6);
//		this.cursoService.actualizarCurso(ccurso7);
//		this.cursoService.actualizarCurso(ccurso8);
//		this.cursoService.actualizarCurso(ccurso9);
//		this.cursoService.actualizarCurso(ccurso10);
//		this.cursoService.actualizarCurso(ccurso11);
//		this.cursoService.actualizarCurso(ccurso12);
//		this.cursoService.actualizarCurso(ccurso13);
//		this.cursoService.actualizarCurso(ccurso14);
//		
//		
//		
//		
//		//----------------------------------------------------------Insertar Usuarios------------------------------------------------------
//		
//		Usuario usuario1= new Usuario();
//		usuario1.setNombre("Blanca Mariana");
//		usuario1.setApellido("Perez Idrovo");
//		usuario1.setTipo("Docente");
//		usuario1.setCorreo("bmapi@gutemberg.edu.ec");
//		usuario1.setContrasenia("12345");
//		
//		Usuario usuario2= new Usuario();
//		usuario2.setNombre("Segundo Fernando");
//		usuario2.setApellido("Arevalo Lopez");
//		usuario2.setTipo("Docente");
//		usuario2.setCorreo("sefal@gutemberg.edu.ec");
//		usuario2.setContrasenia("12345");
//		
//		Usuario usuario3= new Usuario();
//		usuario3.setNombre("Maria Fernanda");
//		usuario3.setApellido("Andrade Pazmiño");
//		usuario3.setTipo("Docente");
//		usuario3.setCorreo("mafep@gutemberg.edu.ec");
//		usuario3.setContrasenia("12345");
//		
//		Usuario usuario4= new Usuario();
//		usuario4.setNombre("Daniel Alexander");
//		usuario4.setApellido("Carrillo Perez");
//		usuario4.setTipo("Docente");
//		usuario4.setCorreo("daecp@gutemberg.edu.ec");
//		usuario4.setContrasenia("12345");
//		
//		Usuario usuario5= new Usuario();
//		usuario5.setNombre("Ana Cristina");
//		usuario5.setApellido("Sanchez Abad");
//		usuario5.setTipo("Docente");
//		usuario5.setCorreo("acsa@gutemberg.edu.ec");
//		usuario5.setContrasenia("12345");
//		
//		Usuario usuario6= new Usuario();
//		usuario6.setNombre("Karolain Anahi");
//		usuario6.setApellido("Calva Calva");
//		usuario6.setTipo("Docente");
//		usuario6.setCorreo("kacal@gutemberg.edu.ec");
//		usuario6.setContrasenia("12345");
//		
//		Usuario usuario7= new Usuario();
//		usuario7.setNombre("Pablo Andres");
//		usuario7.setApellido("Carrera Carpio");
//		usuario7.setTipo("Docente");
//		usuario7.setCorreo("pacc@gutemberg.edu.ec");
//		usuario7.setContrasenia("12345");
//		
//		Usuario usuario8= new Usuario();
//		usuario8.setNombre("Luis Fernando");
//		usuario8.setApellido("Quizhpe Espinoza");
//		usuario8.setTipo("Docente");
//		usuario8.setCorreo("lufeqe@gutemberg.edu.ec");
//		usuario8.setContrasenia("12345");
//		
//		Usuario usuario9= new Usuario();
//		usuario9.setNombre("Stefany Anahi");
//		usuario9.setApellido("Patiño Espinoza");
//		usuario9.setTipo("Docente");
//		usuario9.setCorreo("stapes@gutemberg.edu.ec");
//		usuario9.setContrasenia("12345");
//		
//		Usuario usuario10= new Usuario();
//		usuario10.setNombre("Josselyn Anahi");
//		usuario10.setApellido("Calva Cueva");
//		usuario10.setTipo("Docente");
//		usuario10.setCorreo("josaca@gutemberg.edu.ec");
//		usuario10.setContrasenia("12345");
//		
//		Usuario usuario11= new Usuario();
//		usuario11.setNombre("Andrea Nataly");
//		usuario11.setApellido("Jumbo Jumbo");
//		usuario11.setTipo("Docente");
//		usuario11.setCorreo("anjuju@gutemberg.edu.ec");
//		usuario11.setContrasenia("12345");
//		
//		Usuario usuario12= new Usuario();
//		usuario12.setNombre("Fredy Alexander");
//		usuario12.setApellido("Crespo Montaño");
//		usuario12.setTipo("Docente");
//		usuario12.setCorreo("felemon@gutemberg.edu.ec");
//		usuario12.setContrasenia("12345");
//		
//		Usuario usuario13= new Usuario();
//		usuario13.setNombre("Luis Roberto");
//		usuario13.setApellido("Machado Obando");
//		usuario13.setTipo("Docente");
//		usuario13.setCorreo("fido@gutemberg.edu.ec");
//		usuario13.setContrasenia("12345");
//		
//		Usuario usuario14= new Usuario();
//		usuario14.setNombre("Leonardo Isaac");
//		usuario14.setApellido("Ordoñez Espinoza");
//		usuario14.setTipo("Docente");
//		usuario14.setCorreo("isaaco@gutemberg.edu.ec");
//		usuario14.setContrasenia("12345");
//		
//		Usuario usuario15= new Usuario();
//		usuario15.setNombre("Michelle Anahi");
//		usuario15.setApellido("Villacres Vera");
//		usuario15.setTipo("Docente");
//		usuario15.setCorreo("mivive@gutemberg.edu.ec");
//		usuario15.setContrasenia("12345");
//		
//		Usuario usuario16= new Usuario();
//		usuario16.setNombre("Julissa Stefania");
//		usuario16.setApellido("Jaramillo Hidalgo");
//		usuario16.setTipo("Estudiante");
//		usuario16.setCorreo("jusjh@gutemberg.edu.ec");
//		usuario16.setContrasenia("67890");
//		
//		Usuario usuario17= new Usuario();
//		usuario17.setNombre("Julian Rafael");
//		usuario17.setApellido("Sanchez Iñiguez");
//		usuario17.setTipo("Estudiante");
//		usuario17.setCorreo("jurai@gutemberg.edu.ec");
//		usuario17.setContrasenia("67890");
//		
//		Usuario usuario18= new Usuario();
//		usuario18.setNombre("Felipe Alexander");
//		usuario18.setApellido("Suing Bailon");
//		usuario18.setTipo("Estudiante");
//		usuario18.setCorreo("fesuba@gutemberg.edu.ec");
//		usuario18.setContrasenia("67890");
//		
//		Usuario usuario19= new Usuario();
//		usuario19.setNombre("Paulina Yahaira");
//		usuario19.setApellido("Andrade Sanchez");
//		usuario19.setTipo("Estudiante");
//		usuario19.setCorreo("payan@gutemberg.edu.ec");
//		usuario19.setContrasenia("67890");
//		
//		Usuario usuario20= new Usuario();
//		usuario20.setNombre("Victor Manuel");
//		usuario20.setApellido("Monroy Abendaño");
//		usuario20.setTipo("Estudiante");
//		usuario20.setCorreo("vimoa@gutemberg.edu.ec");
//		usuario20.setContrasenia("67890");
//		
//		Usuario usuario21= new Usuario();
//		usuario21.setNombre("Pedro Pablo");
//		usuario21.setApellido("Velasco Ibarra");
//		usuario21.setTipo("Estudiante");
//		usuario21.setCorreo("pepai@gutemberg.edu.ec");
//		usuario21.setContrasenia("67890");
//		
//		Usuario usuario22= new Usuario();
//		usuario22.setNombre("William Rigoberto");
//		usuario22.setApellido("Mayorga Montaño");
//		usuario22.setTipo("Estudiante");
//		usuario22.setCorreo("wimam@gutemberg.edu.ec");
//		usuario22.setContrasenia("67890");
//		
//		Usuario usuario23= new Usuario();
//		usuario23.setNombre("Andy Esteban");
//		usuario23.setApellido("Chiriboga Villacres");
//		usuario23.setTipo("Estudiante");
//		usuario23.setCorreo("achivi@gutemberg.edu.ec");
//		usuario23.setContrasenia("67890");
//		
//		Usuario usuario24= new Usuario();
//		usuario24.setNombre("Richard Ramiro");
//		usuario24.setApellido("Ramirez Rosales");
//		usuario24.setTipo("Estudiante");
//		usuario24.setCorreo("rirales@gutemberg.edu.ec");
//		usuario24.setContrasenia("67890");
//		
//		Usuario usuario25= new Usuario();
//		usuario25.setNombre("Anthony Alexander");
//		usuario25.setApellido("Calvache Molina");
//		usuario25.setTipo("Estudiante");
//		usuario25.setCorreo("ancamo@gutemberg.edu.ec");
//		usuario25.setContrasenia("67890");
//		
//		Usuario usuario26= new Usuario();
//		usuario26.setNombre("Miriam del Rocio");
//		usuario26.setApellido("Velazquez Ibarra");
//		usuario26.setTipo("Estudiante");
//		usuario26.setCorreo("mivi@gutemberg.edu.ec");
//		usuario26.setContrasenia("67890");
//		
//		Usuario usuario27= new Usuario();
//		usuario27.setNombre("Oscar Manuel");
//		usuario27.setApellido("Correa Correa");
//		usuario27.setTipo("Estudiante");
//		usuario27.setCorreo("oscor@gutemberg.edu.ec");
//		usuario27.setContrasenia("67890");
//		
//		Usuario usuario28= new Usuario();
//		usuario28.setNombre("Carlos Alexander");
//		usuario28.setApellido("Diaz Diaz");
//		usuario28.setTipo("Estudiante");
//		usuario28.setCorreo("cadiaz@gutemberg.edu.ec");
//		usuario28.setContrasenia("67890");
//		
//		Usuario usuario29= new Usuario();
//		usuario29.setNombre("Luis Leonel");
//		usuario29.setApellido("Cervantes Ontaneda");
//		usuario29.setTipo("Estudiante");
//		usuario29.setCorreo("luico@gutemberg.edu.ec");
//		usuario29.setContrasenia("67890");
//		
//		Usuario usuario30= new Usuario();
//		usuario30.setNombre("Mayra Elizabeth");
//		usuario30.setApellido("Hernandez Molina");
//		usuario30.setTipo("Estudiante");
//		usuario30.setCorreo("mayher@gutemberg.edu.ec");
//		usuario30.setContrasenia("67890");
//		
//		Usuario usuario31= new Usuario();
//		usuario31.setNombre("Jimy Alexander");
//		usuario31.setApellido("Carcelen Moraloes");
//		usuario31.setTipo("Estudiante");
//		usuario31.setCorreo("jicama@gutemberg.edu.ec");
//		usuario31.setContrasenia("67890");
//		
//		Usuario usuario32= new Usuario();
//		usuario32.setNombre("Jessica Carolina");
//		usuario32.setApellido("Quichimbo Pino");
//		usuario32.setTipo("Estudiante");
//		usuario32.setCorreo("jequin@gutemberg.edu.ec");
//		usuario32.setContrasenia("67890");
//		
//		Usuario usuario33= new Usuario();
//		usuario33.setNombre("Dennis Alexander");
//		usuario33.setApellido("Pilco Rosales");
//		usuario33.setTipo("Estudiante");
//		usuario33.setCorreo("depiro@gutemberg.edu.ec");
//		usuario33.setContrasenia("67890");
//		
//		Usuario usuario34= new Usuario();
//		usuario34.setNombre("Juan Pablo");
//		usuario34.setApellido("Valdivieso Perez");
//		usuario34.setTipo("Estudiante");
//		usuario34.setCorreo("juvupe@gutemberg.edu.ec");
//		usuario34.setContrasenia("67890");
//		
//		Usuario usuario35= new Usuario();
//		usuario35.setNombre("Juan Fernando");
//		usuario35.setApellido("Ramon Carcelen");
//		usuario35.setTipo("Estudiante");
//		usuario35.setCorreo("juralen@gutemberg.edu.ec");
//		usuario35.setContrasenia("67890");
//		
//		Usuario usuario36= new Usuario();
//		usuario36.setNombre("Johan Andres");
//		usuario36.setApellido("Zea Carpio");
//		usuario36.setTipo("Estudiante");
//		usuario36.setCorreo("jozea@gutemberg.edu.ec");
//		usuario36.setContrasenia("67890");
//		
//		Usuario usuario37= new Usuario();
//		usuario37.setNombre("Cristian David");
//		usuario37.setApellido("Carrera Lopez");
//		usuario37.setTipo("Estudiante");
//		usuario37.setCorreo("crisloca@gutemberg.edu.ec");
//		usuario37.setContrasenia("67890");
//		
//		Usuario usuario38= new Usuario();
//		usuario38.setNombre("Luis Maximiliano");
//		usuario38.setApellido("Montalvo Ortiz");
//		usuario38.setTipo("Estudiante");
//		usuario38.setCorreo("lumono@gutemberg.edu.ec");
//		usuario38.setContrasenia("67890");
//		
//		Usuario usuario39= new Usuario();
//		usuario39.setNombre("Jorge Rafael");
//		usuario39.setApellido("Villamar Flores");
//		usuario39.setTipo("Estudiante");
//		usuario39.setCorreo("jorvis@gutemberg.edu.ec");
//		usuario39.setContrasenia("67890");
//		
//		Usuario usuario40= new Usuario();
//		usuario40.setNombre("Luz Maria");
//		usuario40.setApellido("Borja Abad");
//		usuario40.setTipo("Estudiante");
//		usuario40.setCorreo("luboa@gutemberg.edu.ec");
//		usuario40.setContrasenia("67890");
//		
//		Usuario usuario41= new Usuario();
//		usuario41.setNombre("Helen Cristina");
//		usuario41.setApellido("Espinoza Fernandez");
//		usuario41.setTipo("Estudiante");
//		usuario41.setCorreo("hefer@gutemberg.edu.ec");
//		usuario41.setContrasenia("67890");
//		
//		Usuario usuario42= new Usuario();
//		usuario42.setNombre("Mario Fernando");
//		usuario42.setApellido("Carrillo Chavez");
//		usuario42.setTipo("Estudiante");
//		usuario42.setCorreo("macavez@gutemberg.edu.ec");
//		usuario42.setContrasenia("67890");
//		
//		Usuario usuario43= new Usuario();
//		usuario43.setNombre("Veronica Cristina");
//		usuario43.setApellido("Tapia Castillo");
//		usuario43.setTipo("Estudiante");
//		usuario43.setCorreo("vetallo@gutemberg.edu.ec");
//		usuario43.setContrasenia("67890");
//		
//		Usuario usuario44= new Usuario();
//		usuario44.setNombre("Noelia Stefany");
//		usuario44.setApellido("Veintimilla Rios");
//		usuario44.setTipo("Estudiante");
//		usuario44.setCorreo("noe@gutemberg.edu.ec");
//		usuario44.setContrasenia("67890");
//		
//		Usuario usuario45= new Usuario();
//		usuario45.setNombre("Diego Dario");
//		usuario45.setApellido("Tapia Palacios");
//		usuario45.setTipo("Estudiante");
//		usuario45.setCorreo("dietapia@gutemberg.edu.ec");
//		usuario45.setContrasenia("67890");
//		
//		Usuario usuario46= new Usuario();
//		usuario46.setNombre("Stefany Carolina");
//		usuario46.setApellido("Arciniega Aguilar");
//		usuario46.setTipo("Estudiante");
//		usuario46.setCorreo("scalar@gutemberg.edu.ec");
//		usuario46.setContrasenia("67890");
//		
//		Usuario usuario47= new Usuario();
//		usuario47.setNombre("Valeria Fatima");
//		usuario47.setApellido("Valladarez Gonzales");
//		usuario47.setTipo("Estudiante");
//		usuario47.setCorreo("vavago@gutemberg.edu.ec");
//		usuario47.setContrasenia("67890");
//		
//		Usuario usuario48= new Usuario();
//		usuario48.setNombre("Katherine Viviana");
//		usuario48.setApellido("Maza Maza");
//		usuario48.setTipo("Estudiante");
//		usuario48.setCorreo("kamaza@gutemberg.edu.ec");
//		usuario48.setContrasenia("67890");
//		
//		Usuario usuario49= new Usuario();
//		usuario49.setNombre("Dario Esteban");
//		usuario49.setApellido("Arevalo Donoso");
//		usuario49.setTipo("Estudiante");
//		usuario49.setCorreo("dadolo@gutemberg.edu.ec");
//		usuario49.setContrasenia("67890");
//
//		Usuario usuario50= new Usuario();
//		usuario50.setNombre("Carolina del Rocio");
//		usuario50.setApellido("Juca Lopez");
//		usuario50.setTipo("Estudiante");
//		usuario50.setCorreo("caroju@gutemberg.edu.ec");
//		usuario50.setContrasenia("67890");
//		
//		Usuario usuario51= new Usuario();
//		usuario51.setNombre("Walter Fernando");
//		usuario51.setApellido("Cevallos Arias");
//		usuario51.setTipo("Estudiante");
//		usuario51.setCorreo("wacea@gutemberg.edu.ec");
//		usuario51.setContrasenia("67890");
//		
//		Usuario usuario52= new Usuario();
//		usuario52.setNombre("Jose Alexander");
//		usuario52.setApellido("Arias Andrade");
//		usuario52.setTipo("Estudiante");
//		usuario52.setCorreo("joara@gutemberg.edu.ec");
//		usuario52.setContrasenia("67890");
//		
//		Usuario usuario53= new Usuario();
//		usuario53.setNombre("Gustavo Rafael");
//		usuario53.setApellido("Sanchez Iñiguez");
//		usuario53.setTipo("Estudiante");
//		usuario53.setCorreo("gus@gutemberg.edu.ec");
//		usuario53.setContrasenia("67890");
//		
//		Usuario usuario54= new Usuario();
//		usuario54.setNombre("Maria Eugenia");
//		usuario54.setApellido("Suing Bailon");
//		usuario54.setTipo("Estudiante");
//		usuario54.setCorreo("mausi@gutemberg.edu.ec");
//		usuario54.setContrasenia("67890");
//		
//		Usuario usuario55= new Usuario();
//		usuario55.setNombre("Milton Alexander");
//		usuario55.setApellido("Morales Perez");
//		usuario55.setTipo("Estudiante");
//		usuario55.setCorreo("mimopeza@gutemberg.edu.ec");
//		usuario55.setContrasenia("67890");
//		
//		Usuario usuario56= new Usuario();
//		usuario56.setNombre("Giselle Estefania");
//		usuario56.setApellido("Guarnizo Ordoñez");
//		usuario56.setTipo("Estudiante");
//		usuario56.setCorreo("giguas@gutemberg.edu.ec");
//		usuario56.setContrasenia("67890");
//		
//		Usuario usuario57= new Usuario();
//		usuario57.setNombre("Melissa Fernanda");
//		usuario57.setApellido("Cajas Jaramillo");
//		usuario57.setTipo("Estudiante");
//		usuario57.setCorreo("mecaja@gutemberg.edu.ec");
//		usuario57.setContrasenia("67890");
//		
//		Usuario usuario58= new Usuario();
//		usuario58.setNombre("Jorge Luis");
//		usuario58.setApellido("Sanchez Iniguez");
//		usuario58.setTipo("Representante");
//		usuario58.setCorreo("jlsanchezi@uce.edu.ec");
//		usuario58.setContrasenia("11111");
//		
//		Usuario usuario59= new Usuario();
//		usuario59.setNombre("Cristhian Daniel");
//		usuario59.setApellido("Cedeno Santos");
//		usuario59.setTipo("Representante");
//		usuario59.setCorreo("cdcedenos@uce.edu.ec");
//		usuario59.setContrasenia("11111");
//		
//		Usuario usuario60= new Usuario();
//		usuario60.setNombre("Nicolas Alexander");
//		usuario60.setApellido("Carrera Chavez");
//		usuario60.setTipo("Administrador");
//		usuario60.setCorreo("nacarrera@uce.edu.ec");
//		usuario60.setContrasenia("11111");
//		
//		
//		
//		
//		this.usuarioService.insertarUsuario(usuario1);
//		this.usuarioService.insertarUsuario(usuario2);
//		this.usuarioService.insertarUsuario(usuario3);
//		this.usuarioService.insertarUsuario(usuario4);
//		this.usuarioService.insertarUsuario(usuario5);
//		this.usuarioService.insertarUsuario(usuario6);
//		this.usuarioService.insertarUsuario(usuario7);
//		this.usuarioService.insertarUsuario(usuario8);
//		this.usuarioService.insertarUsuario(usuario9);
//		this.usuarioService.insertarUsuario(usuario10);
//		this.usuarioService.insertarUsuario(usuario11);
//		this.usuarioService.insertarUsuario(usuario12);
//		this.usuarioService.insertarUsuario(usuario13);
//		this.usuarioService.insertarUsuario(usuario14);
//		this.usuarioService.insertarUsuario(usuario15);
//		this.usuarioService.insertarUsuario(usuario16);
//		this.usuarioService.insertarUsuario(usuario17);
//		this.usuarioService.insertarUsuario(usuario18);
//		this.usuarioService.insertarUsuario(usuario19);
//		this.usuarioService.insertarUsuario(usuario20);
//		this.usuarioService.insertarUsuario(usuario21);
//		this.usuarioService.insertarUsuario(usuario22);
//		this.usuarioService.insertarUsuario(usuario23);
//		this.usuarioService.insertarUsuario(usuario24);
//		this.usuarioService.insertarUsuario(usuario25);
//		this.usuarioService.insertarUsuario(usuario26);
//		this.usuarioService.insertarUsuario(usuario27);
//		this.usuarioService.insertarUsuario(usuario28);
//		this.usuarioService.insertarUsuario(usuario29);
//		this.usuarioService.insertarUsuario(usuario30);
//		this.usuarioService.insertarUsuario(usuario31);
//		this.usuarioService.insertarUsuario(usuario32);
//		this.usuarioService.insertarUsuario(usuario33);
//		this.usuarioService.insertarUsuario(usuario34);
//		this.usuarioService.insertarUsuario(usuario35);
//		this.usuarioService.insertarUsuario(usuario36);
//		this.usuarioService.insertarUsuario(usuario37);
//		this.usuarioService.insertarUsuario(usuario38);
//		this.usuarioService.insertarUsuario(usuario39);
//		this.usuarioService.insertarUsuario(usuario40);
//		this.usuarioService.insertarUsuario(usuario41);
//		this.usuarioService.insertarUsuario(usuario42);
//		this.usuarioService.insertarUsuario(usuario43);
//		this.usuarioService.insertarUsuario(usuario44);
//		this.usuarioService.insertarUsuario(usuario45);
//		this.usuarioService.insertarUsuario(usuario46);
//		this.usuarioService.insertarUsuario(usuario47);
//		this.usuarioService.insertarUsuario(usuario48);
//		this.usuarioService.insertarUsuario(usuario49);
//		this.usuarioService.insertarUsuario(usuario50);
//		this.usuarioService.insertarUsuario(usuario51);
//		this.usuarioService.insertarUsuario(usuario52);
//		this.usuarioService.insertarUsuario(usuario53);
//		this.usuarioService.insertarUsuario(usuario54);
//		this.usuarioService.insertarUsuario(usuario55);
//		this.usuarioService.insertarUsuario(usuario56);
//		this.usuarioService.insertarUsuario(usuario57);
//		this.usuarioService.insertarUsuario(usuario58);
//		this.usuarioService.insertarUsuario(usuario59);
//		this.usuarioService.insertarUsuario(usuario60);
		
		//Filtrar estudiantes por curso
		
	//	List<Estudiante> listasencillo= this.estudianteService.listaEstudiantes("Primero", "A");
		
	//	for (Estudiante s:listasencillo) {
	//		System.out.println(s.toString());
	//		System.out.println(s.getListaMateria().toString());
	//	}
	

	// Filtracion

	// this.gestorEstudiante.consultarCurso("Primero", "A");

//		Estudiante ges36=this.gestorDocente.actualizarRegistrarNota("mecaja@gutemberg.edu.ec", "Ciencias");
	// Estudiante
	// ges37=this.gestorDocente.actualizarRegistrarNota("mecaja@gutemberg.edu.ec",
	// "Lenguaje");
	// Estudiante
	// ges38=this.gestorDocente.actualizarRegistrarNota("mecaja@gutemberg.edu.ec",
	// "Sociales");
	// Estudiante
	// ges39=this.gestorDocente.actualizarRegistrarNota("mecaja@gutemberg.edu.ec",
	// "Ciencias");
	// Estudiante
	// ges40=this.gestorDocente.actualizarRegistrarNota("mecaja@gutemberg.edu.ec",
	// "Aleman");

//		Estudiante t4=this.estudianteService.buscarEstudiantePorCorreo("mecaja@gutemberg.edu.ec");
//		
//		t4.getListaMateria().get(4).setCalificacion(new BigDecimal("6.00"));
//		
//		this.estudianteService.actualizarEstudiante(t4);
//		
//		this.gestorEstudiante.consultarCurso("Septimo", "B");

//	  boolean compro=this.gestorUsuario.comprobarExistenciaUsuario("sefal@gutemberg.edu.ec", "12345");
//	  System.out.println(compro);

//		Docente uno= this.docenteService.buscarDocentePorId(2);
//		
//		System.out.println(uno.getMateria().getNombre());

//		BigDecimal resultado= new BigDecimal("10.00");
//		
//		resultado=resultado.divide(new BigDecimal("2.00"));
//		
//		System.out.println(resultado);
		
		// Encriptacion
		
//		Usuario usuario13= new Usuario();
//		usuario13.setNombre("Luis Roberto");
//		usuario13.setApellido("Machado Obando");
//		usuario13.setTipo("Docente");
//		usuario13.setCorreo(this.usuarioService.encriptarPassword("fido@gutemberg.edu.ec"));
//		usuario13.setContrasenia("12345");
	
		
	}

}
