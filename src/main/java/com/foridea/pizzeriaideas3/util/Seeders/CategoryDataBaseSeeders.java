package com.foridea.pizzeriaideas3.util.Seeders;


import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.entities.ImageProfile;
import com.foridea.pizzeriaideas3.repository.CategoryRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CategoryDataBaseSeeders {

    private static final String categories[] = {"Empanadas", "Pizzas", "Gaseosas",
        "Postres", "Panificados",
        "Ensaladas", "Vinos", "Cerbezas"};
    private static final String listFile[] = {"image05.png", "image01.png", "image03.png",
        "image02.png", "image04.png", "image06.png",
        "image07.png", "image08.png"};
    @Autowired
    private CategoryRepository categoryRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException  {
        List<Category> categorylis = categoryRepository.findAll();

        if (categorylis.isEmpty()) {

            String sCarpAct = System.getProperty("user.dir");
            for (int index = 0; index < categories.length; index++) {
                ImageProfile image = new ImageProfile();
                Category category = new Category();
                category.setName(categories[index].toUpperCase());
                category.setDescription("Descripción de " + categories[index]);

                InputStream inputStream = new FileInputStream(new File(sCarpAct + "/src/main/resources/static/images/" + listFile[index]));
                //String name, @Nullable String originalFilename, @Nullable String contentType, InputStream contentStream)
                MultipartFile partFile = new MockMultipartFile(listFile[index], listFile[index], "image/png", inputStream);
                image.setFileData(partFile.getBytes());
                image.setFileType("image/png");
                image.setName(partFile.getName());
                category.setImageProfile(image);
                category.setStatus(Boolean.TRUE);               
                categoryRepository.save(category);
                  System.out.println(category);

            }
        }
    }

}
