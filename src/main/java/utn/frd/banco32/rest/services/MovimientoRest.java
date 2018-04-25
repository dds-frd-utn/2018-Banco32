package utn.frd.banco32.rest.services;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.banco32.entity.Movimiento;
import utn.frd.banco32.sessions.MovimientoFacade;

@Path("/movimiento")
public class MovimientoRest {

    @EJB
    private MovimientoFacade ejbMovimientoFacade;
//obtener todas las entidades

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> findAll() {
        return ejbMovimientoFacade.findAll();
    }


    //crear movimiento
    @POST
    @Path("/crear/{idCuenta}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Movimiento movimiento, @PathParam("idCuenta") int idCuenta) {
        //movimiento.setIdCuenta(ejbMovimientoFacade.find(idCuenta));
        movimiento.setIdCuenta(idCuenta);
        movimiento.setCreado(new Date()); // seteo la fecha de creacion (actual)
        movimiento.setImporte(1000);      
        movimiento.setTipo(1);            // tipo 1 no definido?
        movimiento.setEstado(2);          // tipo 2 no definido?
        movimiento.setProcesado(new Date());
        ejbMovimientoFacade.create(movimiento);
    }

//actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id") long id, Movimiento movimiento) {
        ejbMovimientoFacade.edit(movimiento);
    }
//eliminar entidades

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id") long id) {
        ejbMovimientoFacade.remove(ejbMovimientoFacade.find(id));
    }

//obtener una entidad por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Movimiento findById(@PathParam("id") int id) {
        return ejbMovimientoFacade.find(id);
    }
    
    //Obtener los últimos 10 movimientos de una cuenta.
    @GET
    @Path("/ultimos/{idCuenta}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> findByIdCuenta(@PathParam("idCuenta") int idCuenta) {
        return ejbMovimientoFacade.findByIdCuenta(idCuenta);
    }
}
