package com.blood.bloodglucose.payload;

import com.blood.bloodglucose.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class GlucoseDto {
    private long id;
    private long userId;
    private Date timestamp;
    private double bloodGlucoseLevel;
    private double carbIntake;
    private double medicationDose;
}
