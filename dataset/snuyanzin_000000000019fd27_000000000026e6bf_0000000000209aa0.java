package com.github.snuyanzin.sanbox.stepik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static boolean[] used = new boolean[10];
    private static boolean[][] columnUsed = new boolean[10][10];
    static int counter = 0;
    static List<int[]> listOfTranspositions = new ArrayList<>();
    static List<int[]> secondaryListOfTranspositions = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int k = Integer.parseInt(input[1]);
                String output = findByTrace(k, n);
                if (output == null) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    System.out.println(output);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(findByTrace(4, 2));
    }

    private static String findByTrace(int requiredTrace, int n) {
        int[] array = new int[n];
        for (boolean[] booleans : columnUsed) {
            Arrays.fill(booleans, false);
        }
        Arrays.fill(used, false);
        listOfTranspositions.clear();
        secondaryListOfTranspositions.clear();
        new Transposition20().transpose(1, array, n);
        for (int[] elem : listOfTranspositions) {
            for (int i = 0; i < elem.length; i++) {
                columnUsed[i][elem[i]] = true;
            }
            secondaryListOfTranspositions.clear();
            for (int i = 0; i < n; i++) {
                Arrays.fill(used, false);
                new Transposition20().transpose2(1, new int[n], n);
                if (!secondaryListOfTranspositions.isEmpty()) {
                    for (int j = 0; j < secondaryListOfTranspositions.get(secondaryListOfTranspositions.size() - 1).length; j++) {
                        columnUsed[j][secondaryListOfTranspositions.get(secondaryListOfTranspositions.size() - 1)[j]] = true;
                    }
                }
            }
            int trace = elem[0];

            if (!secondaryListOfTranspositions.isEmpty() && secondaryListOfTranspositions.size() == n - 1) {
                for (int i = 1; i < n; i++) {
                    trace += secondaryListOfTranspositions.get(i - 1)[i];
                }
            }
            if (secondaryListOfTranspositions.size() == n - 1 && requiredTrace == trace) {

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < elem.length; i++) {
                    sb.append(elem[i]);
                    if (i != elem.length - 1) {
                        sb.append(' ');
                    }
                }
                sb.append('\n');
                for (int i = 0; i < secondaryListOfTranspositions.size(); i++) {
                    for (int j = 0; j < secondaryListOfTranspositions.get(i).length; j++) {
                        sb.append(secondaryListOfTranspositions.get(i)[j]);
                        if (j < secondaryListOfTranspositions.get(i).length - 1) {
                            sb.append(' ');
                        }
                    }
                    if (i < secondaryListOfTranspositions.size() - 1) {
                        sb.append('\n');
                    }
                }
                return sb.toString();
            }
            for (boolean[] booleans : columnUsed) {
                Arrays.fill(booleans, false);
            }
        }
        return null;
    }

    public void transpose(int n, int[] array, int m) {
        if (n == array.length + 1) {
            counter++;
            int[] result = new int[array.length];

            /*for (int[] elem: listOfTranspositions) {
                int shift = 0;
                while (shift < array.length && elem[0] != array[shift]) shift++;
                for (int i = 0; i < array.length; i++) {
                    if (elem[i] != array[(shift + i) % array.length]) {
                        break;
                    } else if (elem[i] == array[(shift + i) % array.length] && i == array.length - 1) {
                        return;
                    }
                }
            }*/
            System.arraycopy(array, 0, result, 0, array.length);
            listOfTranspositions.add(result);
            return;
        }
        for (int i = 1; i <= m; i++) {
            if (used[i]) {
                continue;
            }
            array[n - 1] = i;
            used[i] = true;
            transpose(n + 1, array, m);
            used[i] = false;
        }
    }

    public void transpose2(int n, int[] array, int m) {
        if (n == array.length + 1) {
            counter++;
            /*for (int[] elem: secondaryListOfTranspositions) {
                int shift = 0;
                while (shift < array.length && elem[0] != array[shift]) shift++;
                for (int i = 0; i < array.length; i++) {
                    if (elem[i] != array[(shift + i) % array.length]) {
                        break;
                    } else if (elem[i] == array[(shift + i) % array.length] && i == array.length - 1) {
                        return;
                    }
                }
            }*/
            for (int i = 0; i < array.length; i++) {
                if (columnUsed[i][array[i]]) {
                    return;
                }
                columnUsed[i][array[i]] = true;
            }
            int[] result = new int[array.length];
            System.arraycopy(array, 0, result, 0, array.length);
            secondaryListOfTranspositions.add(result);
            return;
        }
        for (int i = 1; i <= m; i++) {
            if (used[i] || columnUsed[n - 1][i]) {
                continue;
            }
            array[n - 1] = i;
            used[i] = true;
            transpose2(n + 1, array, m);
            used[i] = false;
        }
    }
}
