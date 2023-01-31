package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Representante;
import ec.edu.uce.repository.IRepresentanteRepository;

@Service
public class RepresentanteServiceImpl implements IRepresentanteService {

	@Autowired
	private IRepresentanteRepository representanteRepo;
	
	@Override
	public void insertarRepresentante(Representante representante) {
		// TODO Auto-generated method stub

		this.representanteRepo.insertarRepresentante(representante);
	}

	@Override
	public void actualizarRepresentante(Representante representante) {
		// TODO Auto-generated method stub

		this.representanteRepo.actualizarRepresentante(representante);
	}

	@Override
	public Representante buscarRepresentantePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.representanteRepo.buscarRepresentantePorId(id);
	}

	@Override
	public void eliminarRepresentantePorId(Integer id) {
		// TODO Auto-generated method stub

		this.representanteRepo.eliminarRepresentantePorId(id);
	}

	@Override
	public Representante buscarRepresentantePorEmail(String email) {
		// TODO Auto-generated method stub
		return this.representanteRepo.buscarRepresentantePorEmail(email);
	}

}
