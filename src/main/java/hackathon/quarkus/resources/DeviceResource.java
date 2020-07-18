package hackathon.quarkus.resources;

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

import hackathon.quarkus.model.Device;
import hackathon.quarkus.service.DeviceService;
import io.smallrye.reactive.messaging.mqtt.MqttMessage;

@Path("/publish")
public class DeviceResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages(){
        return Response.status(Response.Status.OK).entity(DeviceService.initList()).build();
    }

    @Inject
    @Channel("panatha")
    Emitter<String> emitter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(Device device) {
        System.out.println("New Publish request: message->"+device.getMessage()+" & topic->"+device.getTopic());
        //SendingMqttMessage<String> message = new SendingMqttMessage<>("myTopic","A message in here",0,false);
        emitter.send(MqttMessage.of(device.getTopic(), device.getMessage()));


        /*MqttMessage<String> mess = new MqttMessage<>() {
            @Override
            public int getMessageId() {
                return 0;
            }

            @Override
            public MqttQoS getQosLevel() {
                return null;
            }

            @Override
            public boolean isDuplicate() {
                return false;
            }

            @Override
            public boolean isRetain() {
                return false;
            }

            @Override
            public String getTopic() {
                return null;
            }

            @Override
            public String getPayload() {
                return null;
            }
        };
         */


        return Response.ok().status(Response.Status.CREATED).build();
    }
}
