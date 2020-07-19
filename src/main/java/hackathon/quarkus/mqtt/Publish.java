package hackathon.quarkus.mqtt;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Publish {
    int i=0;

    //@Outgoing("panatha3")
    //public Multi<String> generate() {
    //    return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
    //            .map(x -> "A message here");
    //}

    @Incoming("panatha2")
    public void consume(byte [] raw) {
    	String n = new String(raw, StandardCharsets.UTF_8);
        System.out.println("Message received: "+n+" "+i++);
    }


    
}
