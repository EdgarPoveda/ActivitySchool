package co.activityschool.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.activityschool.controller.RolController;
import co.activityschool.dto.RolResponse;
import co.activityschool.dto.UsuarioResponse;
import co.activityschool.entities.Rol;
import co.activityschool.entities.Usuario;

@Component
public class EntidadToConverter {
	
	@Autowired
	private ModelMapper modelMaper;
	
	public RolResponse convertirRol(Rol rol) {
		return modelMaper.map(rol, RolResponse.class);
	}
	
	public List<RolResponse> convertirRoles(List<Rol> roles) {
		return roles.stream().map(rol -> convertirRol(rol)).collect(Collectors.toList());
	}
	
	public UsuarioResponse convertirUsuario(Usuario usuario) {
		return modelMaper.map(usuario, UsuarioResponse.class);
	}
	
	public List<UsuarioResponse> convertirUsuarios(List<Usuario> usuarios) {
		return usuarios.stream().map(usuario -> convertirUsuario(usuario)).collect(Collectors.toList());
	}
}
