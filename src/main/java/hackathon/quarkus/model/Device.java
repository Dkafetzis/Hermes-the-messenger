package hackathon.quarkus.model;

public class Device {
    private String message;
    private String topic;

    public Device() {}

    public Device(String message, String topic) {
        this.message = message;
        this.topic = topic;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "message='" + message + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
