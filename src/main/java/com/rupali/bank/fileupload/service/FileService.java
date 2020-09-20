package com.rupali.bank.fileupload.service;

import com.rupali.bank.fileupload.helper.FileHelper;
import com.rupali.bank.fileupload.model.Tutorial;
import com.rupali.bank.fileupload.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {
    @Autowired
    TutorialRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Tutorial> tutorials = FileHelper.excelToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }
}
