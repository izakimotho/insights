package com.lunna.insight.Services.Profile;

import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.CommonInfo;
import com.lunna.insight.Models.DTO.Common.RestPayload;
import com.lunna.insight.Models.DTO.Profile.UserMaster;

import java.util.List;

public interface UserMasterBal {
    RestPayload getUserCreations(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey, String oderBy, String oderType, boolean authStatus, int menuId, String reqUrl, boolean noPage, boolean reduced, int tenantId, boolean rejected) throws Exception;

    UserMaster getUserCreation(int id,  int menuId, String reqUrl, int tenantId) throws Exception;

    UserMaster getUserCreationByToken(String token,  int menuId, String reqUrl, int tenantId) throws Exception;

    UserMaster updateUserCreation(UserMaster userMaster, String baseUri, CommonInfo commonInfo, int loggedInUser, int tenantId) throws Exception;

    List<Integer> activateDeactivateUserCreations(List<Integer> userCreationIds, boolean activate, int menuId, CommonInfo commonInfo, int tenantId) throws Exception;

    UserMaster createUserCreation(UserMaster userMaster, String baseUri, int menuId, CommonInfo commonInfo, int tenantId) throws Exception;

    UserMaster NextLoginChangePwd(UserMaster userMaster, int menuId, String baseUri, String reqUri, CommonInfo commonInfo, int tenantId) throws Exception;


    UserMaster loadUserByUsername(String userMaster) throws Exception;

}