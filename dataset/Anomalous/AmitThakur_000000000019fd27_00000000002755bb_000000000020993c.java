import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sample {

    public static int[] parseTokens(String input) {
        return Arrays.stream(input.split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    public static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = parseInt(reader.readLine());
        
        for (int i = 0; i < testCases; i++) {
            int number = parseInt(reader.readLine());
            // You can add your logic here to process each test case
        }
    }
}