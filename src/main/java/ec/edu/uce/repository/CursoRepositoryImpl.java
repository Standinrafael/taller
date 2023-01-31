package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Curso;

@Repository
@Transactional
public class CursoRepositoryImpl implements ICursoRepository {

	final static Logger LOGGER = Logger.getLogger(CursoRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarCurso(Curso curso) {
		// TODO Auto-generated method stub
		this.entityManager.persist(curso);

	}

	@Override
	public void actualizarCurso(Curso curso) {
		// TODO Auto-generated method stub
		this.entityManager.merge(curso);

	}

	@Override
	public Curso buscarCursoPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Curso.class, id);
	}

	@Override
	public void eliminarCursoPorId(Integer id) {
		// TODO Auto-generated method stub
		Curso cursoEliminar = this.buscarCursoPorId(id);
		this.entityManager.remove(cursoEliminar);

	}

	@Override
	public Curso buscarCursoPorParalelo(String nombre, String paralelo) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Curso> myQuery = this.entityManager
					.createQuery("select c from Curso c where c.nombre=:nombre and c.paralelo=:paralelo", Curso.class);
			myQuery.setParameter("nombre", nombre);
			myQuery.setParameter("paralelo", paralelo);
			return myQuery.getSingleResult();
		} catch (NoResultException e) {
			LOGGER.info("No se encontro el curso");
			return null;
		}
	}

}
