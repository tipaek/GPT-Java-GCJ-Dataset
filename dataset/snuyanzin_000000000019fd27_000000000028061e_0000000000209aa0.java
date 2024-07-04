
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static boolean[] used = new boolean[50];
    private static boolean[][] columnUsed = new boolean[50][50];
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
    }

    public static String findByTrace(int requiredTrace, int n) {
        int[] array = new int[n];
        for (boolean[] booleans : columnUsed) {
            Arrays.fill(booleans, false);
        }
        Arrays.fill(used, false);
        listOfTranspositions.clear();
        secondaryListOfTranspositions.clear();
        transpose(1, array, n);
        for (int[] elem : listOfTranspositions) {
            for (boolean[] booleans : columnUsed) {
                Arrays.fill(booleans, false);
            }
            Arrays.fill(used, false);
            for (int i = 0; i < elem.length; i++) {
                columnUsed[i][elem[i]] = true;
            }
            secondaryListOfTranspositions.clear();
            secondaryListOfTranspositions.add(elem);
            for (int i = 0; i < n; i++) {
                Arrays.fill(used, false);
                transpose2(1, new int[n], n);
                if (!secondaryListOfTranspositions.isEmpty()) {
                    for (int j = 0; j < secondaryListOfTranspositions.get(secondaryListOfTranspositions.size() - 1).length; j++) {
                        columnUsed[j][secondaryListOfTranspositions.get(secondaryListOfTranspositions.size() - 1)[j]] = true;
                    }

                }

                int trace = 0;
                int[] traceMatrix = new int[n];
                int[] traceMatrixBack = new int[n];

                if (!secondaryListOfTranspositions.isEmpty() && secondaryListOfTranspositions.size() == n) {
                    for (int q = 0; q < n; q++) {
                        trace += secondaryListOfTranspositions.get(q)[q];
                        for (int j = 0; j < n; j++) {
                            traceMatrix[j] += secondaryListOfTranspositions.get(q)[(n + j + q) % (n)];
                            //           System.out.println(n + " " + j + "  " + q);
                            traceMatrixBack[j] += secondaryListOfTranspositions.get(q)[(2 * n - j - q) % (n)];
                            //         System.out.println(" els for traceback j " + j + "] " + q + " " + ((n - j) % (n)) + "  "  + secondaryListOfTranspositions.get(q)[(2 * n - j - q) % (n)]);
                        }
                    }
                }
                for (int o = 0; o < n; o++) {
                    if (traceMatrix[o] == requiredTrace || traceMatrixBack[o] == requiredTrace) {
                        int shift = requiredTrace == traceMatrix[o] ? o : n - o;
                        StringBuilder sb = new StringBuilder();
                        if (requiredTrace == traceMatrix[o]) {
                            for (int q = 0; q < secondaryListOfTranspositions.size(); q++) {
                                for (int j = 0; j < secondaryListOfTranspositions.get(q).length; j++) {
                                    sb.append(secondaryListOfTranspositions.get(q)[(j + shift) % n]);
                                    if (j < secondaryListOfTranspositions.get(q).length - 1) {
                                        sb.append(' ');
                                    }
                                }
                                if (q < secondaryListOfTranspositions.size() - 1) {
                                    sb.append('\n');
                                }
                            }
                        } else {
                            for (int q = secondaryListOfTranspositions.size() - 1; q >= 0; q--) {
                                for (int j = 0; j < secondaryListOfTranspositions.get(q).length; j++) {
                                    sb.append(secondaryListOfTranspositions.get(q)[j % n]);
                                    if (j < secondaryListOfTranspositions.get(q).length - 1) {
                                        sb.append(' ');
                                    }
                                }
                                if (q != 0) {
                                    sb.append('\n');
                                }
                            }
                        }
                        return sb.toString();
                    }
                }
               /* System.out.println(trace);
                System.out.println(Arrays.toString(traceMatrix));
                System.out.println(Arrays.toString(traceMatrixBack));*/
            }
        }
        return null;
    }

    public static void transpose(int n, int[] array, int m) {
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

    public static void transpose2(int n, int[] array, int m) {
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
            //         System.out.println("\t\t\t\t2Check " + Arrays.toString(array));
            for (int i = 0; i < array.length; i++) {
                if (columnUsed[i][array[i]]) {
                    return;
                }
            }
            for (int i = 0; i < array.length; i++) {
                columnUsed[i][array[i]] = true;
            }
            int[] result = new int[array.length];
            System.arraycopy(array, 0, result, 0, array.length);
            secondaryListOfTranspositions.add(result);
            return;
        }
        for (int i = 1; i <= m; i++) {
            if (used[i] || columnUsed[n - 1][i]) {
                if (n - i >= 0 && columnUsed[n - i][i]) {
                    //                 System.out.println("\t\t\t\t\t " + i + " used by column " + (n - 1));
                }
                continue;
            }
            array[n - 1] = i;
            used[i] = true;
            transpose2(n + 1, array, m);
            used[i] = false;
        }
    }
}
