package com.rupali.bank.fileupload.repository;

import com.rupali.bank.fileupload.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
