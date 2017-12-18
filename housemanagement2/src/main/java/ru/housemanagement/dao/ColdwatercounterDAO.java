package ru.housemanagement.dao;

import ru.housemanagement.model.Coldwatercounter;

import java.util.List;

public interface ColdwatercounterDAO {
    void saveColdwatercounter(Coldwatercounter coldwatercounter);
    Coldwatercounter getVolByFlatnumber(Long flatnumber);
    List<Coldwatercounter> getAllColdwatercounter();
    int returnVol();
}
