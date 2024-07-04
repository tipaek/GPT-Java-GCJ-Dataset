//package com.company;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=0;k<t;k++) {
            int n = s.nextInt();
            if (n == 1) {
                System.out.println("Case #" + (k + 1) + ": ");
                System.out.println(1+" "+1);
            } else {
                int[] A = printPascal(n, 0, 0);
                int r = A[0];
                int c = A[1];
                int i;
                System.out.println("Case #" + (k + 1) + ": ");
                for (i = 1; i <= r; i++) {
                    System.out.println(i + " " + 1);
                }
                int b = i - 1;
                for (int j = 2; j <= c; j++) {
                    System.out.println(b + " " + j);
                }
                //  System.out.println(i);
                //  System.out.println(r+" "+c);
            }
        }
    }

    public static int[] printPascal(int k,int r,int c)
    {
        int[] A=new int[2];
        boolean flag=false;
        int[][] arr = new int[10000][10000];
        for (int line = 0;; line++)
        {
            // Every line has number of integers equal to line number
            for (int i = 0;i <= line; i++)
            {
                // First and last values in every row are 1
                if (line == i || i == 0){
                    arr[line][i] = 1;
                    if(arr[line][i]==k){
                        flag=true;
                        c=i;
                        break;
                    }
                }
                else {

                    arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
                    if(arr[line][i]==k){
                        flag=true;
                        c=i;
                        break;
                    }
                }

            }
            if(flag){
                r=line;
                break;
            }
        }
        A[0]=r;
        A[1]=c;
       // System.out.println(r+" "+c);
        return A;
    }
}
