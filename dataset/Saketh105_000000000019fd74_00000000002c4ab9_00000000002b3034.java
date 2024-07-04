/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author Saketh Ram Kotamraju
 */
 class Solution {

    public static void main(String args[]) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                String p = scan.next();
                p = p.replace("*", "");
                arr[j] = p;
            }
            Arrays.sort(arr);
            String s = solve(arr);
            System.out.println("Case #" + (i+1) + ": " + s);
        }
    }

    public static String solve(String[] arr) {
        String fixed = arr[0];
        for (int i = 1; i<arr.length; i++) {
            if(!fixed.contains(arr[i])){
            return "*";
            }
        }
        return fixed;
    }

}
