

package com.lunna.insight.RestControllers.Profile;


import com.lunna.insight.Core.commons.Constants;
import com.lunna.insight.Core.commons.Validator;
import com.lunna.insight.Core.exceptions.DataValidationException;
import com.lunna.insight.Core.exceptions.DuplicateEntryException;
import com.lunna.insight.Core.exceptions.NoRightsException;
import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.CommonInfo;
import com.lunna.insight.Models.DTO.Common.RestPayload;
import com.lunna.insight.Models.DTO.Profile.Permissions;
import com.lunna.insight.Models.DTO.Profile.UserMaster;
import com.lunna.insight.Services.Profile.AuthorizationsBal;
import com.lunna.insight.Services.Profile.UserMasterBal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Component
@Path("/user-creation")
public class UserMasterRest {
    @Context
    private UriInfo uri;

    @Context
    private HttpHeaders headers;

    @Autowired
    private UserMasterBal userMasterBal;

    @Autowired
    private AuthorizationsBal authorizationsBal;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserCreations(@Context HttpServletRequest request) {

        int page = 1;
        int pageSize = 10;
        int replaceRemoved = 0;
        int localeId = 1;
        int menuId = 0;
        try {
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            }
            int tenantEntity = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            if (Validator.isInteger(headers.getHeaderString("FC_ActiveLanguage"))) {
                localeId = Integer.parseInt(headers.getHeaderString("FC_ActiveLanguage"));
            }
            if (Validator.isInteger(request.getParameter("page"))) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            if (Validator.isInteger(request.getParameter("pageSize"))) {
                pageSize = Integer.parseInt(request.getParameter("pageSize"));
            }
            if (Validator.isInteger(request.getParameter("replaceRemoved"))) {
                replaceRemoved = Integer.parseInt(request.getParameter("replaceRemoved"));
            }
            if (Validator.isInteger(headers.getHeaderString("FC_Menu"))) {
                menuId = Integer.parseInt(headers.getHeaderString("FC_Menu"));
            }
            int tenantId;
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            } else {
                tenantId = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            }
            if (Validator.validateBlankString(request.getParameter("token"))) {
                return Response.status(200).entity(userMasterBal.getUserCreationByToken(request.getParameter("token"), menuId, uri.getBaseUri().toString() + "files/", tenantId)).build();
            }
            boolean rejected = Boolean.parseBoolean(request.getParameter("rejected"));
            RestPayload payload;
            authorizationsBal.checkAuthorization(headers.getHeaderString("FC_Authorization"), Constants.USER_MASTER_RESOURCE_NAME, Constants.ACTION_VIEW);
            payload = userMasterBal.getUserCreations(page, replaceRemoved, pageSize, request.getParameter("_active") != null ? request.getParameter("_active").equalsIgnoreCase("true") ? ActiveStatus.ACTIVE : ActiveStatus.INACTIVE : ActiveStatus.ALL, request.getParameter("_q"), request.getParameter("oderBy"), request.getParameter("oderType"), request.getParameter("authStatus") == null || (request.getParameter("authStatus").equalsIgnoreCase("true")), menuId, uri.getBaseUri().toString() + "files/", request.getParameter("_noPage") != null && request.getParameter("_noPage").equalsIgnoreCase("true"), request.getParameter("_reduced") != null && request.getParameter("_reduced").equalsIgnoreCase("true"), tenantId, rejected);

