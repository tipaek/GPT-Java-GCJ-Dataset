
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            List<Integer> input = Stream.of(in.readLine().split("")).map(Integer::parseInt).collect(toList());
            System.out.println("Case #" + i +": " + solve(input));
        }
    }

    public static String solve(List<Integer> arr) {
        int prevLevel = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer currLevel : arr) {
            append(stringBuilder, prevLevel, currLevel);
            stringBuilder.append(currLevel);
            prevLevel = currLevel;
        }
        append(stringBuilder, prevLevel, 0);
        return stringBuilder.toString();
    }

    private static void append(StringBuilder stringBuilder, int prevLevel, int currLevel) {
        for (int i = prevLevel; i < currLevel; i++) {
            stringBuilder.append('(');
        }
        for (int i = currLevel; i < prevLevel; i++) {
            stringBuilder.append(')');
        }
    }

}
