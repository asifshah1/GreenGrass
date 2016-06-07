package com.ric.bill.mm.impl;

import java.util.Set;

import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.tr.TarifKlsk;
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
			//затем по строкам - составляющим тариф 
			for (TarifServProp t : k.getTarprop()) {
				if (t.getServ().equals(serv) && t.getProp().getCd().equals(cd)) {
					return t.getN1();
				}
			}
		}
		return null;
		
	}
}