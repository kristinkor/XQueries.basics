package edu.citytech.stocks.model;

public class Stock implements Comparable<Stock> {
    private String symbol;

    private float price;

    private float marketCapInBillions;

    private Dividends dividends;

    private String companyName;

    private float momentumScore;

    private String subSector;

    private String sector;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getMarketCapInBillions() {
        return marketCapInBillions;
    }

    public void setMarketCapInBillions(float marketCapInBillions) {
        this.marketCapInBillions = marketCapInBillions;
    }

    public Dividends getDividends() {
        return dividends;
    }

    public void setDividends(Dividends dividends) {
        this.dividends = dividends;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                ", marketCapInBillions=" + marketCapInBillions +
                ", dividends=" + dividends +
                ", companyName='" + companyName + '\'' +
                ", momentumScore=" + momentumScore +
                ", subSector='" + subSector + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getMomentumScore() {
        return momentumScore;
    }

    public void setMomentumScore(float momentumScore) {
        this.momentumScore = momentumScore;
    }

    public String getSubSector() {
        return subSector;
    }

    public void setSubSector(String subSector) {
        this.subSector = subSector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public int compareTo(Stock stock) {
        var v1 = this.getDividends().getYield();
        var v2 = stock.getDividends().getYield();

        return -1 * Float.compare(v1, v2);
    }
}