# library-service for the +masters CFG course
This application was made for learning/developing: 
- Testing (Junit, mocking), and 
- Docker (creating an image, and using containers)

## How to use 
1. Run `src/main/resources/database/init-library.sql` in MySQL workbench
2. Edit the configuration in application.yml to reflect your DB password and username (placeholders there currently)

### With docker
1. You will need docker installed
2. mvn clean 
3. Create a package using maven, either in IntelliJ (rhs window), or, `mvn package`
4. Find the path to the created .jar file, it should be within target. If you had issues, investigate the logs - warning, failing tests may prevent the .jar from creating. 
5. Add this path to the Dockerfile (if different to before), it's `target/library-service-0.0.1-SNAPSHOT.jar` 
E.g. `COPY target/library-service-0.0.1-SNAPSHOT.jar /src/library-service.jar` -> `COPY some_new_path/library-service-0.0.1-SNAPSHOT.jar /src/library-service.jar`
6. Use this dockerfile to build the image, by running `docker build -t library-service .`
7. Navigating to docker desktop, or otherwise, obtain the image reference, and put this in place of the current image, on line 14 `    image: c9ae7795fbddee101aa7f337f2b3ca080bb5b5ec63bbbe9da93c5fda7cc4cb21`
8. You should be able to run this now - either using the green 'play' button, or using `docker-compose up` (you must be in the same directory as docker-compose.yml)
