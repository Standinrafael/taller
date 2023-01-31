package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Curso;
import ec.edu.uce.repository.ICursoRepository;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private ICursoRepository cursoRepo;

	@Override
	public void insertarCurso(Curso curso) {
		// TODO Auto-generated method stub
		this.cursoRepo.insertarCurso(curso);

	}

	@Override
	public void actualizarCurso(Curso curso) {
		// TODO Auto-generated method stub
		this.cursoRepo.actualizarCurso(curso);

	}

	@Override
	public Curso buscarCursoPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.cursoRepo.buscarCursoPorId(id);
	}

	@Override
	public void eliminarCursoPorId(Integer id) {
		// TODO Auto-generated method stub

		this.cursoRepo.eliminarCursoPorId(id);
	}

	@Override
	public Curso buscarCursoPorParalelo(String nombre, String paralelo) {
		// TODO Auto-generated method stub
		return this.cursoRepo.buscarCursoPorParalelo(nombre, paralelo);
	}

}
