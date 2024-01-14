package com.blood.bloodglucose.controllers;

import com.blood.bloodglucose.entity.GlucoseData;
import com.blood.bloodglucose.payload.GlucoseDto;
import com.blood.bloodglucose.payload.UserDto;
import com.blood.bloodglucose.services.GlucoseService;
import com.blood.bloodglucose.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GlucoseService glucoseService;

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PostMapping("/glucose")
    public ResponseEntity<GlucoseDto> add_glucose(@RequestBody GlucoseDto glucoseDto){
        GlucoseDto  createGlucoseDto = this.glucoseService.addGlucose(glucoseDto);
        return new ResponseEntity<>(createGlucoseDto, HttpStatus.CREATED);
    }

    @GetMapping("/average-blood-glucose")
    public ResponseEntity<Double> getAverageBloodGlucoseLevel(@RequestParam Long userId) {
        Double averageBloodGlucoseLevel = glucoseService.getAverageBloodGlucoseLevel(userId);
        return ResponseEntity.ok(averageBloodGlucoseLevel);
    }

    @GetMapping("/average-carbIntake")
    public ResponseEntity<Double> getAverageCarbIntake(@RequestParam Long userId) {
        Double averageCarbIntake = glucoseService.getAverageCarbIntake(userId);
        return ResponseEntity.ok(averageCarbIntake);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GlucoseData>> getAllGlucoseData() {
        List<GlucoseData> glucoseDataList = glucoseService.getAllGlucoseData();
        return ResponseEntity.ok(glucoseDataList);
    }
}
