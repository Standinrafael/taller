package ec.edu.uce.service;

import ec.edu.uce.modelo.Empleado;

public interface IEmpleadoService {
	
	// Metodos CRUD

		public void insertarEmpleado(Empleado empleado);

		public void actualizarEmpleado(Empleado empleado);

		Empleado buscarEmpleadoPorId(Integer id);

		public void eliminarEmpleadoPorId(Integer id);
		
		Empleado buscarEmpleadoPorEmail(String email);

}
