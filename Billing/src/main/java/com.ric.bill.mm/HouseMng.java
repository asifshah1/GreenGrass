

import java.util.List;
import java.util.Set;

import com.ric.bill.MeterManagable;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.Manage;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MeterLog;

public interface HouseMng extends Manage {
	
	public List<House> findAll();
	public List<MeterLog> getMetLogByServTp(MeterManagable mm, Serv serv, String tp);
	
}