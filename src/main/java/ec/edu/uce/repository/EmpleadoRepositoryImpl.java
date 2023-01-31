package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Docente;
import ec.edu.uce.modelo.Empleado;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {

	final static Logger LOGGER = Logger.getLogger(EmpleadoRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub

		this.entityManager.persist(empleado);
	}

	@Override
	public void actualizarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub

		this.entityManager.merge(empleado);
	}

	@Override
	public Empleado buscarEmpleadoPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
	}

	@Override
	public void eliminarEmpleadoPorId(Integer id) {
		// TODO Auto-generated method stub
		Empleado empleadoEliminar=this.buscarEmpleadoPorId(id);
		this.entityManager.remove(empleadoEliminar);

	}

	@Override
	public Empleado buscarEmpleadoPorEmail(String email) {
		// TODO Auto-generated method stub
		
		try {
			TypedQuery<Empleado> myQuery = this.entityManager
					.createQuery("select e from Empleado e where e.correo=:email", Empleado.class);
			myQuery.setParameter("email", email);
			return myQuery.getSingleResult();
		} catch (NoResultException e) {
			LOGGER.info("No se encontro empleado con el email: " + email);
			return null;
		}
	}

}
