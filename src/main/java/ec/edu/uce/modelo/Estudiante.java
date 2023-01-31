package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estudiante")
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
	@Column(name = "estu_id")
	private Integer id;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Column(name = "estu_edad")
	private Integer edad;

	@Column(name = "estu_direccion")
	private String direccion;

	@Column(name = "estu_telefono")
	private String telefono;

	@Column(name = "estu_numero_materia")
	private Integer numeroMateria;

	@Column(name = "estu_correo")
	private String correo;

	@Column(name = "estu_contrasenia")
	private String contrasenia;

	@Column(name = "estu_matematicas")
	private BigDecimal matematicas;

	@Column(name = "estu_lenguaje")
	private BigDecimal lenguaje;

	@Column(name = "estu_sociales")
	private BigDecimal sociales;

	@Column(name = "estu_ciencias")
	private BigDecimal ciencias;

	@Column(name = "estu_aleman")
	private BigDecimal aleman;
	
	@Column(name = "estu_conductaMatematicas")
	private String conductaMatematicas;
	
	@Column(name = "estu_conductaLenguaje")
	private String conductaLenguaje;
	
	@Column(name = "estu_conductaSociales")
	private String conductaSociales;
	
	@Column(name = "estu_conductaCiencias")
	private String conductaCiencias;
	
	@Column(name = "estu_conductaAleman")
	private String conductaAleman;

	@Column(name = "estu_administrador")
	private Boolean isAdministrador ;

	@ManyToOne
	@JoinColumn(name = "curs_id")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "repr_id")
	private Representante representate;

	@JoinTable(name = "estudiante_materia", joinColumns = @JoinColumn(name = "fk_estudiante", nullable = false), inverseJoinColumns = @JoinColumn(name = "fk_materia", nullable = false))
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Materia> listaMateria;

	public List<Materia> getListaMateria() {
		return listaMateria;
	}

	public void setListaMateria(List<Materia> listaMateria) {
		this.listaMateria = listaMateria;
	}

	// Metodos Get y Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Representante getRepresentate() {
		return representate;
	}

	
	
	public String getConductaMatematicas() {
		return conductaMatematicas;
	}

	public void setConductaMatematicas(String conductaMatematicas) {
		this.conductaMatematicas = conductaMatematicas;
	}

	public String getConductaLenguaje() {
		return conductaLenguaje;
	}

	public void setConductaLenguaje(String conductaLenguaje) {
		this.conductaLenguaje = conductaLenguaje;
	}

	public String getConductaSociales() {
		return conductaSociales;
	}

	public void setConductaSociales(String conductaSociales) {
		this.conductaSociales = conductaSociales;
	}

	public String getConductaCiencias() {
		return conductaCiencias;
	}

	public void setConductaCiencias(String conductaCiencias) {
		this.conductaCiencias = conductaCiencias;
	}

	public String getConductaAleman() {
		return conductaAleman;
	}

	public void setConductaAleman(String conductaAleman) {
		this.conductaAleman = conductaAleman;
	}

	public void setRepresentate(Representante representate) {
		this.representate = representate;
	}

	public Boolean getIsAdministrador() {
		return isAdministrador;
	}

	public void setIsAdministrador(Boolean isAdministrador) {
		this.isAdministrador = isAdministrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public BigDecimal getMatematicas() {
		return matematicas;
	}

	public void setMatematicas(BigDecimal matematicas) {
		this.matematicas = matematicas;
	}

	public BigDecimal getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(BigDecimal lenguaje) {
		this.lenguaje = lenguaje;
	}

	public BigDecimal getSociales() {
		return sociales;
	}

	public void setSociales(BigDecimal sociales) {
		this.sociales = sociales;
	}

	public BigDecimal getCiencias() {
		return ciencias;
	}

	public void setCiencias(BigDecimal ciencias) {
		this.ciencias = ciencias;
	}

	public BigDecimal getAleman() {
		return aleman;
	}

	public void setAleman(BigDecimal aleman) {
		this.aleman = aleman;
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

	public Integer getNumeroMateria() {
		return numeroMateria;
	}

	public void setNumeroMateria(Integer numeroMateria) {
		this.numeroMateria = numeroMateria;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getNombreClase() {
		return "Estudiante";
	}

	// To String
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", numeroMateria=" + numeroMateria
				+ ", correo=" + correo + ", contrasenia=" + contrasenia + "]";
	}

}
