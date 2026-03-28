package com.marketyard.feecalculator.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * JPA entity representing fee data collected from the EP (External Purchaser) source.
 * Maps to the "sourceEP" table in the database.
 */
@Entity
@Table(name = "sourceEP")
public class SourceEP {
    protected SourceEP() {}

    public SourceEP(LocalDate date, String commodity, double valuation, double epMarketFee){
        this.date = date;
        this.commodity = commodity;
        this.valuation = valuation;
        this.epMarketFee = epMarketFee;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "transaction_id",nullable = false, updatable = false)
    private int sourceEPId;         // Auto-generated transaction identifier

    @Column(name="Date")
    private LocalDate date;
    @Column(name="Commodity")
    private String commodity;
    @Column(name="Valuation")
    private double valuation;
    @Column(name="MarketFee")
    private double epMarketFee;

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

    public double getEpMarketFee() {
        return epMarketFee;
    }

    public void setEpMarketFee(double epMarketFee) {
        this.epMarketFee = epMarketFee;
    }
}
