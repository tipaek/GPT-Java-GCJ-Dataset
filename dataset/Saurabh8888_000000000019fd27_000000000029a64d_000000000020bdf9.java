/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_jam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Saurabh
 */
public class Solution {

    public static void main(String[] ar) throws Exception {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(reader.nextLine());
        int i = 0;
        while (i < t) {
            int n = Integer.parseInt(reader.nextLine());
            int num[][] = new int[n][2];
            String output = "";
            List<String> templist = new ArrayList<String>();
            for (int j = 0; j < n; j++) {
                String temp[] = reader.nextLine().split(" ");
                templist.add(temp[0] + "" + temp[1]);
                for (int k = 0; k < 2; k++) {
                    num[j][k] = Integer.parseInt(temp[k]);
                }
            }

            num = sortbyColumn(num, 0);
            Boolean j_lock = false, c_lock = false, imp = false;
            int c_time = -1, j_time = -1;

            for (int j = 0; j < n; j++) {
                if (c_time == -1 || c_time <= num[j][0]) {
                    c_lock = false;
                    c_time = -1;
                } else {
                    c_lock = true;
                }
                if (j_time == -1 || j_time <= num[j][0]) {
                    j_lock = false;
                    j_time = -1;
                } else {
                    j_lock = true;
                }
                if (j_lock == false || c_lock == false) {
                    if (c_lock == false) {
                        c_lock = true;
                        c_time = num[j][1];
                        output = output + 'C';
                    } else if (j_lock == false) {
                        j_lock = true;
                        j_time = num[j][1];
                        output = output + 'J';
                    }
                } else {
                    output = "IMPOSSIBLE";
                    imp = true;
                    break;
                }

            }

            char output1[] = new char[n];
            if (imp == true) {
                output1 = output.toCharArray();
            } else {
                StringBuilder output2 = new StringBuilder(output);
                for (int j = 0; j < n; j++) {
                    String test = num[j][0] + num[j][1] + "";
                    int temppos = templist.indexOf(test);
                    output1[j] = output2.charAt(temppos);
                    templist.remove(temppos);
                    output2.deleteCharAt(temppos);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + output1.toString());
            i++;
        }

    }

    public static int[][] sortbyColumn(int arr[][], int col) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(final int[] entry, final int[] entry1) {
                if (entry[col] > entry1[col]) {
                    return 1;
                } else {
                    return -1;
                }

            }
        });
        return arr;
    }
}
