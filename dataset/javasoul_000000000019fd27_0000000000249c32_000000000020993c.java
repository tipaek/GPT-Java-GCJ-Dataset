//package codegam2020.qualification.vestigium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] all = new int[n][n];
            int sum = 0;
            for(int r=0;r<n;r++)
                for(int c=0;c<n;c++){
                    all[r][c]=in.nextInt();
                    if(r==c)
                        sum+=all[r][c];
                }
            HashSet<Integer> set = new HashSet<>();
            //rows
            int rows=0;
            for(int r=0;r<n;r++){
                set.clear();
                for(int c=0;c<n;c++)
                    set.add(all[r][c]);
                if(set.size()<n)
                    rows++;
            }
            int cols = 0;
            for(int c=0;c<n;c++){
                set.clear();
                for(int r=0;r<n;r++)
                    set.add(all[r][c]);
                if(set.size()<n)
                    cols++;
            }
            System.out.println(String.format("Case #%s: %s %s %s",i,sum,rows,cols));
        }
    }
}
