package com.puzzle.util;

import java.util.ArrayList;
import java.util.Random;

public class getCode {
    public static String verifycode(){
        //put all characters in the list

        ArrayList<Character> list=new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));

        }

        String result="";
        Random r=new Random();
        //  generate 4  characters
        for (int i = 0; i < 4; i++) {
            int number=r.nextInt(list.size());
            char k=list.get(number);
            result=result+k;
        }
        int number=r.nextInt(9);
        result=result+number;
        char[] result1=result.toCharArray();
        int index=r.nextInt(result1.length);
        char tmp=result1[4];
        result1[4]=result1[index];
        result1[index]=tmp;

        return new String(result1);


    }
}
