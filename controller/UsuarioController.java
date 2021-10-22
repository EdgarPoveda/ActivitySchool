package co.activityschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.activityschool.dto.UsuarioCrearRequest;
import co.activityschool.dto.UsuarioLogin;
import co.activityschool.dto.UsuarioResponse;
import co.activityschool.service.UsuarioService;
import co.activityschool.util.EntidadToConverter;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EntidadToConverter entidadToConverter;
	
	@GetMapping(value = "usuarios")
	private List<UsuarioResponse> obtenerUsuarios(){
		return entidadToConverter.convertirUsuarios(usuarioService.obtenerUsuarios());
	}
	
	@GetMapping(value = "usuarios/{id}")
	private UsuarioResponse obtenerUsuarioPorID(@PathVariable Long id) {
		return entidadToConverter.convertirUsuario(usuarioService.obtenerUsusarioPorId(id));
	}
	
	@PostMapping(value = "login")
	private UsuarioResponse login(@RequestBody UsuarioLogin usuarioLogin) {
		return entidadToConverter.convertirUsuario(usuarioService.login(usuarioLogin));
	}
	
	@PostMapping(value = "usuarios")
	private UsuarioResponse crearUsuario(@RequestBody UsuarioCrearRequest usuarioCrearRequest) {
		return entidadToConverter.convertirUsuario(usuarioService.crearUsuario(usuarioCrearRequest));
	}

}
