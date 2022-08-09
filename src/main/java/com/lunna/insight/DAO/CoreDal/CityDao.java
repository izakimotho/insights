package com.lunna.insight.DAO.CoreDal;

import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.City;
import com.lunna.insight.Models.DTO.Common.RestPayload;

public interface CityDao {
    RestPayload getCities(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey, int cntryId) throws Exception;

    RestPayload getCities(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey) throws Exception;

    City getCity(int id) throws Exception;

}
