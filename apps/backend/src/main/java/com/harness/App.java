package com.harness;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        int port = 8080; 
        
        String version = System.getenv("APP_VERSION");
        if (version == null || version.isEmpty()) {
            version = "v1.0.0-Backend";
        }

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        String finalVersion = version; 
        server.createContext("/api", (exchange -> { // Backend API path
            String response = "Backend: Hello from Java! Version: " + finalVersion + "\n";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }));

        server.setExecutor(null); 
        server.start();

        System.out.println("Backend started on port: " + port + " with version: " + version);
    }
}