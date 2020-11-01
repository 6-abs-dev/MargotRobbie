package bloodyenterprise.girlfriend.controllers;

import bloodyenterprise.girlfriend.entity.Message;
import bloodyenterprise.girlfriend.services.ResponseService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ResponseController {
    @Qualifier("mockService")
    private final ResponseService responseService;

    @SneakyThrows
    @CrossOrigin
    @GetMapping(value = "/newMessage")
    public Message respondToMessage(@RequestParam String message){
        System.out.println(message);
        Thread.sleep(3000);
        return responseService.respondToMessage(message);
    }

    @CrossOrigin
    @GetMapping(value = "/getHistory")
    public List<Message> getHistory(){
        return responseService.getHistory();
    }

    @CrossOrigin
    @GetMapping(value = "/getWeather")
    public String getWeather(){
        return responseService.getWeather();
    }
}
