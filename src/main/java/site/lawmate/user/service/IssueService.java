package site.lawmate.user.service;

import site.lawmate.user.component.Messenger;
import site.lawmate.user.domain.dto.IssueDto;
import site.lawmate.user.domain.model.Issue;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


public interface IssueService extends CommandService<IssueDto>, QueryService<IssueDto> {
    default Issue dtoToEntity(IssueDto dto) {
        return Issue.builder()
                .law(dto.getLaw())
                .title(dto.getTitle())
                .content(dto.getContent())
                .attachment(dto.getAttachment())
                .lawyerId(dto.getLawyerId())
                .build();
    }

    default IssueDto entityToDto(Issue issue) {
        return IssueDto.builder()
                .id(issue.getId())
                .law(issue.getLaw())
                .title(issue.getTitle())
                .content(issue.getContent())
                .attachment(issue.getAttachment())
                .lawyerId(issue.getLawyerId())
                .build();
    }

    Messenger update(IssueDto dto);

    Messenger count();

    void addEmitter(SseEmitter emitter);
}
