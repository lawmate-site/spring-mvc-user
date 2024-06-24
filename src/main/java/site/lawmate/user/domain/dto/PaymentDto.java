package site.lawmate.user.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import site.lawmate.user.enums.PaymentStatus;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaymentDto {
    private String paymentUid;
    private Long amount;
    private PaymentStatus status;

    @Builder
    public PaymentDto(String paymentUid, Long amount, PaymentStatus status) {
        this.paymentUid = paymentUid;
        this.amount = amount;
        this.status = status;
    }
}
