package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Horario;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository {

	final static Logger LOGGER = Logger.getLogger(HorarioRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarHorario(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(horario);
	}

	@Override
	public void actualizarHorario(Horario horario) {
		// TODO Auto-generated method stub

		this.entityManager.merge(horario);
	}

	@Override
	public Horario buscarHorarioPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public void eliminarHorarioPorId(Integer id) {
		// TODO Auto-generated method stub
		Horario horarioEliminar=this.buscarHorarioPorId(id);
		this.entityManager.remove(horarioEliminar);

	}

}
