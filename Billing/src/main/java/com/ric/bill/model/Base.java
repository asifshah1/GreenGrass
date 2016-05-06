package com.ric.bill.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


@MappedSuperclass
public abstract class Base implements Storable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	protected int id; // id записи

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	//вернуть параметр Integer из хранилища
	@Transient
	public final Integer getI1(Integer klsk) {
		/*
		 * 
		 * ОСНОВНАЯ ИДЕЯ - ТАКАЯ
		 * при первом обращении за параметром, узнать в Store о наличии загруженных параметров, если их нет, -
		 * то загрузить их
		 * 
		 */
		return null;
	}
	
	//вернуть параметр String из хранилища
	@Transient
	public final String getS1(Integer klsk) {
		return null;
	}

	public abstract Integer getKlsk();
	
	public abstract void setKlsk(Integer klsk);	
}
