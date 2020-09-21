package com.rupali.bank.fileupload.repository;

import com.rupali.bank.fileupload.model.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
}
