package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Empleado;
import ec.edu.uce.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepo;

	@Override
	public void insertarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub

		this.empleadoRepo.insertarEmpleado(empleado);
	}

	@Override
	public void actualizarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.actualizarEmpleado(empleado);
	}

	@Override
	public Empleado buscarEmpleadoPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.buscarEmpleadoPorId(id);
	}

	@Override
	public void eliminarEmpleadoPorId(Integer id) {
		// TODO Auto-generated method stub

		this.empleadoRepo.eliminarEmpleadoPorId(id);
	}

	@Override
	public Empleado buscarEmpleadoPorEmail(String email) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.buscarEmpleadoPorEmail(email);
	}

}
