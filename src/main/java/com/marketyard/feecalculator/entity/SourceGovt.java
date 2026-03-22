package com.marketyard.feecalculator.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * JPA entity representing fee data collected from the Government (Govt) source.
 * Maps to the "sourceGovt" table in the database.
 */
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
    private int sourceGovtId;       // Auto-generated transaction identifier

    @Column(name="Date")
    private LocalDate date;         // The date the Government fee was collected

    @Column(name="Commodity")
    private String commodity;       // The commodity name for which Govt fee was calculated

    @Column(name="Valuation")
    private double valuation;       // The total valuation of the Govt commodity

    @Column(name="MarketFee")
    private double govtMarketFee;   // The calculated market fee for Govt source

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
