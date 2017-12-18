package ru.housemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.housemanagement.dao.MetricJdbcDAO;
import ru.housemanagement.model.Metric;

import java.util.List;


@Service
public class MetricService {

    @Autowired
    private MetricJdbcDAO metricJdbcDAO;

    public MetricService() {
        super();
    }

    public List<Metric> getAllMetrics() {
        return metricJdbcDAO.getAllMetrics();
    }


    public void saveMetric(Metric metric) {
        metricJdbcDAO.saveMetric(metric);
    }

    public List<Metric> getMetricByOwner(String owner) { return metricJdbcDAO.getMetricByOwner(owner);}
}
