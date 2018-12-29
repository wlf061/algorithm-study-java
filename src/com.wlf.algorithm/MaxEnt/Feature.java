package com.wlf.algorithm.MaxEnt;

/**
 * 类的描述
 *
 * @author nancy.wang
 * @Time 2018/12/28
 */
public class Feature {
    /**
     * 事件，如Outdoor
     */
    String label;
    /**
     * 事件发生的环境，如Sunny
     */
    String feature;

    public Feature(String label, String feature) {
        this.label = label;
        this.feature = feature;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (this.feature.equals(feature.feature) && this.label.equals(feature.label)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "[" + label + ", " + feature + "]";
    }
}
