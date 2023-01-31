package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Docente;
import ec.edu.uce.repository.IDocenteRepository;

@Service
public class DocenteServiceImpl implements IDocenteService {

	@Autowired
	private IDocenteRepository docenteRepo;

	@Override
	public void insertarDocente(Docente docente) {
		// TODO Auto-generated method stub

		this.docenteRepo.insertarDocente(docente);
	}

	@Override
	public void actualizarDocente(Docente docente) {
		// TODO Auto-generated method stub

		this.docenteRepo.actualizarDocente(docente);
	}

	@Override
	public Docente buscarDocentePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.docenteRepo.buscarDocentePorId(id);
	}

	@Override
	public void eliminarDocentePorId(Integer id) {
		// TODO Auto-generated method stub

		this.docenteRepo.eliminarDocentePorId(id);
	}

	@Override
	public Docente buscarDocentePorEmail(String email) {
		// TODO Auto-generated method stub
		return this.docenteRepo.buscarDocentePorEmail(email);
	}

}
