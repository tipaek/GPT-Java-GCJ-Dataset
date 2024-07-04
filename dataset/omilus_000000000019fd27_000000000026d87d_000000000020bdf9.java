import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Solution {
    static int overlap(int x1, int x2, List<Integer[]> xa) {
        int mingap = Integer.MAX_VALUE;

        for (Integer[] interval : xa) {
            int y1 = interval[0];
            int y2 = interval[1];

            if (Math.max(x1, y1) < Math.min(x2, y2))
//            if (x1 < y2 && y1 < x2)
            {
                // overlap
                return -1;
            } else {
                mingap = Math.min(mingap, Math.min(Math.abs(x1 - y1), Math.abs(x2 - y2)));
            }
        }
        return mingap;
    }

    static String solve(int[][] arr, int[][] origArr) {


        List<Integer[]> ca = new LinkedList<>();
        List<Integer[]> ja = new LinkedList<>();

        Set<String> cset = new HashSet<>();
        Set<String> jset = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int from = arr[i][0];
            int to = arr[i][1];


            int cgap = overlap(from, to, ca);
            if (cgap >= 0) {
//                    ans.append("C");
                int jgap = overlap(from, to, ja);
                if (jgap == -1 || cgap <= jgap) {
                    ca.add(new Integer[]{from, to});
                    cset.add(from + ":" + to);
                    continue;
                }
            }
            int jgap = overlap(from, to, ja);
            if (jgap >= 0) {
                ja.add(new Integer[]{from, to});
                jset.add(from + ":" + to);
                continue;
            }

            return "IMPOSSIBLE";
        }
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < origArr.length; i++) {
            int from = origArr[i][0];
            int to = origArr[i][1];
            String str = from + ":" + to;
            if (cset.contains(str)) {
                ans.append("C");
                cset.remove(str);
            } else if (jset.contains(str)) {
                ans.append("J");
                jset.remove(str);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int cs = 1; cs <= cases; cs++) {
            int n = in.nextInt();
            in.nextLine();

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] line = in.nextLine().split(" ");
                int from = Integer.parseInt(line[0]);
                int to = Integer.parseInt(line[1]);
                arr[i] = new int[]{from, to};
            }
            int[][] arr2 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2, (o1, o2) -> o1[0] - o2[0]);
            System.out.println("Case #" + cs + ": " + solve(arr2, arr));
        }
    }
}
