package com.company;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        for (int i = 1; i <= size; i++) {
            int boxSize = scanner.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            int[][] box = new int[boxSize][boxSize];

            for (int p = 0; p < boxSize; p++) {
                Set<Integer> row = new HashSet<>();
                for (int q = 0; q < boxSize; q++) {
                    box[p][q] = Integer.parseInt(scanner.next());
                    row.add(box[p][q]);
                    if (p == q) k += box[p][q];
                }
                if (row.size() != boxSize) r++;
            }

            for (int p = 0; p < boxSize; p++) {
                Set<Integer> col = new HashSet<>();
                for (int q = 0; q < boxSize; q++) {
                    col.add(box[q][p]);
                }
                if (col.size() != boxSize) c++;
            }

            System.out.println("case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
