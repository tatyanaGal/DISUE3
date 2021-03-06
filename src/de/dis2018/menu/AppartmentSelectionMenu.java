package de.dis2018.menu;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import de.dis2018.data.Apartment;

/**
 * A small menu showing all apartments from a set for selection
 */
public class AppartmentSelectionMenu extends Menu {
	public static final int BACK = -1;
	
	public AppartmentSelectionMenu(String title, List<Apartment> apartments) {
		super(title);
		
		Iterator<Apartment> it = apartments.iterator();
		while(it.hasNext()) {
			Apartment w = it.next();
			addEntry(w.getStreet()+" "+w.getStreetnumber()+", "+w.getPostalcode()+" "+w.getCity(), w.getid());
		}
		addEntry("Back", BACK);
	}
}
