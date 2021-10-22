package co.activityschool.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.activityschool.dto.RolCrearRequest;
import co.activityschool.entities.Rol;
import co.activityschool.repository.RolRepository;

@Service
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	public List<Rol> obtenerRoles(){
		return rolRepository.findAll();
	}
	
	public Rol obtenerRolPorId(Long id) {
		return rolRepository.findById(id).get();
	}
	
	public Rol crearRol(RolCrearRequest rolCrearRequest) {
		Rol rol = new Rol();
		rol.setEstado(true);
		rol.setFechaCreacion(new Date());
		rol.setRol(rolCrearRequest.getRol());
		return rolRepository.save(rol);
		
	}
}
