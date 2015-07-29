package com.myXMLParser.candy;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"energy", "candyType", "ingredients",
        "value", "production", "description"})
public class Candy {
    private int energy;

    @XmlElement(name = "type")
    private CandyType candyType;

    @XmlElement(name = "ingredient")
    @XmlElementWrapper
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

    private Value value;
    private String production;
    private String description;

    @XmlAttribute(name = "name")
    private String name;

    public Candy() {
        candyType = new CandyType();
        ingredients = new ArrayList<Ingredient>();
        value = new Value();
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int value) {
        this.energy = value;
    }

    public CandyType getCandyType() {
        return candyType;
    }

    public void setCandyType(CandyType value) {
        this.candyType = value;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String value) {
        this.production = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public List<Ingredient> getIngredients() {
        if (ingredients == null) {
            ingredients = new ArrayList<Ingredient>();
        }
        return this.ingredients;
    }


    public void print() {
        System.out.println("---------------------------------------");
        System.out.printf("|Name        | %-22s |\n", this.getName());

        System.out.println("---------------------------------------");
        System.out.printf("|Energy      | %-22d |\n", energy);

        System.out.println("---------------------------------------");
        System.out.printf("|CandyType   | %-22s |\n",
                this.getCandyType().value.toString());

        System.out.println("---------------------------------------");
        System.out.printf("|Ingredients:                         |\n");
        for (int i = 0; i < this.ingredients.size(); i++) {
            System.out.println("---------------------------------------");
            System.out.printf("|%-11s | %-22d |\n",
                    this.ingredients.get(i).name,
                    this.ingredients.get(i).quantity);
        }
        System.out.println("---------------------------------------");
        System.out.printf("|Values:                              |\n");

        System.out.println("---------------------------------------");
        System.out.printf("|Proteins    | %-22d |\n", this.getValue()
                .getProteins());

        System.out.println("---------------------------------------");
        System.out
                .printf("|Fats        | %-22d |\n", this.getValue().getFats());

        System.out.println("---------------------------------------");
        System.out.printf("|Carbs       | %-22d |\n", this.getValue()
                .getCarbohydrates());

        System.out.println("---------------------------------------");
        System.out.printf("|Production  | %-22s |\n", this.getProduction());

        System.out.println("---------------------------------------");
        System.out.printf("|Description | %-22s |\n", this.getDescription());
        System.out.println("---------------------------------------");
    }
}

