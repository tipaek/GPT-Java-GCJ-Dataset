
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(br.readLine());
            for (int i = 1; i <= numberOfCases; i++) {
                String input = br.readLine();
                Deque<Character> stack = new ArrayDeque<>();
                StringBuilder sb = new StringBuilder(2 * input.length());
                for (int j = 0; j < input.length(); j++) {
                    int value = Integer.parseInt(input.charAt(j) + "");
                    while (value > stack.size()) {
                        stack.push('(');
                        sb.append('(');
                    }
                    while (value < stack.size()) {
                        stack.pop();
                        sb.append(')');
                    }
                    sb.append(value);
                }
                while (!stack.isEmpty()) {
                    stack.pop();
                    sb.append(')');
                }
                System.out.println("Case #" + i + ": " + sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}