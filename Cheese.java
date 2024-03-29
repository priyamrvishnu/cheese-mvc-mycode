package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    @NotNull
    @Size(min=3, max=15)
    private String name;


    @NotNull
    private String description;

    private ChesseType type;

    private int cheeseId;

    private static int nextId=1;

    public Cheese(String name, String description){
        this();
        this.name=name;
        this.description= description;
    }

    public Cheese(){
        cheeseId=nextId;
        nextId++;
    }



    public String getName() {return name; }

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}


    public void setDescription(String description) {this.description = description;}


    public ChesseType getType() {return type;}

    public void setType(ChesseType type) { this.type = type;  }

    public int getCheeseId() { return cheeseId; }

    public void setCheeseId(int cheeseId) {this.cheeseId = cheeseId; }
}

