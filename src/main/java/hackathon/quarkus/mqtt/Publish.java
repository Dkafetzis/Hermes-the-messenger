package hackathon.quarkus.mqtt;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;

@ApplicationScoped
public class Publish {
    private String message="message here";

    public Publish() {}

    public Publish(String topic) {
        this.message = topic;
    }


    @Outgoing("myTopic")
    public Multi<String> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .map(x -> message);
    }
}
