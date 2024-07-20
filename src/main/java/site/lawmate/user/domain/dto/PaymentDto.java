package site.lawmate.user.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import site.lawmate.user.domain.model.mysql.Product;
import site.lawmate.user.domain.model.mysql.User;
import site.lawmate.user.enums.PaymentStatus;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaymentDto {
    private Long id;
    private Long lawyer;
    private String paymentUid;
    private PaymentStatus status;
    private User buyer;
    private Product product;
    private Long amount;
}
