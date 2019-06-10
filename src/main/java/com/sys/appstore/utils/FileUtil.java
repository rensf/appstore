package com.sys.appstore.utils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileUtil {

    /**
     * 上传文件
     *
     * @param file
     * @param filepath
     * @return
     * @throws IOException
     */
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

    /**
     * 查看文件
     *
     * @param filepath
     * @param response
     * @throws IOException
     */
    public static void checkFile(String filepath, HttpServletResponse response) throws IOException {
        InputStream fileInputStream = new FileInputStream(filepath);
        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(fileInputStream, outputStream);
        fileInputStream.close();
        outputStream.close();
    }
}
