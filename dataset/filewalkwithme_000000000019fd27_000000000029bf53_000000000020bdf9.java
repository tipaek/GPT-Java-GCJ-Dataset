import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int k = 1; k <= t; k++) {
            int n = in.nextInt();

            Integer[][] tasks = new Integer[n][2];

            for (int i=0;i<n;i++){
                tasks[i][0] = in.nextInt();
                tasks[i][1] = in.nextInt();
            }

            String res = solve(tasks);

            // System.out.println(Arrays.deepToString(tasks));
            System.out.println("Case #" + k + ": " + res );
        }
    }

    public static String solve(Integer[][] tasks){
        return nextValid(tasks, "");
    }

    public static String nextValid(Integer[][] tasks, String str) {
        // System.out.println("str: "+str);
        BitSet bj = new BitSet((24*60)+1);
        BitSet bc = new BitSet((24*60)+1);

        char[] arr = str.toCharArray();

        for (int i=0; i<arr.length; i++){
            int ini = tasks[i][0];
            int end = tasks[i][1];

            if (arr[i]=='J') {
                bj.set(ini, end);
                continue;
            }

            if (arr[i]=='C') {
                bc.set(ini, end);
                continue;
            }
        }

        // System.out.println(Arrays.deepToString(tasks));
        // System.out.println(str);
        int ini = tasks[arr.length][0];
        int end = tasks[arr.length][1];

        int nextJ = bj.nextSetBit(ini);
        boolean intersectJ = nextJ >= ini && nextJ < end;
        if (!intersectJ) {
            // System.out.println("dont intersectJ");
            if (arr.length==tasks.length-1){
                return str+"J";
            }
            String res = nextValid(tasks, str+"J");
            if (!res.equals("IMPOSSIBLE")) {
                return res;
            }
        }

        int nextC = bc.nextSetBit(ini);
        boolean intersectC = nextC >= ini && nextC < end;
        if (!intersectC) {
            // System.out.println("dont intersectC");
            if (arr.length==tasks.length-1){
                return str+"C";
            }
            String res = nextValid(tasks, str+"C");
            if (!res.equals("IMPOSSIBLE")) {
                return res;
            }
        }

        return "IMPOSSIBLE";
    }

    public static boolean valid(Integer[][] tasks, String str, Character c) {
        BitSet bj = new BitSet((24*60)+1);
        BitSet bc = new BitSet((24*60)+1);

        char[] arr = str.toCharArray();

        for (int i=0; i<arr.length; i++){
            int ini = tasks[i][0];
            int end = tasks[i][1];

            if (arr[i]=='J') {
                bj.set(ini, end);
                continue;
            }

            if (arr[i]=='C') {
                bc.set(ini, end);
                continue;
            }
        }

        int ini = tasks[arr.length][0];
        int end = tasks[arr.length][1];

        if (c=='J') {
            int nextJ = bj.nextSetBit(ini);
            boolean intersectJ = nextJ >= ini && nextJ < end;
            return intersectJ;
        }

        int nextC = bc.nextSetBit(ini);
        boolean intersectC = nextC >= ini && nextC < end;
        return intersectC;
    }
}