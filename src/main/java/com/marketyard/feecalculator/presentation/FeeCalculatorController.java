package com.marketyard.feecalculator.presentation;

import com.marketyard.feecalculator.business.FeeProcessingService;
import com.marketyard.feecalculator.entity.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/amc")
public class FeeCalculatorController {

    private final FeeProcessingService feeProcessingService;

    public FeeCalculatorController(FeeProcessingService feeProcessingService) {
        this.feeProcessingService = feeProcessingService;
    }

    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> insertData(@RequestBody @Valid MarketFee marketFee) {
        List<String> statusMessages = new ArrayList<>();

        if (marketFee.getDayTotal() > -1) {
            MarketData marketData = new MarketData(marketFee.getDate(), marketFee.getDayTotal());
            statusMessages.add(feeProcessingService.insertMarketData(marketData));
        }

        if ("D.I".equals(marketFee.getDiCheckbox())) {
            SourceDI sourceDI = new SourceDI(marketFee.getDate(), marketFee.getDiCommodity(),
                    marketFee.getDiValuation(), marketFee.getDiMarketFee());
            statusMessages.add(feeProcessingService.insertSourceDIData(sourceDI));
        }

        if ("MCP".equals(marketFee.getMcpCheckbox())) {
            SourceMCP sourceMCP = new SourceMCP(marketFee.getDate(), marketFee.getMcpCommodity(),
                    marketFee.getMcpValuation(), marketFee.getMcpMarketFee());
            statusMessages.add(feeProcessingService.insertSourceMCPData(sourceMCP));
        }

        if ("Ep".equals(marketFee.getEpCheckbox())) {
            SourceEP sourceEP = new SourceEP(marketFee.getDate(), marketFee.getEpCommodity(),
                    marketFee.getEpValuation(), marketFee.getEpMarketFee());
            statusMessages.add(feeProcessingService.insertSourceEPData(sourceEP));
        }

        if ("Govt".equals(marketFee.getGovtCheckbox())) {
            SourceGovt sourceGovt = new SourceGovt(marketFee.getDate(), marketFee.getGovtCommodity(),
                    marketFee.getGovtValuation(), marketFee.getGovtMarketFee());
            statusMessages.add(feeProcessingService.insertSourceGovtData(sourceGovt));
        }

        if ("Others".equals(marketFee.getOthersCheckbox())) {
            SourceOthers sourceOthers = new SourceOthers(marketFee.getDate(), marketFee.getOthersValuation(),
                    marketFee.getOthersMarketFee());
            statusMessages.add(feeProcessingService.insertOthersData(sourceOthers));
        }

        String message = statusMessages.isEmpty() ? "No data to save" : "Data saved successfully";
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(message, statusMessages));
    }
}
