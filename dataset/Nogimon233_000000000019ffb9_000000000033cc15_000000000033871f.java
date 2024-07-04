import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String temp = in.nextLine();

        for (int i = 1; i <= t; ++i) {
//            String line = in.nextLine();
//            String[] ss = line.split(" ");
//            int c = Integer.parseInt(ss[0]);
//            int d = Integer.parseInt(ss[1]);
            int c = in.nextInt();
            int d = in.nextInt();
            int[] time = new int[c+1];
            for (int j = 2; j <= c; j++) {
                time[j] = in.nextInt() * (-1);
            }
            int[][] edges = new int[d][2];
            for (int j = 0; j < d; j++) {
                edges[j][0] = in.nextInt();
                edges[j][1] = in.nextInt();
            }


            String ans = solve(c, d, time, edges);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(int c, int d, int[] time, int[][] edges) {
        int[][] ans = new int[c+1][c+1];
        //build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //top will have less formers [node, prev node, prev time]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (time[a[0]] - time[b[0]]));
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        pq.add(new int[] {1, 0, 0});
        int t = 100;
        int prevx = 0;
        while(!pq.isEmpty()) {
            int[] curr1 = pq.remove();
            int curr = curr1[0];

            int x = time[curr];
            if (x != prevx) {
                t += 100;
                prevx = x;
            }
            int prev = curr1[1];
            int prevt = curr1[2];
            ans[prev][curr] = t - prevt;

            List<Integer> next = graph.get(curr);
            for (int temp : next) {
                if (visited.contains(temp)) {
                    continue;
                }
                pq.add(new int[] {temp, curr, t});
                visited.add(temp);
                //ans[temp][curr] = t-prevt;
                //ans[curr][temp] = t-prevt;
            }

        }

        int max = t + 10000;
        StringBuilder sb = new StringBuilder();
        for (int[] edge:edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            int now = Math.max(ans[e1][e2], ans[e2][e1]);
            sb.append( now == 0 ? max : now);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();


    }





}

/*
public class Solution1 {

    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String temp = in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            String[] ss = line.split(" ");
            long l = Long.parseLong(ss[0]);
            long r = Long.parseLong(ss[1]);

            String ans = solve(l, r);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(long l, long r) {
        boolean leftLarge = (l >= r);
        long large;
        long small;
        if (leftLarge) {
            large = l;
            small = r;
        } else {
            large = r;
            small = l;
        }

        long pan = 1;

        long lc = 0, sc = 0;
        //let large and small match
        long n1 = binary(large - small, pan, 1);
        long an = pan + (n1-1);
        long sum = (pan + an) * n1 / 2;

        pan = an+1;
        large = large - sum;
        lc += n1;

        if (large == small && !leftLarge) {
            leftLarge = true;
        }

        //deduct large and small
        long n2 = binary(large, pan, 2);
        an = pan + (n2-1)*2;
        sum = (pan + an) * n2 / 2;
        large = large - sum;
        lc += n2;

        long n3 = binary(small, pan+1, 2);
        an = pan+1 + (n3-1)*2;
        sum = (pan+1 + an) * n3 / 2;
        small = small - sum;
        sc += n3;

        if (leftLarge)
            return String.valueOf(lc+sc) + " " + String.valueOf(large) + " " + String.valueOf(small);
        else
            return String.valueOf(lc+sc) + " " + String.valueOf(small) + " " + String.valueOf(large);



    }

    //number deduct how many pan to be still positive
    private static long binary(long number, long pan, int d) {
        if (number == 0) {
            return 0;
        }
        long low = 1, high = number / pan+1;
        while(low < high) {
            long mid = low + (high-low)/2;

            long an = pan + (mid-1)*d;
            long sum = (pan + an) * mid / 2;

            if (sum > 0 && sum <= number) {
                low++;
            } else {
                high = mid;
            }
        }

        long n = low-1;
        return n;

    }





}
*/

class TrieNode{
    char c;
    int count;
    TrieNode[] next;
    public TrieNode(char _c){
        c = _c;
        next = new TrieNode[26];
        count = 0;
    }
}
