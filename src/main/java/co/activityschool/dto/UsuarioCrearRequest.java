package co.activityschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCrearRequest {

	private String nombreUsuario;
	private String cargoUsuario;
	private String identificacionUsuario;
	
	private Long idRol;
}
