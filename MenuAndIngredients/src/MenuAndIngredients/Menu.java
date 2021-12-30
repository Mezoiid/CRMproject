package MenuAndIngredients;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menu {
    private int volume;
    private Set<Dish> menu;

    public Menu(){
        menu=new HashSet<>();
    }

    public void addDish(Dish dish){
        menu.add(dish);
    }

    public void remove(Dish dish){
        menu.remove(dish);
    }

    public Dish findID(int id){
        for (Dish aim:menu) {
            if (id==aim.getId())
                return aim;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder out= new StringBuilder();
        for (Dish aim:menu) {
            out.append(aim.toString()+"\n");

        }
        return String.valueOf(out);
    }
}
