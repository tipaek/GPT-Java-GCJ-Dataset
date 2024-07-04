import java.util.*;
import java.io.*;
class Solution {
public static void main(String[] args) {
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int T = in.nextInt();

    int N;

    for (int Tcase = 1; Tcase <= T; Tcase++) {
    	N = in.nextInt();

        PriorityQueue<int[]> q = new PriorityQueue<>((i1, i2) -> {
            return Integer.compare(i1[0], i2[0]);
        });

        int jEnd = -1;
        int cEnd = -1;


        for (int i = 0; i < N; i++) {
            int[] val = new int[]{in.nextInt(), in.nextInt()};
            q.offer(val);
        }

        StringBuilder sb = new StringBuilder();

        boolean possible = true;

        while (!q.isEmpty()) {
            int[] val = q.poll();

            if (jEnd < cEnd && jEnd <= val[0]) {
                sb.append('J');
                jEnd = val[1];
            } else if (cEnd <= val[0]) {
                sb.append('C');
                cEnd = val[1];
            } else {
                possible = false;
                break;
            }
        }

        if (sb.length() == 0 || !possible) {
            sb = new StringBuilder("IMPOSSIBLE");
        }


    	System.out.println("Case #" + Tcase + ": " + sb.toString());
    }
}
}