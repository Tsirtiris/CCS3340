package com.blood.bloodglucose.respositories;

import com.blood.bloodglucose.entity.GlucoseData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GlucoseRepo extends JpaRepository<GlucoseData, Integer> {
    List<GlucoseData> findByUserId(Long userId);
}
