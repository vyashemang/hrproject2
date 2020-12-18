package com.example.erp.controller;

import com.example.erp.bean.Department;
import com.example.erp.service.DepartmentService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("department")
public class DepartmentController {

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
