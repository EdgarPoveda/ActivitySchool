package co.activityschool.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoActividadResponse {

	private Long idTipoActividad;
	private String nombreTipoActividad;
	private Date fechaCreacionTipoActividad;
	private RolResponse rol;
}
