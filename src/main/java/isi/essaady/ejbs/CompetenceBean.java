package isi.essaady.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import isi.essaady.entities.Competence;


/**
 * Session Bean implementation class Competence
 */
@Stateless
@LocalBean
public class CompetenceBean {

	@PersistenceContext
    EntityManager em;
	
    public CompetenceBean() {}
    
    
    /**
     * Selects all availble competences.
     * 
     * @return List<Competence>	Compentces list
     */
    @SuppressWarnings("unchecked")
	public List<Competence> getAllComps() {
    	return em.createNamedQuery("Competence.findAll").getResultList();
    }
    
    
    /**
     * Updates an existing competence.
     * 
     * @param comp	The new updated competence object.
     * @return Competence	The edited competence object
     */
	public Competence updateComp(Competence comp) {
    	return em.merge(comp);
    }
	
	
	/**
     * Creates a new competence.
     * 
     * @param comp	The new competence object.
     */
	public void createComp(Competence comp) {
		em.persist(comp);
	}
	
	
	/**
     * Removes a competence.
     * 
     * @param comp	The competence object to remove.
     */
	public void deleteComp(Competence comp) {
		if (!em.contains(comp)) {
			comp = em.merge(comp);
		}
		em.remove(comp);
	}
	
	

}
