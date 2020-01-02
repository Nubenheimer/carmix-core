package com.razrblade.traffic.carsharing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "homo_mobilis")
public class HomoMobilis {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table")
	@TableGenerator(name = "table", table = "id_generator", pkColumnName = "seq_id", valueColumnName = "hm_v")
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "office")
	private String office;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;
}
