package com.rehabilitationml.model;

import java.time.LocalDate;

/**
 * Tracks adherence to rehabilitation protocols.
 */
public class ProtocolAdherence {
    private String athleteId;
    private LocalDate date;
    private boolean adhered;
    private String notes;

    // Getters and setters
    public String getAthleteId() { return athleteId; }
    public void setAthleteId(String athleteId) { this.athleteId = athleteId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public boolean isAdhered() { return adhered; }
    public void setAdhered(boolean adhered) { this.adhered = adhered; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
