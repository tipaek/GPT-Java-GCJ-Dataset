//package com.company;

import java.util.Scanner;

public class Solution {

    public static boolean factor(int n,int k){
        double b=(double)k/n;
        if(Math.floor(b)==b){
            for(int i=1;i<=n;i++){
                if(b==i)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=0;k<t;k++){
            int n=s.nextInt();
            int trace=s.nextInt();

            int[][] A=new int[n][n];
          //  System.out.println(factor(n,trace));

            if(n==2 && trace==3){
                System.out.println("Case #"+(k+1)+": "+"IMPOSSIBLE");
            }
            else if(trace==(n*(n+1))/2) {
                System.out.println("Case #" + (k + 1) + ": " + "POSSIBLE");

                for (int i = 0; i < n; i++) {
                    for (int j = 0;j < n; j++){
                        int p= i+j+1;
                        if(p<=n){
                            A[i][j]=p;
                        }
                        else if(A[i][j-1]==n){
                            A[i][j]=1;
                        }
                        else{
                            A[i][j] =A[i][j-1]+1;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(A[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            else if(factor(n,trace)){
                System.out.println("Case #" + (k + 1) + ": " + "POSSIBLE");
                int p=trace/n;
                A[0][0]=p;
                for(int j=1;j<n;j++){
                    if(A[0][j-1]!=n)
                        A[0][j]=A[0][j-1]+1;
                    else
                        A[0][j]=1;
                }

                for(int i=1;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(j==0)
                            A[i][j]=A[i-1][n-1];
                        else
                            A[i][j]=A[i-1][j-1];
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(A[i][j] + " ");
                    }
                    System.out.println();
                }

            }
            else
                System.out.println("Case #"+(k+1)+": "+"IMPOSSIBLE");
        }
    }
}
