package co.activityschool.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadResponse {
	
	private Long idActividad;
	private String nombreActividad;
	private Date fechaCreacionActividad;
	private Boolean estadoActividad;
	private String descripcionActividad; 
	
	private UsuarioResponse usuario;
	private TipoActividadResponse tipoActividad;
}
