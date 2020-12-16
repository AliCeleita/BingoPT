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
@Table(name = "bingo_param_figure")
@TypeDef(
	    name = "list-array",
	    typeClass = ListArrayType.class
	)
public class Figura{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer figure_id;
	
	@Column(name = "group_figure_id", nullable = false)
	private Integer group_figure_id;
	
	@Column(name = "figure_name", nullable = false, length = 100)
	@Size(min = 1, max = 100, message = "El nombre de la figura debe tener entre 1 y 100 cáracteres")
	private String figure_name;
	
	@Type(type = "list-array")
	@Column(name = "positions_winner", nullable = true, columnDefinition = "boolean[]")
	private List<Boolean> positions_winner;
	
	@Column(name = "status", nullable = false, length = 1)
	@Size(min = 1, max = 1, message = "Status debe tener solo 1 cáracter")
	private String status;
	
	@Column(name = "created_by", nullable = false)
	private Integer created_by;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
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
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "created_at", nullable = false)
	@Past(message = "La fecha debe ser menor a la actual")
    private Timestamp created_at;
	
	@Column(name = "used", nullable = false)
	private Boolean used;

	public Integer getFigure_id() {
		return figure_id;
	}

	public void setFigure_id(Integer figure_id) {
		this.figure_id = figure_id;
	}

	public Integer getGroup_figure_id() {
		return group_figure_id;
	}

	public void setGroup_figure_id(Integer group_figure_id) {
		this.group_figure_id = group_figure_id;
	}

	public String getFigure_name() {
		return figure_name;
	}

	public void setFigure_name(String figure_name) {
		this.figure_name = figure_name;
	}

	public List<Boolean> getPositions_winner() {
		return positions_winner;
	}

	public void setPositions_winner(List<Boolean> positions_winner) {
		this.positions_winner = positions_winner;
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

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

}
