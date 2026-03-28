package com.marketyard.feecalculator.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * JPA entity representing fee data collected from the MCP (Market Commodity Platform) source.
 * Maps to the "sourceMCP" table in the database.
 */
@Entity
@Table(name = "sourceMCP")
public class SourceMCP {
    protected SourceMCP() {}

    public SourceMCP(LocalDate date, String commodity, double valuation, double mcpMarketFee){
        this.date = date;
        this.commodity = commodity;
        this.valuation = valuation;
        this.mcpMarketFee = mcpMarketFee;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="transaction_id", updatable = false, nullable = false)
    private int sourceMCPId;        // Auto-generated transaction identifier

    @Column(name="Date")
    private LocalDate date;
    @Column(name="Commodity")
    private String commodity;
    @Column(name="Valuation")
    private double valuation;
    @Column(name="MarketFee")
    private double mcpMarketFee;

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

    public double getMcpMarketFee() {
        return mcpMarketFee;
    }

    public void setMcpMarketFee(double mcpMarketFee) {
        this.mcpMarketFee = mcpMarketFee;
    }
}
