package com.indeed.elephant.api.explanation.utils;

import java.util.Scanner;

/**
 * @author zhxu
 */

public class Solution {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int testCases = in.nextInt();
        final int length = in.nextInt();

        for (int i = 0; i < testCases; ++i) {
            if (length == 10) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < 10; j++) {
                    sb.append(query(j + 1, in));
                }
                System.out.println(sb.toString());
            }
            else {
                System.out.println("\n");
            }
            
            String res = in.nextLine();
            if(res.equals("N")) {
                break;
            }
        }
    }

    private static int query(int pos, Scanner in) {
        System.out.println(pos);
        return in.nextInt();
    }
}
