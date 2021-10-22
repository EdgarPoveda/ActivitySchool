package co.activityschool.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.activityschool.dto.UsuarioCrearRequest;
import co.activityschool.dto.UsuarioLogin;
import co.activityschool.entities.Usuario;
import co.activityschool.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolService rolService;

	public List<Usuario> obtenerUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario obtenerUsusarioPorId(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public Usuario login(UsuarioLogin usuarioLogin) {
		Usuario usuario = usuarioRepository.findByIdentificacionUsuario(usuarioLogin.getIdentificacionUsuario());
		if(usuario.getContraseniaUsuario().equals(usuarioLogin.getContrasenia())) {
			return usuario;
		}else {
			return null;
		}
	}
	
	public Usuario crearUsuario(UsuarioCrearRequest usuarioCrearRequest) {
		Usuario usuario = new Usuario();
		usuario.setCargoUsuario(usuarioCrearRequest.getCargoUsuario());
		usuario.setFechaCreacion(new Date());
		usuario.setIdentificacionUsuario(usuarioCrearRequest.getIdentificacionUsuario());
		usuario.setNombreUsuario(usuarioCrearRequest.getNombreUsuario());
		usuario.setRol(rolService.obtenerRolPorId(usuarioCrearRequest.getIdRol()));
		return usuarioRepository.save(usuario);
	}
}
