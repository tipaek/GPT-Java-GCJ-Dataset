
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = sc.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            int activityCount = sc.nextInt();
            int[][] arr = new int[activityCount][2];
            for (int i = 0; i < activityCount; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            String result = solve(arr);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String solve(int[][] arr) {
        char[] result = new char[arr.length];
        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>();

        for (int i = 0; i < arr.length; i++) {
            q.add(new Tuple(i, false, arr[i][0]));
            q.add(new Tuple(i, true, arr[i][1]));
        }

        boolean cBusy = false;
        boolean jBusy = false;

        while (!q.isEmpty()) {

            Tuple t = q.poll();
//            System.out.println(t);
            if (!t.isEnd && cBusy && jBusy) {
                return "IMPOSSIBLE";
            }

            if (t.isEnd) {
                final char c = result[t.index];
                if (c == 'C') {
                    cBusy = false;
                } else {
                    jBusy = false;
                }
            } else {
                if (cBusy) {
                    result[t.index] = 'J';
                    jBusy = true;
                } else {
                    result[t.index] = 'C';
                    cBusy = true;
                }
            }
        }
        return new String(result);
    }

    private static class Tuple implements Comparable<Tuple> {
        int index;
        boolean isEnd;
        int time;

        public Tuple(int index, boolean isEnd, int time) {
            this.index = index;
            this.isEnd = isEnd;
            this.time = time;
        }

        @Override
        public int compareTo(Tuple o) {
            int compare =  Integer.compare(time, o.time);
            if(compare == 0)
            {
                return Boolean.compare(!isEnd, !o.isEnd);
            }
            return compare;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "index=" + index +
                    ", isEnd=" + isEnd +
                    ", time=" + time +
                    '}';
        }
    }


// wrong unsorted greedy try
//    public static String solve(int[][] arr) {
//        boolean[] cameron = new boolean[1441];
//        boolean[] james = new boolean[1441];
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < arr.length; i++) {
//            if (Solution.tryAssign(cameron, arr[i][0], arr[i][1])) {
//                sb.append("C");
//            } else if (Solution.tryAssign(james, arr[i][0], arr[i][1])) {
//                sb.append("J");
//            } else {
//                return "IMPOSSIBLE";
//            }
//        }
//        return sb.toString();
//    }
//
//    public static boolean tryAssign(boolean[] arr, int from, int to) {
//        for (int i = from; i < to; i++) {
//            if (arr[i]) {
//                return false;
//            }
//        }
//
//        for (int i = from; i < to; i++) {
//            arr[i] = true;
//        }
//        return true;
//    }
}