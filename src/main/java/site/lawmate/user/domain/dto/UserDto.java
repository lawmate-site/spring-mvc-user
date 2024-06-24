package site.lawmate.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String age;
    private String sex;
    private String regDate;
    private String modDate;
    private String token;
    private Long point;
    private String password;
}
