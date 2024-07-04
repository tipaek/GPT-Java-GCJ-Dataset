import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            String output = analyzeString(scanner);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static String analyzeString(Scanner scanner) {
        StringBuilder output = new StringBuilder();
        String input = scanner.next();
        List<Integer> numberList = new ArrayList<>();

        for (char c : input.toCharArray()) {
            numberList.add(Character.getNumericValue(c));
        }

        int lastLevel = 0;
        numberList.add(0); // Append a zero to handle the closing brackets at the end

        for (int level : numberList) {
            if (level == lastLevel) {
                output.append(level);
            } else if (lastLevel == 0) {
                output.append("(".repeat(level)).append(level);
            } else if (level < lastLevel) {
                output.append(")".repeat(lastLevel - level)).append(level);
            } else {
                output.append("(".repeat(level - lastLevel)).append(level);
            }
            lastLevel = level;
        }

        return output.substring(0, output.length() - 1); // Remove the last appended zero
    }
}