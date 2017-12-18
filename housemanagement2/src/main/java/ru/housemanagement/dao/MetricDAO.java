package ru.housemanagement.dao;

import ru.housemanagement.model.Metric;

import java.util.List;

public interface MetricDAO {
    void saveMetric(Metric metric);
    List<Metric> getMetricByOwner(String owner);
    List<Metric> getAllMetrics();
}
