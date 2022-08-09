package com.lunna.insight.Services.Profile.ProfileImpl;

import com.lunna.insight.Core.security.session.TokenResponse;
import com.lunna.insight.Models.DTO.Common.CommonInfo;
import com.lunna.insight.Models.DTO.Common.ModuleChange;
import com.lunna.insight.Models.DTO.Profile.LoginAction;
import com.lunna.insight.Models.DTO.Profile.UserLogin;
import com.lunna.insight.Models.DTO.Profile.UserModules;
import com.lunna.insight.Models.DTO.Profile.ValidUserAction;
import com.lunna.insight.Services.Profile.LoginService;
import org.springframework.stereotype.Component;


@Component
public class LoginServiceImpl implements LoginService {
    @Override
    public LoginAction validateUser(UserLogin login) throws Exception {
        return null;
    }

    @Override
    public ValidUserAction validateUserName(UserLogin login, String reqUrl, CommonInfo commonInfo) throws Exception {
        return null;
    }

    @Override
    public UserModules getAvailableUserModules(UserLogin login) throws Exception {
        return null;
    }

    @Override
    public boolean userResetPassword(String email, String dateTime, int tenantId) throws Exception {
        return false;
    }

    @Override
    public LoginAction signOutUser(LoginAction action) throws Exception {
        return null;
    }

    @Override
    public LoginAction clearExistingSessions(UserLogin login) throws Exception {
        return null;
    }

    @Override
    public TokenResponse checkNextModuleLicence(ModuleChange change) throws Exception {
        return null;
    }
}
