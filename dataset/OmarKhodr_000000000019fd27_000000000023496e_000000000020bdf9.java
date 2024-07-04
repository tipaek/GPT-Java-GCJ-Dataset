import java.util.Scanner;
import java.util.*;

public class Solution {

    public static boolean overlap(int[] o1, int[] o2) {
        return (o1[0]<o2[0] && o1[1]>o2[0]) || (o2[0]<o1[0] && o2[1]>o1[0]);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int x=0;x<t;x++) {
            int n = in.nextInt();
            int[][] intervals = new int[n][3];
            for (int i=0; i<n; i++) {
                int st = in.nextInt();
                int en = in.nextInt();
                intervals[i][0] = st; intervals[i][1] = en; intervals[i][2] = i;
            }
//            Set<int[]> lapped = new HashSet<>();
//            for (int i=0; i<n; i++) {
//                for (int j=0; j<n; j++) {
//
//                }
//            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });
            char[] assign = new char[n];
            boolean khalas = false;
            for (int i=0; i<n; i++) {
                if (assign[intervals[i][2]] == 'C') continue;
                if (assign[intervals[i][2]] == 0) assign[intervals[i][2]] = 'C';
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (overlap(intervals[i], intervals[j])) {
                        if (assign[intervals[i][2]] == 'J' && assign[intervals[j][2]] == 'J') {
                            khalas = true;
                            break;
                        } else if (assign[intervals[i][2]] == 'C' && assign[intervals[j][2]] == 0) {
                            assign[intervals[j][2]] = 'J';
                        }
                    }
                }
                if (khalas) {
                    break;
                }
            }
            System.out.print("Case #" + (x+1)+ ": ");
            if (khalas) {
                System.out.println("IMPOSSIBLE");
            }
            else {
                for (char c: assign) {
                    System.out.printf("%c", c);
                }
                System.out.printf("\n");
            }

        }
    }
}

/*
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440

 */
