import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int N;
    private static String[] A;

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = sc.nextInt();
            A = new String[N];
            for(int i = 0; i < N; i++) {
                A[i] = sc.next();
            }
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        StringBuilder builder = new StringBuilder();
        String[] reveresed = new String[N];
        for(int i = 0; i < A.length; i++){
            reveresed[i] = new StringBuilder(A[i]).reverse().toString();
        }
        for(int i = 0; i < 100; i++){
            char ch = 0;
            for(String str: reveresed){
                if(str.length() <= i){
                    continue;
                }
                char thisCh = str.charAt(i);
                if(thisCh== '*'){
                    continue;
                }
                if(ch == 0){
                    ch = thisCh;
                }else{
                    if(ch != thisCh){
                        return "*";
                    }
                }
            }
            if(ch == 0){
               break;
            }
            builder.append(ch);
        }
        return builder.reverse().toString();
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
