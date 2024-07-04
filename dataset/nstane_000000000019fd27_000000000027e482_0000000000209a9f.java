import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.out;


public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String testData = in.nextLine();
        int testCases = Integer.parseInt(testData);

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringBuilder stringBuilder = new StringBuilder();

            String input = in.nextLine();

            int counter = 0;

            for (int index = 0; index < input.length(); index++) {
                int num = input.charAt(index) - 48;

                if (num > counter) {
                    int diff = num - counter;
                    appendCharByTimes(stringBuilder, diff, '(');
                    counter += diff;
                } else {
                    int diff = counter - num;
                    appendCharByTimes(stringBuilder, diff, ')');
                    counter -= diff;
                }
                stringBuilder.append(num);
            }

            appendCharByTimes(stringBuilder, counter, ')');

            out.println("Case Number" + testCase + ": " + stringBuilder.toString());
        }

        in.close();
    }

    private static void appendCharByTimes(StringBuilder stringBuilder, int times, char b) {
        while (times-- > 0) {
            stringBuilder.append(b);
        }
    }
}
