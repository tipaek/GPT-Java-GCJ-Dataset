//package codejam.Year2020.qualification;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static String str;

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            str = sc.next();
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        int[] digits = new int[str.length()];
        int lastNum = 0;
        int curr = 0;
        String result = "";
        for(int i = 0; i < str.length(); i++){
            int num = Integer.parseInt(str.substring(i, i + 1));
            if(curr > num){
                result = addParan(result, curr - num, ')');
            }else if(curr < num) {
                result = addParan(result, num - curr, '(');
            }
            result+= num;
            curr = num;
        }
        result = addParan(result, curr, ')');
        return result;
    }

    private static String addParan(String result, int count, char charToAdd){
        for(int i = 0; i < count; i++){
            result+= charToAdd;
        }
        return result;
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
