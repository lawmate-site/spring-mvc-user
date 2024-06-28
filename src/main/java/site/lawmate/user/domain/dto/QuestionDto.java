package site.lawmate.user.domain.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
@Builder(toBuilder = true)
@Getter
public class QuestionDto {
    private Long id;
    private String law;
    private String title;
    private String content;
    private Long writerId;
    private String regDate;
    private String modDate;
}
