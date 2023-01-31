package ec.edu.uce.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "docente")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_docente")
	@SequenceGenerator(name = "seq_docente", sequenceName = "seq_docente", allocationSize = 1)
	@Column(name = "doce_id")
	private Integer id;

	@Column(name = "doce_nombre")
	private String nombre;

	@Column(name = "doce_apellido")
	private String apellido;

	@Column(name = "doce_edad")
	private Integer edad;

	@Column(name = "doce_direccion")
	private String direccion;

	@Column(name = "doce_telefono")
	private String telefono;

	@Column(name = "doce_numero_curso")
	private Integer numeroCurso;

	@Column(name = "doce_correo")
	private String correo;

	@Column(name = "doce_contrasenia")
	private String contrasenia;

	@Column(name = "doce_administrador")
	private Boolean isAdministrador ;

	@Column(name = "doce_horasLibres")
	private Integer horasLibres;

	@Column(name = "doce_diaAtencion")
	private String diaAtencion;

	@Column(name = "doce_horaAtencion")
	private Integer HoraAtencion;

	@ManyToOne
	@JoinColumn(name = "mate_id")
	private Materia materia;

	@ManyToMany(mappedBy = "listaDocente")
	private List<Curso> listaCurso;

	// Metodos Get y Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHorasLibres() {
		return horasLibres;
	}

	public void setHorasLibres(Integer horasLibres) {
		this.horasLibres = horasLibres;
	}

	public String getDiaAtencion() {
		return diaAtencion;
	}

	public void setDiaAtencion(String diaAtencion) {
		this.diaAtencion = diaAtencion;
	}

	public Integer getHoraAtencion() {
		return HoraAtencion;
	}

	public void setHoraAtencion(Integer horaAtencion) {
		HoraAtencion = horaAtencion;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getNumeroCurso() {
		return numeroCurso;
	}

	public void setNumeroCurso(Integer numeroCurso) {
		this.numeroCurso = numeroCurso;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombreClase() {
		return "Docente";
	}

	// To String

	public Boolean getIsAdministrador() {
		return isAdministrador;
	}

	public void setIsAdministrador(Boolean isAdministrador) {
		this.isAdministrador = isAdministrador;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public List<Curso> getListaCurso() {
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	@Override
	public String toString() {
		return "Docente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", direccion="
				+ direccion + ", telefono=" + telefono + ", numeroCurso=" + numeroCurso + ", correo=" + correo
				+ ", contrasenia=" + contrasenia + "]";
	}

}
