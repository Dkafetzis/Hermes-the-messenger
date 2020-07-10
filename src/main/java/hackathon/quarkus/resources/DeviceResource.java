package hackathon.quarkus.resources;

import hackathon.quarkus.model.Device;
import hackathon.quarkus.service.DeviceService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/publish")
public class DeviceResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages(){
        return Response.status(Response.Status.OK).entity(DeviceService.initList()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(Device device) {
        System.out.println(device);
        return Response.ok().status(Response.Status.CREATED).build();
    }
}
