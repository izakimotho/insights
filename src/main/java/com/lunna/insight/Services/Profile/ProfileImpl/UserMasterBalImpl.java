package com.lunna.insight.Services.Profile.ProfileImpl;

import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.CommonInfo;
import com.lunna.insight.Models.DTO.Common.RestPayload;
import com.lunna.insight.Models.DTO.Profile.UserMaster;
import com.lunna.insight.Services.Profile.UserMasterBal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMasterBalImpl implements UserMasterBal {
    @Override
    public RestPayload getUserCreations(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey, String oderBy, String oderType, boolean authStatus, int menuId, String reqUrl, boolean noPage, boolean reduced, int tenantId, boolean rejected) throws Exception {
        return null;
    }

    @Override
    public UserMaster getUserCreation(int id, int menuId, String reqUrl, int tenantId) throws Exception {
        return null;
    }

    @Override
    public UserMaster getUserCreationByToken(String token, int menuId, String reqUrl, int tenantId) throws Exception {
        return null;
    }

    @Override
    public UserMaster updateUserCreation(UserMaster userMaster, String baseUri, CommonInfo commonInfo, int loggedInUser, int tenantId) throws Exception {
        return null;
    }

    @Override
    public List<Integer> activateDeactivateUserCreations(List<Integer> userCreationIds, boolean activate, int menuId, CommonInfo commonInfo, int tenantId) throws Exception {
        return null;
    }

    @Override
    public UserMaster createUserCreation(UserMaster userMaster, String baseUri, int menuId, CommonInfo commonInfo, int tenantId) throws Exception {
        return null;
    }

    @Override
    public UserMaster NextLoginChangePwd(UserMaster userMaster, int menuId, String baseUri, String reqUri, CommonInfo commonInfo, int tenantId) throws Exception {
        return null;
    }


    @Override
    public UserMaster loadUserByUsername(String user) throws Exception {



        UserMaster userMaster =new UserMaster();

            try {

            } catch (Exception ex) {
                ex.printStackTrace();

                throw ex;
            }
        return userMaster;
    }
}
