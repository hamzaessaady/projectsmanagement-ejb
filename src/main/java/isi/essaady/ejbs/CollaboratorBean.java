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
     * Gets all availble collaborators.
     * 
     * @return List<Collaborator>  All collaborators
     */
    @SuppressWarnings("unchecked")
	public List<Collaborator> getAllCollabs() {
    	return em.createNamedQuery("Collaborator.findAll").getResultList();
    }
    
    
    /**
     * Updates an existing Collaborator.
     * 
     * @param  collab  The new updated Collaborator object.
     * @return  Collaborator  The edited Collaborator object
     */
	public Collaborator updateCollab(Collaborator collab) {
    	return em.merge(collab);
    }
	
	
	/**
     * Creates a new collaborator.
     * 
     * @param comp	The new collaborator object.
     */
	public void createCollab(Collaborator collab) {
		em.persist(collab);
	}
	
	
	/**
     * Removes a collaborator.
     * 
     * @param collab  The collaborator object to remove.
     */
	public void deleteCollab(Collaborator collab) {
		if (!em.contains(collab)) {
			collab = em.merge(collab);
		}
		em.remove(collab);
	}

}
