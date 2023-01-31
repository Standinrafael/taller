package ec.edu.uce.repository;


import ec.edu.uce.modelo.Representante;

public interface IRepresentanteRepository {

	// Metodos CRUD

	public void insertarRepresentante(Representante representante);

	public void actualizarRepresentante(Representante representante);

	Representante buscarRepresentantePorId(Integer id);

	public void eliminarRepresentantePorId(Integer id);
	
	Representante buscarRepresentantePorEmail(String email);
}
