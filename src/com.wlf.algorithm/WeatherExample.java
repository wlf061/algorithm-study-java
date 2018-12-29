package com.wlf.algorithm;
import static com.wlf.algorithm.WeatherExample.Activity.*;
import static com.wlf.algorithm.WeatherExample.Weather.*;


/**
 * Weather 是状态值；
 * Activity 是观测序列
 *
 * @author nancy.wang
 * @Time 2018/12/26
 */
public class WeatherExample {
    enum Weather {
        RAINY,
        SUNNY,
    }

    enum Activity {
        WALK,
        SHOP,
        CLEAN,
    }

    static int[] states = new int[]{RAINY.ordinal(), SUNNY.ordinal()};
    static int[] observations = new int[]{WALK.ordinal(), SHOP.ordinal(), CLEAN.ordinal()};
    static double[] start_probability = new double[]{0.6, 0.4};
    static double[][] transititon_probability = new double[][]{
            {0.7, 0.3},
            {0.4, 0.6},
    };
    static double[][] emission_probability = new double[][]{
            {0.1, 0.4, 0.5},
            {0.6, 0.3, 0.1},
    };

    public static void main(String[] str) {
        int[] result = Viterbi.compute(observations, states, start_probability, transititon_probability, emission_probability);
        for (int r : result) {
            System.out.print(Weather.values()[r] + " ");
        }
        System.out.println();
    }

}
