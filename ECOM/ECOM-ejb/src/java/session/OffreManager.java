/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Offre;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author John624
 */
@Stateless
@LocalBean
public class OffreManager {
    @PersistenceContext(unitName = "ECOM-ejbPU")
    private EntityManager em;

    public List<Offre> getAllOffre() {
        Query query= em.createNamedQuery("Offre.findAll");   
        return query.getResultList();
    }

    public Offre update(Offre offre) {
        return em.merge(offre);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
