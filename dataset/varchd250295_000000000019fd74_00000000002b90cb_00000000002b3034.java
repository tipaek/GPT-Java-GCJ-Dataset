// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd74/00000000002b3034
// TIME - 

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int test = 1; test <= t; test++ ) {

            String ans = "";

            int n = Integer.parseInt(buf.readLine());
            StringBuilder[] patterns = new StringBuilder[n];
            int maxLength = Integer.MIN_VALUE;
            int maxIdx = -1;

            for(int i = 0; i < n; i++) {
                patterns[i] = new StringBuilder(buf.readLine());
                if(patterns[i].length() > maxLength) {
                    maxLength = patterns[i].length();
                    maxIdx = i;
                }
            }
            patterns[0] = new StringBuilder(patterns[maxIdx].substring(0, maxLength - patterns[0].length() + 1) + patterns[0].substring(1, patterns[0].length()));
            System.out.println("part 1- " + patterns[maxIdx].substring(0, maxLength - patterns[0].length())); 
            System.out.println("part 2- " + patterns[0].substring(1, patterns[0].length()));
            System.out.println(patterns[0].toString());
            ans = patterns[maxIdx].substring(1, maxLength);
            for(int i = 1; i < n; i++) {

                patterns[i] = new StringBuilder(patterns[maxIdx].substring(0, maxLength - patterns[i].length() + 1) + patterns[i].substring(1, patterns[i].length()));
                System.out.println(patterns[i].toString());
                if(!patterns[i].toString().equals(patterns[i-1].toString())) {
                    ans = "*";
                }
            }
           
            System.out.println("Case #" + test + ": " + ans);
        }
    }
}