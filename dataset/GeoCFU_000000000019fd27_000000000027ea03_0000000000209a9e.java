package com.company;

import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws IOException {

        //Scanner S = new Scanner(new FileInputStream("C:\\Users\\Geo\\Desktop\\codejam.txt"));
        //InputStreamReader r = new InputStreamReader(System.in);
        Scanner S = new Scanner(System.in);
        int T = S.nextInt();
        int b = S.nextInt();
        for(Integer t = 0 ; t < T ;t++) {
            boolean[] arr = new boolean[b];
            int lastSame = -1;
            int lastDiff = -1;
            int count = 0;

            for(int i = 0; i < b/2 ; i++){

                System.out.println(i);
                System.out.flush();
                boolean v = S.next() == "1";
                count++;
                arr[i] = v;

                System.out.println(b-1-i);
                System.out.flush();
                boolean opp = S.next() == "1";
                count++;
                arr[b-1-i] = opp;

                if(v == opp){
                    lastSame = i;
                } else {
                    lastDiff = i;
                }

                if(count == 10){
                    boolean sameChanged = false;
                    boolean diffChanged = false;

                    if(lastDiff != -1){
                        System.out.println(lastDiff);
                        System.out.flush();
                        v = S.next() == "1";
                        count++;
                        diffChanged = v!= arr[lastDiff];
                    }

                    if(lastSame != -1){
                        System.out.println(lastSame);
                        System.out.flush();
                        boolean s = S.next() == "1";
                        count++;
                        sameChanged = s!= arr[lastSame];
                    }

                    if(sameChanged){
                        complement(arr);
                    } else {
                        if(diffChanged){
                            reverse(arr);
                        }
                    }


                }
            }

            char[] res = new char[b];
            for(int i = 0 ; i < b ; i++){
                res[i] = arr[i]? '1' : '0';
            }
            System.out.println(new String(res));
            System.out.flush();
            String result = S.next();
            if(result != "Y"){
                System.exit(0);
            }
        }

    }

    static void reverse(boolean[] arr){
        for(int i = 0 ; i < arr.length/2 ;i++){
            boolean tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }

    static void complement(boolean[] arr){
        for(int i = 0 ; i < arr.length ;i++){
            arr[i] = !arr[i];
        }
    }
}