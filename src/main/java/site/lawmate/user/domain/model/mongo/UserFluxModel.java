package site.lawmate.user.domain.model.mongo;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Indexed;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class UserFluxModel extends BaseFluxEntity {
    @Id
    private String id;

//    @Indexed(unique = true)
//    private String email;
//    private String profile;
//    private String name;
}
