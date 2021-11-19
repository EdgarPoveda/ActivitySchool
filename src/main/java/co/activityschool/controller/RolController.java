package co.activityschool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	private ResponseEntity<?> obtenerRolPorId(@PathVariable Long id) {
		Map response = new HashMap();
		try {
			RolResponse rolResponse = entidadToConverter.convertirRol(rolService.obtenerRolPorId(id));
			return new ResponseEntity<>(rolResponse, HttpStatus.OK);
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping(value = "rol")
	private ResponseEntity<?> crearRol(@RequestBody RolCrearRequest rolCrearRequest) {
		Map response = new HashMap();
		try {
			RolResponse rolResponse = entidadToConverter.convertirRol(rolService.crearRol(rolCrearRequest));
			return new ResponseEntity<>(rolResponse, HttpStatus.OK);
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
	}
}
