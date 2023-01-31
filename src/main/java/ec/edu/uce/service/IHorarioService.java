package ec.edu.uce.service;

import ec.edu.uce.modelo.Horario;

public interface IHorarioService {
	
	// Metodos CRUD

		public void insertarHorario(Horario horario);

		public void actualizarHorario(Horario horario);

		Horario buscarHorarioPorId(Integer id);

		public void eliminarHorarioPorId(Integer id);

}
