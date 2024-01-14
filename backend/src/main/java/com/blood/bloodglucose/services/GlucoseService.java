package com.blood.bloodglucose.services;

import com.blood.bloodglucose.entity.GlucoseData;
import com.blood.bloodglucose.payload.GlucoseDto;

import java.util.Date;
import java.util.List;

public interface GlucoseService {
    GlucoseDto addGlucose(GlucoseDto glucoseDto);
    Double getAverageBloodGlucoseLevel(Long userId);

    Double getAverageCarbIntake(Long userId);

    List<GlucoseData> getAllGlucoseData();
}
