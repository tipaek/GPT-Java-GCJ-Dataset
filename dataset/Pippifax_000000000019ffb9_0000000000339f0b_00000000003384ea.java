import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static BufferedReader in;
    static List<long[]> numbers = new ArrayList<>();

    public static void main(String[] args) {
        readInput();

        int i = 1;

        for (long[] stacks : numbers) {
            processNumber(stacks[0], stacks[1], i);
            i++;
        }
    }

    private static void processNumber(long leftStack, long rightStack, int testcaseId) {
        int i = 1;

        while (leftStack >= i || rightStack >= i) {
            if (leftStack >= rightStack) {
                leftStack -= i;
            } else {
                rightStack -= i;
            }

            i++;
        }

        i--;

        System.out.println("Case #" + testcaseId + ": " + i + " " + leftStack + " " + rightStack);
    }

    private static void readInput() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                String[] fractals = line.split(" ");

                long leftStack = Long.parseLong(fractals[0]);
                long rightStack = Long.parseLong(fractals[1]);

                long[] stacks = new long[2];
                stacks[0] = leftStack;
                stacks[1] = rightStack;

                numbers.add(stacks);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}
