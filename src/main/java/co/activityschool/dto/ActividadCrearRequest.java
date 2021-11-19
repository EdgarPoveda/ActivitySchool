package co.activityschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadCrearRequest {

	private String nombreActividad;
	private Long idUsuario;
	private Long idTipoActividad;
	private String descripcionActividad;
	
}
