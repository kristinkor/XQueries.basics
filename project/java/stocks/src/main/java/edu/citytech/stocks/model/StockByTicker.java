package edu.citytech.stocks.model;

import java.util.Arrays;

public class StockByTicker {
    private int _id;
    private int nodeCount;
    private String ticker;
    private String companyName;
    private String sector;
    private float price;
    private float peRatio;
    private float marketCapInBillions;
    private float numberOfShares;
    private Dividend dividend;
    private String[] tags;
    private String source;
    private String date;

    public int get_id() {
        return _id;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public String getTicker() {
        return ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSector() {
        return sector;
    }

    public float getPrice() {
        return price;
    }

    public float getPeRatio() {
        return peRatio;
    }

    public float getMarketCapInBillions() {
        return marketCapInBillions;
    }

    public float getNumberOfShares() {
        return numberOfShares;
    }

    public Dividend getDividend() {
        return dividend;
    }

    public String[] getTags() {
        return tags;
    }

    public String getSource() {
        return source;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "StockByTicker{" +
                "_id=" + _id +
                ", nodeCount=" + nodeCount +
                ", ticker='" + ticker + '\'' +
                ", companyName='" + companyName + '\'' +
                ", sector='" + sector + '\'' +
                ", price=" + price +
                ", peRatio=" + peRatio +
                ", marketCapInBillions=" + marketCapInBillions +
                ", numberOfShares=" + numberOfShares +
                ", dividends=" + dividend +
                ", tags=" + Arrays.toString(tags) +
                ", source='" + source + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
