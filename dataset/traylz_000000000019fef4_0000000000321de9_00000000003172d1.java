
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.TreeMap;
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

    static int solve(int numOfDiners, List<Long> slices) {
        final TreeMap<Long, Integer> countsOfSlices = slices.stream().collect(Collectors.toMap(i -> i, i -> 1, Integer::sum, TreeMap::new));
        if (countsOfSlices.values().stream().anyMatch(size -> size >= numOfDiners)) {
            return 0;
        }
        if (numOfDiners == 2) {
            return 1;
        } else if (countsOfSlices.entrySet().stream().anyMatch(slice -> countsOfSlices.containsKey(slice.getKey() * 2))) {
            return 1;
        } else if (countsOfSlices.entrySet().stream().anyMatch(slice -> slice.getValue() == 2 && countsOfSlices.higherKey(slice.getKey()) != null)) {
            return 1;
        }
        return 2;
    }

}
