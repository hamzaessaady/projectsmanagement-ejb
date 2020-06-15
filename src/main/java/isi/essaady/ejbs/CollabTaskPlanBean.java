package isi.essaady.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import isi.essaady.entities.CollabTaskPlan;

/**
 * Session Bean implementation class CollabTaskPlanBean
 */
@Stateless
@LocalBean
public class CollabTaskPlanBean {
	
	@PersistenceContext
    EntityManager em;

    public CollabTaskPlanBean() {}
    
    
    /**
     * getAllCollabTaskPlan() method
     */
    @SuppressWarnings("unchecked")
	public List<CollabTaskPlan> getAllCollabTaskPlan() {
    	return em.createNamedQuery("CollabTaskPlan.findAll").getResultList();
    }
    
    
    /**
     * Updates an existing Project.
     * 
     * @param proj	The new updated project object
     * @return Project	The edited project object
     */
    public CollabTaskPlan updateCollabTaskPlan(CollabTaskPlan collabTaskPlan) {
    	return em.merge(collabTaskPlan);
    }

}
