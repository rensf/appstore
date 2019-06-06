package com.sys.appstore.utils;

import com.sys.appstore.config.MyPropsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadFileUtil {

    @Autowired
    private static MyPropsConfig myProps;

    public static String uploadImage(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        String newname = IDGenerator.idGenerator() + filename.substring(filename.indexOf("."));
        File newFile = new File(myProps.getImagepath());
        if(!newFile.exists()) {
            newFile.mkdir();
        }
        FileOutputStream out = new FileOutputStream(newFile + "/" + newname);
        out.write(file.getBytes());
        out.close();
        return newname;
    }

}
