
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
 static boolean overlap(int a, int b, List<Integer[]> xa) {
        for (Integer[] interval : xa) {
            int from = interval[0];
            int to = interval[1];
            if (a < to && b > from) {
                // overlap
                return true;
            }
        }
        return false;
    }

    static String solve(int[][] arr) {
        StringBuilder ans = new StringBuilder();


        List<Integer[]> ca = new ArrayList<>();
        List<Integer[]> ja = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int from = arr[i][0];
            int to = arr[i][1];


                if (!overlap(from, to, ca)) {
                    ans.append("C");
                    ca.add(new Integer[]{from,to});
                    continue;
                }

                if (!overlap(from, to, ja)) {
                    ans.append("J");
                    ja.add(new Integer[]{from,to});
                    continue;
                }

            return "IMPOSSIBLE";
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
            // Arrays.sort(arr,(o1, o2) -> o1[0]-o2[0]);
            System.out.println("Case #" + cs + ": " + solve(arr));
        }
    }
}
