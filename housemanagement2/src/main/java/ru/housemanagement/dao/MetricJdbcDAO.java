package ru.housemanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import ru.housemanagement.model.Metric;

import java.util.List;

@Repository
public class MetricJdbcDAO implements MetricDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MetricJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveMetric(Metric metric) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String owner = auth.getName();

        String sql = "INSERT INTO metrics (owner, vol) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{owner, metric.getVol()});
    }



    @Override
    public List<Metric> getAllMetrics() {
        String sql = "SELECT owner, vol, timeoffilling FROM metrics";
        return jdbcTemplate.query(sql, (resultSet, i) -> {

            Metric metric = new Metric();

            metric.setOwner(resultSet.getString("owner"));
            metric.setVol(resultSet.getInt("vol"));
            metric.setTimeoffilling(resultSet.getString("timeoffilling"));

            return metric;
        });
    }

    @Override
    public List<Metric> getMetricByOwner(String owner) {
        String sql = "SELECT * FROM metrics WHERE owner = ?";
        return jdbcTemplate.query(sql, new Object[] {owner}, (resultSet, i) -> {

            Metric metric = new Metric();

            metric.setOwner(resultSet.getString("owner"));
            metric.setVol(resultSet.getInt("vol"));
            metric.setTimeoffilling(resultSet.getString("timeoffilling"));

            return metric;
        });
    }
}
