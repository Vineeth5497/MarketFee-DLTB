package com.marketyard.feecalculator.business;

import com.marketyard.feecalculator.entity.*;
import com.marketyard.feecalculator.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class responsible for processing and storing market fee data.
 * Acts as the business logic layer between the controllers and repositories
 * for various fee sources (DI, MCP, EP, Govt, Others).
 */
@Service
public class FeeProcessingService {

    private static final Logger log = LoggerFactory.getLogger(FeeProcessingService.class);

    private final MarketDataRepo marketDataRepo;
    private final SourceDIRepo sourceDIRepo;
    private final SourceMCPRepo sourceMCPRepo;
    private final SourceEPRepo sourceEPRepo;
    private final SourceGovtRepo sourceGovtRepo;
    private final SourceOthersRepo sourceOthersRepo;

    public FeeProcessingService(MarketDataRepo marketDataRepo, SourceDIRepo sourceDIRepo,
                               SourceMCPRepo sourceMCPRepo, SourceEPRepo sourceEPRepo,
                               SourceGovtRepo sourceGovtRepo, SourceOthersRepo sourceOthersRepo) {
        this.marketDataRepo = marketDataRepo;
        this.sourceDIRepo = sourceDIRepo;
        this.sourceMCPRepo = sourceMCPRepo;
        this.sourceEPRepo = sourceEPRepo;
        this.sourceGovtRepo = sourceGovtRepo;
        this.sourceOthersRepo = sourceOthersRepo;
    }

    /**
     * Initializes and persists market data for a given date.
     * Resets the grand total and monthly total to zero for a fresh day's data.
     *
     * @param marketData The initial market data payload for the day.
     * @return A success message upon successful insertion.
     */
    @Transactional
    public String insertMarketData(MarketData marketData) {
        marketData.setGrandTotal(0);
        marketData.setMonthTotal(0);
        marketDataRepo.save(marketData);
        log.info("Market data saved for date {}", marketData.getDate());
        return "Market Data Saved Successfully";
    }

    /**
     * Saves fee processing data specific to Source D.I.
     *
     * @param sourceDI The Source D.I data entity object.
     * @return A success message upon successful insertion.
     */
    @Transactional
    public String insertSourceDIData(SourceDI sourceDI) {
        sourceDIRepo.save(sourceDI);
        return "Source D.I Data Saved Successfully";
    }

    /**
     * Saves fee processing data specific to Source MCP.
     *
     * @param sourceMCP The Source MCP data entity object.
     * @return A success message upon successful insertion.
     */
    @Transactional
    public String insertSourceMCPData(SourceMCP sourceMCP) {
        sourceMCPRepo.save(sourceMCP);
        return "Source MCP Data Saved Successfully";
    }

    /**
     * Saves fee processing data specific to Source EP.
     *
     * @param sourceEP The Source EP data entity object.
     * @return A success message upon successful insertion.
     */
    @Transactional
    public String insertSourceEPData(SourceEP sourceEP) {
        sourceEPRepo.save(sourceEP);
        return "Source EP Data Saved Successfully";
    }

    /**
     * Saves fee processing data specific to Source Government.
     *
     * @param sourceGovt The Source Govt data entity object.
     * @return A success message upon successful insertion.
     */
    @Transactional
    public String insertSourceGovtData(SourceGovt sourceGovt) {
        sourceGovtRepo.save(sourceGovt);
        return "Source Govt Data Saved Successfully";
    }

    /**
     * Saves fee processing data specific to Other Sources.
     *
     * @param sourceOthers The Source Others data entity object.
     * @return A success message upon successful insertion.
     */
    @Transactional
    public String insertOthersData(SourceOthers sourceOthers) {
        sourceOthersRepo.save(sourceOthers);
        return "Source Others Data Saved Successfully";
    }
}
