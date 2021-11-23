package co.activityschool.util;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.activityschool.dto.ActividadResponse;
import co.activityschool.dto.RolResponse;
import co.activityschool.dto.TipoActividadResponse;
import co.activityschool.dto.UsuarioCrearResponse;
import co.activityschool.dto.UsuarioResponse;
import co.activityschool.entities.Actividad;
import co.activityschool.entities.Rol;
import co.activityschool.entities.TipoActividades;
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
	
	public UsuarioCrearResponse convertirUsuarioCrear (Usuario usuario) {
		return modelMaper.map(usuario, UsuarioCrearResponse.class); 
	}
	
	public List<UsuarioResponse> convertirUsuarios(List<Usuario> usuarios) {
		return usuarios.stream().map(usuario -> convertirUsuario(usuario)).collect(Collectors.toList());
	}
	
	public TipoActividadResponse convertirTipoActividad(TipoActividades tipoActividades) {
		return modelMaper.map(tipoActividades, TipoActividadResponse.class);
	}
	
	public List<TipoActividadResponse> convertirTipoActividades(List<TipoActividades> tipoActividades) {
		return tipoActividades.stream().map(tipoActividad -> convertirTipoActividad(tipoActividad)).collect(Collectors.toList());
	}
	
	public ActividadResponse convertirActividad(Actividad actividad) {
		return modelMaper.map(actividad, ActividadResponse.class);
	}
	
	public List<ActividadResponse> convertirActividades(List<Actividad> actividades){
		return actividades.stream().map(actividad -> convertirActividad(actividad)).collect(Collectors.toList());
	}
}
