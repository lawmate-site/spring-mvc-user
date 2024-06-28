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
        log.info("Parameters received through question service:" + dto);
        Question question = dtoToEntity(dto);
        Question savedQuestion = questionRepository.save(question);
        return Messenger.builder()
                .message(questionRepository.existsById(savedQuestion.getId()) ? "SUCCESS" : "FAILURE")
                .build();
    }

    @Override
    public Messenger delete(Long id) {
        questionRepository.deleteById(id);
        return Messenger.builder()
                .message(questionRepository.findById(id).isPresent() ? "" : "")
                .build();
    }

    @Override
    public Messenger update(QuestionDto questionDto) {
        return null;
    }

    @Override
    public List<QuestionDto> findAll() {
        return null;
    }

    @Override
    public Optional<QuestionDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Messenger count() {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
