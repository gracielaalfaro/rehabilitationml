package com.rehabilitationml.model;

/**
 * Represents patient-reported feedback and outcome measures.
 */
public class FeedbackOutcome {
    private String athleteId;
    private int painScore; // e.g., scale 0-10
    private int satisfactionScore; // e.g., scale 0-10
    private int functionalScore; // e.g., scale 0-100
    private String comments;

    // Getters and setters
    public String getAthleteId() { return athleteId; }
    public void setAthleteId(String athleteId) { this.athleteId = athleteId; }

    public int getPainScore() { return painScore; }
    public void setPainScore(int painScore) { this.painScore = painScore; }

    public int getSatisfactionScore() { return satisfactionScore; }
    public void setSatisfactionScore(int satisfactionScore) { this.satisfactionScore = satisfactionScore; }

    public int getFunctionalScore() { return functionalScore; }
    public void setFunctionalScore(int functionalScore) { this.functionalScore = functionalScore; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
}
