package hackathon.quarkus.mqtt;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Publish {
    /*private String topic;

    public Publish() {}

    public Publish(String topic) {
        this.topic = topic;
    }
     */

    @Outgoing("pao")
    public Multi<String> generate() {
        return Multi.createFrom().item("Pao Channel Publishes");
    }
}
