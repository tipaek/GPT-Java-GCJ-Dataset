import java.util.*;
import java.io.*;

public class Solution {
    private static final int MAX_NUM = 101;

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testTotalCount = in.nextInt(); //first input
        for (int testCase = 1; testCase <= testTotalCount; testCase++) {
            int arrSize = in.nextInt(); //second input
            int[][] arr = new int[arrSize][arrSize];
            for (int i = 0; i < arrSize; i++) {
                for (int j = 0; j < arrSize; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            System.out.println(new String().format("Case #%s: %s %s %s",
                    testCase, findTraceSum(arr), findRowRepeatCount(arr), findColumnRepeatCount(arr)));
        }

    }

    public static int findTraceSum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }

        return sum;
    }

    public static int findRowRepeatCount(int[][] arr) {
        int repeatCount = 0;
        for (int i = 0; i < arr.length; i++) {

            boolean check[] = new boolean[MAX_NUM];
            for (int j = 0; j < arr.length; j++) {
                if (check[arr[i][j]]) {
                    repeatCount++;
                    break;
                } else {
                    check[arr[i][j]] = true;
                }
            }
        }

        return repeatCount;
    }

    public static int findColumnRepeatCount(int[][] arr) {
        int repeatCount = 0;
        for (int i = 0; i < arr.length; i++) {

            boolean check[] = new boolean[MAX_NUM];
            for (int j = 0; j < arr.length; j++) {
                if (check[arr[j][i]]) {
                    repeatCount++;
                    break;
                } else {
                    check[arr[j][i]] = true;
                }
            }
        }

        return repeatCount;
    }
}