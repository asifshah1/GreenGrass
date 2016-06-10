package com.ric.bill.mm.impl;

import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.tr.TarifKlsk;
import com.ric.bill.model.tr.TarifServ;
import com.ric.bill.model.tr.TarifServOrg;
import com.ric.bill.model.tr.TarifServProp;

/**
 * Абстрактный класс сервисов, умеющих работать с тарифами
 * @author lev
 *
 */

public abstract class TarifStore extends BaseStore {
	
	
	/**
	 * Получить значение типа Double тарифа по CD 
	 * @param tar - список записей тарифа по свойствам
	 * @param cd - код свойства
	 * @return - свойство
	 */
	public Double getServPropByCD (Set<TarifKlsk> tarKlsk, Serv serv, String cd) {
		//искать сперва по наборам тарифа объекта 
		for (TarifKlsk k : tarKlsk) {
			System.out.println("k="+k.getId());
			//затем по строкам - составляющим тариф 

			for (TarifServOrg t : k.getTarorg()) {
				System.out.println("t="+k.getId());
				//System.out.println("t2="+t.getId());
				//System.out.println("t2="+t.getProp().getCd());
		//		if (t.getServ().equals(serv) && t.getProp().getCd().equals(cd)) {
			//		return t.getN1();
				//}
			}

		}
		return null;
		
	}
}
