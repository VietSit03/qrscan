package project.qrscan.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    public abstract ResponseEntity<?> uploadImage(MultipartFile file, Long productId) throws IOException;
    public abstract ResponseEntity<?> downloadImage(String filename);
}
