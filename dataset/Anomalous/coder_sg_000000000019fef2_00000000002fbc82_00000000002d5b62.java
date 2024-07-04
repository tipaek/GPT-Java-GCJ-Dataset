import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            String[] coordinates = reader.readLine().split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            StringBuilder answer = new StringBuilder();

            if ((Math.abs(x) % 2 == Math.abs(y) % 2)) {
                answer.append("IMPOSSIBLE");
            } else {
                switch (x) {
                    case -4:
                        if (y == -3) answer.append("SSW");
                        else if (y == 3) answer.append("NNW");
                        else answer.append("IMPOSSIBLE");
                        break;
                    case -3:
                        if (y == -4) answer.append("WWS");
                        else if (y == 0) answer.append("WW");
                        else if (y == 4) answer.append("WWN");
                        else answer.append("IMPOSSIBLE");
                        break;
                    case -2:
                        if (y == -3) answer.append("NWS");
                        else if (y == -1) answer.append("SW");
                        else if (y == 1) answer.append("NW");
                        else if (y == 3) answer.append("SWN");
                        break;
                    case -1:
                        if (y == -2) answer.append("WS");
                        else if (y == 0) answer.append("W");
                        else if (y == 2) answer.append("WN");
                        else answer.append("IMPOSSIBLE");
                        break;
                    case 0:
                        if (y == -3) answer.append("SS");
                        else if (y == -1) answer.append("S");
                        else if (y == 1) answer.append("N");
                        else if (y == 3) answer.append("NN");
                        break;
                    case 1:
                        if (y == -2) answer.append("ES");
                        else if (y == 0) answer.append("E");
                        else if (y == 2) answer.append("EN");
                        else answer.append("IMPOSSIBLE");
                        break;
                    case 2:
                        if (y == -3) answer.append("NES");
                        else if (y == -1) answer.append("SE");
                        else if (y == 1) answer.append("NE");
                        else if (y == 3) answer.append("SEN");
                        break;
                    case 3:
                        if (y == -4) answer.append("EES");
                        else if (y == 0) answer.append("EE");
                        else if (y == 4) answer.append("EEN");
                        else answer.append("IMPOSSIBLE");
                        break;
                    case 4:
                        if (y == -3) answer.append("SSE");
                        else if (y == 3) answer.append("NNE");
                        else answer.append("IMPOSSIBLE");
                        break;
                    default:
                        answer.append("IMPOSSIBLE");
                        break;
                }
            }
            result.append(String.format("Case #%d: %s\n", i + 1, answer));
        }
        System.out.print(result);
    }
}