package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Materia;
import ec.edu.uce.repository.IMateriaRepository;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepo;

	@Override
	public void insertarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepo.insertarMateria(materia);

	}

	@Override
	public void actualizarMateria(Materia materia) {
		// TODO Auto-generated method stub

		this.materiaRepo.actualizarMateria(materia);
	}

	@Override
	public Materia buscarMateriaPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepo.buscarMateriaPorId(id);
	}

	@Override
	public void eliminarMateriaPorId(Integer id) {
		// TODO Auto-generated method stub

		this.materiaRepo.eliminarMateriaPorId(id);
	}

}
