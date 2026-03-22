package com.marketyard.feecalculator.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * JPA entity representing fee data collected from miscellaneous (Others) sources.
 * Maps to the "sourceOthers" table in the database.
 * Unlike other sources, this entity does not track a specific commodity name.
 */
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
    private int sourceOthersId;     // Auto-generated transaction identifier

    @Column(name="Date")
    private LocalDate date;         // The date the Others fee was collected

    @Column(name="Valuation")
    private double valuation;       // The total valuation for Others source

    @Column(name="MarketFee")
    private double othersMarketFee; // The calculated market fee for Others source

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
