package com.lunna.insight.Services.Profile;

import com.lunna.insight.Core.security.session.TokenResponse;
import com.lunna.insight.Models.DTO.Common.CommonInfo;
import com.lunna.insight.Models.DTO.Common.ModuleChange;
import com.lunna.insight.Models.DTO.Profile.LoginAction;
import com.lunna.insight.Models.DTO.Profile.UserLogin;
import com.lunna.insight.Models.DTO.Profile.UserModules;
import com.lunna.insight.Models.DTO.Profile.ValidUserAction;


public interface LoginService {

    LoginAction validateUser(UserLogin login) throws Exception;

    ValidUserAction validateUserName(UserLogin login, String reqUrl, CommonInfo commonInfo) throws Exception;

    UserModules getAvailableUserModules(final UserLogin login) throws Exception;

    boolean userResetPassword(String email, String dateTime, int tenantId) throws Exception;

    LoginAction signOutUser(LoginAction action) throws Exception;

    LoginAction clearExistingSessions(UserLogin login) throws Exception;

    TokenResponse checkNextModuleLicence(ModuleChange change) throws Exception;

}
