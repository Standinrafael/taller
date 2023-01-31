package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_curso")
	@SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso", allocationSize = 1)

	@Column(name = "curs_id")
	private Integer id;

	@Column(name = "curs_nombre")
	private String nombre;

	@Column(name = "curs_paralelo")
	private String paralelo;

	@ElementCollection
	private List<BigDecimal> promedio;

	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private List<Estudiante> estudiantes;

	@JoinTable(name = "curso_docente", joinColumns = @JoinColumn(name = "fk_curso", nullable = false), inverseJoinColumns = @JoinColumn(name = "fk_docente", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Docente> listaDocente;

	@OneToOne(mappedBy = "curso", cascade = CascadeType.ALL)
	private Horario horario;

	// Metodos Get y Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getParalelo() {
		return paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public List<BigDecimal> getPromedio() {
		return promedio;
	}

	public void setPromedio(List<BigDecimal> promedio) {
		this.promedio = promedio;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public List<Docente> getListaDocente() {
		return listaDocente;
	}

	public void setListaDocente(List<Docente> listaDocente) {
		this.listaDocente = listaDocente;
	}

	// To String
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", paralelo=" + paralelo + "]";
	}

}
