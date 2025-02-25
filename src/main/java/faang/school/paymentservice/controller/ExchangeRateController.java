package faang.school.paymentservice.controller;

import faang.school.paymentservice.dto.exchange_rate.ExchangeRatesResponseDto;
import faang.school.paymentservice.service.ExchangeRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Exchange Rate API", description = "API for retrieving exchange rates"  )
@RestController
@RequestMapping("/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @Operation(summary = "Get exchange rates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exchange rates retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @GetMapping("latest")
    public ResponseEntity<ExchangeRatesResponseDto> getLatestExchangeRates() {
        return ResponseEntity.ok(exchangeRateService.getLatestExchangeRates());
    }

    @Operation(summary = "Convert amount from one currency to another")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Amount converted successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @GetMapping("/convert")
    public ResponseEntity<Double> convertAmount(
            @RequestParam("from") String fromCurrency,
            @RequestParam("to") String toCurrency,
            @RequestParam("amount") double amount) {
        return ResponseEntity.ok(exchangeRateService.convertAmount(amount, fromCurrency, toCurrency));
    }
}
