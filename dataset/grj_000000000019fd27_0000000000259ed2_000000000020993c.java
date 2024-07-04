
import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int a = 1; a <= t; ++a) {
            int size = in.nextInt();

            int[][] array = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    array[i][j] = in.nextInt();
                }
            }
            calculate(a, array);
        }
    }

    private static void calculate(int number, int[][] array) {
        System.out.println("Case #" + number + ": " + trace(array) + " " + rep(array) + " " + rep2(array));
    }

    private static int rep(int[][] array) {
        int result = 0;

        for (int i = 0; i < array.length ; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < array.length ; j++) {
                int element = array[i][j];
                if (hashSet.contains(element)) {
                    result++;
                    break;
                }
                hashSet.add(element);
            }
        }
        return result;
    }

    private static int rep2(int[][] array) {
        int result = 0;

        for (int i = 0; i < array.length ; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < array.length ; j++) {
                int element = array[j][i];
                if (hashSet.contains(element)) {
                    result++;
                    break;
                }
                hashSet.add(element);
            }
        }
        return result;
    }

    private static int trace(int[][] array) {
        int result = 0;
        for (int i = 0; i < array.length ; i++) {
            result+=array[i][i];
        }
        return result;
    }
}