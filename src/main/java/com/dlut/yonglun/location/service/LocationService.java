package com.dlut.yonglun.location.service;

import com.dlut.yonglun.location.exception.FileException;
import com.dlut.yonglun.location.property.FileProperties;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;

import wknn.WKNN;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author yonglunyao
 */
public class LocationService {
    private double[] location = new double[2];

    @Autowired
    public LocationService() {

    }

    public double[] execute(String filename) {
        int scan_times = 10;
        Object[] wknnArgs = new Object[2];
        wknnArgs[0] = filename;
        wknnArgs[1] = scan_times;

        WKNN wknn = null;
        Object[] objArray = new Object[0];

        try {
            wknn = new WKNN();
            objArray = wknn.wknn(3, wknnArgs);
        } catch (MWException e) {
            e.printStackTrace();
        }

        File file = new File("./data/"+filename);
        if(!file.delete()){
            System.out.println(file+" delete filed!");
        }

        MWNumericArray mwFloor = (MWNumericArray) objArray[0];
        double floor = mwFloor.getDouble();

        MWNumericArray mwSouth = (MWNumericArray) objArray[1];
        double south = mwSouth.getDouble();

        MWNumericArray mwEast = (MWNumericArray) objArray[2];
        double east = mwEast.getDouble();

        double[] location = new double[3];
        location[0] = floor;
        location[1] = south;
        location[2] = east;

        return location;
    }

}
