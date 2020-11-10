package bloodyenterprise.girlfriend.services;

import bloodyenterprise.girlfriend.entity.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class MockService implements ResponseService {
    private final RestTemplate restTemplate;

    private static final LinkedList<Message> messages = new LinkedList<>();
    private static final LinkedList<String> greetingsWords = new LinkedList<>();
    private static int incrementer = 0;

    static {
        messages.add(new Message("Болина", "Ну привет"));
        messages.add(new Message("Киса", "Привет-привет!"));
        Stream.of("привет", "здорово", "хай").forEach(greetingsWords::add);
    }

    @Override
    public Message respondToMessage(String message) {
        if (greetingsWords.contains(message.toLowerCase()))
            return new Message("Марго", "ну привет-привет");

        switch (message) {
            case "как дела?":
                return new Message("Марго", "пока не родила, ты как?");
            case "любовь":
                return new Message("Марго", "<p>&#128512; &#128516; &#128525; &#128151;<p>");
            case "погода":
                return new Message("Марго", getWeather());
//            case "погода яндекс":
//                return new Message("Болина", getYandexForecast());
//            case "погода мок":
//                return new Message("Болина", getMockWeather());
            default:
                incrementer++;
                return new Message("Марго", "Тестовое сообщение №" + incrementer);
        }
    }

    @Override
    public List<Message> getHistory() {
        return messages;
    }

    @Override
    public int getRandomNumber() {
        return (int) (Math.random() * 999 + 100);
    }

    @Override
    public String getWeather() {
        return "{\n" +
                "    \"now\": 1602927791,\n" +
                "    \"now_dt\": \"2020-10-17T09:43:11.387Z\",\n" +
                "    \"info\": {\n" +
                "        \"lat\": 53,\n" +
                "        \"lon\": 50,\n" +
                "        \"url\": \"https://yandex.ru/pogoda/?lat=53&lon=50\"\n" +
                "    },\n" +
                "    \"fact\": {\n" +
                "        \"temp\": 9,\n" +
                "        \"feels_like\": 4,\n" +
                "        \"icon\": \"bkn_d\",\n" +
                "        \"condition\": \"partly-cloudy\",\n" +
                "        \"wind_speed\": 4,\n" +
                "        \"wind_gust\": 8.6,\n" +
                "        \"wind_dir\": \"n\",\n" +
                "        \"pressure_mm\": 754,\n" +
                "        \"pressure_pa\": 1006,\n" +
                "        \"humidity\": 43,\n" +
                "        \"daytime\": \"d\",\n" +
                "        \"polar\": false,\n" +
                "        \"season\": \"autumn\",\n" +
                "        \"obs_time\": 1602927277\n" +
                "    },\n" +
                "    \"forecast\": {\n" +
                "        \"date\": \"2020-10-17\",\n" +
                "        \"date_ts\": 1602878400,\n" +
                "        \"week\": 42,\n" +
                "        \"sunrise\": \"07:10\",\n" +
                "        \"sunset\": \"17:39\",\n" +
                "        \"moon_code\": 8,\n" +
                "        \"moon_text\": \"moon-code-8\",\n" +
                "        \"parts\": [\n" +
                "            {\n" +
                "                \"part_name\": \"evening\",\n" +
                "                \"temp_min\": 0,\n" +
                "                \"temp_max\": 4,\n" +
                "                \"temp_avg\": 2,\n" +
                "                \"feels_like\": -2,\n" +
                "                \"icon\": \"skc_n\",\n" +
                "                \"condition\": \"clear\",\n" +
                "                \"daytime\": \"n\",\n" +
                "                \"polar\": false,\n" +
                "                \"wind_speed\": 2.7,\n" +
                "                \"wind_gust\": 7,\n" +
                "                \"wind_dir\": \"n\",\n" +
                "                \"pressure_mm\": 757,\n" +
                "                \"pressure_pa\": 1010,\n" +
                "                \"humidity\": 69,\n" +
                "                \"prec_mm\": 0,\n" +
                "                \"prec_period\": 360,\n" +
                "                \"prec_prob\": 0\n" +
                "            },\n" +
                "            {\n" +
                "                \"part_name\": \"night\",\n" +
                "                \"temp_min\": -1,\n" +
                "                \"temp_max\": 1,\n" +
                "                \"temp_avg\": 0,\n" +
                "                \"feels_like\": -4,\n" +
                "                \"icon\": \"skc_n\",\n" +
                "                \"condition\": \"clear\",\n" +
                "                \"daytime\": \"n\",\n" +
                "                \"polar\": false,\n" +
                "                \"wind_speed\": 2.5,\n" +
                "                \"wind_gust\": 5,\n" +
                "                \"wind_dir\": \"e\",\n" +
                "                \"pressure_mm\": 758,\n" +
                "                \"pressure_pa\": 1011,\n" +
                "                \"humidity\": 78,\n" +
                "                \"prec_mm\": 0,\n" +
                "                \"prec_period\": 360,\n" +
                "                \"prec_prob\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
    }
}
