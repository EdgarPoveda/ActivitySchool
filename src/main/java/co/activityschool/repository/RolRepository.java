package co.activityschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.activityschool.entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
