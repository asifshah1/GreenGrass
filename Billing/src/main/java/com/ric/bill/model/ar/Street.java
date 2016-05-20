package com.ric.bill.model.ar;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ric.bill.MeterManagable;
import com.ric.bill.Storable;
import com.ric.bill.model.bs.Base;

/**
 * Улица
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "STREET", schema="AR")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class Street extends Base implements java.io.Serializable {

	public Street() {
	}

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_STREET", referencedColumnName="ID")
	private Set<House> house = new HashSet<House>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_AREA", referencedColumnName="ID", updatable = false)
	private Area area;

	// наименование улицы
	@Column(name = "NAME", nullable = true)
	private String name; 
	
	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<House> getHouse() {
		return house;
	}

	public void setHouse(Set<House> house) {
		this.house = house;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


}