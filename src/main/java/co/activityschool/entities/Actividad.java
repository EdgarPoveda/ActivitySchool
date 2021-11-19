package co.activityschool.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_actividad")
	private Long idActividad;
	@Column(name = "nombre_actividad", length = 30)
	private String nombreActividad;
	@Column(name = "fecha_creacion_actividad")
	private Date fechaCreacionActividad;
	@Column(name = "estado_actividad")
	private Boolean estadoActividad;
	@Column(name = "descripcion_actividad", length = 300)
	private String descripcionActividad;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
		
	@ManyToOne(cascade = CascadeType.ALL)
	private TipoActividades tipoActividad;
}
