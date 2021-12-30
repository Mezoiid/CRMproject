package MenuAndIngredients;

public enum Units {
    KILOGRAM(false,1),
    GRAM(false,1000),
    MILLIGRAM(false,1000000),
    TON(false,0.001),
    LITER(true,1),
    MILLILITER(true,1000);
    private boolean isLiquid;
    private double num;

    public boolean isLiquid() {
        return isLiquid;
    }

    public double getNum() {
        return num;
    }

    Units(boolean isLiquid, double num ) {
    }

    public static double convert(Units from,Units to,double howMuch){
        if (from.isLiquid!= to.isLiquid)
            return -1;
        return howMuch/from.num*to.num;
    }



}
