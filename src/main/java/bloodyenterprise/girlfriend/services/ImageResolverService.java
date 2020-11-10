package bloodyenterprise.girlfriend.services;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ImageResolverService {
    private static int lastRandomNumber;

    public String getRandomPhoto() {
        int randomNumber = getPseudoRandomNumber();
        switch (randomNumber){
            case 1:
                return "http://localhost:8080/image/1";
            case 2:
                return "http://localhost:8080/image/2";
            case 3:
                return "http://localhost:8080/image/3";
            case 4:
                return "http://localhost:8080/image/4";
            case 5:
                return "http://localhost:8080/image/5";
        }
        return "http://localhost:8080/image/6";
    }

    private int getPseudoRandomNumber(){
        int randomNumber = (int) (Math.random() * 6);
        if (randomNumber == lastRandomNumber){
            int anotherNumber = getPseudoRandomNumber();
            lastRandomNumber = anotherNumber;
            return anotherNumber;
        }
        lastRandomNumber = randomNumber;
        return randomNumber;
    }
}
