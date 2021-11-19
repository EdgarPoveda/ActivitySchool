package co.activityschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoActividadesRequest {

	private String nombreTipoActividad;
	private Long idRol;
}
