package co.activityschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.activityschool.dto.RolCrearRequest;
import co.activityschool.dto.RolResponse;
import co.activityschool.service.RolService;
import co.activityschool.util.EntidadToConverter;

@RestController
@CrossOrigin(origins = "*")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@Autowired 
	private EntidadToConverter entidadToConverter;
	
	@GetMapping(value = "roles")
	private List<RolResponse> obtenerRoles(){
		return entidadToConverter.convertirRoles(rolService.obtenerRoles());
	}
	
	@GetMapping(value = "roles/{id}")
	private RolResponse obtenerRolPorId(@PathVariable Long id) {
		return entidadToConverter.convertirRol(rolService.obtenerRolPorId(id));
	}
	
	@PostMapping(value = "rol")
	private RolResponse crearRol(@RequestBody RolCrearRequest rolCrearRequest) {
		return entidadToConverter.convertirRol(rolService.crearRol(rolCrearRequest));
	}
}
