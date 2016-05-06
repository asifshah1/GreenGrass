package com.ric.bill.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

/**
 * Класс - Дом
 * @author lev
 *
 */
@Entity
@Table(name = "HOUSE", schema="AR")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class House extends Base implements java.io.Serializable, Storable {

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	private Integer klsk; // klsk объекта

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_K_LSK", referencedColumnName="FK_K_LSK")
	private Set<Dw> dw = new HashSet<Dw>(0);

	public House() {
	}

	public Integer getKlsk() {
		return klsk;
	}
	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}
	
	public Set<Dw> getDw() {
		return dw;
	}
	public void setDw(Set<Dw> dw) {
		this.dw = dw;
	}
	
}
