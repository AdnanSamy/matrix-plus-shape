package com.sam.matrix;

import java.util.Random;

public class GenerateRandom {
    
    public static int generateInt(int min, int max){
        Random random = new Random();

        return random.nextInt(max - min + 1) + min;
    }
}
