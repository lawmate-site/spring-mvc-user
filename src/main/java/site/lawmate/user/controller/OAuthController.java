package site.lawmate.user.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.lawmate.user.domain.dto.UrlDto;
import site.lawmate.user.domain.dto.MessageDto;
import site.lawmate.user.domain.dto.TokenDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class OAuthController {

    @Value("${spring.security.oauth2.resourceserver.opaque-token.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.resourceserver.opaque-token.client-secret}")
    private String clientSecret;


    @GetMapping("/url")
    public ResponseEntity<UrlDto> auth() {
        String url = new GoogleAuthorizationCodeRequestUrl(clientId,
                "http://localhost:3000/pages/auth/callback",
                Arrays.asList(
                        "email",
                        "profile",
                        "openid")).build();

        return ResponseEntity.ok(new UrlDto(url));
    }

    @GetMapping("/callback")
    public ResponseEntity<TokenDto> callback(@RequestParam("code") String code) throws URISyntaxException {

        String token;
        try {
            token = new GoogleAuthorizationCodeTokenRequest(
                    new NetHttpTransport(), new GsonFactory(),
                    clientId,
                    clientSecret,
                    code,
                    "http://localhost:3000/pages/auth/callback"
            ).execute().getAccessToken();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(new TokenDto(token));
    }

    @GetMapping("/messages")
    public ResponseEntity<MessageDto> messages(@AuthenticationPrincipal(expression = "name") String name) {
        return ResponseEntity.ok(new MessageDto(name));
    }
}
