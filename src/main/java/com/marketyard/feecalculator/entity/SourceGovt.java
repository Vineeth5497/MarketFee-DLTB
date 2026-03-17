package com.marketyard.feecalculator.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sourceGovt")
public class SourceGovt {
    protected SourceGovt() {}

    public SourceGovt(LocalDate date, String commodity, double valuation, double govtMarketFee){
        this.date = date;
        this.commodity = commodity;
        this.valuation = valuation;
        this.govtMarketFee = govtMarketFee;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="transaction_id", updatable = false, nullable = false)
    private int sourceGovtId;
    @Column(name="Date")
    private LocalDate date;
    @Column(name="Commodity")
    private String commodity;
    @Column(name="Valuation")
    private double valuation;
    @Column(name="MarketFee")
    private double govtMarketFee;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public double getValuation() {
        return valuation;
    }

    public void setValuation(double valuation) {
        this.valuation = valuation;
    }

    public double getGovtMarketFee() {
        return govtMarketFee;
    }

    public void setGovtMarketFee(double govtMarketFee) {
        this.govtMarketFee = govtMarketFee;
    }
}
