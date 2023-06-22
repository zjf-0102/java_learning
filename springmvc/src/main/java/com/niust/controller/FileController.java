package com.niust.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 这个控制器用来处理文件的上传和下载，需要ResponseEntity这个类型
 */
@Controller
public class FileController {

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        ServletContext context = session.getServletContext();
        String realPath = context.getRealPath("/static/img/1.jpg");
        FileInputStream is = new FileInputStream(realPath);
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        MultiValueMap<String, String> Headers = new HttpHeaders();
        Headers.add("Content-Disposition","attachment;filename=1.jpg");
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, Headers, status);
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        ServletContext context = session.getServletContext();
        String realPath = context.getRealPath("/static/img");
        photo.transferTo(new File(realPath + File.separator + photo.getOriginalFilename()));
        return "target";
    }

}
