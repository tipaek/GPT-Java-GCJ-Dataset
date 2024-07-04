
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int t = 0; t < testCount; t++) {
                int u = scanner.nextInt();
                List<String> dataPoints = new ArrayList<String>();
                for (int i = 0; i < 10000; i++) {
                    int q = scanner.nextInt();
                    String r = scanner.next();
                    dataPoints.add(r);
                }
                System.out.println("Case #" + (t+1) + ": " + solve(u, dataPoints));
            }
        }
    }

    private static String solve(int u, List<String> data) {
        String acc = "ABCDEFGHJI";
        return acc;
    }
}
