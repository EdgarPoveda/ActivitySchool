package co.activityschool.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.activityschool.dto.UsuarioCrearRequest;
import co.activityschool.dto.UsuarioEstablecerContrasenia;
import co.activityschool.dto.UsuarioLogin;
import co.activityschool.dto.UsuarioResponse;
import co.activityschool.service.UsuarioService;
import co.activityschool.util.EntidadToConverter;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EntidadToConverter entidadToConverter;

	@GetMapping(value = "usuarios")
	private ResponseEntity<?> obtenerUsuarios() {
		try {
			return new ResponseEntity<>(entidadToConverter.convertirUsuarios(usuarioService.obtenerUsuarios()),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "usuarios/{id}")
	private ResponseEntity<?> obtenerUsuarioPorID(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(entidadToConverter.convertirUsuario(usuarioService.obtenerUsusarioPorId(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "login")
	private ResponseEntity<?> login(@RequestBody UsuarioLogin usuarioLogin) {
		Map response = new HashMap();
		try {
			response.put("token", usuarioService.login(usuarioLogin));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "usuarios")
	private ResponseEntity<?> crearUsuario(@RequestBody UsuarioCrearRequest usuarioCrearRequest) {
		Map response = new HashMap();
		try {
			UsuarioResponse usuarioResponse = entidadToConverter.convertirUsuario(usuarioService.crearUsuario(usuarioCrearRequest));
			return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping(value = "usuario/{token}")
	private ResponseEntity<?> usuarioPorToken(@PathVariable String token) {
		Map response = new HashMap();
		try {
			return new ResponseEntity<>(entidadToConverter.convertirUsuario(usuarioService.usuarioPorIdAutomatico(token)), HttpStatus.OK);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "usuario/establecercontrasenia")
	public ResponseEntity<?> cambiarContrasenia(@RequestBody UsuarioEstablecerContrasenia usuarioEstablecerContrasenia){
		Map response = new HashMap();
		try {
			return new ResponseEntity<>(entidadToConverter.convertirUsuario(usuarioService.actualizarContrasenia(usuarioEstablecerContrasenia)), HttpStatus.OK);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

}
