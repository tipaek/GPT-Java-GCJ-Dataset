import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        List<String> nestedStringList = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String numbers = in.nextLine();
            StringBuilder nestedString = new StringBuilder();
            Integer depthTillNow = 0;
            for (int j = 0; j < numbers.length(); j++) {
                Integer number = Integer.parseInt(String.valueOf(numbers.charAt(j)));
                if (number > depthTillNow) {
                    int tempDepth = 0;
                    for (int k = 0; k < (number - depthTillNow); k++) {
                        nestedString.append("(");
                        tempDepth++;
                    }
                    depthTillNow += tempDepth;
                } else if (number < depthTillNow) {
                    int tempDepth = 0;
                    for (int k = 0; k < (depthTillNow - number); k++) {
                        nestedString.append(")");
                        tempDepth++;
                    }
                    depthTillNow -= tempDepth;
                }

                nestedString.append(number);

                if (j + 1 == numbers.length()) {
                    for (int k = 0; k < depthTillNow; k++) {
                        nestedString.append(")");
                    }
                }
            }
            nestedStringList.add(nestedString.toString());
        }
        for (int i = 0; i < t; ++i) {
            System.out.println("Case #" + (i+1) + ": " + nestedStringList.get(i));
        }
    }
}
