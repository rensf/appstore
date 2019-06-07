package com.sys.appstore.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadFileUtil {

    public static String uploadFile(MultipartFile file, String filepath) throws IOException {
        String filename = file.getOriginalFilename();
        String newname = IDGenerator.idGenerator() + filename.substring(filename.indexOf("."));
        File newFile = new File(filepath);
        if (!newFile.exists()) {
            newFile.mkdir();
        }
        FileOutputStream out = new FileOutputStream(newFile + "/" + newname);
        out.write(file.getBytes());
        out.close();
        return newname;
    }

}
