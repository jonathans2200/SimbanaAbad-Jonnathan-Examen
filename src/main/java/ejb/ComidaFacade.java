/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Comida;

/**
 *
 * @author jonat
 */
@Stateless
public class ComidaFacade extends AbstractFacade<Comida> {

    @PersistenceContext(unitName = "examen")
    private EntityManager em;

    public ComidaFacade() {
        super(Comida.class);
    }

 @Override
    protected EntityManager getEntityManager() {
   return em;
    }
}
