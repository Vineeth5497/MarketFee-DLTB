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

/**
 * REST controller responsible for receiving and persisting market fee data.
 * Delegates data processing to {@link com.marketyard.feecalculator.business.FeeProcessingService}.
 * Each fee source (DI, MCP, EP, Govt, Others) is conditionally saved based
 * on the checkbox flags in the incoming request payload.
 */
@RestController
@RequestMapping(path = "/amc")
public class FeeCalculatorController {

    private final FeeProcessingService feeProcessingService;

    public FeeCalculatorController(FeeProcessingService feeProcessingService) {
        this.feeProcessingService = feeProcessingService;
    }

    /**
     * Receives a {@link MarketFee} payload and persists data for all selected fee sources.
     * Each fee source is only saved if its corresponding checkbox value is set
     * (e.g., "D.I", "MCP", "Ep", "Govt", "Others").
     *
     * @param marketFee The validated market fee form data submitted from the frontend.
     * @return A {@link ResponseEntity} wrapping an {@link ApiResponse} with a list of status messages.
     */
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> insertData(@RequestBody @Valid MarketFee marketFee) {
        List<String> statusMessages = new ArrayList<>();

        // Save top-level market data (date and day total) if a valid dayTotal is provided
        if (marketFee.getDayTotal() > -1) {
            MarketData marketData = new MarketData(marketFee.getDate(), marketFee.getDayTotal());
            statusMessages.add(feeProcessingService.insertMarketData(marketData));
        }

        // Only save D.I source data if the D.I checkbox is checked
        if ("D.I".equals(marketFee.getDiCheckbox())) {
            SourceDI sourceDI = new SourceDI(marketFee.getDate(), marketFee.getDiCommodity(),
                    marketFee.getDiValuation(), marketFee.getDiMarketFee());
            statusMessages.add(feeProcessingService.insertSourceDIData(sourceDI));
        }

        // Only save MCP source data if the MCP checkbox is checked
        if ("MCP".equals(marketFee.getMcpCheckbox())) {
            SourceMCP sourceMCP = new SourceMCP(marketFee.getDate(), marketFee.getMcpCommodity(),
                    marketFee.getMcpValuation(), marketFee.getMcpMarketFee());
            statusMessages.add(feeProcessingService.insertSourceMCPData(sourceMCP));
        }

        // Only save Ep source data if the Ep checkbox is checked
        if ("Ep".equals(marketFee.getEpCheckbox())) {
            SourceEP sourceEP = new SourceEP(marketFee.getDate(), marketFee.getEpCommodity(),
                    marketFee.getEpValuation(), marketFee.getEpMarketFee());
            statusMessages.add(feeProcessingService.insertSourceEPData(sourceEP));
        }

        // Only save Government source data if the Govt checkbox is checked
        if ("Govt".equals(marketFee.getGovtCheckbox())) {
            SourceGovt sourceGovt = new SourceGovt(marketFee.getDate(), marketFee.getGovtCommodity(),
                    marketFee.getGovtValuation(), marketFee.getGovtMarketFee());
            statusMessages.add(feeProcessingService.insertSourceGovtData(sourceGovt));
        }

        // Only save Others source data if the Others checkbox is checked
        if ("Others".equals(marketFee.getOthersCheckbox())) {
            SourceOthers sourceOthers = new SourceOthers(marketFee.getDate(), marketFee.getOthersValuation(),
                    marketFee.getOthersMarketFee());
            statusMessages.add(feeProcessingService.insertOthersData(sourceOthers));
        }

        // Build and return the response with all accumulated status messages
        String message = statusMessages.isEmpty() ? "No data to save" : "Data saved successfully";
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(message, statusMessages));
    }
}
