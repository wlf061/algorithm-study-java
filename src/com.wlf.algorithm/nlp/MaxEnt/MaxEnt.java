package com.wlf.algorithm.nlp.MaxEnt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 类的描述
 * @author nancy.wang
 * @Time 2018/12/28
 */
public class MaxEnt {

    List<Feature> featureList = new ArrayList<Feature>();
    /**
     * 每个特征的出现次数
     */
    List<Integer> featureCountList = new ArrayList<Integer>();

    public void loadData(String path) {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(new File(path)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] str) {
        String path = "E:\\study\\mechain-learning\\algorithm-study\\algorithm-study-java\\src\\com.wlf.algorithm\\MaxEnt\\train.txt";
        MaxEnt maxEnt = new MaxEnt();
        maxEnt.loadData(path);
    }

}
