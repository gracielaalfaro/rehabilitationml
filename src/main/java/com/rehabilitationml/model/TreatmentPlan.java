package com.rehabilitationml.model;

import java.util.List;

/**
 * Represents a rehabilitation treatment plan for an athlete.
 */
public class TreatmentPlan {
    private String planId;
    private String description;
    private List<String> interventions; // e.g., physiotherapy, surgery, medication
    private int durationDays;
    private List<String> goals; // e.g., restore range of motion, improve muscle strength

    // Getters and setters
    public String getPlanId() { return planId; }
    public void setPlanId(String planId) { this.planId = planId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getInterventions() { return interventions; }
    public void setInterventions(List<String> interventions) { this.interventions = interventions; }

    public int getDurationDays() { return durationDays; }
    public void setDurationDays(int durationDays) { this.durationDays = durationDays; }

    public List<String> getGoals() { return goals; }
    public void setGoals(List<String> goals) { this.goals = goals; }
}
