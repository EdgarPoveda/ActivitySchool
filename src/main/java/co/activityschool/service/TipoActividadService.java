package co.activityschool.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.activityschool.dto.TipoActividadesRequest;
import co.activityschool.entities.TipoActividades;
import co.activityschool.repository.TipoActividadesRepository;

@Service
public class TipoActividadService {

	@Autowired
	private TipoActividadesRepository tipoActividadesRepository;

	@Autowired
	private RolService rolService;

	public List<TipoActividades> obtenerTipoActividad() {
		return tipoActividadesRepository.findAll();
	}

	public TipoActividades obtenerTipoActividadesPorId(Long id) throws Exception {
		try{
			TipoActividades tipoActividades = tipoActividadesRepository.findById(id).get();
			return tipoActividades;
		}catch (Exception e) {
			throw new Exception("Tipo de actividad no encontrada");
		}
	}

	public TipoActividades crearTipoActividades(TipoActividadesRequest tipoActividadesRequest) throws Exception {
		try {
			TipoActividades tipoActividades = new TipoActividades();
			tipoActividades.setFechaCreacionTipoActividad(new Date());
			tipoActividades.setNombreTipoActividad(tipoActividadesRequest.getNombreTipoActividad());
			tipoActividades.setRol(rolService.obtenerRolPorId(tipoActividadesRequest.getIdRol()));
			return tipoActividadesRepository.save(tipoActividades);
		} catch (Exception e) {
			throw e;
		}
	}

}
