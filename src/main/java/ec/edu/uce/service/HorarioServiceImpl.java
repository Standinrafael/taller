package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Horario;
import ec.edu.uce.repository.IHorarioRepository;

@Service
public class HorarioServiceImpl implements IHorarioService {

	@Autowired
	private IHorarioRepository horarioRepo;
	
	@Override
	public void insertarHorario(Horario horario) {
		// TODO Auto-generated method stub

		this.horarioRepo.insertarHorario(horario);
	}

	@Override
	public void actualizarHorario(Horario horario) {
		// TODO Auto-generated method stub

		this.horarioRepo.actualizarHorario(horario);
	}

	@Override
	public Horario buscarHorarioPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.horarioRepo.buscarHorarioPorId(id);
	}

	@Override
	public void eliminarHorarioPorId(Integer id) {
		// TODO Auto-generated method stub

		this.horarioRepo.eliminarHorarioPorId(id);
	}

}
