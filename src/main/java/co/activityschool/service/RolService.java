package co.activityschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
