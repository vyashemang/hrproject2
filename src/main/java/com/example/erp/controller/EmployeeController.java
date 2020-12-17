package com.example.erp.controller;

import com.example.erp.bean.Department;
import com.example.erp.bean.Employee;
import com.example.erp.service.DepartmentService;
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
        EmployeeService employeeService = null;
        if(employeeService.verifyEmail(email)){
            System.out.println("Email is valid");
            return Response.status(200).build();
        }
        System.out.println("Email is not valid");
        return Response.status(400, "Email is not valid").build();
    }
    @POST
    @Path("/employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(Employee employee) throws URISyntaxException {
        System.out.println(employee.getEmail());
        EmployeeService employeeService=null;
        employeeService.addEmployee(employee);
        return Response.ok().build();
    }
}
