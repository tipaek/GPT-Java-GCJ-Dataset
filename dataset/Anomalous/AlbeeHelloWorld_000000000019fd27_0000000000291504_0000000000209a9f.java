import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = getScanner();
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int previous = 0;

            for (int j = 0; j < input.length(); j++) {
                int current = Character.getNumericValue(input.charAt(j));
                if (current > previous) {
                    output.append("(".repeat(current - previous));
                } else if (current < previous) {
                    output.append(")".repeat(previous - current));
                }
                output.append(current);
                previous = current;
            }
            output.append(")".repeat(previous));
            System.out.println("Case #" + i + ": " + output);
        }
    }

    static Scanner getScanner() throws Exception {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // return new Scanner(new File("input.txt"));
    }
}