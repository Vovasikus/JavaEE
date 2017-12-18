package ru.housemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.housemanagement.dao.ColdwatercounterJdbcDAO;


@Service
public class ColdwatercounterService {

    @Autowired
    private ColdwatercounterJdbcDAO coldwatercounterJdbcDAO;

    public int returnVol() {return coldwatercounterJdbcDAO.returnVol();};
}
