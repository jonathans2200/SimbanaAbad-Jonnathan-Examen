/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public Tarjeta buscarXNumero(int numero) {
        String jpql = "select t from Tarjeta t where t.numeroTarjeta = :num";
        Query query = em.createQuery(jpql, Tarjeta.class);
        query.setParameter("num", numero);
        Tarjeta tarjeta = (Tarjeta) query.getSingleResult();
        return tarjeta;
    }

   

   public List<Pedido> generar(int tarjeta) throws Exception {
		try {
			String jpql = "SELECT s FROM Pedido s Where s.tarjeta.numeroTarjeta =:ced";
			Query q = em.createQuery(jpql, Pedido.class);
			q.setParameter("ced", tarjeta);
			return q.getResultList();
		} catch (NoResultException e) {
			// System.out.println(e.getMessage());
			throw new Exception("No hay datos");
		}

	}
   
  

}
