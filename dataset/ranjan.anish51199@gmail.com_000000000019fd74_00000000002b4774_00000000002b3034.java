//package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=0;k<t;k++){
            int n=s.nextInt();
            String[] A=new String[n];
            int m=0;
            int size=0;
            for(int i=0;i<n;i++){
                A[i]=s.next();
                A[i]=A[i].replace("*","");
                if(A[i].length()>size) {
                    size=A[i].length();
                    m = i;
                }
            }
            boolean flag= true;
            String res=A[m];
            for(int i=0;i<n;i++){
                if(!A[m].contains(A[i])){
                   flag=false;
                }
            }
            if(flag){
                System.out.println("Case #"+(k+1)+": "+A[m]);
            }
            else
                System.out.println("Case #"+(k+1)+": "+"*");
           // System.out.println(A[m]);
        }
    }
}
