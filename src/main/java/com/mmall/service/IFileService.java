package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/10/22.
 */
public interface IFileService {
    public String upload(MultipartFile file, String path);
}
