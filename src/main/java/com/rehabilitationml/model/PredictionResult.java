package com.rehabilitationml.model;

/**
 * Stores model prediction results and confidence scores.
 */
public class PredictionResult {
    private String athleteId;
    private boolean predictedSuccess;
    private double confidenceScore;
    private String explanation;

    // Getters and setters
    public String getAthleteId() { return athleteId; }
    public void setAthleteId(String athleteId) { this.athleteId = athleteId; }

    public boolean isPredictedSuccess() { return predictedSuccess; }
    public void setPredictedSuccess(boolean predictedSuccess) { this.predictedSuccess = predictedSuccess; }

    public double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(double confidenceScore) { this.confidenceScore = confidenceScore; }

    public String getExplanation() { return explanation; }
    public void setExplanation(String explanation) { this.explanation = explanation; }
}
