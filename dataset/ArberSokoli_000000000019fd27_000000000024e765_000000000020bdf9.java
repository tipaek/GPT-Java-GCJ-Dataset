import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
      try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
         int t = Integer.parseInt(sc.nextLine());
         
         for(int t0 = 0; t0 < t; t0++) {
            int n = Integer.parseInt(sc.nextLine());
            boolean impossible = false;
            String answer = "";
            int c = 0;
            int j = 0;
            int[][] s = new int[n][2];
            boolean[] done = new boolean[n];
            int min = 1440;
            int minindex = -1;
            for(int i = 0; i < n; i++) {
               String[] s12 = sc.nextLine().split(" ");
               int s1 = Integer.parseInt(s12[0]);
               int s2 = Integer.parseInt(s12[1]);
               s[i][0] = s1;
               s[i][1] = s2;
               if(s1 <= min) {
                  min = s1;
                  minindex = i;
               }
               done[i] = false;
            }
            
            for(int z = 0; z < n; z++) {
               int start = s[minindex][0];
               int end = s[minindex][1];
               if(j >= c) {
                  if(start < c) {
                     impossible = true;
                  }
                  c = end;
                  answer += "C";
               }
               else {
                  if(start < j) {
                     impossible = true;
                  }
                  j = end;
                  answer += "J";
               }
               done[minindex] = true;
               min = 1440;
               for(int i = 0; i < n; i++) {
                  if(!done[i]) {
                     if(s[i][0] <= min) {
                        min = s[i][0];
                        minindex = i;
                     }
                  }
               }
            }
            if(impossible) {
               answer = "IMPOSSIBLE";
            }            
            System.out.println("Case #" + (t0 + 1) + ": " + answer);
         }
      }
	}
}