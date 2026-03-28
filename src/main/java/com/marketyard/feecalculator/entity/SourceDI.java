package com.marketyard.feecalculator.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * JPA entity representing fee data collected from the D.I (Direct Income) source.
 * Maps to the "sourceDI" table in the database.
 */
@Entity
@Table(name = "sourceDI")
public class SourceDI {
    protected SourceDI() {}

    public SourceDI(LocalDate date, String commodity, double valuation, double diMarketFee){
        this.date = date;
        this.commodity = commodity;
        this.valuation = valuation;
        this.diMarketFee = diMarketFee;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="transaction_id", updatable = false, nullable = false)
    private int sourceDIId;         // Auto-generated transaction identifier

    @Column(name="Date", nullable = false)
    private LocalDate date;
    @Column(name="Commodity")
    private String commodity;
    @Column(name="Valuation")
    private double valuation;
    @Column(name="MarketFee")
    private double diMarketFee;

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

    public double getDiMarketFee() {
        return diMarketFee;
    }

    public void setDiMarketFee(double diMarketFee) {
        this.diMarketFee = diMarketFee;
    }
}
