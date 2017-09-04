package com.main.service;

import com.main.models.ActivityArea;
import com.main.repository.ActivityAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityAreaService {

    @Autowired
    private ActivityAreaRepository activityareaRepository;

    public List<ActivityArea> findAll() {
        return activityareaRepository.findAll();
    }

    public ActivityArea findOne(Integer id) {
        return activityareaRepository.findOne(id);
    }

    public ActivityArea save(ActivityArea activityarea) {
        return activityareaRepository.saveAndFlush(activityarea);
    }

    public void delete(Integer id) {
        activityareaRepository.delete(id);
    }
}
