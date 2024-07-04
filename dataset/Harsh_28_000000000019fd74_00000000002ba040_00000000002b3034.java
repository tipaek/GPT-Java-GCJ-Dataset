
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Harsh
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                int n = sc.nextInt();
                String[] pattern = new String[n];
                for (int j = 0; j < n; j++) {
                    pattern[j] = sc.next().toUpperCase();
                }

                int count[] = new int[n];
                String substr[] = new String[n];
                int maxLength = 0;
                int positionOfMaxSubStr = 0;
                for (int j = 0; j < pattern.length; j++) {
                    count[j] = 0;
                    if (pattern[j].charAt(0) == '*') {

                        for (int k = 0; k < pattern[j].length(); k++) {
                            if (pattern[j].charAt(k) != '*') {
                                count[j]++;
                            }
                        }
                        if (count[j] == pattern[j].length() - 1) {
                            substr[j] = pattern[j].substring(1);
                        }
                    }
                }

                for (int j = 0; j < substr.length; j++) {
                    if (substr[j].length() >= maxLength) {
                        maxLength = substr[j].length();
                        positionOfMaxSubStr = j;
                    }
                }

                int c = 0;
                for (int j = 0; j < n; j++) {
                    if (substr[positionOfMaxSubStr].contains(substr[j])) {
                        c++;
                    }
                }

                if (c == substr.length) {
                    System.out.println("Case #" + (i+1) + ":" + substr[positionOfMaxSubStr]);
                }
                else{
                    System.out.println("Case #" + (i+1) + ": *" );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
