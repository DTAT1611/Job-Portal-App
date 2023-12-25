package com.example.myapplication.Model;

public class Data {
    String tilte;
    String description;
    String skill;
    String salara;
    String id;
    String date;

    public Data(){

    }

    public Data(String tilte, String description, String skill, String salara, String id, String date) {
        this.tilte = tilte;
        this.description = description;
        this.skill = skill;
        this.salara = salara;
        this.id = id;
        this.date = date;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSalara() {
        return salara;
    }

    public void setSalara(String salara) {
        this.salara = salara;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
