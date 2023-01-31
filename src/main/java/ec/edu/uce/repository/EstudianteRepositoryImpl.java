package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.modelo.EstudianteSencillo;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	final static Logger LOGGER = Logger.getLogger(EstudianteRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);

	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub

		this.entityManager.merge(estudiante);
	}

	@Override
	public Estudiante buscarEstudiantePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void eliminarEstudiantePorId(Integer id) {
		// TODO Auto-generated method stub

		Estudiante estudianteEliminar = this.buscarEstudiantePorId(id);
		this.entityManager.remove(estudianteEliminar);
	}

	@Override
	public Estudiante buscarEstudiantePorCorreo(String email) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Estudiante> myQuery = this.entityManager
					.createQuery("select e from Estudiante e where e.correo=:email", Estudiante.class);
			myQuery.setParameter("email", email);
			return myQuery.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("");
			return null;
		}
	}

	@Override
	public List<Estudiante> listaEstudiantes(String curso, String paralelo) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery(
				"select e from Estudiante e JOIN FETCH e.curso c where c.nombre=:curso and c.paralelo=:paralelo",
				Estudiante.class);
		myQuery.setParameter("curso", curso);
		myQuery.setParameter("paralelo", paralelo);
		return myQuery.getResultList();
	}

}
