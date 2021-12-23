import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dish {
    private String name;
    private double cost;
    private int id;
    private static int nextId=1;
    private List<Ingredient> ingredients;

    public Dish(String name, double cost,ArrayList<Ingredient> ingredients) {
        this.id=nextId++;
        this.name = name;
        this.cost = cost;
        this.ingredients =new ArrayList<>(ingredients) ;
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

    //public Ingredient[] getIngredients() {
    //    return ingredie;
    //}

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", number=" + id +
               // ", ingredients=" + Arrays.toString(ingredients) +
                '}';
    }

   // public void setIngredients(Ingredient[] ingredients) {
    //  this.ingredients = ingredients;
   // }
}
