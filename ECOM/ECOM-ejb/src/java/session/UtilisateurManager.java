/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Utilisateur;
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
public class UtilisateurManager {

    @PersistenceContext(unitName = "ECOM-ejbPU")
    private EntityManager em;

    //executes a "named query" whose name is "Utilisateur.findall". Look at the beginning of the file Utilisateur.java, you will find this query. It's equivalent to a select * from Utilisateur. But as we are working with objects, in that case we will return a List of Utilisateurs, not tuples.
    public List<Utilisateur> getAllUtilisateurs() {
        Query query = em.createNamedQuery("Utilisateur.findAll");
        //System.out.println("²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²");
        return query.getResultList();
    }

    public Utilisateur insertUtilisateur() {
        
        em.close();
        return null;
    }
    //update(Utilisateur utilisateur)... updates the database content with the value of the Customer passed as a parameter. The em.merge(utilisateur);

    public Utilisateur update(Utilisateur utilisateur) {
        return em.merge(utilisateur);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
