package hackathon.quarkus.resources;

import java.nio.charset.StandardCharsets;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import hackathon.quarkus.model.Device;
import io.smallrye.reactive.messaging.mqtt.MqttMessage;

@Path("/Resources")
public class DeviceResource {

	static String message = new String();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages(){
        return Response.status(Response.Status.OK).entity("Hello").build();
    }

    @Inject
    @Channel("out")
    Emitter<String> emitter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Publish")
    public Response publish(Device device) {
        System.out.println("New Publish request: message->"+device.getMessage()+" & topic->"+device.getTopic());
        //SendingMqttMessage<String> message = new SendingMqttMessage<>("myTopic","A message in here",0,false);
        emitter.send(MqttMessage.of(device.getTopic(), device.getMessage()));

        return Response.ok().status(Response.Status.CREATED).build();
    }
    
    
    @Incoming("in")
    public void consume(byte [] raw) {
    	message = new String(raw, StandardCharsets.UTF_8);
        System.out.println("Message received: " + message);
    }
    
    @GET
    @Path("/Subscribe")
    @Produces(MediaType.APPLICATION_JSON)
    public Response subscribe() {
    	System.out.println(message);
        return Response.ok().status(Response.Status.ACCEPTED).entity("{ \"message\":\"" + message + "\"}").build();
    }
}
