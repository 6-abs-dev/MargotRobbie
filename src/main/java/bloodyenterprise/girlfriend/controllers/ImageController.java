package bloodyenterprise.girlfriend.controllers;

import bloodyenterprise.girlfriend.services.ImageResolverService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@AllArgsConstructor
@RestController
public class ImageController {
    private final ImageResolverService imageResolverService;

    @CrossOrigin
    @GetMapping(value = "/getSexyPhoto")
    public String getSexyPhoto() {
        return imageResolverService.getRandomPhoto();
    }

    @AllArgsConstructor
    @Data
    private static class ImageUrlDto {
        private String url;
    }

    @CrossOrigin
    @GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] exposeImages(@PathVariable int id) throws IOException {
        System.out.println(id);

        File initialFile;

        switch (id) {
            case 1:
                initialFile = new File("C:\\Users\\brave_dev\\Desktop\\girlfriend\\girlfriend\\src\\main\\resources\\static\\4.jpg");
                break;
            case 2:
                initialFile = new File("C:\\Users\\brave_dev\\Desktop\\girlfriend\\girlfriend\\src\\main\\resources\\static\\4.jpg");
                break;
            case 3:
                initialFile = new File("C:\\Users\\brave_dev\\Desktop\\girlfriend\\girlfriend\\src\\main\\resources\\static\\3.jpg");
                break;
            case 4:
                initialFile = new File("C:\\Users\\brave_dev\\Desktop\\girlfriend\\girlfriend\\src\\main\\resources\\static\\3.jpg");
                break;
            case 5:
                initialFile = new File("C:\\Users\\brave_dev\\Desktop\\girlfriend\\girlfriend\\src\\main\\resources\\static\\3.jpg");
                break;
            default:
                initialFile = new File("C:\\Users\\brave_dev\\Desktop\\girlfriend\\girlfriend\\src\\main\\resources\\static\\4.jpg");
        }
        InputStream in = FileUtils.openInputStream(initialFile);
        return IOUtils.toByteArray(in);
    }
}