            if (null != payload && request.getParameter("_noPage") != null && request.getParameter("_noPage").equalsIgnoreCase("true")) {
                return Response.status(200).entity(payload.getResults()).build();
            } else {
                return Response.status(200).entity(payload).build();
            }
        } catch (NoRightsException nre) {
            nre.printStackTrace();
            throw new WebApplicationException(nre.getMessage(), 403);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @GET
    @Path("/{id}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserCreation(@Context HttpServletRequest request, @PathParam("id") int id) {
        try {
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            }
            int tenantEntity = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            int localeId = 1;
            int menuId = 0;
            UserMaster retUserMaster;
            if (Validator.isInteger(headers.getHeaderString("FC_ActiveLanguage"))) {
                localeId = Integer.parseInt(headers.getHeaderString("FC_ActiveLanguage"));
            }
            if (Validator.isInteger(headers.getHeaderString("FC_Menu"))) {
                menuId = Integer.parseInt(headers.getHeaderString("FC_Menu"));
            }
            int tenantId;
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            } else {
                tenantId = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            }
            authorizationsBal.checkAuthorization(headers.getHeaderString("FC_Authorization"), Constants.USER_MASTER_RESOURCE_NAME, Constants.ACTION_VIEW);
            retUserMaster = userMasterBal.getUserCreation(id, menuId, uri.getBaseUri().toString() + "files/", tenantId);

            return Response.status(200).entity(retUserMaster).build();
        } catch (NoRightsException nre) {
            nre.printStackTrace();
            throw new WebApplicationException(nre.getMessage(), 403);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserCreations(UserMaster userMaster, @Context HttpServletRequest request, @PathParam("id") int id) {
        try {
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            }
            int tenantEntity = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));

            UserMaster retUserMaster;

            int loggedInUser = authorizationsBal.checkAuthorization(headers.getHeaderString("FC_Authorization"), Constants.USER_MASTER_RESOURCE_NAME, Constants.ACTION_UPDATE);
            String userIp = ":::127";
            Date userDate = new Date();
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Ip"))) {
                userIp = headers.getHeaderString("FC_Client_Ip");
            }
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Time"))) {
                userDate = new Date(Long.parseLong(headers.getHeaderString("FC_Client_Time")));
            }
            CommonInfo commonInfo = new CommonInfo();
            commonInfo.setUserIp(userIp);
            commonInfo.setUserDate(userDate);
            commonInfo.setUserId(loggedInUser);
            commonInfo.setTenantId(tenantEntity);
            retUserMaster = userMasterBal.updateUserCreation(userMaster, uri.getBaseUri().toString(), commonInfo, loggedInUser, tenantEntity);
            return Response.status(200).entity(retUserMaster).build();
        } catch (NoRightsException nre) {
            nre.printStackTrace();
            throw new WebApplicationException(nre.getMessage(), 403);
        } catch (DataValidationException dve) {
            throw new WebApplicationException(dve.getMessage(), 417);
        } catch (DuplicateEntryException dup) {
            dup.printStackTrace();
            throw new WebApplicationException(dup.getMessage(), 409);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @PUT
    @Path("nextLoginChangePwd/{id}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response NextLoginChangePwd(UserMaster userMaster, @Context HttpServletRequest request, @PathParam("id") int id) {
        try {
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            }
            int tenantEntity = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            int localeId = 1;
            int menuId = 0;

            UserMaster retUserMaster;
            if (Validator.isInteger(headers.getHeaderString("FC_ActiveLanguage"))) {
                localeId = Integer.parseInt(headers.getHeaderString("FC_ActiveLanguage"));
            }
            if (Validator.isInteger(headers.getHeaderString("FC_Menu"))) {
                menuId = Integer.parseInt(headers.getHeaderString("FC_Menu"));
            }
            String userIp = ":::127";
            Date userDate = new Date();
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Ip"))) {
                userIp = headers.getHeaderString("FC_Client_Ip");
            }
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Time"))) {
                userDate = new Date(Long.parseLong(headers.getHeaderString("FC_Client_Time")));
            }
            int tenantId;
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            } else {
                tenantId = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            }
            int userId = authorizationsBal.checkAuthorization(headers.getHeaderString("FC_Authorization"), Constants.USER_MASTER_RESOURCE_NAME, Constants.ACTION_UPDATE);
            CommonInfo commonInfo = new CommonInfo();
            commonInfo.setUserIp(userIp);
            commonInfo.setUserDate(userDate);
            commonInfo.setTenantId(tenantEntity);
            commonInfo.setUserId(userId);
            retUserMaster = userMasterBal.NextLoginChangePwd(userMaster, menuId, uri.getBaseUri().toString(), uri.getBaseUri().toString(), commonInfo, tenantId);

            return Response.status(200).entity(retUserMaster).build();
        } catch (NoRightsException nre) {
            nre.printStackTrace();
            throw new WebApplicationException(nre.getMessage(), 403);
        } catch (DuplicateEntryException dup) {
            dup.printStackTrace();
            throw new WebApplicationException(dup.getMessage(), 409);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @POST
    @Path("/activate")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response activateUserCreations(List<Integer> UserCreationIDs, @Context HttpServletRequest request) {
        try {
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            }
            int tenantEntity = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            int menuId = 0;
            if (Validator.isInteger(headers.getHeaderString("FC_Menu"))) {
                menuId = Integer.parseInt(headers.getHeaderString("FC_Menu"));
            }
            String userIp = ":::127";
            Date userDate = new Date();
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Ip"))) {
                userIp = headers.getHeaderString("FC_Client_Ip");
            }
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Time"))) {
                userDate = new Date(Long.parseLong(headers.getHeaderString("FC_Client_Time")));
            }
            List<Integer> activate;
            int loggedInUser = authorizationsBal.checkAuthorization(headers.getHeaderString("FC_Authorization"), Constants.USER_MASTER_RESOURCE_NAME, Constants.ACTION_ACTIVATE);
            CommonInfo commonInfo = new CommonInfo();
            commonInfo.setUserIp(userIp);
            commonInfo.setUserDate(userDate);
            commonInfo.setTenantId(tenantEntity);
            commonInfo.setUserId(loggedInUser);
            int tenantId;
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            } else {
                tenantId = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            }
            activate = userMasterBal.activateDeactivateUserCreations(UserCreationIDs, true, menuId, commonInfo, tenantId);

            return Response.status(200).entity(activate).build();
        } catch (NoRightsException nre) {
            nre.printStackTrace();
            throw new WebApplicationException(nre.getMessage(), 403);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }

    }

    @POST
    @Path("/deactivate")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deActivateUserCreations(List<Integer> UserCreationIDs, @Context HttpServletRequest request) {
        try {
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            }
            int tenantEntity = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            int menuId = 0;
            if (Validator.isInteger(headers.getHeaderString("FC_Menu"))) {
                menuId = Integer.parseInt(headers.getHeaderString("FC_Menu"));
            }
            String userIp = ":::127";
            Date userDate = new Date();
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Ip"))) {
                userIp = headers.getHeaderString("FC_Client_Ip");
            }
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Time"))) {
                userDate = new Date(Long.parseLong(headers.getHeaderString("FC_Client_Time")));
            }
            List<Integer> deactivate;
            int loggedInUser = authorizationsBal.checkAuthorization(headers.getHeaderString("FC_Authorization"), Constants.USER_MASTER_RESOURCE_NAME, Constants.ACTION_DEACTIVATE);
            CommonInfo commonInfo = new CommonInfo();
            commonInfo.setUserIp(userIp);
            commonInfo.setUserDate(userDate);
            commonInfo.setTenantId(tenantEntity);
            commonInfo.setUserId(loggedInUser);
            int tenantId;
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            } else {
                tenantId = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            }
            deactivate = userMasterBal.activateDeactivateUserCreations(UserCreationIDs, false, menuId, commonInfo, tenantId);

            return Response.status(200).entity(deactivate).build();
        } catch (NoRightsException nre) {
            nre.printStackTrace();
            throw new WebApplicationException(nre.getMessage(), 403);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/json")
    public Response createUserCreation(@Context HttpServletRequest request, UserMaster userMaster) {
        Locale locale;
        try {
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            }
            int tenantEntity = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            int localeId = 1;
            int menuId = 0;
            int userId;

            if (Validator.isInteger(headers.getHeaderString("FC_ActiveLanguage"))) {
                localeId = Integer.parseInt(headers.getHeaderString("FC_ActiveLanguage"));
            }
            if (Validator.isInteger(headers.getHeaderString("FC_Menu"))) {
                menuId = Integer.parseInt(headers.getHeaderString("FC_Menu"));
            }

            UserMaster retUserMaster;
            userId = authorizationsBal.checkAuthorization(headers.getHeaderString("FC_Authorization"), Constants.USER_MASTER_RESOURCE_NAME, Constants.ACTION_CREATE);
            String userIp = ":::127";
            Date userDate = new Date();
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Ip"))) {
                userIp = headers.getHeaderString("FC_Client_Ip");
            }
            if (Validator.validateBlankString(headers.getHeaderString("FC_Client_Time"))) {
                userDate = new Date(Long.parseLong(headers.getHeaderString("FC_Client_Time")));
            }
            CommonInfo commonInfo = new CommonInfo();
            commonInfo.setUserIp(userIp);
            commonInfo.setUserDate(userDate);
            commonInfo.setTenantId(tenantEntity);
            commonInfo.setUserId(userId);
            int tenantId;
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            } else {
                tenantId = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            }
            retUserMaster = userMasterBal.createUserCreation(userMaster, uri.getBaseUri().toString(), menuId, commonInfo, tenantId);

            return Response.status(200).entity(retUserMaster).build();
        } catch (NoRightsException nre) {
            nre.printStackTrace();
            throw new WebApplicationException(nre.getMessage(), 403);
        } catch (DuplicateEntryException dup) {
            dup.printStackTrace();
            throw new WebApplicationException(dup.getMessage(), 409);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }



    @GET
    @Path("/permissions")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPermissions(@Context HttpServletRequest request) {
        try {
            int tenantId;
            if (headers.getHeaderString("Tenant_Entity") == null || headers.getHeaderString("Tenant_Entity").equalsIgnoreCase("")) {
                throw new Exception("Missing Tenant Entity Header");
            } else {
                tenantId = Integer.parseInt(headers.getHeaderString("Tenant_Entity"));
            }

            List<Permissions> permissions = authorizationsBal.getPermissions(tenantId, headers.getHeaderString("FC_Authorization"), Constants.USER_MASTER_RESOURCE_NAME);
            return Response.status(200).entity(permissions).build();
        } catch (NoRightsException nre) {
            throw new WebApplicationException(nre.getMessage(), 403);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }
}
