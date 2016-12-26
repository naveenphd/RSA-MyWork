package com.phd.rules;

import java.util.ArrayList;
import java.util.Random;


public class MySameSequenceWithRange {

 

    public void generateSequence(){

    	
        Random rnd = new Random(7);

        for(int i=0;i<2;i++){

            System.out.println(rnd.nextInt(7));

        }

    }


    public static ArrayList<Integer> generateRadmonSequence(int randomLength){

    	ArrayList<Integer> nonSesistiyList = new ArrayList<>();
        Random rnd = new Random(randomLength);

        for(int i=0;i<2;i++){
            //System.out.println(rnd.nextInt(randomLength));
            nonSesistiyList.add(rnd.nextInt(randomLength));
        }
		return nonSesistiyList;

    }     

    public static void main(String a[]){

        MySameSequenceWithRange mss = new MySameSequenceWithRange();

        mss.generateSequence();
        
        ArrayList<Integer> nonSesistiyList = new  ArrayList<>();
        nonSesistiyList = generateRadmonSequence(10);
        
        for (Integer integerTemp : nonSesistiyList) {
			
        	System.out.println(""+integerTemp);
		}

      /*  System.out.println("====================");

        mss.generateSequence();

        System.out.println("====================");

        mss.generateSequence();
*/
    }

}

