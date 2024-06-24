package site.lawmate.user.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.lawmate.user.component.Messenger;
import site.lawmate.user.domain.dto.UserDto;
import site.lawmate.user.service.PaymentService;
import site.lawmate.user.service.UserService;

import java.sql.SQLException;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
@Slf4j
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")
})
public class UserController {
    private final UserService service;

    @SuppressWarnings("static-access")
    @PostMapping("/save")
    public ResponseEntity<Messenger> save(@RequestBody UserDto dto) throws SQLException {
        log.info("Parameters received through controller: " + dto);
        return ResponseEntity.ok(service.save(dto));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Messenger> login(@RequestBody UserDto dto) throws SQLException {
        Messenger messenger = service.login(dto);
        return ResponseEntity.ok(messenger);
    }

    @GetMapping("/existsEmail")
    public ResponseEntity<Boolean> existsByEmail(@RequestParam("email") String email) {
        log.info("Parameter information of existsEmail: " + email);
        Boolean flag = service.existsByEmail(email);
        log.info("existsEmail : " + email);
        return ResponseEntity.ok(flag);
    }


    @GetMapping("/detail")
    public ResponseEntity<Optional<UserDto>> findById(@RequestParam("id") Long id) {
        log.info("Parameter information of findById: " + id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody UserDto dto) {
        return ResponseEntity.ok(service.modify(dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(service.existsById(id));
    }

    @GetMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestHeader("authorization") String accessToken) {
        var flag = service.logout(accessToken);
        return ResponseEntity.ok(flag);
    }

}
