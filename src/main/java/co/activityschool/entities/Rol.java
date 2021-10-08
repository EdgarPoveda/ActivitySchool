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
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//Getters y Setters 
@Data
//crear constructor con todos lo argumentos
@AllArgsConstructor
//crear sin argumentos
@NoArgsConstructor
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Long idRol;
	@Column(name = "rol", length = 30)
	private String rol;
	@Column(name = "fecha_creacion_rol")
	private Date fechaCreacion;
	@Column(name = "fecha_modificacion_rol")
	private Date fechaModificacion;
	@Column(name = "estado_rol")
	private Boolean estado;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "rol")	
	private List<Usuario> usuarios;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "rol")		
	private List<TipoActividades> tipoActividades;
}
