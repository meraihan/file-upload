package com.rupali.bank.fileupload.service;

import com.rupali.bank.fileupload.helper.FileHelper;
import com.rupali.bank.fileupload.model.FileUpload;
import com.rupali.bank.fileupload.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {
    @Autowired
    FileUploadRepository repository;

    public void save(MultipartFile file) {
        try {
            List<FileUpload> fileUploads = FileHelper.excelToTutorials(file.getInputStream());
            repository.saveAll(fileUploads);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<FileUpload> getAllTutorials() {
        return repository.findAll();
    }
}
