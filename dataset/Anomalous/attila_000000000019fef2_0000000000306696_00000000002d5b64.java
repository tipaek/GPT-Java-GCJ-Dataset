import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = reader.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);

            StringBuilder resultBuilder = new StringBuilder();
            int steps = 0;

            while (r > 1) {
                int initialR = r;
                int initialB = r * s - r - 1;

                for (int i = 0; i < s - 1; i++) {
                    int currentB = initialB - i;
                    resultBuilder.append("\n").append(initialR).append(' ').append(currentB);
                    steps++;
                }
                r--;
            }

            System.out.println("Case #" + testCase + ": " + steps);
            System.out.println(resultBuilder.toString().substring(1));
        }
    }

    private static void rearrangeList(List<Integer> list, int a, int b) {
        List<Integer> partA = new ArrayList<>(list.subList(0, a));
        List<Integer> partB = new ArrayList<>(list.subList(a, a + b));
        List<Integer> partC = new ArrayList<>(list.subList(a + b, list.size()));

        list.clear();
        list.addAll(partB);
        list.addAll(partA);
        list.addAll(partC);
    }
}