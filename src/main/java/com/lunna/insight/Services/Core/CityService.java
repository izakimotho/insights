package com.lunna.insight.Services.Core;

import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.City;
import com.lunna.insight.Models.DTO.Common.RestPayload;

public interface CityService {
    RestPayload getCities(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey, int cntryId) throws Exception;

    RestPayload getCities(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey) throws Exception;

    City getCity(int id, int localeId) throws Exception;
}
