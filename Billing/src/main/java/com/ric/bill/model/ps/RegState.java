package com.ric.bill.model.ps;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.cache.annotation.Cacheable;

import com.ric.bill.Simple;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Lst;

/**
 * Пасп стол. Временно отсутствующие, временно присутствующие.
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "REG_STATE", schema="PS")
public class RegState implements java.io.Serializable, Registrable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; //id

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LSK", referencedColumnName="LSK", updatable = false)
	private Kart kart;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_PERS", referencedColumnName="ID", updatable = false)
	private Pers pers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TEMP_TP", referencedColumnName="ID", updatable = false)
	private Lst tp;
	
    @Column(name = "DT_REG", updatable = false, nullable = true)
	private Date dtReg; //Дата регистрации
	
    @Column(name = "DT_REG_TS", updatable = false, nullable = true)
	private Date dtRegTs; //Дата регистрации, фактически установлена

    @Column(name = "DT_UNREG", updatable = false, nullable = true)
	private Date dtUnReg; //Дата снятия с учёта

    @Column(name = "DT_UNREG_TS", updatable = false, nullable = true)
	private Date dtUnRegTs; //Дата снятия с учёта, фактически установлена

	@Column(name = "LSK", updatable = false, insertable = false)
	private String lsk;

	public Integer getId() {
		return this.id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}

	public Pers getPers() {
		return pers;
	}

	public void setPers(Pers pers) {
		this.pers = pers;
	}

	public Date getDtReg() {
		return dtReg;
	}

	public void setDtReg(Date dtReg) {
		this.dtReg = dtReg;
	}

	public Date getDtRegTs() {
		return dtRegTs;
	}

	public void setDtRegTs(Date dtRegTs) {
		this.dtRegTs = dtRegTs;
	}

	public Date getDtUnReg() {
		return dtUnReg;
	}

	public void setDtUnReg(Date dtUnReg) {
		this.dtUnReg = dtUnReg;
	}

	public Date getDtUnRegTs() {
		return dtUnRegTs;
	}

	public void setDtUnRegTs(Date dtUnRegTs) {
		this.dtUnRegTs = dtUnRegTs;
	}

	public Lst getTp() {
		return tp;
	}

	public void setTp(Lst tp) {
		this.tp = tp;
	}

	public String getLsk() {
		return lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}
	
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (!(o instanceof RegState)) return false;
     
       RegState otherRegState = (RegState) o;
     
       if (getId() != null ?
           !getId().equals(otherRegState.getId()) : otherRegState.getId() != null)
           return false;
     
       return true;
   }
	
}

