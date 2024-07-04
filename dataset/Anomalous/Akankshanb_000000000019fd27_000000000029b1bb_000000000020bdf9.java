import java.util.*;
import java.io.*;

class Solution {
    private static int len = 0;

    public static String schedule(List<int[]> times) {
        len = times.size();
        String[] res = new String[len];
        List<int[]> temp = new ArrayList<>(times);
        
        times.sort(Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean JFull = false, CFull = false;

        for (int[] time : times) {
            if (pq.isEmpty()) {
                pq.add(new int[]{time[0], time[1], 0});
                JFull = true;
                res[temp.indexOf(time)] = "J";
                continue;
            }
            int[] top = pq.peek();
            if (top[1] <= time[0]) {
                int[] item = pq.poll();
                if (item[2] == 0) {
                    JFull = false;
                } else if (item[2] == 1) {
                    CFull = false;
                }
            }
            int whichItem = 0;
            if (!JFull) {
                whichItem = 0;
                JFull = true;
                res[temp.indexOf(time)] = "J";
            } else if (!CFull) {
                whichItem = 1;
                CFull = true;
                res[temp.indexOf(time)] = "C";
            }
            pq.add(new int[]{time[0], time[1], whichItem});
        }
        return parseList(res);
    }

    private static String parseList(String[] res) {
        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            if (s == null) return "IMPOSSIBLE";
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                list.add(new int[]{start, end});
            }
            System.out.println("Case #" + i + ": " + schedule(list));
        }
    }
}