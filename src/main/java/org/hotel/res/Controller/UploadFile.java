package org.hotel.res.Controller;

import org.springframework.boot.ApplicationHome;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class UploadFile {

    //Save the uploaded file to this folder
	
	ApplicationHome home = new ApplicationHome(this.getClass());
	File jarFile = home.getSource();
	File jarDir = home.getDir();
	static String  upload_dir = "src/main/resources/templates/tmp/";
	File uploadDir = new File(jarDir, upload_dir );
    private static String UPLOADED_FOLDER = upload_dir ;

    public static ResponseEntity<Void> singleFileUpload(@RequestParam("file") MultipartFile file) {

    	
    	String imageName = "image " + new Date() + file.getOriginalFilename();
        if (file.isEmpty()) {
            return new ResponseEntity("Error : Please select a file to upload" , HttpStatus.NO_CONTENT);
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + imageName );
            Files.write(path, bytes);
            return new ResponseEntity("You successfully uploaded '" + imageName + "'" + " dir " + UPLOADED_FOLDER , HttpStatus.OK);

        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}