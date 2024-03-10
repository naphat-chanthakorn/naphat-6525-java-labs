package chanthakorn.naphat.lab11;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    protected String name, nationality, dob, playerType, gender;
    ArrayList<String> hobby, sport;
    protected int year;

    // Constructor
    public Player(String name, String nationality, String dob, String playerType, String gender, ArrayList<String> hobby, ArrayList<String> sport, int year) {
        this.name = name;
        this.nationality = nationality;
        this.dob = dob;
        this.playerType = playerType;
        this.gender = gender;
        this.hobby = hobby;
        this.sport = sport;
        this.year = year;
    }
    
    // Getters and setters for each attribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<String> getHobby() {
        return hobby;
    }

    public void setHobby(ArrayList<String> hobby) {
        this.hobby = hobby;
    }

    public ArrayList<String> getSport() {
        return sport;
    }

    public void setSport(ArrayList<String> sports) {
        this.sport = sport;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}