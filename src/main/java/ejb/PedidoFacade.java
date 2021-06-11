/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    
    
    public Pedido obtenerPedido(String id) throws Exception {
        try {
            String jpl = "select p from Pedido p Where p.numero =:numero ";
            Query q = em.createQuery(jpl, Pedido.class);
            q.setParameter("numero", id);
            return (Pedido) q.getSingleResult();

        } catch (NoResultException e) {
            //System.out.println(e.getMessage());
            throw new Exception("No se encontraron pedidos");
        }
        //return null;
    }
    
}
