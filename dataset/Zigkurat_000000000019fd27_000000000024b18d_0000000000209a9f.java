import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> lines = new ArrayList<>();
        while (in.hasNext()) {
            lines.add(in.nextLine());
        }

        for (int i = 1; i < lines.size(); i++) {
            String result = processLine(lines.get(i));
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processLine(String line) {
        String result = "";

        int openCount = 0;
        for (int i = 0; i < line.length(); i++) {
            int currentDigit = Integer.parseInt(line.substring(i, i + 1));

            if (currentDigit > openCount) {
                for (int j = 0; j < currentDigit - openCount; j++) {
                    result += "(";

                }
            } else if (currentDigit < openCount) {
                for (int j = 0; j < openCount - currentDigit; j++) {
                    result += ")";
                }
            }

            result += currentDigit;
            openCount = currentDigit;
        }

        for (int i = 0; i < openCount; i++) {
            result += ")";
        }

        return result;
    }
}
