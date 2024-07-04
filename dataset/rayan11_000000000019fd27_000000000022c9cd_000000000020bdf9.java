import java.util.*;
import java.io.*;

public class Solution {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int T = Integer.parseInt (br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase ++) {
            int n = Integer.parseInt (br.readLine().trim());
            int [][] intervals = new int [n][2];
            Character [] result = new Character [n];
            for (int i = 0; i < n; i ++) {
                intervals[i] = Arrays.stream (br.readLine().trim().split (" ")).mapToInt (Integer::parseInt).toArray();
            }
            boolean isOver = false;
            for (int i = 0; i < n; i ++) {
                if (isOver) break;
                int [] curr = intervals[i];
                char value = result[i] == null ? 'C' : result[i] =='C'? 'J' : 'C';
                if (result[i] == null) result[i] = 'J';
                for (int j = i + 1; j < n; j ++) {
                    if (overlaps (curr, intervals[j])) {
                        if (result[j] != null && result[j] != value) {
                            /* System.out.println (value + " " + result[j] + " " + Arrays.toString (curr) + " " + Arrays.toString (intervals[j])); */
                            System.out.printf ("Case #%d: IMPOSSIBLE\n", testCase);
                            isOver = true;
                        } else result[j] = value;
                    }
                }
            }
            if (! isOver)
                System.out.printf ("Case #%d: %s\n", testCase, getAns (result));
        }
    }

    public static String getAns (Character [] result) {
        StringBuilder ans = new StringBuilder ();
        for (Character c : result ) ans.append (c);
        return ans.toString();
    }

    public static boolean overlaps (int [] ar, int [] br) {
        List<int []> list = new ArrayList<>();
        list.add (ar);
        list.add (br);
        Collections.sort (list, (a,b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);

        if (list.get (0)[1] > list.get (1)[0]) return true;

        return false;
    }
}

/* 4
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
720 1440 */