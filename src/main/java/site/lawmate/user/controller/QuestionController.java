package site.lawmate.user.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.lawmate.user.component.Messenger;
import site.lawmate.user.domain.dto.QuestionDto;
import site.lawmate.user.domain.dto.UserDto;
import site.lawmate.user.service.QuestionService;
import site.lawmate.user.service.impl.QuestionServiceImpl;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/questions")
@Slf4j
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")
})
public class QuestionController {
    private final QuestionService service;

    @SuppressWarnings("static-access")
    @PostMapping("/save")
    public ResponseEntity<Messenger> save(@RequestBody QuestionDto dto) throws SQLException {
        log.info("Parameters received through controller: " + dto);
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<QuestionDto>> findAll(Long id) throws SQLException {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Messenger> deleteById(@PathVariable("id") Long id) throws SQLException {
        return ResponseEntity.ok(service.delete(id));
    }

    @PatchMapping(path = "/update")
    public ResponseEntity<Messenger> update(@RequestBody QuestionDto dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(path = "/detail")
    public ResponseEntity<Messenger> findById(@RequestParam Long id) throws SQLException {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Messenger> count() throws SQLException {
        return ResponseEntity.ok(service.count());
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsById(@RequestParam Long id) throws SQLException {
        return ResponseEntity.ok(service.existsById(id));
    }


}