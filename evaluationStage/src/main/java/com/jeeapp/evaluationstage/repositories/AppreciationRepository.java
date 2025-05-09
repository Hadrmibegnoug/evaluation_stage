package com.jeeapp.evaluationstage.repositories;

import com.jeeapp.evaluationstage.model.Appreciation;
import com.jeeapp.evaluationstage.model.AppreciationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppreciationRepository extends JpaRepository<Appreciation, AppreciationId> {
}
