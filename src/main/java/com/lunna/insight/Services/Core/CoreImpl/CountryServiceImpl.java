package com.lunna.insight.Services.Core.CoreImpl;

import com.lunna.insight.DAO.CoreDal.CountryDal;
import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.Country;
import com.lunna.insight.Models.DTO.Common.RestPayload;
import com.lunna.insight.Services.Core.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component

@Transactional
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryDal countryDal;

    @Override
    public RestPayload getCountry(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey) throws Exception {
        return countryDal.getCountry(page, replaceRemoved, maxRecords, status, searchKey);
    }

    @Override
    public Country getCountry(UUID id) throws Exception {
        return countryDal.getCountry(id);
    }
}
