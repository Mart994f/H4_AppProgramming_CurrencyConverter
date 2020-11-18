package dk.zbc.currencyconverter;

public class Rate {

    private final String name;

    private final double spotRate;

    private final int flagId;

    private double convertedValue;

    public String getName() {
        return name;
    }

    public double getSpotRate() {
        return spotRate;
    }

    public int getFlagId() {
        return flagId;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public Rate(String name, double spotRate, int flagId) {
        this.name = name;
        this.spotRate = spotRate;
        this.flagId = flagId;
    }
}
