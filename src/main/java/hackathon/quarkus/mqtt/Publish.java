package hackathon.quarkus.mqtt;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.annotations.Merge;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;

@ApplicationScoped
public class Publish {
    int i=0;

    @Outgoing("panatha")
    public Multi<String> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .map(x -> "A message here");
   }

    @Incoming("panatha2")
    @Merge
    public void consume(String raw) {
        //String m = new String(raw, StandardCharsets.UTF_8);
        System.out.println("Message received: "+raw+" "+i++);
    }


    @Incoming("panatha3")
    @Merge
    public void consume2(String raw) {
        //String m = new String(raw, StandardCharsets.UTF_8);
        System.out.println("Message received: "+raw+" "+i++);
    }
}
