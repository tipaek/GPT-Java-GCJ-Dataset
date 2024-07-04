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
            int n = in.nextInt();
            int[][] points = new int[n][2];
            for (int j = 0; j < n; j++) {
                points[j][0] = in.nextInt();
                points[j][1] = in.nextInt();
            }


            String ans = solve(n, points);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(int n, int[][] points) {
        if (n <= 4) {
            return String.valueOf(n);
        }

        if (n == 5) {
            return solve5(n, points);
        }
        if (n == 6) {
            return solve6(n, points);
        }
        else {
            return solve7(n, points);
        }


    }

    private static String solve7(int n, int[][] points) {
        Map<Float, Integer> map = new HashMap<>();
        int zero = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (points[i][0] == points[j][0]) {
                    zero++;
                    max = Math.max(max, zero);
                } else {
                    float k = (points[i][1] - points[j][1]) / (float)(points[i][0] - points[j][0]);
                    map.put(k, map.getOrDefault(k, 0)+1);
                    max = Math.max(max, map.get(k));
                }
            }
        }

        if (max >= 3) {
            return String.valueOf(7);
        } else if (max == 2) {
            return String.valueOf(6);
        } else {
            return String.valueOf(4);
        }
    }

    private static String solve6(int n, int[][] points) {
        int ans = 0;
        for (int a1 = 0; a1 <= 2; a1++) {
            for (int a2 = a1+1; a2 < 6; a2++) {
                //now pick a1 and a2
                for (int a3=a1+1; a3 <= 5; a3++) {
                    if (a3 == a2) {
                        continue;
                    }

                    for (int a4 = a3+1; a4 < 6; a4++) {
                        if (a4 == a2) {
                            continue;
                        }
                        ans = Math.max(ans, solve61(a1, a2, a3, a4, points));
                    }

                }
            }
        }
        return String.valueOf(ans);
    }

    private static int solve61(int a1, int a2, int a3, int a4, int[][] points) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (i != a1 && i != a2 && i != a3 && i != a4) {
                list.add(i);
            }
        }

        int a5 = list.get(0);
        if (line(points, a5, a1, a3) || line(points, a5, a1, a4) || line(points, a5, a2, a3) || line(points, a5, a2, a4)) {
            return 6;
        }
        a5 = list.get(1);
        if (line(points, a5, a1, a3) || line(points, a5, a1, a4) || line(points, a5, a2, a3) || line(points, a5, a2, a4)) {
            return 6;
        }
        return 4;
    }

    private static String solve5(int n, int[][] points) {
        int ans = 0;
        for (int a1 = 0; a1 <= 1; a1++) {
            for (int a2 = a1+1; a2 < 5; a2++) {
                //now pick a1 and a2
                for (int a3=a1+1; a3 <= 4; a3++) {
                    if (a3 == a2) {
                        continue;
                    }

                    for (int a4 = a3+1; a4 < 5; a4++) {
                        if (a4 == a2) {
                            continue;
                        }
                        ans = Math.max(ans, solve51(a1, a2, a3, a4, points));
                    }

                }
            }
        }
        return String.valueOf(ans);
    }

    private static int solve51(int a1, int a2, int a3, int a4, int[][] points) {
        int a5 = -1;
        for (int i = 0; i < 5; i++) {
            if (i != a1 && i != a2 && i != a3 && i != a4) {
                a5 = i;
                break;
            }
        }

        if (line(points, a5, a1, a3) || line(points, a5, a1, a4) || line(points, a5, a2, a3) || line(points, a5, a2, a4)) {
            return 5;
        } else {
            return 4;
        }
    }

    //3 points on a line
    private static boolean line(int[][] points, int a1, int a2, int a3) {
        if (points[a1][0] == points[a2][0]) {
            return (points[a1][0] == points[a3][0]);
        }
        if (points[a1][0] == points[a3][0]) {
            return false;
        }

        float k1 = (points[a1][1] - points[a2][1]) / (float)(points[a1][0] - points[a2][0]);
        float k2 = (points[a1][1] - points[a3][1]) / (float)(points[a1][0] - points[a3][0]);
        return k1 == k2;

    }


}

/*
public class Solution2 {

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
