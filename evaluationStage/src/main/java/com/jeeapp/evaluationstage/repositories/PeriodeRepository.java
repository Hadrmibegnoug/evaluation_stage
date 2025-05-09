package com.jeeapp.evaluationstage.repositories;

import com.jeeapp.evaluationstage.model.Periode;
import com.jeeapp.evaluationstage.model.PeriodeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodeRepository extends JpaRepository<Periode, PeriodeId> {
}
