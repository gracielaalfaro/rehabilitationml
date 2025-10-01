package com.rehabilitationml.model;

import java.time.LocalDateTime;

/**
 * Represents a specific performance metric for an athlete.
 */
public class PerformanceMetric {
    private String metricName;
    private double value;
    private LocalDateTime timestamp;

    // Getters and setters
    public String getMetricName() { return metricName; }
    public void setMetricName(String metricName) { this.metricName = metricName; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
