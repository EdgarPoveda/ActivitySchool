package co.activityschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadActualizarRequest {
	
	private Long idActividad;
	private Boolean estadoActividad;
}
