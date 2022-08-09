
package com.lunna.insight.RestControllers.Common;


import com.lunna.insight.Core.commons.Validator;
import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.RestPayload;
import com.lunna.insight.Services.Core.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/city-master")
public class CityRest {

    @Context
    HttpHeaders headers;

    @Autowired
    CityService cityService;

    @GetMapping
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCities(@PathParam("id") int id, @Context HttpServletRequest request) {
        int page = 1;
        int pageSize = 10;
        int replaceRemoved = 0;
        try {
            if (Validator.isInteger(request.getParameter("page"))) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            if (Validator.isInteger(request.getParameter("pageSize"))) {
                pageSize = Integer.parseInt(request.getParameter("pageSize"));
            }
            if (Validator.isInteger(request.getParameter("replaceRemoved"))) {
                replaceRemoved = Integer.parseInt(request.getParameter("replaceRemoved"));
            }

            RestPayload payload = cityService.getCities(page, replaceRemoved, pageSize,
                request.getParameter("_active") != null ? request.getParameter("_active").equalsIgnoreCase("true") ? ActiveStatus.ACTIVE : ActiveStatus.INACTIVE : ActiveStatus.ALL,
                request.getParameter("_q"), id);
            if (request.getParameter("_noPage") != null && request.getParameter("_noPage").equalsIgnoreCase("true")) {
                return Response.status(200).entity(payload.getResults()).build();
            } else {
                return Response.status(200).entity(payload).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCities(@Context HttpServletRequest request) {
        int page = 1;
        int pageSize = 10;
        int replaceRemoved = 0;
        try {
            if (Validator.isInteger(request.getParameter("page"))) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            if (Validator.isInteger(request.getParameter("pageSize"))) {
                pageSize = Integer.parseInt(request.getParameter("pageSize"));
            }
            if (Validator.isInteger(request.getParameter("replaceRemoved"))) {
                replaceRemoved = Integer.parseInt(request.getParameter("replaceRemoved"));
            }

            RestPayload payload = cityService.getCities(page, replaceRemoved, pageSize,
                request.getParameter("_active") != null ? request.getParameter("_active").equalsIgnoreCase("true") ? ActiveStatus.ACTIVE : ActiveStatus.INACTIVE : ActiveStatus.ALL,
                request.getParameter("_q"));
            if (request.getParameter("_noPage") != null && request.getParameter("_noPage").equalsIgnoreCase("true")) {
                return Response.status(200).entity(payload.getResults()).build();
            } else {
                return Response.status(200).entity(payload).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @GET
    @Path("/{id}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCity(@PathParam("id") int id) {
        try {
            int localeId = 1;
            if (Validator.isInteger(headers.getHeaderString("FC_ActiveLanguage"))) {
                localeId = Integer.parseInt(headers.getHeaderString("FC_ActiveLanguage"));
            }
            return Response.status(200).entity(cityService.getCity(id, localeId)).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }
}
