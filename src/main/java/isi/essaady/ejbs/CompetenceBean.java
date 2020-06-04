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
     * getAllComps() method
     */
    @SuppressWarnings("unchecked")
	public List<Competence> getAllComps() {
    	return em.createNamedQuery("Competence.findAll").getResultList();
    }

}
