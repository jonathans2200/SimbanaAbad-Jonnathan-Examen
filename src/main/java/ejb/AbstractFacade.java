/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author jonat
 */
public  abstract class AbstractFacade<T> {
    
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
   protected abstract EntityManager getEntityManager();
   
   public void crear(T entity){
       getEntityManager().persist(entity);
   }

 public void editar(T entity){
       getEntityManager().merge(entity);
   }

 public void eliminar(T entity){
       getEntityManager().remove(getEntityManager().merge(entity));
   }


 public T buscar(Object entity){
 return getEntityManager().find(entityClass, entity);
 }

public List<T> buscarTodo(){
    CriteriaQuery cq=getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    return getEntityManager().createQuery(cq).getResultList();
    
}
}
