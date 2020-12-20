package com.example.erp.controller;

import com.example.erp.bean.Department;
import com.example.erp.bean.Employee;
import com.example.erp.service.DepartmentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("department")
public class DepartmentController {

    DepartmentService departmentService = new DepartmentService();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartment(){

        List<String> departments;
        departments = departmentService.getDepartment();

        return Response.ok().entity(departments).build();
    }

    @GET
    @Path("/read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readDepartment(){
        List<Department> departments;
        departments = departmentService.readDepartment();
        return Response.ok().entity(departments).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDepartment(Department department) throws URISyntaxException {
        departmentService.addDepartment(department);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees(@PathParam("id") int id){
        List<Employee> employees;
        employees = departmentService.getEmployeesByDeptId(id);
        System.out.println(employees);
        return Response.ok().entity(employees).build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDepartment(Department department) throws URISyntaxException {
        departmentService.updateDepartment(department);
        return Response.ok().build();
    }


}
