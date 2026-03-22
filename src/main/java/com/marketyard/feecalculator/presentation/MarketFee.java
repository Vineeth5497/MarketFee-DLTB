package com.marketyard.feecalculator.presentation;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * Request model representing the complete market fee form submission.
 * Contains fee data grouped by source (D.I, MCP, Ep, Govt, Others)
 * along with a checkbox flag per source to indicate if that section was filled.
 * Only sources with their checkbox flag set will be saved to the database.
 */
public class MarketFee {
    protected MarketFee() {}

    @NotNull(message = "Date is required")
    private LocalDate date;         // The date for which the fee data is being submitted

    // --- D.I Source Fields ---
    private String diCheckbox;      // Set to "D.I" if this source is active
    private String diCommodity;     // Name of the commodity for D.I source
    private double diValuation;     // Total valuation for D.I source
    private double diMarketFee;     // Market fee amount for D.I source

    // --- MCP Source Fields ---
    private String mcpCheckbox;     // Set to "MCP" if this source is active
    private String mcpCommodity;    // Name of the commodity for MCP source
    private double mcpValuation;    // Total valuation for MCP source
    private double mcpMarketFee;    // Market fee amount for MCP source

    // --- Government Source Fields ---
    private String govtCheckbox;    // Set to "Govt" if this source is active
    private String govtCommodity;   // Name of the commodity for Govt source
    private double govtValuation;   // Total valuation for Govt source
    private double govtMarketFee;   // Market fee amount for Govt source

    // --- EP Source Fields ---
    private String epCheckbox;      // Set to "Ep" if this source is active
    private String epCommodity;     // Name of the commodity for EP source
    private double epValuation;     // Total valuation for EP source
    private double epMarketFee;     // Market fee amount for EP source

    // --- Others Source Fields ---
    private String othersCheckbox;  // Set to "Others" if this source is active
    private String othersCommodity; // Name of the commodity for Others source
    private double othersValuation; // Total valuation for Others source
    private double othersMarketFee; // Market fee amount for Others source

    private double dayTotal;        // Total market fee collected for the day across all sources

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDiCommodity() {
        return diCommodity;
    }

    public void setDiCommodity(String diCommodity) {
        this.diCommodity = diCommodity;
    }

    public double getDiValuation() {
        return diValuation;
    }

    public void setDiValuation(double diValuation) {
        this.diValuation = diValuation;
    }

    public double getDiMarketFee() {
        return diMarketFee;
    }

    public void setDiMarketFee(double diMarketFee) {
        this.diMarketFee = diMarketFee;
    }

    public String getDiCheckbox() {
        return diCheckbox;
    }

    public void setDiCheckbox(String diCheckbox) {
        this.diCheckbox = diCheckbox;
    }

    public String getMcpCommodity() {
        return mcpCommodity;
    }

    public void setMcpCommodity(String mcpCommodity) {
        this.mcpCommodity = mcpCommodity;
    }

    public double getMcpValuation() {
        return mcpValuation;
    }

    public void setMcpValuation(double mcpValuation) {
        this.mcpValuation = mcpValuation;
    }

    public double getMcpMarketFee() {
        return mcpMarketFee;
    }

    public void setMcpMarketFee(double mcpMarketFee) {
        this.mcpMarketFee = mcpMarketFee;
    }

    public String getMcpCheckbox() {
        return mcpCheckbox;
    }

    public void setMcpCheckbox(String mcpCheckbox) {
        this.mcpCheckbox = mcpCheckbox;
    }

    public String getGovtCommodity() {
        return govtCommodity;
    }

    public void setGovtCommodity(String govtCommodity) {
        this.govtCommodity = govtCommodity;
    }

    public double getGovtValuation() {
        return govtValuation;
    }

    public void setGovtValuation(double govtValuation) {
        this.govtValuation = govtValuation;
    }

    public double getGovtMarketFee() {
        return govtMarketFee;
    }

    public void setGovtMarketFee(double govtMarketFee) {
        this.govtMarketFee = govtMarketFee;
    }

    public String getGovtCheckbox() {
        return govtCheckbox;
    }

    public void setGovtCheckbox(String govtCheckbox) {
        this.govtCheckbox = govtCheckbox;
    }

    public String getEpCommodity() {
        return epCommodity;
    }

    public void setEpCommodity(String epCommodity) {
        this.epCommodity = epCommodity;
    }

    public double getEpValuation() {
        return epValuation;
    }

    public void setEpValuation(double epValuation) {
        this.epValuation = epValuation;
    }

    public double getEpMarketFee() {
        return epMarketFee;
    }

    public void setEpMarketFee(double epMarketFee) {
        this.epMarketFee = epMarketFee;
    }

    public String getEpCheckbox() {
        return epCheckbox;
    }

    public void setEpCheckbox(String epCheckbox) {
        this.epCheckbox = epCheckbox;
    }

    public String getOthersCommodity() {
        return othersCommodity;
    }

    public void setOthersCommodity(String othersCommodity) {
        this.othersCommodity = othersCommodity;
    }

    public double getOthersValuation() {
        return othersValuation;
    }

    public void setOthersValuation(double othersValuation) {
        this.othersValuation = othersValuation;
    }

    public double getOthersMarketFee() {
        return othersMarketFee;
    }

    public void setOthersMarketFee(double othersMarketFee) {
        this.othersMarketFee = othersMarketFee;
    }

    public String getOthersCheckbox() {
        return othersCheckbox;
    }

    public void setOthersCheckbox(String othersCheckbox) {
        this.othersCheckbox = othersCheckbox;
    }

    public double getDayTotal() {
        return dayTotal;
    }

    public void setDayTotal(double dayTotal) {
        this.dayTotal = dayTotal;
    }
}
