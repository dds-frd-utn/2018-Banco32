/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.banco32.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import utn.frd.banco32.entity.Movimiento;

/**
 *
 * @author zetta
 */
@Stateless
public class MovimientoFacade extends AbstractFacade<Movimiento> {

    @PersistenceContext(unitName = "utn.frd_banco32_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovimientoFacade() {
        super(Movimiento.class);
    }
    
    public List<Movimiento> findByIdCuentaUltimos(long id){
        return em.createNamedQuery("Movimiento.findByIdCuenta",Movimiento.class).setParameter("idCuenta",id).setMaxResults(10).getResultList();
    }
    
    public List<Movimiento> findByIdCuenta(long id){
        return em.createNamedQuery("Movimiento.findByIdCuenta",Movimiento.class).setParameter("idCuenta",id).getResultList();
    }
    
    
    public List<Movimiento> findByEstadoYCuenta(int estado, long idCuenta){
        return em.createNamedQuery("Movimiento.findByEstadoYCuenta", Movimiento.class).setParameter("estado",estado).setParameter("idCuenta",idCuenta).getResultList();
    }
    
    public Object findSaldo(long idCuenta){
        return em.createNamedQuery("Movimiento.findSaldo", Movimiento.class).setParameter("idCuenta", idCuenta).getSingleResult();
    }
   
}