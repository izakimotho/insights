package com.lunna.insight.Services.Profile;

import com.lunna.insight.Models.DTO.Profile.AuthorizationDetails;
import com.lunna.insight.Models.DTO.Profile.Permissions;
import com.lunna.insight.Models.DTO.Profile.UserLogin;

import java.util.List;

public interface AuthorizationsBal {
    int checkAuthorization(String userToken, String resourceName, String permission) throws Exception;

    int checkAuthorization(String userToken, String resourceName, String permission, int entityId) throws Exception;

    int checkAuthorization(String userToken) throws Exception;

    int checkAuthorization(int userId, String resourceName, String permission) throws Exception; //for POS call only

    int getUserIdFromToken(String userToken) throws Exception;

    List<Permissions> getPermissions(Integer tenantId, String userToken, String resourceName) throws Exception;

    List<Permissions> getPermissions(Integer tenantId, String userToken, String resourceName, int entityId) throws Exception;

    AuthorizationDetails logAuthorization(List<AuthorizationDetails> authorizationDetails, UserLogin login, int localeId, String userToken, Integer headerId, Integer entityId, String resourceName, String permission, boolean authStatus);

    String getResourceNameByFileUploadType(String type) throws Exception;
}