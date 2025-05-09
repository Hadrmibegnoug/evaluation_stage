package com.jeeapp.evaluationstage.repositories;

import com.jeeapp.evaluationstage.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StageRepository extends JpaRepository<Stage, Long> {
}
