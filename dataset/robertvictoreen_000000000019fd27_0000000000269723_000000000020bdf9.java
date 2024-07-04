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
            int[] val = new int[]{in.nextInt(), in.nextInt(), i};
            q.offer(val);
        }

        StringBuilder sb = new StringBuilder();

        boolean[] isJ = new boolean[N];

        boolean possible = true;

        while (!q.isEmpty()) {
            int[] val = q.poll();

            if (jEnd <= val[0] && cEnd <= val[0]) {
                //keep them busy

                if (jEnd > cEnd) {
                    isJ[val[2]] = true;
                    jEnd = val[1];
                } else {
                    cEnd = val[1];
                }

            } else if (jEnd <= val[0]) {
                isJ[val[2]] = true;
                jEnd = val[1];
            } else if (cEnd <= val[0]) {
                cEnd = val[1];
            } else {
                possible = false;
                break;
            }
        }

        if (!possible) {
            sb.append("IMPOSSIBLE");
        } else for (int i = 0; i < N; i++) {
            if (isJ[i] == true) {
                sb.append('J');
            } else {
                sb.append('C');
            }
        }


    	System.out.println("Case #" + Tcase + ": " + sb.toString());
    }
}
}