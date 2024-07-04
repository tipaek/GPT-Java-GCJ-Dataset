import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String[] precomputedData = {
            "-4,-4=IMPOSSIBLE", "-4,-3=SSW", "-4,-2=IMPOSSIBLE", "-4,-1=NSW", "-4,0=IMPOSSIBLE", "-4,1=SNW", "-4,2=IMPOSSIBLE", "-4,3=NNW", "-4,4=IMPOSSIBLE",
            "-3,-4=WWS", "-3,-3=IMPOSSIBLE", "-3,-2=ESW", "-3,-1=IMPOSSIBLE", "-3,0=WW", "-3,1=IMPOSSIBLE", "-3,2=ENW", "-3,3=IMPOSSIBLE", "-3,4=WWN",
            "-2,-4=IMPOSSIBLE", "-2,-3=NWS", "-2,-2=IMPOSSIBLE", "-2,-1=SW", "-2,0=IMPOSSIBLE", "-2,1=NW", "-2,2=IMPOSSIBLE", "-2,3=SWN", "-2,4=IMPOSSIBLE",
            "-1,-4=EWS", "-1,-3=IMPOSSIBLE", "-1,-2=WS", "-1,-1=IMPOSSIBLE", "-1,0=W", "-1,1=IMPOSSIBLE", "-1,2=WN", "-1,3=IMPOSSIBLE", "-1,4=EWN",
            "0,-4=IMPOSSIBLE", "0,-3=SS", "0,-2=IMPOSSIBLE", "0,-1=S", "0,1=N", "0,2=IMPOSSIBLE", "0,3=NN", "0,4=IMPOSSIBLE",
            "1,-4=WES", "1,-3=IMPOSSIBLE", "1,-2=ES", "1,-1=IMPOSSIBLE", "1,0=E", "1,1=IMPOSSIBLE", "1,2=EN", "1,3=IMPOSSIBLE", "1,4=WEN",
            "2,-4=IMPOSSIBLE", "2,-3=NES", "2,-2=IMPOSSIBLE", "2,-1=SE", "2,0=IMPOSSIBLE", "2,1=NE", "2,2=IMPOSSIBLE", "2,3=SEN", "2,4=IMPOSSIBLE",
            "3,-4=EES", "3,-3=IMPOSSIBLE", "3,-2=WSE", "3,-1=IMPOSSIBLE", "3,0=EE", "3,1=IMPOSSIBLE", "3,2=WNE", "3,3=IMPOSSIBLE", "3,4=EEN",
            "4,-4=IMPOSSIBLE", "4,-3=SSE", "4,-2=IMPOSSIBLE", "4,-1=NSE", "4,0=IMPOSSIBLE", "4,1=SNE", "4,2=IMPOSSIBLE", "4,3=NNE", "4,4=IMPOSSIBLE"
        };

        Map<String, String> answersMap = new HashMap<>();
        for (String entry : precomputedData) {
            String[] keyValue = entry.split("=");
            answersMap.put(keyValue[0], keyValue[1]);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String result = answersMap.getOrDefault(x + "," + y, "IMPOSSIBLE");
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }
}