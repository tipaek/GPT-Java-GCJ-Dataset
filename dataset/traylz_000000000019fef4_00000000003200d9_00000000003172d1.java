
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            final String[] setup = in.readLine().split(" ");
            final int numOfSlices = Integer.parseInt(setup[0]);
            final int numOfDiners = Integer.parseInt(setup[1]);
            final List<Long> slices = Stream.of(in.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
            int result = solve(numOfDiners, slices);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static int solve(int numOfDiners, List<Long> slices) {
        final Map<Long, Integer> countsOfSlices = slices.stream().collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));
        for (int i = 0; i < numOfDiners - 1; i++) {
            final int numOfCuts = i;
            // can we solve the puzzle with i slices?
            if(countsOfSlices.values().stream().anyMatch(size -> size == numOfDiners - numOfCuts)) {
                return i;
            }
            if (numOfCuts > 0 && countsOfSlices.entrySet().stream().anyMatch(slice -> countsOfSlices.containsKey(slice.getKey() * 2))) {
                return i;
            }
        }
        return numOfDiners - 1;
    }

}
