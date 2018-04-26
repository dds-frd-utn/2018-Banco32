package utn.frd.banco32.rest.services;

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
import utn.frd.banco32.entity.EstadoMovimiento;
import utn.frd.banco32.sessions.EstadoMovimientoFacade;

/**
 *
 * @author Sergio
 */
@Path("/estadoMovimiento")
public class EstadoMovimientoRest {

    @EJB
    private EstadoMovimientoFacade ejbEstadoMovimientoFacade;
//obtener todas las entidades

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<EstadoMovimiento> findAll() {
        return ejbEstadoMovimientoFacade.findAll();
    }
//crear entidades

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(EstadoMovimiento estadoMovimiento) {
        ejbEstadoMovimientoFacade.create(estadoMovimiento);
    }
//actualizar entidades

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id") long id, EstadoMovimiento estadoMovimiento) {
        ejbEstadoMovimientoFacade.edit(estadoMovimiento);
    }
//eliminar entidades
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id") long id) {
        ejbEstadoMovimientoFacade.remove(ejbEstadoMovimientoFacade.find(id));
    }
    
//obtener una entidad por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public EstadoMovimiento findById(@PathParam("id") long id) {
        return ejbEstadoMovimientoFacade.find(id);
    }
}
