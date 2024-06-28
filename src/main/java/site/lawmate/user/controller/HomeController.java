package site.lawmate.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class HomeController {

    public String Date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

    @GetMapping("/")
    public String home() {
        return "Welcome to user server! " + Date;
    }

}
