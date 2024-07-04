import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        String[][] moves = {
            {"IMPOSSIBLE", "WWN", "IMPOSSIBLE", "EWN", "IMPOSSIBLE", "WEN", "IMPOSSIBLE", "EEN", "IMPOSSIBLE"},
            {"NNW", "IMPOSSIBLE", "SWN", "IMPOSSIBLE", "NN", "IMPOSSIBLE", "SEN", "IMPOSSIBLE", "NNE"},
            {"IMPOSSIBLE", "ENW", "IMPOSSIBLE", "WN", "IMPOSSIBLE", "EN", "IMPOSSIBLE", "WNE", "IMPOSSIBLE"},
            {"SNW", "IMPOSSIBLE", "NW", "IMPOSSIBLE", "N", "IMPOSSIBLE", "NE", "IMPOSSIBLE", "SNE"},
            {"IMPOSSIBLE", "WW", "IMPOSSIBLE", "W", "IMPOSSIBLE", "E", "IMPOSSIBLE", "EE", "IMPOSSIBLE"},
            {"NSW", "IMPOSSIBLE", "SW", "IMPOSSIBLE", "S", "IMPOSSIBLE", "SE", "IMPOSSIBLE", "NSE"},
            {"IMPOSSIBLE", "ESW", "IMPOSSIBLE", "WS", "IMPOSSIBLE", "ES", "IMPOSSIBLE", "WSE", "IMPOSSIBLE"},
            {"SSW", "IMPOSSIBLE", "NWS", "IMPOSSIBLE", "SS", "IMPOSSIBLE", "NES", "IMPOSSIBLE", "SSE"},
            {"IMPOSSIBLE", "WWS", "IMPOSSIBLE", "EWS", "IMPOSSIBLE", "WES", "IMPOSSIBLE", "EES", "IMPOSSIBLE"}
        };

        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int xNew = x + 4;
            int yNew = Math.abs(y - 4);

            if (xNew >= 0 && xNew <= 8 && yNew >= 0 && yNew <= 8) {
                System.out.println("Case #" + (i + 1) + ": " + moves[yNew][xNew]);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}