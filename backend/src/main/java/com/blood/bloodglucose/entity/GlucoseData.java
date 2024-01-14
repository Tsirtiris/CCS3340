package com.blood.bloodglucose.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "glucose_data")
@NoArgsConstructor
@Getter
@Setter
public class GlucoseData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date timestamp;

    @Column(name = "blood_glucose_level", nullable = false)
    private double bloodGlucoseLevel;

    @Column(name = "carb_intake", nullable = false)
    private double carbIntake;

    @Column(name = "medication_dose", nullable = false)
    private double medicationDose;
}
