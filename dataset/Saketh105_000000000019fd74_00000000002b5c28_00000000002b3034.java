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
            ArrayList<String> arr = new ArrayList<>();
            ArrayList<String> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String p = scan.next();
                arr.add(p);
                String h = "";
                for (int k = 0; k < p.length(); k++) {
                    if (!p.substring(k, k + 1).equalsIgnoreCase("*")) {
                        h += p.substring(k, k + 1);
                    }
                }
                a.add(h);
            }
            Collections.sort(a);
            Collections.sort(arr);
            String s = solve(arr, a);
            System.out.println("Case #" + (i + 1) + ": " + s);
        }
    }

    public static String solve(ArrayList<String> arr, ArrayList<String> a1) {
        String sol = "";
        for (int i = arr.size() - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                String s1 = a1.get(j);
                String s2 = a1.get(1);
                if (!s1.contains(s2)) {
                    return "*";
                }
            }
        }
        String a = "abc";
        String last = arr.get(0);
        StringBuilder s = new StringBuilder(last.length());
        for (int i = 0; i < last.length(); i++) {
            if (last.substring(i, i + 1).equalsIgnoreCase("*")) {
                s.append(a);
            } else {
                s.append(last.substring(i, i + 1));
            }
        }
        return s.toString();
    }
}
