// package com.taylorc.codejam1a2020;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int caseCnt = s.nextInt();
        s.nextLine();

        for (int i = 0; i < caseCnt; i++) {
            int size = s.nextInt();
            s.nextLine();
            List<String> patterns = new ArrayList<>();
            int max = 0;
            String ans = "";
            for (int p = 0; p < size; p++) {
                String curr = s.nextLine();
                if (curr.length() > max) {
                    max = curr.length();
                    ans = curr;
                }
                patterns.add(curr);
            }
            boolean match = true;
            String left = "", right = ""; 
            for (int p = 0; p < size; p++) {
                for (int k = 0; k < size; k++) {
                    if (p == k) continue; 
                    String pPattern = patterns.get(p), kPattern = patterns.get(k); 
                    String[] pParts = pPattern.split("\\*");
                    String[] kParts = kPattern.split("\\*");
                    System.out.println("pParts: " + Arrays.toString(pParts));
                    System.out.println("kParts: " + Arrays.toString(kParts));
                    int leftMin = Math.min(pParts[0].length(), kParts[0].length());
                    int rightMin = Math.min(pParts[1].length(), kParts[1].length());
                    int rightMax = Math.max(pParts[1].length(), kParts[1].length());
                    if (!pParts[0].substring(0, leftMin).equals(kParts[0].substring(0, leftMin))) {
                        match = false; 
                        break; 
                    } else {
                        if (pParts[0].length() > left.length()) left = pParts[0];
                        if (kParts[0].length() > left.length()) left = kParts[0]; 
                    }

                    if (!pParts[1].substring(rightMax - rightMin).equals(kParts[1].substring(rightMax - rightMin))) {
                        match = false;
                        break;
                    } else {
                        if (pParts[1].length() > right.length()) right = pParts[1];
                        if (kParts[1].length() > right.length()) right = kParts[1];
                    }
                }
            }
//            for (int p = 0; p < size; p++) {
//                String curr = patterns.get(p);
//                if (ans.equals(curr)) continue;
//                String sub = ans.substring(max - curr.length() + 1);
//                String currSub = curr.substring(1);
////                System.out.println("sub: " +  sub);
////                System.out.println("currSub: " +  currSub);
//                if (!sub.equals(currSub)) {
//                    match = false;
//                    break;
//                }
//            }
            if (match) {
                System.out.println("Case #" + (i + 1) + ": " + left + right);
            } else {
                System.out.println("Case #" + (i + 1) + ": " + "*");
            }

        }
    }
}
