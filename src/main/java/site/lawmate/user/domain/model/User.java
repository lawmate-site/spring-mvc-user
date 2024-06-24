package site.lawmate.user.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Component
@Getter
@Builder(toBuilder = true)
@ToString(exclude = {"id"})
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String age;
    private String sex;
    private String token;
    private Long point;
    private String password;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    @OneToMany(mappedBy = "buyer")
    private List<Payment> payments;

    @OneToMany(mappedBy = "client")
    private List<Issue> issues;

}


