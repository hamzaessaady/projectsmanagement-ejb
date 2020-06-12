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
    
    
    /**
     * Updates an existing Project.
     * 
     * @param proj	The new updated project object
     * @return Project	The edited project object
     */
	public Project updateProj(Project proj) {
    	return em.merge(proj);
    }
	
	
	/**
     * Creates a new project.
     * 
     * @param proj	The new project object.
     */
	public void createProj(Project proj) {
		em.persist(proj);
	}
	
	
	/**
     * Removes a project.
     * 
     * @param proj  The project object to remove.
     */
	public void deleteProj(Project proj) {
		if (!em.contains(proj)) {
			proj = em.merge(proj);
		}
		em.remove(proj);
	}

}
