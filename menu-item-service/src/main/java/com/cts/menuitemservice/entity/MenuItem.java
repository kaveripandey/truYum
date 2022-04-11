package com.cts.menuitemservice.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
//@EqualsAndHashCode
@Table(name="menu_item")
public class MenuItem {
	@Id
	private long id;
	private String name;
	private float price;
	private boolean active;
	
	@Column(name="date_of_launch")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfLaunch;
	private String category;
	@Column(name="free_delivery")
	private boolean freeDelivery;
	
}
