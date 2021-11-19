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

import co.activityschool.dto.TipoActividadResponse;
import co.activityschool.dto.TipoActividadesRequest;
import co.activityschool.service.TipoActividadService;
import co.activityschool.util.EntidadToConverter;

@RestController
@CrossOrigin(origins = "*")
public class TipoActividadController {

	@Autowired
	private TipoActividadService tipoActividadService;
	
	@Autowired
	private EntidadToConverter entidadToConverter;
	
	@GetMapping(value = "tipoactividades")
	public List<TipoActividadResponse> obtenerTipoActividades(){
		return entidadToConverter.convertirTipoActividades(tipoActividadService.obtenerTipoActividad());
	}
	
	@GetMapping(value = "tipoactividades/{id}")
	public ResponseEntity<?> obtenerTipoActividadPorId(@PathVariable Long id){
		Map response = new HashMap();
		try {
			TipoActividadResponse tipoActividadResponse = entidadToConverter.convertirTipoActividad(tipoActividadService.obtenerTipoActividadesPorId(id));
			return new ResponseEntity<>(tipoActividadResponse, HttpStatus.OK);
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "tipoactividades")
	public ResponseEntity<?> crearTipoActividades(@RequestBody TipoActividadesRequest tipoActividadesRequest){
		Map response = new HashMap();
		try {
			TipoActividadResponse tipoActividadResponse = entidadToConverter.convertirTipoActividad(tipoActividadService.crearTipoActividades(tipoActividadesRequest));
			return new ResponseEntity<>(tipoActividadResponse, HttpStatus.OK);
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
