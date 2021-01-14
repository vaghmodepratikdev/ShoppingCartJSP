package isi.exo.Action;

import java.util.ArrayList;

import isi.exo.entity.orderentity;
import isi.exo.manager.orderManager;

public class orderAction {
	  public static ArrayList<orderentity>  getAllListOfOrder()
	  {
		  return orderManager.getaAllOrder();
	  }

}
