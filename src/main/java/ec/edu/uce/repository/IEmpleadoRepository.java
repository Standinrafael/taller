package ec.edu.uce.repository;

import ec.edu.uce.modelo.Empleado;
import ec.edu.uce.modelo.Representante;

public interface IEmpleadoRepository {

	// Metodos CRUD

	public void insertarEmpleado(Empleado empleado);

	public void actualizarEmpleado(Empleado empleado);

	Empleado buscarEmpleadoPorId(Integer id);

	public void eliminarEmpleadoPorId(Integer id);
	
	Empleado buscarEmpleadoPorEmail(String email);

}
