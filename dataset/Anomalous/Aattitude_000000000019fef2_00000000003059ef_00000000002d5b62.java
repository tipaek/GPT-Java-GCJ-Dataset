import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(br.readLine());
        HashMap<String, String> directionMap = new HashMap<>();

        directionMap.put("1 0", "E");
        directionMap.put("3 0", "EE");
        directionMap.put("-1 0", "W");
        directionMap.put("-3 0", "WW");

        directionMap.put("0 1", "N");
        directionMap.put("0 -1", "S");
        directionMap.put("2 1", "NE");
        directionMap.put("4 1", "SNE");

        directionMap.put("2 -1", "SE");
        directionMap.put("4 -1", "NSE");

        directionMap.put("-2 -1", "SW");
        directionMap.put("-4 -1", "NSW");

        directionMap.put("-2 1", "NW");
        directionMap.put("-4 1", "SNW");

        directionMap.put("1 2", "EN");
        directionMap.put("3 2", "WNE");

        directionMap.put("1 -2", "ES");
        directionMap.put("3 -2", "WSE");

        directionMap.put("-1 -2", "WS");
        directionMap.put("-3 -2", "ESW");

        directionMap.put("-1 2", "WN");
        directionMap.put("-3 2", "ENW");

        directionMap.put("0 3", "NN");
        directionMap.put("0 -3", "SS");
        directionMap.put("2 3", "SEN");
        directionMap.put("4 3", "NNE");

        directionMap.put("2 -3", "NES");
        directionMap.put("4 -3", "SSE");

        directionMap.put("-2 -3", "NWS");
        directionMap.put("-4 -3", "SSW");

        directionMap.put("-2 3", "SWN");
        directionMap.put("-4 3", "NNW");

        directionMap.put("1 4", "WEN");
        directionMap.put("3 4", "EEN");

        directionMap.put("1 -4", "WES");
        directionMap.put("3 -4", "EES");

        directionMap.put("-1 -4", "EWS");
        directionMap.put("-3 -4", "WWS");

        directionMap.put("-1 4", "EWN");
        directionMap.put("-3 4", "WWN");

        for (int i = 0; i < testCaseCount; i++) {
            String input = br.readLine();
            String result = directionMap.getOrDefault(input, "IMPOSSIBLE");
            bw.write("Case #" + (i + 1) + ": " + result + "\n");
        }

        bw.flush();
    }
}