package co.activityschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLogin {

	private String identificacionUsuario;
	private String Contrasenia;
}
