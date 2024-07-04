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
            String left = "", right = "";

            for (int p = 0; p < size; p++) {
                String curr = s.nextLine();
                String[] parts = curr.split("\\*");
                if (parts[0].length() > left.length()) {
                    left = parts[0];
                }
                if (parts[1].length() > right.length()) {
                    right = parts[1];
                }

                patterns.add(curr);
            }
            boolean match = true;
            for (int p = 0; p < size; p++) {
                String pPattern = patterns.get(p);
                String[] pParts = pPattern.split("\\*");
                

                if (!pParts[0].equals(left.substring(0, pParts[0].length()))){
                    match = false;
                    break;
                }
                if (!pParts[1].equals(right.substring(right.length() - pParts[1].length()))) {
                    
                    match = false;
                    break;
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
