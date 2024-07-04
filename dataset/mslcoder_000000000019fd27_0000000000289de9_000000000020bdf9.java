

import java.util.*;

class Time {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 1;
        while (n-- > 0) {
            int t = sc.nextInt();
            int a[][] = new int[t][3];

            //  Map<Time, Integer> map = new LinkedHashMap<Time, Integer>();
            for (int i = 0; i < t; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
                a[i][2] = i;
                // map.put(new Time(a[i][0], a[i][1]), 0);
            }

            boolean p1 = false, p2 = false;

            Arrays.sort(a, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] > o2[0])
                        return 1;
                    else
                        return -1;
                }
            });
            int p[] = new int[2];
            String s = "";
            p[0] = a[0][1];
            p[1] = 0;
            s = s + "C";
            for (int i = 1; i < t; i++) {

                if (a[i][0] - p[0] >= 0) {
                    p[0] = a[i][1];
                    s = s + "C";
                } else if (a[i][0] - p[1] >= 0) {
                    p[1] = a[i][1];
                    s = s + "J";
                } else {
                    s = "IMPOSSIBLE";
                    break;
                }
            }

            char c[] = new char[t];

            for (int i = 0; i < t; i++) {
                if (!s.equals("IMPOSSIBLE"))
                    c[a[i][2]] = s.charAt(i);
            }


            if (!s.equals("IMPOSSIBLE"))
                System.out.println("Case #" + m++ + ": " + String.valueOf(c));
            else
                System.out.println("Case #" + m++ + ": " + s);
        }
    }
}
