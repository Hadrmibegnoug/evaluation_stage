package com.jeeapp.evaluationstagev2.repositories;

import com.jeeapp.evaluationstagev2.model.entities.Periode;
import com.jeeapp.evaluationstagev2.model.entities.PeriodeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodeRepository extends JpaRepository<Periode, PeriodeId> {
}
