package site.lawmate.user.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.lawmate.user.domain.dto.SessionUser;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class HomeController {

    public String Date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    private final HttpSession httpSession;

    @GetMapping("/")
    public String home(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
            return "Hello, " + user.getName() + "!";
        }
        return "Welcome to user server! " + Date;
    }

}
