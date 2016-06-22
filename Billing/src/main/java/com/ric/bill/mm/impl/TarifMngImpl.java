package com.ric.bill.mm.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.TarifContains;
import com.ric.bill.dao.KartDAO;
import com.ric.bill.dao.TarifDAO;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.tr.TarifKlsk;
import com.ric.bill.model.tr.TarifServ;
import com.ric.bill.model.tr.TarifServOrg;
import com.ric.bill.model.tr.TarifServProp;

/**
 * Сервис работы с тарифами
 * @author lev
 *
 */
@Service
public class TarifMngImpl implements TarifMng {
	
	@Autowired
	private TarifDAO tDao;


	/**
	 * Получить значение типа Double тарифа по CD 
	 * @param tc - объект
	 * @param cd - код свойства
	 * @return - свойство
	 */
	public Double findProp(TarifContains tc, Serv serv, String cd) {
		//искать сперва по наборам тарифа объекта 
		for (TarifKlsk k : tc.getTarifklsk()) {
			//затем по строкам - составляющим тариф 
			for (TarifServProp t : k.getTarprop()) {
				if (t.getServ().equals(serv) && t.getProp().getCd().equals(cd)) {
					return t.getN1();
				}
			}
		}
		return null;
		
	}

	/**
	 * Получить список всех услуг по тарифу данного объекта
	 * @param tc - объект
	 * @return
	 */
	public Set<Serv> getAllServ(TarifContains tc) {
		Set<Serv> lst = new HashSet<Serv>();
		//искать сперва по наборам тарифа объекта 
		for (TarifKlsk k : tc.getTarifklsk()) {
			//затем по строкам - составляющим тариф 
			for (TarifServProp t : k.getTarprop()) {
				lst.add(t.getServ());
			}
		}
		return lst;
	}
	
}
