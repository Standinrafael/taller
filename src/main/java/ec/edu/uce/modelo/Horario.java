package ec.edu.uce.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_horario")
	@SequenceGenerator(name = "seq_horario", sequenceName = "seq_horario", allocationSize = 1)
	@Column(name = "hora_id")
	private Integer id;

	@Column(name = "hora_materia")
	private String materia;

	@Column(name = "hora_dia")
	private String dia;

	@Column(name = "hora_hora")
	private Integer hora;

	@OneToOne
	@JoinColumn(name = "hora_id_curso")
	private Curso curso;

	// Getters y Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	// To String
	@Override
	public String toString() {
		return "Horario [id=" + id + ", materia=" + materia + ", dia=" + dia + ", hora=" + hora + ", curso=" + curso
				+ "]";
	}

}
