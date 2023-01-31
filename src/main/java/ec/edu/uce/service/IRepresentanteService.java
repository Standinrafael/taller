package ec.edu.uce.service;

import ec.edu.uce.modelo.Representante;

public interface IRepresentanteService {
	
	// Metodos CRUD

		public void insertarRepresentante(Representante representante);

		public void actualizarRepresentante(Representante representante);

		Representante buscarRepresentantePorId(Integer id);

		public void eliminarRepresentantePorId(Integer id);
		
		Representante buscarRepresentantePorEmail(String email);

}
