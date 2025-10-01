package com.rehabilitationml.model;

/**
 * Represents an athlete's personal and demographic information.
 */
public class Athlete {
    private String athleteId;
    private String name;
    private int age;
    private String gender;
    private String sport;
    private String position;
    private String team;

    // Getters and setters
    public String getAthleteId() { return athleteId; }
    public void setAthleteId(String athleteId) { this.athleteId = athleteId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getSport() { return sport; }
    public void setSport(String sport) { this.sport = sport; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }
}
