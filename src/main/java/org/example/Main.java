package org.example;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        final Server server = newServer(8080);
        server.closeOnJvmShutdown();
        server.start().join();

        logger.info("Server has been started. Serving dummy service at http://127.0.0.1:{}",
                server.activeLocalPort());



    }

    static Server newServer(int port) {
        ServerBuilder builder = Server.builder();
        return builder.http(port)
                .service("/", (ctx, req) -> HttpResponse.of("Hello, Aremeria!"))
                .build();
    }

}