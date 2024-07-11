package site.lawmate.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import site.lawmate.user.component.Messenger;
import site.lawmate.user.domain.dto.IssueDto;
import site.lawmate.user.service.IssueService;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {
    @Override
    public Messenger save(IssueDto issueDto) {
        return null;
    }

    @Override
    public Messenger delete(Long id) {
        return null;
    }

    @Override
    public Messenger update(IssueDto issueDto) {
        return null;
    }

    @Override
    public List<IssueDto> findAll() {
        return null;
    }

    @Override
    public Optional<IssueDto> findById(Long id) {
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
