package co.activityschool.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
	
	private Long idUsuario;
	private String nombreUsuario;
	private String cargoUsuario;
	private Date fechaCreacion;
	private String identificacionUsuario;
	private Boolean cambioContrasenia;
	
	private RolResponse rol;
}
