package site.lawmate.user.domain.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "questions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@ToString(exclude = {"id"})
@Slf4j
public class Question extends BaseEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User writer;


    @Builder(builderMethodName = "builder")
    public Question(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static Question of(String title, String content) {
        Question question = new Question();
        question.title = title;
        question.content = content;
        return question;
    }
}
