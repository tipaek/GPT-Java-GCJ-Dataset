import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();
            String output = "";
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                try {
                    String[] intervalStr = sc.nextLine().split(" ");
                    int[] interval = new int[2];
                    interval[0] = Integer.parseInt(intervalStr[0]);
                    interval[1] = Integer.parseInt(intervalStr[1]);
                    if (listContains(interval, cameron)) {
                        if (listContains(interval, jamie)) {
                            output = "IMPOSSIBLE";
                        } else {
                            jamie.add(interval);
                            if (!"IMPOSSIBLE".equals(output)) {
                                output += "J";
                            }
                        }
                    } else {
                        cameron.add(interval);
                        if (!"IMPOSSIBLE".equals(output)) {
                            output += "C";
                        }
                    }
                } catch (Throwable e) {

                }
            }

            System.out.println("Case #" + k + ": " + output);
        }
    }

    public static boolean overlaps(int s1, int e1, int s2, int e2) {
        return (e1 > s2) && (s1 < e2);
    }

    public static boolean listContains(int[] interval, List<int[]> list) {
        for (int[] ints : list) {
            if (ints != null && ints.length == 2) {
                if (overlaps(interval[0], interval[1], ints[0], ints[1])) {
                    return true;
                }
            }
        }

        return false;
    }
}
