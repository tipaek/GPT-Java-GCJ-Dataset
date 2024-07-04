
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= T; i++) {
            int timeRange = sc.nextInt();
            String re = helper(timeRange, sc);
            System.out.println(String.format("Case #%s: %s", i, re));
        }
    }

    private static String helper(int timeRange, Scanner sc) {
        int[][] t = new int[timeRange][2];
        for(int i = 0; i < timeRange; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            t[i][0] = start;
            t[i][1] = end;
        }
        Arrays.sort(t, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //1: C, 2: J
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        boolean isPossible = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t.length; i++) {
            int[] e = t[i];
            int start = e[0], end = e[1];
            if (queue.isEmpty()) {
                queue.add(new int[]{1, start, end});
                sb.append('C');
            } else {
                while(!queue.isEmpty() && queue.peek()[2] <= start) {
                    queue.remove();
                }
                if (queue.size() == 2) {
                    isPossible = false;
                    break;
                }
                if (queue.isEmpty()) {
                    queue.add(new int[]{1, start, end});
                    sb.append('C');
                } else {
                    int[] top = queue.peek();
                    if (top[0] == 1) {
                        queue.add(new int[]{2, start, end});
                        sb.append('J');
                    } else {
                        queue.add(new int[]{1, start, end});
                        sb.append('C');
                    }
                }
            }
        }

        if (!isPossible) return "IMPOSSIBLE";
        return sb.toString();
    }

//    overlap of 3
//
//    overlap of 2 is ok


//           4
//           3
//           360 480
//           420 540
//           600 660
//           3
//           0 1440
//           1 3
//           2 4
//           5
//           99 150
//           1 100
//           100 301
//           2 5
//           150 250
//           2
//           0 720
//           720 1440



}
