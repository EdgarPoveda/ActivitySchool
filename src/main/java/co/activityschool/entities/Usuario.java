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
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;
	@Column(name = "id_usuario_automatico")
	private String idUsuarioAutomatico;
	@Column(name = "nombre_usuario", length = 30)
	private String nombreUsuario;
	@Column(name = "cargo_usuario", length = 30)
	private String cargoUsuario;
	@Column(name = "fecha_creacion_usuario")
	private Date fechaCreacion;
	@Column(name = "identificacion_usuario", length = 30)
	private String identificacionUsuario;
	@Column(name = "contrasenia_usuario", length = 30)
	private String contraseniaUsuario;
	@Column(name = "cambio_contrasenia")
	private Boolean cambioContrasenia;
	

	@ManyToOne(cascade = CascadeType.ALL)
	private Rol rol;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Actividad> actividades; 
}	
