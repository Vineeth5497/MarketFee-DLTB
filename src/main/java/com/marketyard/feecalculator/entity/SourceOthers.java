package com.marketyard.feecalculator.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sourceOthers")
public class SourceOthers {
    protected SourceOthers() {}

    public SourceOthers(LocalDate date, double valuation, double othersMarketFee){
        this.date = date;
        this.valuation = valuation;
        this.othersMarketFee = othersMarketFee;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="transaction_id", updatable = false, nullable = false)
    private int sourceOthersId;
    @Column(name="Date")
    private LocalDate date;
    @Column(name="Valuation")
    private double valuation;
    @Column(name="MarketFee")
    private double othersMarketFee;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValuation() {
        return valuation;
    }

    public void setValuation(double valuation) {
        this.valuation = valuation;
    }

    public double getOthersMarketFee() {
        return othersMarketFee;
    }

    public void setOthersMarketFee(double othersMarketFee) {
        this.othersMarketFee = othersMarketFee;
    }
}
