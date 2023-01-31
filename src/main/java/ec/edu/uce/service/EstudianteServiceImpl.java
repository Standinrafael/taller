package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.modelo.EstudianteSencillo;
import ec.edu.uce.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepo;

	@Override
	public void insertarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub

		this.estudianteRepo.insertarEstudiante(estudiante);
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub

		this.estudianteRepo.actualizarEstudiante(estudiante);
	}

	@Override
	public Estudiante buscarEstudiantePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarEstudiantePorId(id);
	}

	@Override
	public void eliminarEstudiantePorId(Integer id) {
		// TODO Auto-generated method stub

		this.estudianteRepo.eliminarEstudiantePorId(id);
	}

	@Override
	public Estudiante buscarEstudiantePorCorreo(String email) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarEstudiantePorCorreo(email);
	}

	@Override
	public List<Estudiante> listaEstudiantes(String curso, String paralelo) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.listaEstudiantes(curso, paralelo);
	}

}
