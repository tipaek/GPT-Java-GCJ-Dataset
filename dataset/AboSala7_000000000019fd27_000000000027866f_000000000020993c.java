package Vestigium.java;

import java.util.Scanner;
import java.util.HashMap;


public class Vestigium {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int testsNum = sc.nextInt();
        int tests =0 ;

        while(testsNum> 0 ){
            int arraySize = sc.nextInt();
            Integer[][] curr = new Integer[arraySize][arraySize];

            for (int i = 0 ; i < arraySize ; i++){
                for(int j = 0 ; j < arraySize ; j++){
                    curr[i][j] = sc.nextInt();
                }
            }

            int trace = 0 ;
            for (int i =0 ; i< arraySize; i++){
                trace+=curr[i][i] ;
            }

            int repRowsNum = 0 ;
            int repColsNum = 0 ;
            HashMap<Integer,Integer> myMap1 = new HashMap<>();
            HashMap<Integer,Integer> myMap2 = new HashMap<>();
            for (int i = 0 ; i < arraySize ; i++){
                myMap1.clear();
                for(int j = 0 ; j < arraySize ; j++){
                    if (myMap1.get(curr[i][j]) == null)myMap1.put(curr[i][j] ,1);
                    else {
                        repRowsNum++ ;
                        break;
                    }
                }
            }
            for (int i = 0 ; i < arraySize ; i++){
                myMap2.clear();
                for(int j = 0 ; j < arraySize ; j++){
                    if (myMap2.get(curr[j][i]) == null)myMap2.put(curr[j][i] ,1);
                    else {
                        repColsNum++ ;
                        break;
                    }
                }
            }
            System.out.println("Case #"+ ++tests +": "+trace+" "+repRowsNum+" "+repColsNum);
            testsNum-- ;
        }
    }
}
