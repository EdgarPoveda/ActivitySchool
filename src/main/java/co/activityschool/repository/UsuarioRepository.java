package co.activityschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.activityschool.entities.Usuario;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByIdentificacionUsuario(String identificacionUsuario);
}
