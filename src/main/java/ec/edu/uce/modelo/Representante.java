package ec.edu.uce.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "representante")
public class Representante {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_representante")
	@SequenceGenerator(name = "seq_representante", sequenceName = "seq_representante", allocationSize = 1)
	@Column(name = "repr_id")
	private Integer id;

	@Column(name = "repr_nombre")
	private String nombre;

	@Column(name = "repr_apellido")
	private String apellido;

	@Column(name = "repr_correo")
	private String correo;

	@Column(name = "repr_contrasenia")
	private String contrasenia;

	@Column(name = "repr_administrador")
	private Boolean isAdministrador ;

	@OneToMany(mappedBy = "representate", cascade = CascadeType.ALL)
	private List<Estudiante> estudiantes;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public Boolean getIsAdministrador() {
		return isAdministrador;
	}

	public void setIsAdministrador(Boolean isAdministrador) {
		this.isAdministrador = isAdministrador;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	// To String
	@Override
	public String toString() {
		return "Representante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", contrasenia=" + contrasenia + ", isAdministrador=" + isAdministrador + ", estudiantes="
				+ estudiantes + "]";
	}

}
