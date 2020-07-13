package hackathon.quarkus.mqtt;

<<<<<<< HEAD
import io.smallrye.mutiny.Multi;
=======
>>>>>>> master
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Publish {
    /*private String topic;

    public Publish() {}

    public Publish(String topic) {
        this.topic = topic;
    }
<<<<<<< HEAD
     */

    @Outgoing("pao")
    public Multi<String> generate() {
        return Multi.createFrom().item("Pao Channel Publishes");
=======

     */

    @Outgoing("pao")
    public String generate() {
        return "LOL";
>>>>>>> master
    }
}
