package site.lawmate.user.service;

import site.lawmate.user.domain.dto.QuestionDto;
import site.lawmate.user.domain.model.Question;

public interface QuestionService extends CommandService<QuestionDto>, QueryService<QuestionDto> {

    default Question dtoToEntity(QuestionDto dto) {
        return Question.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    default QuestionDto entityToDto(Question question) {
        return QuestionDto.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .build();
    }
}