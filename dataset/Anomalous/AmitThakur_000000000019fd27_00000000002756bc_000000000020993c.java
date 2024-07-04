import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Solution {

    public static int[] parseTokens(String input) {
        return Stream.of(input.split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    public static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = parseInt(reader.readLine());
        while (testCases-- > 0) {
            int number = parseInt(reader.readLine());
        }
    }
}