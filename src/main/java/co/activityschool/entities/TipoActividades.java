package co.activityschool.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoActividades {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_actividad")
	private Long idTipoActividad;
	@Column(name = "nombre_tipo_actividad", length = 30)
	private String nombreTipoActividad;
	@Column(name = "fecha_creacion_tipo_actividad")
	private Date fechaCreacionTipoActividad;
	@Column(name = "fecha_modificacion_tipo_actividad")
	private Date fechaModificacionTipoActividad;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Rol rol;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tipoActividad")
	private List<Actividad> actividades;
}
