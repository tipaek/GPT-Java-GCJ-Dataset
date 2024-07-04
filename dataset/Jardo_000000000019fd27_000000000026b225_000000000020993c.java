package sk.liptak;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {

            int sameRow = 0;
            int sameCol = 0;

            int n = scanner.nextInt();
            scanner.nextLine();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                String line =scanner.nextLine();
                int[] intLine = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                arr[j] = intLine;
                if(Arrays.stream(intLine).distinct().count() != n)
                    sameRow++;
            }

            for (int j = 0; j < n; j++) {
                int finalJ = j;
                if(IntStream.range(0, arr.length)
                        .map(b -> arr[b][finalJ]).distinct().count() != n)
                    sameCol++;
            }

            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += arr[j][j];
            }

            System.out.println("Case #" + (i+1)+": " + trace + " " + sameRow + " " + sameCol);

        }
    }
}
