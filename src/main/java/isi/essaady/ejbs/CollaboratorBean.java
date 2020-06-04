package isi.essaady.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import isi.essaady.entities.Collaborator;


/**
 * Session Bean implementation class CollaboratorBean
 */
@Stateless
@LocalBean
public class CollaboratorBean {

	@PersistenceContext
    EntityManager em;
	
    public CollaboratorBean() {}
    
    /**
     * getAllCollabs() method
     */
    @SuppressWarnings("unchecked")
	public List<Collaborator> getAllCollabs() {
    	return em.createNamedQuery("Collaborator.findAll").getResultList();
    }

}
