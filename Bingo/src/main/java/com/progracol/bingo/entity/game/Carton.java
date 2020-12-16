package com.progracol.bingo.entity.game;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vladmihalcea.hibernate.type.array.ListArrayType;

@Entity
@Table(name = "bingo_param_board")
@TypeDef(
	    name = "list-array",
	    typeClass = ListArrayType.class
	)
public class Carton {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer board_id;
	
	@Type(type = "list-array")
	@Column(name = "board_numbers", nullable = false, columnDefinition = "integer[]")
	private List<Integer> board_numbers;
	
	@Column(name = "status", nullable = false, length = 1)
	@Size(min = 1, max = 1, message = "Status debe tener solo 1 cáracter")
	private String status;
	
	@Column(name = "created_by", nullable = true)
	private Integer created_by;
	
	@Column(name = "last_updated_at", nullable = true)
	@Past(message = "La fecha debe ser menor a la actual")
    private Timestamp last_updated_at;
	
	@Column(name = "last_updated_by", nullable = true)
	private Integer last_updated_by;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "deleted_at", nullable = true)
	@Past(message = "La fecha debe ser menor a la actual")
    private Timestamp deleted_at;
	
	@Column(name = "deleted_by", nullable = true)
	private Integer deleted_by;
	
	@Column(name = "created_at", nullable = true)
	@Past(message = "La fecha debe ser menor a la actual")
    private Timestamp created_at;
	
	@Type(type = "list-array")
	@Column(name = "sensor_values", nullable = true, columnDefinition = "integer[]")
	private List<Integer> sensor_values;

	public Integer getBoard_id() {
		return board_id;
	}

	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}

	public List<Integer> getBoard_numbers() {
		return board_numbers;
	}

	public void setBoard_numbers(List<Integer> board_numbers) {
		this.board_numbers = board_numbers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public Timestamp getLast_updated_at() {
		return last_updated_at;
	}

	public void setLast_updated_at(Timestamp last_updated_at) {
		this.last_updated_at = last_updated_at;
	}

	public Integer getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(Integer last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Timestamp getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}

	public Integer getDeleted_by() {
		return deleted_by;
	}

	public void setDeleted_by(Integer deleted_by) {
		this.deleted_by = deleted_by;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public List<Integer> getSensor_values() {
		return sensor_values;
	}

	public void setSensor_values(List<Integer> sensor_values) {
		this.sensor_values = sensor_values;
	}

}
