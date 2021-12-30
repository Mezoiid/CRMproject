package MenuAndIngredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dish {
    private String name;
    private double cost;
    private int id;
    private static int nextId=1;
    private List<Ingredient> ingredients;

    public int getId() {
        return id;
    }

    public Dish(String name, double cost) {
        this.id=nextId++;
        this.name = name;
        this.cost = cost;
        this.ingredients =new ArrayList<>() ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void addIngredient( Ingredient ingredient,double volume){
        if(ingredients.contains(ingredient))
            return;
        ingredient.setVolume(volume);
        ingredients.add(ingredient);
    }
    public void removeIngredient( Ingredient ingredient){
       if(!ingredients.contains(ingredient))
           return;

       ingredients.remove(ingredient);
    }


    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", number=" + id +
               ", ingredients=" + ingredients +
                '}';
    }
    
}
