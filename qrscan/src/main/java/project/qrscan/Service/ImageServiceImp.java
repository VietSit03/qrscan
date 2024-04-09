package project.qrscan.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.qrscan.Entitiy.ImageProduct;
import project.qrscan.Entitiy.Product;
import project.qrscan.Repository.ImageRepository;
import project.qrscan.Repository.ProductRepository;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServiceImp implements ImageService{
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<?> uploadImage(MultipartFile file, Long productId) throws IOException {
        Product product = new Product();
        if (productRepository.findById(productId).isPresent()) {
            product = productRepository.findById(productId).get();
        }
        else {
            throw new RuntimeException("Not found product");
        }
        ImageProduct imageProduct = imageRepository.save(
                ImageProduct.builder().name(file.getOriginalFilename()).type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes())).product(product).build()
        );
        return ResponseEntity.status(HttpStatus.OK).body("Upload successful: " + file.getOriginalFilename());
    }

    @Override
    public ResponseEntity<?> downloadImage(String filename) {
        Optional<ImageProduct> imageProduct = imageRepository.findByName(filename);
        if (imageProduct.isPresent()) {
            byte[] images = ImageUtils.decompressImage(imageProduct.get().getImageData());
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf("image/png"))
                    .body(images);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found image");
    }
}
