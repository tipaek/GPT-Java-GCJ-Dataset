package com.imagsystems.telnet.ui;

import java.io.*;
import java.util.*;

public class Solution {
    private static int getRepeatCount(Long[][] matrix, String type, int length) {
        int count = 0;
        for (int i = 0; i < length; ++i) {
            Map<Long, Long> map = new HashMap<>();
            for (int j = 0; j < length; ++j) {
                if (type.equals("row")) {
                    map.put(matrix[i][j], matrix[i][j]);
                } else {
                    map.put(matrix[j][i], matrix[j][i]);
                }
            }
            if (length != map.size()) {
                count++;
            }
        }
        return count;
    }
    
    public static Long calculateTranceAndRepeatation(Long[][] matrix, int length) {
        Long trace = 0L;
        for (int i = 0; i < length; i++) {
            trace = trace + matrix[i][i];
        }
        return trace;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String t = in.nextLine();
        for (int i = 1; i <= Long.parseLong(t); ++i) {
            int length = in.nextInt();
            Long[][] matrix = new Long[length][length];
            for (int j = 0; j < length; ++j) {
                for (int k = 0; k < length; ++k) {
                    matrix[j][k] = in.nextLong();
                }
            }
            System.out.println("Case #" + i + ": " + calculateTranceAndRepeatation(matrix, length) +
                               " " + getRepeatCount(matrix, "row", length) + " " +
                               getRepeatCount(matrix, "column", length));
        }
    }
    
}
