package com.jeeapp.evaluationstagev2.repositories;

import com.jeeapp.evaluationstagev2.model.entities.Appreciation;
import com.jeeapp.evaluationstagev2.model.entities.AppreciationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppreciationRepository extends JpaRepository<Appreciation, AppreciationId> {
}
