package com.ric.bill.mm;

import java.util.Set;

import com.ric.bill.Calc;
import com.ric.bill.CntPers;
import com.ric.bill.Standart;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.tr.TarifKlsk;

public interface KartMng extends StorableMng {

	void getCntPers(Serv serv, CntPers cntPers, int tp);
	Double getServPropByCD(Set<TarifKlsk> tarklsk, Serv serv, String string);
	Standart getStandart(MeterLog mLog, Calc calc, CntPers cntPers);

}