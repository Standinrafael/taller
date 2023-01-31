package ec.edu.uce.repository;

import ec.edu.uce.modelo.Horario;

public interface IHorarioRepository {

	// Metodos CRUD

	public void insertarHorario(Horario horario);

	public void actualizarHorario(Horario horario);

	Horario buscarHorarioPorId(Integer id);

	public void eliminarHorarioPorId(Integer id);

}
