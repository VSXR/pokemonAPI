FROM amazoncorretto:21

COPY target/pokemonAPI-0.0.1.jar pokemonAPI-0.0.1.jar

ENTRYPOINT ["java", "-jar", "/pokemonAPI-0.0.1.jar"]
