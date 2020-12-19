package com.example.erp.controller;

import com.example.erp.bean.Department;
import com.example.erp.service.DepartmentService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("department")
public class DepartmentController {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartment(){

        List<String> departments;

        DepartmentService departmentService = new DepartmentService();
        departments = departmentService.getDepartment();

        return Response.ok().entity(departments).build();
    }

    @GET
    @Path("/read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readDepartment(){
        List<Department> departments;
        DepartmentService departmentService = new DepartmentService();
        departments = departmentService.readDepartment();
        return Response.ok().entity(departments).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDepartment(Department department) throws URISyntaxException {
        System.out.println(department.getDname());
        System.out.println(department.getCapacity());
        DepartmentService departmentService = null;
        departmentService.addDepartment(department);
        return Response.ok().build();
    }



}
