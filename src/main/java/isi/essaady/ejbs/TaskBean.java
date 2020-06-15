package isi.essaady.ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import isi.essaady.entities.Task;

/**
 * Session Bean implementation class TaskBean
 */
@Stateless
@LocalBean
public class TaskBean {

	@PersistenceContext
    EntityManager em;
	
    public TaskBean() {}
    
    
    /**
     * Updates an existing Task.
     * 
     * @param task	The new updated task object.
     * @return Task	The edited task object
     */
	public Task updateTask(Task task) {
		em.flush();
    	Task updatedTask = em.merge(task);
    	em.flush();
    	return updatedTask;
    }
	
	
	/**
     * Creates a new task.
     * 
     * @param task	The new task object.
     */
	public void createTask(Task task) {
		em.persist(task);
	}
	
	
	/**
     * Removes a task.
     * 
     * @param task  The task object to remove.
     */
	public void deleteTask(Task task) {
		if (!em.contains(task)) {
			task = em.merge(task);
		}
		em.remove(task);
	}

}
