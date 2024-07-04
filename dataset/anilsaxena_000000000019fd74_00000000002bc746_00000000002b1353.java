import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int N;


    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = sc.nextInt();
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        List<String> steps = new ArrayList<>();
        if(N <= 500){
            for(int i = 1; i <= N; i++){
                steps.add(i + " " + 1);
            }
        }else if(N <= 997){
            int diff = N - 500;
            int sum = 0;
            for(int i = 1; i <= diff + 1; i++){
                steps.add(i + " " + 1);
                sum++;
            }
            steps.add(diff + 2 + " " + 2);
            sum+= (diff + 1);
            steps.add(diff + 2 + " " + 1);
            sum++;
            int row = diff + 3;
            while(steps.size() < 500) {
                steps.add(row + " " + 1);
                sum++;
                row++;
            }
            printDebug("Sum"+ sum + " - "+ steps.size());
        }else if(N <= 1000){
            int diff = N - 500;
            int sum = 0;
            steps.add("1 1");
            steps.add("2 1");
            int nextRow = 0;
            if(N == 998){
                steps.add("3 1");
                steps.add("4 2");
                steps.add("4 1");
                nextRow = 5;
                sum = 7;
                diff -= 2;
            }else if(N == 999){
                steps.add("3 1");
                steps.add("4 1");
                steps.add("5 2");
                steps.add("5 1");
                nextRow = 6;
                sum = 9;
                diff -= 3;
            }else if(N == 1000){
                steps.add("3 1");
                steps.add("4 1");
                steps.add("5 1");
                steps.add("6 2");
                steps.add("6 1");
                nextRow = 7;
                sum = 11;
                diff -= 4;
            }

            for(int i = nextRow; i <= diff + 1; i++){
                steps.add(i + " " + 1);
                sum++;
            }
            steps.add(diff + 2 + " " + 2);
            sum+= (diff + 1);
            steps.add(diff + 2 + " " + 1);
            sum++;
            int row = diff + 3;
            while(steps.size() < 500) {
                steps.add(row + " " + 1);
                sum++;
                row++;
            }
            printDebug("Sum"+ sum + " - "+ steps.size());
        }
        return joinValues(steps, "\n");
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
