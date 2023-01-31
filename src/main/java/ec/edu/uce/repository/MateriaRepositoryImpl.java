package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Materia;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);

	}

	@Override
	public void actualizarMateria(Materia materia) {
		// TODO Auto-generated method stub

		this.entityManager.merge(materia);
	}

	@Override
	public Materia buscarMateriaPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public void eliminarMateriaPorId(Integer id) {
		// TODO Auto-generated method stub
		Materia materiaEliminar = this.buscarMateriaPorId(id);
		this.entityManager.remove(materiaEliminar);

	}

}
