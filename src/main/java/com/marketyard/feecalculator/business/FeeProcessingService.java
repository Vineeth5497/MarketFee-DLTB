package com.marketyard.feecalculator.business;

import com.marketyard.feecalculator.entity.*;
import com.marketyard.feecalculator.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public String insertMarketData(MarketData marketData) {
        marketData.setGrandTotal(0);
        marketData.setMonthTotal(0);
        marketDataRepo.save(marketData);
        log.info("Market data saved for date {}", marketData.getDate());
        return "Market Data Saved Successfully";
    }

    @Transactional
    public String insertSourceDIData(SourceDI sourceDI) {
        sourceDIRepo.save(sourceDI);
        return "Source D.I Data Saved Successfully";
    }

    @Transactional
    public String insertSourceMCPData(SourceMCP sourceMCP) {
        sourceMCPRepo.save(sourceMCP);
        return "Source MCP Data Saved Successfully";
    }

    @Transactional
    public String insertSourceEPData(SourceEP sourceEP) {
        sourceEPRepo.save(sourceEP);
        return "Source EP Data Saved Successfully";
    }

    @Transactional
    public String insertSourceGovtData(SourceGovt sourceGovt) {
        sourceGovtRepo.save(sourceGovt);
        return "Source Govt Data Saved Successfully";
    }

    @Transactional
    public String insertOthersData(SourceOthers sourceOthers) {
        sourceOthersRepo.save(sourceOthers);
        return "Source Others Data Saved Successfully";
    }
}
