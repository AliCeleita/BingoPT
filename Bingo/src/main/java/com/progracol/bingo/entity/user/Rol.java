package com.progracol.bingo.entity.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "bingo_rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rol_id;
	
	@Column(name = "name", nullable = false, length = 256)
	@Size(min = 3, max = 256, message = "El nombre del rol debe tener entre 3 y 256 cáracteres")
	private String name;
	
	@Column(name = "status", nullable = false, length = 1)
	@Size(min = 1, max = 1, message = "Status debe tener solo 1 cáracter")
	private String status;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "created_at", nullable = true)
	@Past(message = "La fecha debe ser menor a la actual")
    private Timestamp created_at;
	
	@Column(name = "created_by", nullable = true, length = 36)
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
	
	@Column(name = "readonly", nullable = true)
	private Integer readonly;

	public Integer getRol_id() {
		return rol_id;
	}

	public void setRol_id(Integer rol_id) {
		this.rol_id = rol_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Integer getReadonly() {
		return readonly;
	}

	public void setReadonly(Integer readonly) {
		this.readonly = readonly;
	}

}
