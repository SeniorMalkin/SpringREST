package com.netcracker;

import com.netcracker.POJO.Result;
import org.springframework.http.MediaType;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class CalculationRestClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/").path("add").path("2").path("3");
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON_UTF8_VALUE);
        Response response = builder.get();
        System.out.println(response.toString());
        System.out.println(response.readEntity(Result.class));

        Client client1 = ClientBuilder.newClient();
        WebTarget webTarget1 = client1.target("http://localhost:8080/").path("subst").path("2").path("3");
        Invocation.Builder builder1 = webTarget1.request(MediaType.APPLICATION_JSON_UTF8_VALUE);
        Response response1 = builder1.get();
        System.out.println(response1.toString());
        System.out.println(response1.readEntity(Result.class));


    }
}
