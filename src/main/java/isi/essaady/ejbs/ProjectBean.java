package isi.essaady.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import isi.essaady.entities.Project;


/**
 * Session Bean implementation class ProjectBean
 */
@Stateless
@LocalBean
public class ProjectBean {

	@PersistenceContext
    EntityManager em;
	
    public ProjectBean() {}
    
    /**
     * getAllProjects() method
     */
    @SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
    	return em.createNamedQuery("Project.findAll").getResultList();
    }

}
