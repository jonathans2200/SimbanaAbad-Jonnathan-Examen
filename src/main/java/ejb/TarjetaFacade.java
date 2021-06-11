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
import model.Tarjeta;

/**
 *
 * @author jonat
 */
@Stateless
public class TarjetaFacade extends AbstractFacade<Tarjeta> {

    @PersistenceContext(unitName = "examen")
    private EntityManager em;

    public TarjetaFacade() {
        super(Tarjeta.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
