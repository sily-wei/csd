package com.wn.csd.test;

import java.util.Random;

/**
 * @author weining
 * @date 2019/11/10 14:05
 */
public class randomDemo {

    public static void main(String[] args) {
        Random r = new Random();
        for (int i =0;i<10;i++){
            int i1 = r.nextInt(999999);
            if (i1<100000){
                i1+=100000;
            }
            System.out.println(i1);
        }


    }
}
