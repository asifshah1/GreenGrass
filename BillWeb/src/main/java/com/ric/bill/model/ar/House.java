package com.ric.bill.model.ar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import com.ric.bill.MeterContains;
import com.ric.bill.TarifContains;
import com.ric.bill.model.bs.Base;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.tr.TarifKlsk;

/**
 * Дом
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "HOUSE", schema="AR")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
//Внимание! пока решил не включать предварительные фильтры в связи с некорректностью логики в выражении Between or Between! Подумать! TODO!
/*@FilterDefs({
	//фильтр, когда одна из дат входит в диапазон
    @FilterDef(name = "FILTER_GEN_DT_OUTER", defaultCondition = "(:DT1 BETWEEN DT1 AND DT2 OR :DT2 BETWEEN DT1 AND DT2)", 
	parameters = {@ParamDef(name = "DT1", type = "date"),
    			  @ParamDef(name = "DT2", type = "date")
	}
    )
})*/
public class House extends Base implements java.io.Serializable, MeterContains, TarifContains {

	public House() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	protected Integer id; //id записи

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_HOUSE", referencedColumnName="ID")
	@BatchSize(size = 500)
	private List<Kw> kw = new ArrayList<Kw>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	@BatchSize(size = 20)
	private List<MeterLog> mlog = new ArrayList<MeterLog>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	@BatchSize(size = 50)
	//@Filters({
	//    @Filter(name = "FILTER_GEN_DT_OUTER")})
	//Внимание! пока решил не включать предварительные фильтры!
	private List<TarifKlsk> tarifklsk = new ArrayList<TarifKlsk>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_STREET", referencedColumnName="ID", updatable = false)
	private Street street;
	
	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	public List<Kw> getKw() {
		return kw;
	}

	public void setKw(List<Kw> kw) {
		this.kw = kw;
	}
	
	public List<MeterLog> getMlog() {
		return mlog;
	}

	public void setMlog(List<MeterLog> mlog) {
		this.mlog = mlog;
	}

	public List<TarifKlsk> getTarifklsk() {
		return tarifklsk;
	}

	public void setTarifklsk(List<TarifKlsk> tarifklsk) {
		this.tarifklsk = tarifklsk;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}
	

}
