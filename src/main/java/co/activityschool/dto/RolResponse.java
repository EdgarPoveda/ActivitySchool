package co.activityschool.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolResponse {
	private Long idRol;
	private String rol;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Boolean estado;
	
}
