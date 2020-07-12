package hackathon.quarkus.mqtt;

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
    public String generate() {
        return "LOL";
    }
}
