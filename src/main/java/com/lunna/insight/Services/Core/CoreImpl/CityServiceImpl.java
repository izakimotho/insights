package com.lunna.insight.Services.Core.CoreImpl;

import com.lunna.insight.DAO.CoreDal.CityDao;
import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.City;
import com.lunna.insight.Models.DTO.Common.RestPayload;
import com.lunna.insight.Services.Core.CityService;
import org.springframework.stereotype.Component;


@Component
public class CityServiceImpl implements CityService {
    CityDao cityDao;

    @Override
    public RestPayload getCities(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey, int cntryId) throws Exception {
        return cityDao.getCities(page, replaceRemoved, maxRecords, status, searchKey, cntryId);
    }

    @Override
    public RestPayload getCities(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey) throws Exception {
        return cityDao.getCities(page, replaceRemoved, maxRecords, status, searchKey);
    }

    @Override
    public City getCity(int id, int localeId) throws Exception {
        return cityDao.getCity(id);
    }
}
