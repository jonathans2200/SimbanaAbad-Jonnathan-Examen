/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Pedido;

/**
 *
 * @author jonat
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido>{

    @PersistenceContext(unitName = "examen")
    private EntityManager em;

    public PedidoFacade() {
        super(Pedido.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
    
}
