package com.lunna.insight.RestControllers.Profile;

import com.lunna.insight.Core.exceptions.NoRightsException;
import com.lunna.insight.Core.commons.Validator;
import com.lunna.insight.Core.exceptions.UserNotExistException;
import com.lunna.insight.Models.DTO.Common.CommonInfo;
import com.lunna.insight.Models.DTO.Common.ModuleChange;
import com.lunna.insight.Models.DTO.Profile.AuthorizationDetails;
import com.lunna.insight.Models.DTO.Profile.LoginAction;
import com.lunna.insight.Models.DTO.Profile.UserLogin;
import com.lunna.insight.Models.DTO.Profile.UserModules;
import com.lunna.insight.Services.Profile.AuthorizationsService;
import com.lunna.insight.Services.Profile.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class LoginRest {

    @Context
    private UriInfo uri;

    @Autowired
    private LoginService loginServices;

    @Context
    private HttpHeaders headers;

    @Autowired
    private AuthorizationsService  authorizationsServices;

    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity getLoginAction(UserLogin login) {
        try {
            String userIp = ":::127";
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Ip"))) {
                userIp = headers.getHeaderString("FC_Client_Ip");
            }
            LoginAction loginAction;
            loginAction = loginServices.validateUser(login);
            if (null != login.getReason()) {

                if (null != loginAction.getToken()) {
                    AuthorizationDetails authorizationDetailsObj = authorizationsServices.logAuthorization(null, login, 1, loginAction.getToken(), null, loginAction.getTenantEntity().getId(), null, null, true);

                    loginAction.setAuthorizations(authorizationDetailsObj);
                }

            }
            return  ResponseEntity.ok(HttpStatus.resolve(200));
            //return  ResponseEntity.status(200).toString();

            //return Response.status(200).entity(loginAction).build();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            e.getCause();
            throw new WebApplicationException(e.getMessage(), 420);
        }
    }

    @POST
    @Consumes("application/json")
    @Path("/validate-user")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity validateUserName(UserLogin login) {
        try {
            String userIp = ":::127";
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Ip"))) {
                userIp = headers.getHeaderString("FC_Client_Ip");
            }
            //return Response.status(200).entity(loginServices.validateUserName(login, uri.getBaseUri().toString() + "files/", new CommonInfo(userIp))).build();
            return  ResponseEntity.ok(HttpStatus.resolve(200));
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage(), 420);
        }
    }

    @POST
    @Path("/module")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity allowModuleChange(ModuleChange change) {
        try {
            authorizationsServices.checkAuthorization(headers.getHeaderString("Authorization"));
            change.setKey(headers.getHeaderString("Authorization"));

            loginServices.checkNextModuleLicence(change);

            //return Response.status(200).entity(loginServices.checkNextModuleLicence(change)).build();
            return  ResponseEntity.ok(HttpStatus.resolve(200));
        } catch (NoRightsException nre) {
            nre.printStackTrace();
            throw new WebApplicationException(nre.getMessage(), 403);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e, 420);
        }
    }

    @POST
    @Path("/{email}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity updateUserCreations(@Context HttpServletRequest request, @PathParam("email") String email) {
        try {

            int tenantId;
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            } else {
                tenantId = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            }

            boolean flag = loginServices.userResetPassword(email, uri.getBaseUri().toString(),  tenantId);
            //return Response.status(200).entity(flag).build();
            return  ResponseEntity.ok(HttpStatus.resolve(200));
        } catch (UserNotExistException e) {
            throw new WebApplicationException(e.getMessage(), 401);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @PUT
    @Path("/signOut")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity signOutUser(@Context HttpServletRequest request, LoginAction action) {
        try {
            LoginAction loginAction=loginServices.signOutUser(action);
            //return Response.status(200).entity(loginServices.signOutUser(action)).build();

            return  ResponseEntity.ok(HttpStatus.resolve(200));
        } catch (UserNotExistException e) {
            throw new WebApplicationException(e.getMessage(), 401);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @PUT
    @Path("/clear-session")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity clearExistingSessions(@Context HttpServletRequest request, UserLogin login) {
        try {
            LoginAction loginAction=loginServices.clearExistingSessions(login);
           // return Response.status(200).entity(loginServices.clearExistingSessions(login)).build();
            return  ResponseEntity.ok(HttpStatus.resolve(200));
        } catch (UserNotExistException e) {
            throw new WebApplicationException(e.getMessage(), 401);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @POST
    @Path("/user-modules")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity getAvailableModules(UserLogin login) {
        try {
           //return Response.status(200).entity(loginServices.getAvailableUserModules(login)).build();
            UserModules userModules=loginServices.getAvailableUserModules(login);
            return  ResponseEntity.ok(HttpStatus.resolve(200));


        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage(), 420);
        }
    }
}
