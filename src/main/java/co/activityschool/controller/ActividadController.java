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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.activityschool.dto.ActividadActualizarRequest;
import co.activityschool.dto.ActividadCrearRequest;
import co.activityschool.dto.ActividadResponse;
import co.activityschool.entities.Actividad;
import co.activityschool.service.ActividadService;
import co.activityschool.util.EntidadToConverter;

@RestController
@CrossOrigin(origins = "*")
public class ActividadController {
	
	@Autowired
	private ActividadService actividadService;
	
	@Autowired
	private EntidadToConverter entidadToConverter;
	
	@GetMapping(value = "actividad")
	public List<ActividadResponse> obtenerActividades(){
		return entidadToConverter.convertirActividades(actividadService.obtenerActividades());
	}

	@GetMapping(value = "actividad/{id}")
	public ResponseEntity<?> obtenerActividadPorId(@PathVariable Long id) {
		Map response = new HashMap();
		try {
			ActividadResponse actividad = entidadToConverter.convertirActividad(actividadService.obtenerActividadPorId(id));
			return new ResponseEntity<>(actividad, HttpStatus.OK);
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "actividad/usuario/{idUsuario}")
	public ResponseEntity<?> obtenerActividadPorUsuario(@PathVariable Long idUsuario){
		Map response = new HashMap();
		try {
			List<ActividadResponse> actividad = entidadToConverter.convertirActividades(actividadService.consultarActividadPorUsuario(idUsuario));
			return new ResponseEntity<>(actividad, HttpStatus.OK);
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "actividad")
	public ResponseEntity<?> crearActividad(@RequestBody ActividadCrearRequest actividadCrearRequest){
		Map response = new HashMap();
		try {
			ActividadResponse actividad = entidadToConverter.convertirActividad(actividadService.crearActividad(actividadCrearRequest));
			return new ResponseEntity<>(actividad, HttpStatus.OK);
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "actividad")
	public ResponseEntity<?> actualizarActividad(@RequestBody ActividadActualizarRequest actividadActualizarRequest){
		Map response = new HashMap();
		try {
			ActividadResponse actividad = entidadToConverter.convertirActividad(actividadService.actualizarActividad(actividadActualizarRequest));
			return new ResponseEntity<>(actividad, HttpStatus.OK);
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
