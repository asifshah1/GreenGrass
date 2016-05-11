package com.ric.bill.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Значение параметра объекта
 */
@Entity
@Table(name = "U_HFPXKLSK", schema="ORALV")
public class Dw implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id;
	
    @Column(name = "S1", updatable = true)
    private String s1;

    @Column(name = "NS1", updatable = true)
    private Double n1;

    /*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_K_LSK", referencedColumnName="FK_K_LSK", updatable = false, insertable = false)
	private Lsk lsk;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_K_LSK", referencedColumnName="FK_K_LSK", updatable = false, insertable = false)
	private House house;
*/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_HFP", referencedColumnName="ID")
	private Par par; 

	public Dw() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}

	public Double getN1() {
		return n1;
	}

	public void setN1(Double n1) {
		this.n1 = n1;
	}	

/*	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Lsk getLsk() {
		return lsk;
	}

	public void setLsk(Lsk lsk) {
		this.lsk = lsk;
	}
*/
	public Par getPar() {
		return par;
	}

	public void setPar(Par par) {
		this.par = par;
	}



	
	
}
