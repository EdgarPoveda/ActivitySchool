package co.activityschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.activityschool.entities.TipoActividades;

@Repository
public interface TipoActividadesRepository extends JpaRepository<TipoActividades, Long> {

}
