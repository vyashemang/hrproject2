package com.example.erp.controller;

import com.example.erp.service.EmployeeService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("employee")
public class EmployeeController {
    @POST
    @Path("/login")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyEmail(@FormDataParam("email") String email) throws URISyntaxException {
        System.out.println(email);
        EmployeeService employeeService = new EmployeeService();
        if(employeeService.verifyEmail(email)){
            System.out.println("Email is valid");
            return Response.status(200).build();
        }
        System.out.println("Email is not valid");
        return Response.status(400, "Email is not valid").build();
    }
}
