import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int X, Y;
    private static char[] A;

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            X = sc.nextInt();
            Y = sc.nextInt();
            A = sc.next().toCharArray();
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        int minute = 0;
        int distance = Math.abs(X) + Math.abs(Y);
        boolean done = false;
        if(X == 0 && Y == 0){
            done = true;
        }else {
            for (int i = 0; i < A.length; i++) {
                char move = A[i];
                if (move == 'E') {
                    X++;
                } else if (move == 'W') {
                    X--;
                } else if (move == 'N') {
                    Y++;
                } else {
                    Y--;
                }
                minute++;
                distance = Math.abs(X) + Math.abs(Y);
                if (minute >= distance) {
                    done = true;
                    break;
                }
            }
        }

        return done ? minute : "IMPOSSIBLE";
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
