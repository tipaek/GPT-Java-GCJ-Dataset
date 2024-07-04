import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        int min = 24*60;
        int[] cameron = new int [min+1];
        int[] jamei = new int [min+1];

        for (int t=1; t<=T; t++) {
            int tasks = in.nextInt();
            Arrays.fill(cameron, 0);
            Arrays.fill(jamei, 0);
            StringBuilder result = new StringBuilder();
            for (int i=1; i <= tasks; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                if (isAvailable(cameron, start, end)) {
                    Arrays.fill(cameron, start, end, 1);
                    result.append("C");
                } else if (isAvailable(jamei, start, end)) {
                    Arrays.fill(jamei, start, end, 1);

                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }


            System.out.println("Case #" + t +": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] person, int start, int end) {
        for (int i = start; i < end; i++) {
            if (person[i] == 1) {
                return false;
            }
        }
        return true;
    }

}