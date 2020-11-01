package bloodyenterprise.girlfriend.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    @CrossOrigin
    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage() throws IOException {
        long round = Math.round(Math.random() * 10);
        System.out.println(round);
        File initialFile;
        if (round<=3){
            initialFile = new File("C:\\Users\\brave_dev\\Desktop\\girlfriend\\girlfriend\\src\\main\\resources\\static\\4.jpg");
        } else if (round < 6){
            initialFile = new File("C:\\Users\\brave_dev\\Desktop\\girlfriend\\girlfriend\\src\\main\\resources\\static\\3.jpg");
        } else {
            initialFile = new File("C:\\Users\\brave_dev\\Desktop\\girlfriend\\girlfriend\\src\\main\\resources\\static\\5.jpg");
        }

        InputStream in = FileUtils.openInputStream(initialFile);
        return IOUtils.toByteArray(in);
    }
}
