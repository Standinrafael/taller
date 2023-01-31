package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Docente;
import ec.edu.uce.modelo.Representante;

@Repository
@Transactional
public class RepresentanteRepositoryImpl implements IRepresentanteRepository {

	final static Logger LOGGER = Logger.getLogger(RepresentanteRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarRepresentante(Representante representante) {
		// TODO Auto-generated method stub

		this.entityManager.persist(representante);
	}

	@Override
	public void actualizarRepresentante(Representante representante) {
		// TODO Auto-generated method stub

		this.entityManager.merge(representante);
	}

	@Override
	public Representante buscarRepresentantePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Representante.class, id);
	}

	@Override
	public void eliminarRepresentantePorId(Integer id) {
		// TODO Auto-generated method stub
		Representante repreEliminar=this.buscarRepresentantePorId(id);
		this.entityManager.remove(repreEliminar);

	}

	@Override
	public Representante buscarRepresentantePorEmail(String email) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Representante> myQuery = this.entityManager
					.createQuery("select r from Representante r where r.correo=:email", Representante.class);
			myQuery.setParameter("email", email);
			return myQuery.getSingleResult();
		} catch (NoResultException e) {
			LOGGER.info("No se encontro representante con el email: " + email);
			return null;
		}
	}

}
