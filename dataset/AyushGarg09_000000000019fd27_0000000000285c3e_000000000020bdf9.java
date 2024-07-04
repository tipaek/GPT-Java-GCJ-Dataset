import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Solution {

    private static String schedule(int[][] x) {
        StringBuilder result = new StringBuilder();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        HashMap<int[], Character> map = new HashMap();

        int nextJamesFree = -1;
        int nextCameronFree = -1;

        for (int[] curr : x) {
            pq.offer(curr);
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (curr[0] < nextCameronFree) {
                if (curr[0] < nextJamesFree)
                    return "IMPOSSIBLE";
                else {
                    map.put(curr, 'J');
                    nextJamesFree = curr[1];
                }
            } else {
                map.put(curr, 'C');
                nextCameronFree = curr[1];
            }

        }

        for (int[] curr : x) {
            result.append(map.get(curr));
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int all = in.nextInt();

            int[][] inputList = new int[all][2];
            for (int j = 0; j < all; j++) {
                int[] curr = { in.nextInt(), in.nextInt() };
                inputList[j] = curr;
            }
            String result = Solution.schedule(inputList);
            System.out.println("Case #" + i + ": " + result);
        }
        in.close();
    }
}