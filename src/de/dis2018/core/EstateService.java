package de.dis2018.core;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import de.dis2018.data.House;
import de.dis2018.data.Estate;
import de.dis2018.data.PurchaseContract;
import de.dis2018.data.EstateAgent;
import de.dis2018.data.TenancyContract;
import de.dis2018.data.Person;
import de.dis2018.data.Apartment;

/**
 * Class for managing all database entities.
 * 
 * TODO: All data is currently stored in memory. The aim of the exercise is to
 * gradually outsource data management to the database. When the work is done,
 * all sets in this class become obsolete!
 */
public class EstateService {
	// TODO All these sets should be commented out after successful implementation.
	// private Set<EstateAgent> estateAgents = new HashSet<EstateAgent>();
	// private Set<Person> persons = new HashSet<Person>();
	// private Set<House> houses = new HashSet<House>();
	// private Set<Apartment> apartments = new HashSet<Apartment>();
	// private Set<TenancyContract> tenancyContracts = new
	// HashSet<TenancyContract>();
	// private Set<PurchaseContract> purchaseContracts = new
	// HashSet<PurchaseContract>();

	// Hibernate Session
	private SessionFactory sessionFactory;

	public EstateService() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	/**
	 * Find an estate agent with the given id
	 * 
	 * @param id
	 *            The ID of the agent
	 * @return Agent with ID or null
	 */
	public EstateAgent getEstateAgentByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		EstateAgent agent = (EstateAgent) session.get(EstateAgent.class, id);
		session.getTransaction().commit();
		return agent;
	}

	/**
	 * Find estate agent with the given login.
	 * 
	 * @param login
	 *            The login of the estate agent
	 * @return Estate agent with the given ID or null
	 */

	public EstateAgent getEstateAgentByLogin(String login) {
		// Transaction tx;
		// try {
		// tx = sess.beginTransaction();
		// //do some work
		// ...
		// tx.commit();
		// }
		// catch (Exception e) {
		// if (tx!=null) tx.rollback();
		// throw e;
		// }
		// finally {
		// sess.close();
		// }
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		EstateAgent agent = (EstateAgent) session.createQuery("from EstateAgent where login = :login ")
				.setParameter("login", login).uniqueResult();
		session.getTransaction().commit();

		return agent;
	}

	/**
	 * Returns all estateAgents
	 */
	public List<EstateAgent> getAllEstateAgents() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EstateAgent> agents = (List<EstateAgent>) session.createQuery("from EstateAgent").list();
		session.getTransaction().commit();
		return agents;
	}

	/**
	 * Find an person with the given id
	 * 
	 * @param id
	 *            The ID of the person
	 * @return Person with ID or null
	 */
	public Person getPersonById(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Person person = (Person) session.get(Person.class, id);
		session.getTransaction().commit();
		return person;
	}

	/**
	 * Adds an estate agent
	 * 
	 * @param ea
	 *            The estate agent
	 */
	public void addEstateAgent(EstateAgent ea) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(ea);
		session.getTransaction().commit();
	}
	
	/**
	 * Update an estate agent
	 * 
	 * @param ea
	 *            The estate agent
	 */
	public void updateEstateAgent(EstateAgent ea) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(ea);
		session.getTransaction().commit();
		
	}

	/**
	 * Deletes an estate agent
	 * 
	 * @param ea
	 *            The estate agent
	 */
	public void deleteEstateAgent(EstateAgent ea) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(ea);
		session.getTransaction().commit();
	}

	/**
	 * Adds a person
	 * 
	 * @param p
	 *            The person
	 */
	public void addPerson(Person p) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}
	
	/**
	 * Update an estate agent
	 * 
	 * @param p
	 *            The person
	 */
	public void updatePerson(Person p) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
	}

	/**
	 * Returns all persons
	 */
	public List<Person> getAllPersons() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Person> persons = (List<Person>) session.createQuery("from Person").list();
		session.getTransaction().commit();
		return persons;
	}

	/**
	 * Deletes a person
	 * 
	 * @param p
	 *            The person
	 */
	public void deletePerson(Person p) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(p);
		session.getTransaction().commit();
	}

	/**
	 * Adds a house
	 * 
	 * @param h
	 *            The house
	 */
	public void addHouse(House h) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(h);
		session.getTransaction().commit();
	}
	
	/**
	 * Update an estate
	 * 
	 * @param h
	 *            The house or apartment
	 */
	public void updateEstate(Estate e) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
		
	}

	/**
	 * Returns all houses of an estate agent
	 * 
	 * @param ea
	 *            the estate agent
	 * @return All houses managed by the estate agent
	 */
	public List<House> getAllHousesForEstateAgent(EstateAgent ea) {
		// Set<House> ret = new HashSet<House>();
		// Iterator<House> it = houses.iterator();
		// while (it.hasNext()) {
		// House h = it.next();
		// if (h.getManager().equals(ea))
		// ret.add(h);
		// }
		// return ret;

		// select c
		// from Contact c
		// join c.phones cphones
		// where c.userAccount.email = :email
		// and cphones.formatedNumber = :number
		//

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<House> houses = (List<House>) session
				.createQuery("FROM House h JOIN Estate e ON h.id = e.id WHERE e.manager =:manager")
				//.createQuery("from House h JOIN h.manager man WHERE man.manager =: manager")
				.setParameter("manager", ea.getId()).list();
		session.getTransaction().commit();
		return houses;
	}

	/**
	 * Find a house with a given ID
	 * 
	 * @param id
	 *            the house id
	 * @return The house or null if not found
	 */
	public House getHouseById(int id) {
		// Iterator<House> it = houses.iterator();
		// while (it.hasNext()) {
		// House h = it.next();
		// if (h.getId() == id)
		// return h;
		// }
		// return null;

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		House house = (House) session.get(House.class, id);
		session.getTransaction().commit();
		return house;
	}

	/**
	 * Deletes a house
	 * 
	 * @param h
	 *            The house
	 */
	public void deleteHouse(House h) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(h);
		session.getTransaction().commit();
	}

	/**
	 * Adds an apartment
	 * 
	 * @param w
	 *            the aparment
	 */
	public void addApartment(Apartment w) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(w);
		session.getTransaction().commit();
	}

	/**
	 * Returns all apartments of an estate agent
	 * 
	 * @param ea
	 *            The estate agent
	 * @return All apartments managed by the estate agent
	 */
	public List<Apartment> getAllApartmentsForEstateAgent(EstateAgent ea) {
		// Set<Apartment> ret = new HashSet<Apartment>();
		// Iterator<Apartment> it = apartments.iterator();
		// while (it.hasNext()) {
		// Apartment w = it.next();
		// if (w.getManager().equals(ea))
		// ret.add(w);
		// }
		// return ret;

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Apartment> apartments = (List<Apartment>) session
				.createQuery("FROM Apartment a JOIN Estate e ON a.id = e.id WHERE e.manager =:manager")
				.setParameter("manager", ea.getId()).list();
		session.getTransaction().commit();
		return apartments;
	}

	/**
	 * Find an apartment with given ID
	 * 
	 * @param id
	 *            The ID
	 * @return The apartment or zero, if not found
	 */
	public Apartment getApartmentByID(int id) {
		// Iterator<Apartment> it = apartments.iterator();
		// while (it.hasNext()) {
		// Apartment w = it.next();
		// if (w.getId() == id)
		// return w;
		// }
		// return null;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Apartment apartment = (Apartment) session.get(Apartment.class, id);
		session.getTransaction().commit();
		return apartment;
	}

	/**
	 * Deletes an apartment
	 * 
	 * @param p
	 *            The apartment
	 */
	public void deleteApartment(Apartment w) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(w);
		session.getTransaction().commit();
	}

	/**
	 * Adds a tenancy contract
	 * 
	 * @param t
	 *            The tenancy contract
	 */
	public void addTenancyContract(TenancyContract t) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}

	/**
	 * Adds a purchase contract
	 * 
	 * @param p
	 *            The purchase contract
	 */
	public void addPurchaseContract(PurchaseContract p) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}

	/**
	 * Finds a tenancy contract with a given ID
	 * 
	 * @param id
	 *            Die ID
	 * @return The tenancy contract or zero if not found
	 */
	public TenancyContract getTenancyContractByID(int id) {
		// Iterator<TenancyContract> it = tenancyContracts.iterator();
		// while (it.hasNext()) {
		// TenancyContract m = it.next();
		// if (m.getId() == id)
		// return m;
		// }
		// return null;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		TenancyContract tenancy = (TenancyContract) session.get(TenancyContract.class, id);
		session.getTransaction().commit();
		return tenancy;
	}

	/**
	 * Finds a purchase contract with a given ID
	 * 
	 * @param id
	 *            The id of the purchase contract
	 * @return The purchase contract or null if not found
	 */
	public PurchaseContract getPurchaseContractById(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		PurchaseContract purchase = (PurchaseContract) session.get(PurchaseContract.class, id);
		session.getTransaction().commit();
		return purchase;
	}

	/**
	 * Returns all tenancy contracts for apartments of the given estate agent
	 * 
	 * @param m
	 *            The estate agent
	 * @return All contracts belonging to apartments managed by the estate agent
	 */
	public List<TenancyContract> getAllTenancyContractsForEstateAgent(EstateAgent ea) {
		// Set<TenancyContract> ret = new HashSet<TenancyContract>();
		// Iterator<TenancyContract> it = tenancyContracts.iterator();
		// while (it.hasNext()) {
		// TenancyContract v = it.next();
		// if (v.getApartment().getManager().equals(ea))
		// ret.add(v);
		// }
		// return ret;
		///// TODO
		// "select * from House h join h.id Estate where Estate.manager := manager"
		
//		String query_findByProductDepartmentHospital = "select location from ProductInstallLocation location "
//	            + " join location.product prod " + " join location.department dep "
//	            + " join location.department.hospital hos " + " where  prod.name = :product "
//	            + " and dep.name.name = :department " + " and hos.name = :hospital ";
//		"select * from Contract c join c.apartment t where  " 

		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<TenancyContract> tenancies = (List<TenancyContract>) session
				.createQuery("from Contract c join Estate e on c.apartment=e.id where e.manager =:manager")
				.setParameter("manager", ea.getId()).list();
		session.getTransaction().commit();
		return tenancies;

	}

	/**
	 * Returns all purchase contracts for houses of the given estate agent
	 * 
	 * @param m
	 *            The estate agent
	 * @return All purchase contracts belonging to houses managed by the given
	 *         estate agent
	 */
	public List<PurchaseContract> getAllPurchaseContractsForEstateAgent(EstateAgent ea) {
		// Set<PurchaseContract> ret = new HashSet<PurchaseContract>();
		// Iterator<PurchaseContract> it = purchaseContracts.iterator();
		// while (it.hasNext()) {
		// PurchaseContract k = it.next();
		// if (k.getHouse().getManager().equals(ea))
		// ret.add(k);
		// }
		// return ret;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<PurchaseContract> purchases = (List<PurchaseContract>) session
				.createQuery("from Contract c join Estate e on c.house=e.id where e.manager =:manager")
				.setParameter("manager", ea.getId()).list();
		session.getTransaction().commit();
		return purchases;
	}

	/**
	 * Finds all tenancy contracts relating to the apartments of a given estate
	 * agent
	 * 
	 * @param ea
	 *            The estate agent
	 * @return set of tenancy contracts
	 */
	//// TODO didn't get it
	// public Set<TenancyContract> getTenancyContractByEstateAgent(EstateAgent ea) {
	// Set<TenancyContract> ret = new HashSet<TenancyContract>();
	// Iterator<TenancyContract> it = tenancyContracts.iterator();
	//
	// while (it.hasNext()) {
	// TenancyContract mv = it.next();
	//
	// if (mv.getApartment().getManager().getId() == ea.getId())
	// ret.add(mv);
	// }
	//
	// return ret;
	// }

	/**
	 * Finds all purchase contracts relating to the houses of a given estate agent
	 * 
	 * @param ea
	 *            The estate agent
	 * @return set of purchase contracts
	 */
	//// TODO didn't get it
	// public Set<PurchaseContract> getPurchaseContractByEstateAgent(EstateAgent ea)
	// {
	// // Set<PurchaseContract> ret = new HashSet<PurchaseContract>();
	// // Iterator<PurchaseContract> it = purchaseContracts.iterator();
	// // while (it.hasNext()) {
	// // PurchaseContract k = it.next();
	// // if (k.getHouse().getManager().equals(ea))
	// // ret.add(k);
	// // }
	// // return ret;
	//
	// Set<PurchaseContract> ret = new HashSet<PurchaseContract>();
	// Iterator<PurchaseContract> it = purchaseContracts.iterator();
	//
	// while (it.hasNext()) {
	// PurchaseContract k = it.next();
	//
	// if (k.getHouse().getManager().getId() == ea.getId())
	// ret.add(k);
	// }
	//
	// return ret;
	// }

	/**
	 * Deletes a tenancy contract
	 * 
	 * @param tc
	 *            the tenancy contract
	 */
	public void deleteTenancyContract(TenancyContract tc) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(tc);
		session.getTransaction().commit();
	}

	/**
	 * Deletes a purchase contract
	 * 
	 * @param tc
	 *            the purchase contract
	 */
	public void deletePurchaseContract(PurchaseContract pc) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(pc);
		session.getTransaction().commit();
	}

	/**
	 * Adds some test data
	 */
	public void addTestData() {
		// Hibernate Session erzeugen
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		EstateAgent m = new EstateAgent();
		m.setName("Max Mustermann");
		m.setAddress("Am Informatikum 9");
		m.setLogin("max");
		m.setPassword("max");

		// TODO: This estate agent is kept in memory and the DB
		//this.addEstateAgent(m);
		session.save(m);
		session.getTransaction().commit();

		session.beginTransaction();

		Person p1 = new Person();
		p1.setAddress("Informatikum");
		p1.setName("Mustermann");
		p1.setFirstname("Erika");

		Person p2 = new Person();
		p2.setAddress("Reeperbahn 9");
		p2.setName("Albers");
		p2.setFirstname("Hans");

		session.save(p1);
		session.save(p2);

		// TODO: These persons are kept in memory and the DB
		//this.addPerson(p1);
		//this.addPerson(p2);
		session.getTransaction().commit();

		session.beginTransaction();
		House h = new House();
		h.setCity("Hamburg");
		h.setPostalcode(22527);
		h.setStreet("Vogt-Kölln-Street");
		h.setStreetnumber("2a");
		h.setSquareArea(384);
		h.setFloors(5);
		h.setPrice(10000000);
		h.setGarden(true);
		h.setManager(m);

		session.save(h);

		// TODO: This house is held in memory and the DB
		//this.addHouse(h);
		session.getTransaction().commit();

		// Create Hibernate Session
		session = sessionFactory.openSession();
		session.beginTransaction();
		EstateAgent m2 = (EstateAgent) session.get(EstateAgent.class, m.getId());
		Set<Estate> immos = m2.getEstates();
		Iterator<Estate> it = immos.iterator();

		while (it.hasNext()) {
			Estate i = it.next();
			System.out.println("Estate: " + i.getCity());
		}
		session.close();

		Apartment w = new Apartment();
		w.setCity("Hamburg");
		w.setPostalcode(22527);
		w.setStreet("Vogt-Kölln-Street");
		w.setStreetnumber("3");
		w.setSquareArea(120);
		w.setFloor(4);
		w.setRent(790);
		w.setKitchen(true);
		w.setBalcony(false);
		w.setManager(m);
		//this.addApartment(w);

		w = new Apartment();
		w.setCity("Berlin");
		w.setPostalcode(22527);
		w.setStreet("Vogt-Kölln-Street");
		w.setStreetnumber("3");
		w.setSquareArea(120);
		w.setFloor(4);
		w.setRent(790);
		w.setKitchen(true);
		w.setBalcony(false);
		w.setManager(m);
		//this.addApartment(w);

//		PurchaseContract pc = new PurchaseContract();
//		pc.setHouse(h);
//		pc.setContractPartner(p1);
//		pc.setContractNo(9234);
//		pc.setDate(new Date(System.currentTimeMillis()));
//		pc.setPlace("Hamburg");
//		pc.setNoOfInstallments(5);
//		pc.setIntrestRate(4);
//		this.addPurchaseContract(pc);
//
//		TenancyContract tc = new TenancyContract();
//		tc.setApartment(w);
//		tc.setContractPartner(p2);
//		tc.setContractNo(23112);
//		tc.setDate(new Date(System.currentTimeMillis() - 1000000000));
//		tc.setPlace("Berlin");
//		tc.setStartDate(new Date(System.currentTimeMillis()));
//		tc.setAdditionalCosts(65);
//		tc.setDuration(36);
//		this.addTenancyContract(tc);
	}
}
