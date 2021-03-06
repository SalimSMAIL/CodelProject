package daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import daos.interfaces.IDAOContact;
import entities.Contact;

public class DAOContact extends HibernateDaoSupport implements IDAOContact{

	public Contact read(Long id) {
		return (Contact) getHibernateTemplate().get(Contact.class, id);
	}
	
	public void create(Contact entity) {
		getHibernateTemplate().save(entity);
		
	}

	public void update(Contact entity) {
		getHibernateTemplate().merge(entity);
	}

	public void delete(Long id) {
		Contact c = read(id);
		getHibernateTemplate().delete(c);
	}
	public Contact load(Long id) {
		return (Contact) getHibernateTemplate().load(Contact.class, id);
	}

	public List<Contact> getContactsBylastName(String lastName) {
		return (List<Contact>)getHibernateTemplate().find("from Contact c where c.lastName=?",lastName);
	}

	public List<Contact> getContactsByfirstName(String firstName) {
		return (List<Contact>)getHibernateTemplate().find("from Contact c where c.firstName=?",firstName);

	}

}
