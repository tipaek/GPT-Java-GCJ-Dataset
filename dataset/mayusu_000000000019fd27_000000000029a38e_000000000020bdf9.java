import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            List<Map.Entry<Integer, Integer>> jamieList = new ArrayList<>();
            List<Map.Entry<Integer, Integer>> cameronList = new ArrayList<>();
            StringBuilder solutionBuilder = new StringBuilder();
            int startTime = in.nextInt();
            int endTime = in.nextInt();
            jamieList.add(new AbstractMap.SimpleEntry<>(startTime, endTime));
            solutionBuilder.append("J");
            for (int j = 2; j <= n; j++) {
                startTime = in.nextInt();
                endTime = in.nextInt();
                boolean taskAssigned = false;
                for (Map.Entry<Integer, Integer> jamie : jamieList) {
                    if (startTime >= jamie.getValue() || endTime <= jamie.getKey()) {
                        jamieList.add(new AbstractMap.SimpleEntry<>(startTime, endTime));
                        solutionBuilder.append("J");
                        taskAssigned = true;
                        break;
                    }
                }
                if (!taskAssigned) {
                    if (cameronList.isEmpty()) {
                        cameronList.add(new AbstractMap.SimpleEntry<>(startTime, endTime));
                        solutionBuilder.append("C");
                        taskAssigned = true;
                    } else {
                        for (Map.Entry<Integer, Integer> cameron : cameronList) {
                            if (startTime >= cameron.getValue() || endTime <= cameron.getKey()) {
                                cameronList.add(new AbstractMap.SimpleEntry<>(startTime, endTime));
                                solutionBuilder.append("C");
                                taskAssigned = true;
                                break;
                            }
                        }
                    }
                }
                if (!taskAssigned) {
                    solutionBuilder = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + solutionBuilder.toString());
        }
    }
}