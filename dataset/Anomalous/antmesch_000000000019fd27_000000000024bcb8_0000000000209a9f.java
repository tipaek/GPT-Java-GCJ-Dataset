import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String output = analyzeString(in);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static String analyzeString(Scanner in) {
        String input = in.next();
        List<Integer> numberList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numberList.add(Character.getNumericValue(c));
        }

        StringBuilder output = new StringBuilder();
        int lastNumber = 0;
        int current;
        int countCurrent = 0;

        for (int i = 0; i < numberList.size(); i++) {
            current = numberList.get(i);
            if (lastNumber != current) {
                output.append(repeat(lastNumber, countCurrent));
                output.append(repeat(')', lastNumber));
                output.append(repeat('(', current));
                lastNumber = current;
                countCurrent = 1;
            } else {
                countCurrent++;
            }
        }

        output.append(repeat(lastNumber, countCurrent));
        output.append(repeat(')', lastNumber));

        return output.toString();
    }

    private static String repeat(int number, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(number);
        }
        return sb.toString();
    }

    private static String repeat(char ch, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}