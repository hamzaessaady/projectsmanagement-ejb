package isi.essaady.ejbs;

import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import isi.essaady.entities.User;

@Stateless
@LocalBean
public class UserBean {
	
	@PersistenceContext
    EntityManager em;
	
    public UserBean() {
    	super();
    }
    
    /*
     * findByUsernamePassword() method
     * TODO: JAVA DOC
     * 
     * */
    public Optional<User> findByUsernamePassword(String username, String password) {
    	return em.createNamedQuery("User.selectUsernamePassword", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList()
                .stream()
                .findFirst();
    }
    
}
