import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int MAX = 24 * 60;
        for (int q = 1; q <= t; q++) {
            int n = sc.nextInt();
            int[] arr = new int[MAX + 1];
            ArrayList<Time>[] times = new ArrayList[MAX + 1];
            for (int x = 0; x < times.length; x++)
                times[x] = new ArrayList<>();
            Time[] alltimes = new Time[n];
            for (int x = 0; x < n; x++) {
                int s=  sc.nextInt();
                int e = sc.nextInt();
                Time time = new Time(s, e);
                times[s].add(time);
                times[e].add(time);
                alltimes[x] = time;
                arr[s]++;
                arr[e]--;
            }
            boolean dup = false;
            for (int x = 1; x < arr.length; x++) {
                arr[x] += arr[x - 1];
                if (arr[x] > 2) {
                    dup = true;
                    break;
                }
            }
            if (dup) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", q);
                continue;
            }
            StringBuilder res = new StringBuilder();
            Queue<Character> que = new ArrayDeque<>();
            que.add('C');
            que.add('J');
            for (int x = 0; x < times.length; x++) {
                for (Time time : times[x]) {
                    if (time.s == x) {
                        char c = que.remove();
                        time.c = c;
                    } else {
                        que.add(time.c);
                    }
                }
            }
            for (Time time : alltimes)
                res.append(time.c);
            System.out.printf("Case #%d: %s\n", q, res);
        }
    }
    
    static class Time {
        int s, e;
        char c;
        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}