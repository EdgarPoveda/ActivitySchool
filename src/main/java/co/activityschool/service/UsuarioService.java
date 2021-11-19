package co.activityschool.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.activityschool.dto.UsuarioCrearRequest;
import co.activityschool.dto.UsuarioEstablecerContrasenia;
import co.activityschool.dto.UsuarioLogin;
import co.activityschool.entities.Usuario;
import co.activityschool.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolService rolService;

	private final int TAMANIO_CONTRASENIA = 8;
	private final Boolean CAMBIO_CONTRASENIA = false;

	public List<Usuario> obtenerUsuarios() throws Exception {
		List<Usuario> usuarios = usuarioRepository.findAll();
		if (!usuarios.isEmpty()) {
			return usuarios;
		}
		throw new Exception("No hay usuarios registrados");
	}

	public Usuario obtenerUsusarioPorId(Long id) throws Exception {
		try {
			Usuario usuario = usuarioRepository.findById(id).get();
			return usuario;
		} catch (Exception e) {
			throw new Exception("Usuario no encontrado");
		}
	}

	public String login(UsuarioLogin usuarioLogin) throws Exception {
		Usuario usuario = usuarioRepository.findByIdentificacionUsuario(usuarioLogin.getIdentificacionUsuario());
		if (usuario.getContraseniaUsuario().equals(usuarioLogin.getContrasenia())) {
			return usuario.getIdUsuarioAutomatico();
		}
		throw new Exception("Credenciales invalidas");

	}

	public Usuario crearUsuario(UsuarioCrearRequest usuarioCrearRequest) throws Exception {
		try {
			Usuario usuario = new Usuario();
			usuario.setCargoUsuario(usuarioCrearRequest.getCargoUsuario());
			usuario.setFechaCreacion(new Date());
			usuario.setIdentificacionUsuario(usuarioCrearRequest.getIdentificacionUsuario());
			usuario.setIdUsuarioAutomatico(UUID.randomUUID().toString());
			usuario.setContraseniaUsuario(contraseniaAutomatica(TAMANIO_CONTRASENIA));
			usuario.setNombreUsuario(usuarioCrearRequest.getNombreUsuario());
			usuario.setRol(rolService.obtenerRolPorId(usuarioCrearRequest.getIdRol()));
			usuario.setCambioContrasenia(CAMBIO_CONTRASENIA);
			return usuarioRepository.save(usuario);
		} catch (Exception e) {
			throw e;
		}
	}

	public Usuario usuarioPorIdAutomatico(String token) throws Exception {
		Usuario usuario = usuarioRepository.findByIdUsuarioAutomatico(token);
		if (usuario != null) {
			return usuario;
		}
		throw new Exception("Token no encontrado");
	}

	public Usuario actualizarContrasenia(UsuarioEstablecerContrasenia usuarioEstablecerContrasenia) throws Exception {
		try{
			Usuario usuario = obtenerUsusarioPorId(usuarioEstablecerContrasenia.getIdUsuario());
			if(usuario.getCambioContrasenia())throw new Exception("Contraseña establecida previamente");
			usuario.setContraseniaUsuario(usuarioEstablecerContrasenia.getContraseniaUsuario());
			usuario.setCambioContrasenia(!CAMBIO_CONTRASENIA);
			return usuarioRepository.save(usuario);
		}catch (Exception e) {
			throw e;
		}
	}

	private static String contraseniaAutomatica(int n) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

}
