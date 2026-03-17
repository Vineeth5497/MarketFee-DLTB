package com.marketyard.feecalculator.presentation;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MarketFee {
    protected MarketFee() {}

    @NotNull(message = "Date is required")
    private LocalDate date;

    private String diCheckbox;
    private String diCommodity;
    private double diValuation;
    private double diMarketFee;

    private String mcpCheckbox;
    private String mcpCommodity;
    private double mcpValuation;
    private double mcpMarketFee;

    private String govtCheckbox;
    private String govtCommodity;
    private double govtValuation;
    private double govtMarketFee;

    private String epCheckbox;
    private String epCommodity;
    private double epValuation;
    private double epMarketFee;

    private String othersCheckbox;
    private String othersCommodity;
    private double othersValuation;
    private double othersMarketFee;

    private double dayTotal;

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
