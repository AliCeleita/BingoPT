package com.progracol.bingo.entity.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.progracol.bingo.entity.user.Rol;

@Entity
@Table(name = "bingo_users")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	@Column(name = "names", nullable = false, length = 256)
	@Size(min = 3, max = 256, message = "El nombre del usuario debe tener entre 3 y 256 cáracteres")
	private String names;
	
	@Column(name = "last_names", nullable = false, length = 256)
	@Size(min = 3, max = 256, message = "La columna debe tener entre 3 y 256 cáracteres")
	private String last_names;
	
	@Column(name = "username", nullable = false, length = 512)
	@Size(min = 3, max = 512, message = "El usuario debe tener entre 3 y 512 cáracteres")
	private String username;
	
	@Column(name = "img_url", nullable = true, length = 2048)
	@Size(min = 10, max = 2048, message = "La url de la imagen debe tener entre 10 y 2048 cáracteres")
	private String img_url;
	
	@Column(name = "password", nullable = false, length = 512)
	@Size(min = 3, max = 512, message = "La contraseña debe tener entre 3 y 512 cáracteres")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "rol_id", foreignKey = @ForeignKey(name = "rol_id__fk"))
	private Rol rol;
	
	@Column(name = "status", nullable = false, length = 1)
	@Size(min = 1, max = 1, message = "Status debe tener solo 1 cáracter")
	private String status;
	
	@Column(name = "expired", nullable = true)
	private Boolean expired;

	@Column(name = "locked", nullable = true)
	private Boolean locked;

	@Column(name = "credrencials_expired", nullable = true)
	private Boolean credrencials_expired;
	
	@Column(name = "phone", nullable = true, length = 255)
	@Size(min = 8, max = 255, message = "El número de teléfono debe tener entre 8 y 255 cáracteres")
	private String phone;

	@Column(name = "position", nullable = true, length = 128)
	@Size(min = 1, max = 128, message = "La posición debe tener entre 1 y 128 cáracteres")
	private String position;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "created_at", nullable = false)
	@Past(message = "La fecha debe ser menor a la actual")
    private Timestamp created_at;
	
	@Column(name = "created_by", nullable = false, length = 36)
	@Size(min = 1, max = 36, message = "Creado por debe tener entre 1 y 36 cáracteres")
	private String created_by;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "last_updated_at", nullable = true)
	@Past(message = "La fecha debe ser menor a la actual")
    private Timestamp last_updated_at;
	
	@Column(name = "last_updated_by", nullable = true, length = 36)
	@Size(min = 1, max = 36, message = "La última actualización debe tener entre 1 y 36 cáracteres")
	private String last_updated_by;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "deleted_at", nullable = true)
	@Past(message = "La fecha debe ser menor a la actual")
    private Timestamp deleted_at;
	
	@Column(name = "deleted_by", nullable = true, length = 36)
	@Size(min = 1, max = 36, message = "Eliminado por debe tener entre 1 y 36 cáracteres")
	private String deleted_by;
	
	@Column(name = "cedula", nullable = true, length = 100)
	@Size(min = 8, max = 100, message = "La cédula del usuario debe tener entre 8 y 100 cáracteres")
	private String cedula;
	
	@Column(name = "customer_id", nullable = true)
	private Integer customer_id;
	
	@Column(name = "preregister", nullable = true)
	private Boolean preregister;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "nacimiento", nullable = true)
	@Past(message = "La fecha debe ser menor a la actual")
    private Timestamp nacimiento;
	
	@Column(name = "maxrecharge", nullable = true)
	private Integer maxrecharge;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLast_names() {
		return last_names;
	}

	public void setLast_names(String last_names) {
		this.last_names = last_names;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getExpired() {
		return expired;
	}

	public void setExpired(Boolean expired) {
		this.expired = expired;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getCredrencials_expired() {
		return credrencials_expired;
	}

	public void setCredrencials_expired(Boolean credrencials_expired) {
		this.credrencials_expired = credrencials_expired;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Timestamp getLast_updated_at() {
		return last_updated_at;
	}

	public void setLast_updated_at(Timestamp last_updated_at) {
		this.last_updated_at = last_updated_at;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Timestamp getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}

	public String getDeleted_by() {
		return deleted_by;
	}

	public void setDeleted_by(String deleted_by) {
		this.deleted_by = deleted_by;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public Boolean getPreregister() {
		return preregister;
	}

	public void setPreregister(Boolean preregister) {
		this.preregister = preregister;
	}

	public Timestamp getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Timestamp nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Integer getMaxrecharge() {
		return maxrecharge;
	}

	public void setMaxrecharge(Integer maxrecharge) {
		this.maxrecharge = maxrecharge;
	}

}
