package com.dlut.yonglun.location.controller;

import com.dlut.yonglun.location.dto.LocationResponse;
import com.dlut.yonglun.location.service.FileService;
import com.dlut.yonglun.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class LocationController {

    @Autowired
    private FileService fileService;
    private LocationService locationService = new LocationService();

    int floor;
    double south;
    double east;

    @PostMapping("/location")
    public LocationResponse location(@RequestParam("file") MultipartFile file){
        String fileName = fileService.storeFile(file);
        double[] locationResult = locationService.execute(fileName);


        floor = (int)Math.round(locationResult[0]);
        south = locationResult[1];
        east = locationResult[2];
        return new LocationResponse(floor, south, east);
    }


}
