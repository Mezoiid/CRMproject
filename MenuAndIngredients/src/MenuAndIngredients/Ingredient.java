package MenuAndIngredients;

public class Ingredient {

    private String name;
    private double volume;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    private Units unit;
    private int cost;
    private Units unitOfContainer;
    private boolean isLiquid;

    public Ingredient(String name, Units unit, int cost, Units unitOfContainer, boolean isLiquid) {
        if (unit.isLiquid()==unitOfContainer.isLiquid()){
            this.unit = unit;
            this.unitOfContainer = unitOfContainer;
        }
        else
            System.out.println("!error with unit and container unit!");
        this.name = name;
        this.cost = cost;
        this.isLiquid = isLiquid;


    }

    public boolean isLiquid() {
        return isLiquid;
    }

    public void setLiquid(boolean liquid) {
        isLiquid = liquid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Units getUnitOfContainer() {
        return unitOfContainer;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                " " + unit +
                '}';
    }

    public void setUnitOfContainer(Units unitOfContainer) {
        this.unitOfContainer = unitOfContainer;
    }

}
