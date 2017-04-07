package com.le.viet.mockito.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by onelazyguy on 4/2/17.
 */
public class ZooClient {
    private static final Logger LOG = LoggerFactory.getLogger(ZooClient.class);

    public static void main(String[] args){
        Animal tiger = new Tiger();
        LOG.info(tiger.makeNoise());
    }
}
