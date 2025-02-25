package faang.school.paymentservice.service;

import faang.school.paymentservice.client.OpenExchangeRates;
import faang.school.paymentservice.dto.exchange_rate.ExchangeRatesResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    @Value("${services.open-exchange-rates.api-key}")
    private String apiKey;

    private final OpenExchangeRates openExchangeRates;

    public ExchangeRatesResponseDto getLatestExchangeRates() {
        log.info("Fetching latest exchange rates from Open Exchange Rates...");
        return openExchangeRates.getLatestRates(apiKey);
    }

    public double convertAmount(double amount, String fromCurrency, String toCurrency) {
        log.info("Converting {} {} to {} using exchange rate...", amount, fromCurrency, toCurrency);
        ExchangeRatesResponseDto exchangeRates = getLatestExchangeRates();
        double conversionRate = exchangeRates.getExchangeRates().get(toCurrency) / exchangeRates.getExchangeRates().get(fromCurrency);
        return amount * conversionRate;
    }
}
