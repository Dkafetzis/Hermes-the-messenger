# Hermes the messenger

Hermes is an easy to use MQTT web client that can be ran alongside an MQTT broker making it easier to send MQTT messages.

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application

You can use docker to run the application or download it and package it yourself

### Running with docker

You can get our image from [this docker repository](https://hub.docker.com/repository/docker/dkafetzis/hermes)

To start the application run `docker run -e "SUBTOPIC=topic_name" -e "MQTTHOST=broker_address" -e "MQTTPORT=broker_port" -p 4859:4859 dkafetzis/hermes:latest`

The following environment variables must be provided
* SUBTOPIC  The topic that the server will subscribe to (default is serverin)
* MQTTHOST  The address of the MQTT broker
* MQTTPORT  The port of the MQTT broker (default is 1883)

### Packaging the app and running it

The application can be packaged using `./mvnw package`.
It produces the `hermes-1.0.0-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/hermes-1.0.0-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/hermes-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.