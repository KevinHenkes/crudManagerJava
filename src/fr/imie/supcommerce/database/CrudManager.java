package fr.imie.supcommerce.database;

import java.util.ArrayDeque;
import java.util.Deque;

import org.hibernate.Session;

public class CrudManager {
	Class<Object> classEntity;

	@SuppressWarnings("unchecked")
	public CrudManager(Object classObject) throws ClassCastException {
		try {
			this.classEntity = (Class<Object>) classObject;
		} catch (ClassCastException e) {
			throw e;
		}
	}

	public Object add(Object item) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();

		session.save(item);

		session.getTransaction().commit();

		return item;
	}

	public Object rm(Object item) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();

		session.delete(item);

		session.getTransaction().commit();

		return item;
	}

	@SuppressWarnings("unchecked")
	public Deque<Object> findAll() {
		Deque<Object> items = new ArrayDeque<Object>();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();

		session.createQuery("FROM " + classEntity.getSimpleName()).list().forEach(item -> {
			items.push(item);
		});

		session.close();

		return items;
	}

	public Object update(Object item) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();

		session.update(item);

		session.getTransaction().commit();

		return item;
	}

	public Object find(long id) {
		Object item;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		item = classEntity.cast(session.get(classEntity, id));

		session.close();

		return item;
	}
}
