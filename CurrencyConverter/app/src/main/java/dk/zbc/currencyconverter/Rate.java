package dk.zbc.currencyconverter;

public class Rate {

    private String name;

    private double spotRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpotRate() {
        return spotRate;
    }

    public void setSpotRate(double spotRate) {
        this.spotRate = spotRate;
    }

    public Rate(String name, double spotRate) {
        this.name = name;
        this.spotRate = spotRate;
    }
}
