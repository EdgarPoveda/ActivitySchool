package co.activityschool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.activityschool.dto.ActividadActualizarRequest;
import co.activityschool.dto.ActividadCrearRequest;
import co.activityschool.entities.Actividad;
import co.activityschool.entities.Usuario;
import co.activityschool.repository.ActividadRepository;

@Service
public class ActividadService {

	@Autowired
	private ActividadRepository actividadRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TipoActividadService tipoActividadService;

	public List<Actividad> obtenerActividades() {
		return actividadRepository.findAll();
	}

	public Actividad obtenerActividadPorId(Long id) throws Exception {
		try {
			Actividad actividad = actividadRepository.findById(id).get();
			return actividad;
		} catch (Exception e) {
			throw new Exception("Actividad no encontrada");
		}
	}

	public Actividad crearActividad(ActividadCrearRequest actividadCrearRequest) throws Exception {
		try {
			Actividad actividad = new Actividad();
			actividad.setEstadoActividad(true);
			actividad.setFechaCreacionActividad(new Date());
			actividad.setNombreActividad(actividadCrearRequest.getNombreActividad());
			actividad.setTipoActividad(
					tipoActividadService.obtenerTipoActividadesPorId(actividadCrearRequest.getIdTipoActividad()));
			actividad.setUsuario(usuarioService.obtenerUsusarioPorId(actividadCrearRequest.getIdUsuario()));
			actividad.setDescripcionActividad(actividadCrearRequest.getDescripcionActividad());
			return actividadRepository.save(actividad);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Actividad> consultarActividadPorUsuario(Long idUsuario) throws Exception {
		try {
			Usuario usuario = usuarioService.obtenerUsusarioPorId(idUsuario);
			List<Actividad> actividades = new ArrayList<>();
			for (Actividad actividad : actividadRepository.findByUsuario(usuario)) {
				if (actividad.getEstadoActividad()) {
					actividades.add(actividad);
				}
			}
			if(actividades.isEmpty())throw new Exception("");
			return actividades;
		} catch (Exception e) {
			throw new Exception("No hay actividades relacionadas al usuario: " + idUsuario);
		}
	}
	
	public Actividad actualizarActividad(ActividadActualizarRequest actividadActualizarRequest) throws Exception {
		try{
			Actividad actividad = obtenerActividadPorId(actividadActualizarRequest.getIdActividad());	
		actividad.setEstadoActividad(actividadActualizarRequest.getEstadoActividad());
		return actividadRepository.save(actividad);
		}catch (Exception e) {
			throw new Exception("No se pudo actualizar la actividad");
		}
		
	}
}