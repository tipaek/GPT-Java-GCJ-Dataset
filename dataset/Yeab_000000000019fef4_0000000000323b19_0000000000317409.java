
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static int[] farNearCount(String s) {
        int far = 0;
        int near = 0;

        for (char c: s.toCharArray()) {
            if (c == 'N' || c == 'E') far++;
            else near++;
        }

        return new int[] {far, near};
    }

    static String simulate(int X, int Y, String path) {
        int dist = Math.abs(X) + Math.abs(Y);
        String ans ="IMPOSSIBLE";
        if (dist == 0) return "0";
        for (int i = 0; i < path.length(); i++) {
            char c= path.charAt(i);
            if (c == 'N') Y++;
            if (c == 'E') X++;
            if (c == 'S') Y--;
            if (c == 'W') X--;
            dist = Math.abs(X) + Math.abs(Y);
            int time = i + 1;
            if (time >= dist) {
                ans = Integer.toString(time);
                break;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < cases; i++) {
            String[] line = scan.nextLine().split(" ");
            int X = Integer.parseInt(line[0]);
            int Y = Integer.parseInt(line[1]);

            System.out.printf("Case #%d: %s\n", (i + 1), simulate(X, Y, line[2]));
        }
    }
}
