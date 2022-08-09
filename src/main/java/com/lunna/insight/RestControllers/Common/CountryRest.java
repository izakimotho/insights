/*
 * Copyright (c) 2016 FC-ServiceStack Compulynx LTD.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are NOT permitted.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL COMPULYNX LTD BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.lunna.insight.RestControllers.Common;

import com.lunna.insight.Core.commons.Validator;
import com.lunna.insight.Models.DTO.ApiResponse;
import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.Country;
import com.lunna.insight.Models.DTO.Common.RestPayload;
import com.lunna.insight.Services.Core.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;


@Component
@RestController
@Transactional
@RequestMapping("/country-master")
public class CountryRest {
    @Context
    HttpHeaders headers;
    @Autowired
    CountryService countryBal;

    @GetMapping()
    @Produces(MediaType.APPLICATION_JSON)
    public  ApiResponse<Country> getCountries(@Context HttpServletRequest request) {
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

            RestPayload payload = countryBal.getCountry(page, replaceRemoved, pageSize,
                request.getParameter("_active") != null ? request.getParameter("_active").equalsIgnoreCase("true") ? ActiveStatus.ACTIVE : ActiveStatus.INACTIVE : ActiveStatus.ALL,
                request.getParameter("_q"));


            if (request.getParameter("_noPage") != null && request.getParameter("_noPage").equalsIgnoreCase("true")) {
                //return Response.status(200).entity(payload.getResults()).build();

                return new ApiResponse<>(HttpStatus.OK.value(), "Country fetched successfully.", payload);
            } else {
                return new ApiResponse<>(HttpStatus.OK.value(), "Country fetched successfully.", payload);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<Country> getCountry(@PathVariable("id") UUID id) {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), "Country fetched successfully.", countryBal.getCountry(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }
}
