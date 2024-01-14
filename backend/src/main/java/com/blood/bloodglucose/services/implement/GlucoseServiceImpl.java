package com.blood.bloodglucose.services.implement;

import com.blood.bloodglucose.entity.GlucoseData;
import com.blood.bloodglucose.entity.User;
import com.blood.bloodglucose.payload.GlucoseDto;
import com.blood.bloodglucose.respositories.GlucoseRepo;
import com.blood.bloodglucose.services.GlucoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GlucoseServiceImpl implements GlucoseService {
    @Autowired
    private GlucoseRepo glucoseRepo;

    private final List<GlucoseData> glucoseDataList;

    @Autowired
    public GlucoseServiceImpl(List<GlucoseData> glucoseDataList) {
        this.glucoseDataList = glucoseDataList;
    }
    @Override
    public GlucoseDto addGlucose(GlucoseDto glucoseDto) {
        GlucoseData glucose = this.dtoToGlucose(glucoseDto);
        GlucoseData savedGlucose = this.glucoseRepo.save(glucose);
        return this.glucoseToDto(savedGlucose);
    }

    @Override
    public Double getAverageBloodGlucoseLevel(Long userId) {
        List<GlucoseData> glucoseDataList = this.glucoseRepo.findByUserId(userId);

        if (glucoseDataList.isEmpty()) {
            return 0.0; // or handle the case where no data is available
        }

        // Calculate the average blood glucose level
        double sum = glucoseDataList.stream()
                .mapToDouble(GlucoseData::getBloodGlucoseLevel)
                .sum();

        return sum / glucoseDataList.size();
    }

    @Override
    public Double getAverageCarbIntake(Long userId) {
        List<GlucoseData> glucoseDataList = this.glucoseRepo.findByUserId(userId);

        if (glucoseDataList.isEmpty()) {
            return 0.0; // or handle the case where no data is available
        }

        // Calculate the average carb intake
        double sum = glucoseDataList.stream()
                .mapToDouble(GlucoseData::getCarbIntake)
                .sum();

        return sum / glucoseDataList.size();
    }

    @Override
    public List<GlucoseData> getAllGlucoseData() {
        return this.glucoseRepo.findAll();
    }


    private GlucoseData dtoToGlucose(GlucoseDto glucoseDto){
        GlucoseData glucoseData = new GlucoseData();
        glucoseData.setId(glucoseDto.getId());
        glucoseData.setBloodGlucoseLevel(glucoseDto.getBloodGlucoseLevel());
        glucoseData.setUserId(glucoseDto.getUserId());
        glucoseData.setCarbIntake(glucoseDto.getCarbIntake());
        glucoseData.setMedicationDose(glucoseDto.getMedicationDose());
        glucoseData.setTimestamp(new Date());
        return glucoseData;
    }

    private GlucoseDto glucoseToDto(GlucoseData glucoseData){
        GlucoseDto glucoseDto = new GlucoseDto();
        glucoseDto.setId(glucoseData.getId());
        glucoseDto.setBloodGlucoseLevel(glucoseData.getBloodGlucoseLevel());
        glucoseDto.setUserId(glucoseData.getUserId());
        glucoseDto.setCarbIntake(glucoseData.getCarbIntake());
        glucoseDto.setMedicationDose(glucoseData.getMedicationDose());
        glucoseDto.setTimestamp(glucoseData.getTimestamp());
        return glucoseDto;
    }
}
