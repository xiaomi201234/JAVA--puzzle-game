package com.puzzle.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] tmp={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r=new Random();
        for (int i = 0; i < tmp.length; i++) {
            // Get random index
            int index=r.nextInt(tmp.length);
            int k=tmp[i];
            tmp[i]=tmp[index];
            tmp[index]=k;

        }

        int[][] data=new int[4][4];
        for (int i = 0; i < tmp.length; i++) {
            data[i/4][i%4]=tmp[i];
        }
    }
}
