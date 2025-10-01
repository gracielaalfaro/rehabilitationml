package com.rehabilitationml.model;

import java.util.Map;

/**
 * Represents the clinical, biomechanical, and performance-related data for an athlete's rehabilitation.
 */
public class AthleteRehabData {
    private String athleteId;
    private String injuryType;
    private int injurySeverity; // e.g., scale 1-10
    private String treatmentPlan;
    private Map<String, Double> physiologicalData; // e.g., muscle strength, range of motion
    private Map<String, Double> performanceMetrics; // e.g., speed, agility
    private boolean protocolAdherence;
    private int rehabDurationDays;
    private boolean rehabSuccess; // For supervised learning label

    // Getters and setters
    public String getAthleteId() { return athleteId; }
    public void setAthleteId(String athleteId) { this.athleteId = athleteId; }

    public String getInjuryType() { return injuryType; }
    public void setInjuryType(String injuryType) { this.injuryType = injuryType; }

    public int getInjurySeverity() { return injurySeverity; }
    public void setInjurySeverity(int injurySeverity) { this.injurySeverity = injurySeverity; }

    public String getTreatmentPlan() { return treatmentPlan; }
    public void setTreatmentPlan(String treatmentPlan) { this.treatmentPlan = treatmentPlan; }

    public Map<String, Double> getPhysiologicalData() { return physiologicalData; }
    public void setPhysiologicalData(Map<String, Double> physiologicalData) { this.physiologicalData = physiologicalData; }

    public Map<String, Double> getPerformanceMetrics() { return performanceMetrics; }
    public void setPerformanceMetrics(Map<String, Double> performanceMetrics) { this.performanceMetrics = performanceMetrics; }

    public boolean isProtocolAdherence() { return protocolAdherence; }
    public void setProtocolAdherence(boolean protocolAdherence) { this.protocolAdherence = protocolAdherence; }

    public int getRehabDurationDays() { return rehabDurationDays; }
    public void setRehabDurationDays(int rehabDurationDays) { this.rehabDurationDays = rehabDurationDays; }

    public boolean isRehabSuccess() { return rehabSuccess; }
    public void setRehabSuccess(boolean rehabSuccess) { this.rehabSuccess = rehabSuccess; }
}
