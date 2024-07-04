//package com.company;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=0;k<t;k++){
            int n=s.nextInt();
            int[][] A=new int[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    A[i][j]=s.nextInt();
                }
            }
            int duplicate_row=0;
            int duplicate_col=0;

            Set<Integer> set= new HashSet<>();
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    set.add(A[i][j]);
                }
                if(set.size()!=n)
                    duplicate_row++;
                set.clear();
            }

            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    set.add(A[j][i]);
                }
                if(set.size()!=n)
                    duplicate_col++;
            }

            int trace=0;
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    if(i==j)
                        trace+=A[i][j];
                }
                }

            System.out.println("Case #"+(k+1)+": "+trace+" "+duplicate_col+" "+duplicate_row);

        }


    }
}
