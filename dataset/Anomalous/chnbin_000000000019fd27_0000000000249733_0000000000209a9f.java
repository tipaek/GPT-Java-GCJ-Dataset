import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputString = scanner.next();
            String result = processString(inputString);
            System.out.println("Case #" + testCase + ": " + result);
        }
        scanner.close();
    }

    private static String processString(String str) {
        StringBuilder result = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();

        for (char c : str.toCharArray()) {
            if (c == '0') {
                if (stack.isEmpty()) {
                    result.append(c);
                } else {
                    result.append("(").append(stack.pop()).append(")").append(c);
                }
            } else {
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(c));
                } else {
                    stack.push(stack.pop() + c);
                }
            }
        }

        if (!stack.isEmpty()) {
            result.append("(").append(stack.pop()).append(")");
        }

        return result.toString();
    }

    public static class TimeSlot {
        public int startTime;
        public int endTime;
        public int index;

        public TimeSlot(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
    }
}