package bloodyenterprise.girlfriend.services;

import bloodyenterprise.girlfriend.entity.Message;

import java.util.List;
import java.util.function.Supplier;

public interface ResponseService {

    String getWeather();

    Message respondToMessage(String message);

    List<Message> getHistory();

}
