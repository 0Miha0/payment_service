package faang.school.paymentservice.client;

import faang.school.paymentservice.dto.exchange_rate.ExchangeRatesResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "open-exchange-rates", url = "${services.open-exchange-rates.url}")
public interface OpenExchangeRates {

    @GetMapping("/latest.json")
    ExchangeRatesResponseDto getLatestRates(@RequestParam("app_id") String appId);
}
