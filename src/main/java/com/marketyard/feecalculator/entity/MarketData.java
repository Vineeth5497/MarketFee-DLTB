package com.marketyard.feecalculator.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * JPA entity representing the top-level market fee summary for a given day.
 * Maps to the "marketData" table in the database.
 * Stores the date, daily total, monthly total, and grand total fees.
 */
@Entity
@Table(name = "marketData")
public class MarketData {
    protected MarketData() {}

    public MarketData(LocalDate date, double dayTotal){
        this.date = date;
        this.dayTotal = dayTotal;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="transaction_id", updatable = false, nullable = false)
    private int marketDataId;           // Auto-generated transaction identifier

    @Column(name="Date", nullable = false)
    private LocalDate date;             // The date the fee data was recorded

    @Column(name="day_total")
    private double dayTotal;            // Total market fee collected for the day

    @Column(name="month_total")
    private double monthTotal;          // Cumulative total for the current month

    @Column(name="grand_total")
    private double grandTotal;          // All-time cumulative grand total

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getDayTotal() {
        return dayTotal;
    }

    public void setDayTotal(double dayTotal) {
        this.dayTotal = dayTotal;
    }

    public double getMonthTotal() {
        return monthTotal;
    }

    public void setMonthTotal(double monthTotal) {
        this.monthTotal = monthTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
