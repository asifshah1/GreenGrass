package com.ric.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Класс Лицевого счета
 * @author lev
 *
 */
@Entity
@Table(name = "KART", schema="AR")
public class Lsk extends Base2 implements Storable {

	private Integer klsk; // klsk объекта

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка имеет другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}
	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}
	

}
