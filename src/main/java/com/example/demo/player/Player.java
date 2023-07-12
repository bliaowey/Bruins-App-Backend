package com.example.demo.player;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.time.*;
import java.util.*;

@Entity
@Table
public class Player implements Serializable{
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    private String name;
    @Id
    private int jerseyNumber;
    private String position;
    private LocalDate dob;
    @Transient
    private int age;
    private String height;
    private int weight;
    private String birthplace;
    private boolean shootsRight;
    private boolean isCaptain;
    private boolean isAlternate;
    private List<String> draft;
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Player(){}

    public Player(String name,
                  int jerseyNumber,
                  String position,
                  LocalDate dob,
                  String height,
                  int weight,
                  String birthplace,
                  boolean shootsRight,
                  boolean isCaptain,
                  boolean isAlternate,
                  String imgUrl,
                  List<String> draft) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
        this.birthplace = birthplace;
        this.shootsRight = shootsRight;
        this.isCaptain = isCaptain;
        this.isAlternate = isAlternate;
        this.imgUrl = imgUrl;
        this.draft = draft;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public boolean isAlternate() {
        return isAlternate;
    }

    public void setAlternate(boolean alternate) {
        isAlternate = alternate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public boolean isShootsRight() {
        return shootsRight;
    }

    public void setShootsRight(boolean shootsRight) {
        this.shootsRight = shootsRight;
    }

    public List<String> getDraft() {
        return draft;
    }

    public void setDraft(List<String> draft) {
        this.draft = draft;
    }

    public String toString() {
        String p = "Name: " + name +
                ", Number: " + jerseyNumber +
                ", Position: " + position +
                ", Height: " + height +
                ", Weight: " + weight +
                ", DOB: " + dob +
                ", Age: " + age +
                ", Birthplace: " + birthplace +
                ", Shoots: ";
        if (shootsRight) {
            p += "Right";
        }else {
            p += "Left";
        }
        return p;
    }
}
