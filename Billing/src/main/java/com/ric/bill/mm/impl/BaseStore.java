package com.ric.bill.mm.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Dist;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.bs.Dw;

/**
 * Базовый класс сервисов, умеющих хранить параметры 
 * @author lev
 *
 */
@Service
public abstract class BaseStore {


	@Autowired
    private ParMng parMng;

	/**
	 * получить значение параметра типа Double объекта по CD свойства
	 */
	@Transactional
	public Double getDbl(Set<Dw> dw, String cd) {
		try {
			for (Dw d: dw) {
				//проверка, что соответствует CD и Number (NM), Единичное (SI)
				if (d.getPar().getCd().equals(cd)) {
					if (d.getPar().getTp().equals("NM")) {
						if (d.getPar().getDataTp().equals("SI")) {
							return d.getN1();
						} else {
								throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом данного SI завершилась ошибкой");
						}
					} else {
						throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом NM завершилась ошибкой");
					}
				}
			}
			//если не найдено, то проверить, существует ли вообще этот параметр, в природе
			if (!parMng.isExByCd(cd)) {
				throw new WrongGetMethod("Параметр "+cd+" не существует в базе данных");
			};
		} catch (WrongGetMethod e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}