//package codejam.Year2020.qualification;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int N;
    private static int[][] A;

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = sc.nextInt();
            A = new int[N][N];
            for(int i = 0; i < N; i++) {
                A[i] = readInts(sc, N);
            }
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        int k = 0, r = 0, c = 0;
        for(int i = 0; i < N; i++){
            k += A[i][i];
            boolean[] rows = new boolean[N + 1];
            for(int j = 0; j < N; j++){
                if(rows[A[i][j]]){
                    r++;
                    break;
                }
                rows[A[i][j]] = true;
            }

            boolean[] columns = new boolean[N + 1];
            for(int j = 0; j < N; j++){
                if(columns[A[j][i]]){
                    c++;
                    break;
                }
                columns[A[j][i]] = true;
            }
        }
        return k + " " + r + " " + c;
    }

    private static String joinValues(List<? extends Object> list, String delim) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static String joinValues(int[] arr, String delim) {
        List<Object> list = new ArrayList<>();
        for (Object value : arr) {
            list.add(value);
        }
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static int[] readInts(Scanner sc, int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printDebug(Object str) {
        if (debug) {
            System.out.println("DEBUG: " + str);
        }
    }

    public static void main(String[] args) throws Exception {
        long currTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - currTime));
        } else {
            solveProblem(System.in);
        }
    }

}
