package faang.school.paymentservice.dto.exchange_rate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRatesResponseDto {

    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;

    @JsonProperty("rates")
    private Map<String, Double> exchangeRates;
}
