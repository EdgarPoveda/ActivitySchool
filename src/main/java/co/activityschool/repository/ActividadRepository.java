package co.activityschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.activityschool.entities.Actividad;
import co.activityschool.entities.Usuario;

public interface ActividadRepository extends JpaRepository<Actividad, Long> {
	
	public List<Actividad> findByUsuario(Usuario usuario);
}
	