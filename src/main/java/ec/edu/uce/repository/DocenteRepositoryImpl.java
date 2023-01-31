package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Docente;

@Repository
@Transactional
public class DocenteRepositoryImpl implements IDocenteRepository {

	final static Logger LOGGER = Logger.getLogger(DocenteRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarDocente(Docente docente) {
		// TODO Auto-generated method stub

		this.entityManager.persist(docente);
	}

	@Override
	public void actualizarDocente(Docente docente) {
		// TODO Auto-generated method stub

		this.entityManager.merge(docente);
	}

	@Override
	public Docente buscarDocentePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Docente.class, id);
	}

	@Override
	public void eliminarDocentePorId(Integer id) {
		// TODO Auto-generated method stub

		Docente docenteEliminar = this.buscarDocentePorId(id);
		this.entityManager.remove(docenteEliminar);
	}

	@Override
	public Docente buscarDocentePorEmail(String email) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Docente> myQuery = this.entityManager
					.createQuery("select d from Docente d where d.correo=:email", Docente.class);
			myQuery.setParameter("email", email);
			return myQuery.getSingleResult();
		} catch (NoResultException e) {
			LOGGER.info("No se encontro docente con el email: " + email);
			return null;
		}
	}

}
