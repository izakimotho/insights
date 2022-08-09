package com.lunna.insight.Services.Profile.ProfileImpl;

import com.lunna.insight.Models.DTO.Profile.AuthorizationDetails;
import com.lunna.insight.Models.DTO.Profile.Permissions;
import com.lunna.insight.Models.DTO.Profile.UserLogin;
import com.lunna.insight.Services.Profile.AuthorizationsService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AuthorizationsServiceImpl implements AuthorizationsService {
    @Override
    public int checkAuthorization(String userToken, String resourceName, String permission) throws Exception {
        return 0;
    }

    @Override
    public int checkAuthorization(String userToken, String resourceName, String permission, int entityId) throws Exception {
        return 0;
    }

    @Override
    public int checkAuthorization(String userToken) throws Exception {
        return 0;
    }

    @Override
    public int checkAuthorization(int userId, String resourceName, String permission) throws Exception {
        return 0;
    }

    @Override
    public int getUserIdFromToken(String userToken) throws Exception {
        return 0;
    }

    @Override
    public List<Permissions> getPermissions(Integer tenantId, String userToken, String resourceName) throws Exception {
        return null;
    }

    @Override
    public List<Permissions> getPermissions(Integer tenantId, String userToken, String resourceName, int entityId) throws Exception {
        return null;
    }

    @Override
    public AuthorizationDetails logAuthorization(List<AuthorizationDetails> authorizationDetails, UserLogin login, int localeId, String userToken, Integer headerId, Integer entityId, String resourceName, String permission, boolean authStatus) {
        return null;
    }

    @Override
    public String getResourceNameByFileUploadType(String type) throws Exception {
        return null;
    }
}
