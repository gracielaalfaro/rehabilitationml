package com.rehabilitationml.model;

import java.time.LocalDate;

/**
 * Represents an injury sustained by an athlete.
 */
public class Injury {
    private String injuryId;
    private String athleteId;
    private String injuryType;
    private String location;
    private int severity; // e.g., scale 1-10
    private LocalDate injuryDate;
    private boolean recurrent;

    // Getters and setters
    public String getInjuryId() { return injuryId; }
    public void setInjuryId(String injuryId) { this.injuryId = injuryId; }

    public String getAthleteId() { return athleteId; }
    public void setAthleteId(String athleteId) { this.athleteId = athleteId; }

    public String getInjuryType() { return injuryType; }
    public void setInjuryType(String injuryType) { this.injuryType = injuryType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getSeverity() { return severity; }
    public void setSeverity(int severity) { this.severity = severity; }

    public LocalDate getInjuryDate() { return injuryDate; }
    public void setInjuryDate(LocalDate injuryDate) { this.injuryDate = injuryDate; }

    public boolean isRecurrent() { return recurrent; }
    public void setRecurrent(boolean recurrent) { this.recurrent = recurrent; }
}
