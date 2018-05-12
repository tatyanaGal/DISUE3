package de.dis2018.menu;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import de.dis2018.data.House;

/**
 *  A small menu showing all houses from a set for selection
 */
public class HouseSelectionMenu extends Menu {
	public static final int BACK = -1;
	
	public HouseSelectionMenu(String title, List<House> houses) {
		super(title);
		
		Iterator<House> it = houses.iterator();
		while(it.hasNext()) {
			House h = it.next();
			addEntry(h.getStreet()+" "+h.getStreetnumber()+", "+h.getPostalcode()+" "+h.getCity(), h.getId());
		}
		addEntry("Back", BACK);
	}
}
