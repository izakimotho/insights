package com.lunna.insight.DAO.CoreDal;

import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.Country;
import com.lunna.insight.Models.DTO.Common.RestPayload;

import java.util.UUID;

public interface CountryDal {
    RestPayload getCountry(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey) throws Exception;

    Country getCountry(UUID id) throws Exception;

}
