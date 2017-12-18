package ru.housemanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.housemanagement.model.Coldwatercounter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ColdwatercounterJdbcDAO implements ColdwatercounterDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ColdwatercounterJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveColdwatercounter(Coldwatercounter coldwatercounter) {
        String sql = "INSERT INTO coldwatercounter (vol) VALUES (?)";
        jdbcTemplate.update(sql, new Object[]{coldwatercounter.getVol()});
    }

    @Override
    public List<Coldwatercounter> getAllColdwatercounter() {
        String sql = "SELECT flatnumber, vol FROM coldwatercounter";
        return jdbcTemplate.query(sql, new RowMapper<Coldwatercounter>() {
            @Override
            public Coldwatercounter mapRow(ResultSet resultSet, int i) throws SQLException {
                Coldwatercounter coldwatercounter = new Coldwatercounter();

                coldwatercounter.setFlatnumber(resultSet.getInt("flatnumber"));
                coldwatercounter.setVol(resultSet.getInt("vol"));

                return coldwatercounter;
            }
        });

    }

    @Override
    public Coldwatercounter getVolByFlatnumber(Long flatnumber) {
        String sql = "SELECT * FROM coldwatercounter WHERE flatnumber = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {flatnumber}, new RowMapper<Coldwatercounter>() {
            @Override
            public Coldwatercounter mapRow(ResultSet resultSet, int i) throws SQLException {
                Coldwatercounter coldwatercounter = new Coldwatercounter();
                coldwatercounter.setVol(resultSet.getInt("vol"));
                coldwatercounter.setFlatnumber(resultSet.getInt("flatnumber"));
                return coldwatercounter;
            }
        });
    }

    @Override
    public int returnVol() {
        String sql = "select vol from coldwatercounter where flatnumber = '102'";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
    }
}
