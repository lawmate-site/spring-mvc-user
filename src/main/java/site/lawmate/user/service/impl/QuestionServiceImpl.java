package site.lawmate.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.lawmate.user.component.Messenger;
import site.lawmate.user.domain.dto.QuestionDto;
import site.lawmate.user.domain.model.Question;
import site.lawmate.user.domain.model.User;
import site.lawmate.user.repository.QuestionRepository;
import site.lawmate.user.repository.UserRepository;
import site.lawmate.user.service.QuestionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Service
@RequiredArgsConstructor
@RequestMapping(path = "/questions")
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public Messenger save(QuestionDto dto) {
        log.info("Parameters received through save service: " + dto);
        User writer = userRepository.findById(dto.getWriter().getId())
                .orElseThrow(() -> new IllegalArgumentException("User " + dto.getWriter() + " not found."));
        Question question = Question.builder()
                .law(dto.getLaw())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(writer)
                .build();
        Question savedQuestion = questionRepository.save(question);
        return Messenger.builder()
                .message(questionRepository.existsById(savedQuestion.getId()) ? "SUCCESS" : "FAILURE")
                .build();
    }

    @Transactional
    @Override
    public Messenger delete(Long id) {
        questionRepository.deleteById(id);
        return Messenger.builder()
                .message(
                        Stream.of(id)
                                .filter(i -> existsById(i))
                                .peek(i -> questionRepository.deleteById(i))
                                .map(i -> "SUCCESS")
                                .findAny()
                                .orElseGet(() -> "FAILURE")
                )
                .build();
    }

    @Override
    public Messenger update(QuestionDto dto) {
        Optional<Question> question = questionRepository.findById(dto.getId());
        if (question.isPresent()) {
            QuestionDto updateQuestion = dto.toBuilder()
                    .law(dto.getLaw())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .build();
            questionRepository.save(dtoToEntity(updateQuestion));

            return Messenger.builder()
                    .message("SUCCESS")
                    .build();
        } else {
            log.warn("Question id '{}' not found.", dto.getId());
        }
        Question ent = questionRepository.save(dtoToEntity(dto));
        return Messenger.builder()
                .message((ent instanceof Question) ? "SUCCESS" : "FAILURE")
                .build();
    }

    @Override
    public List<QuestionDto> findAll() {
        return questionRepository.findAllByOrderByIdDesc().stream().map(i -> entityToDto(i)).toList();
    }

    @Override
    public Optional<QuestionDto> findById(Long id) {
        return questionRepository.findById(id).map(i -> entityToDto(i));
    }

    @Override
    public Messenger count() {
        return Messenger.builder()
                .message(questionRepository.count() + "")
                .build();
    }

    @Override
    public boolean existsById(Long id) {
        return questionRepository.existsById(id);
    }

    @Override
    public Question dtoToEntity(QuestionDto dto) {
        return Question.builder()
                .law(dto.getLaw())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }

    @Override
    public QuestionDto entityToDto(Question question) {
        return QuestionDto.builder()
                .id(question.getId())
                .law(question.getLaw())
                .title(question.getTitle())
                .content(question.getContent())
                .writer(question.getWriter())
                .build();
    }
}
