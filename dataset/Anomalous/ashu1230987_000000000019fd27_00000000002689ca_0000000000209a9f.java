import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        int caseNumber = 1;

        while (T > 0) {
            String input = scn.next();
            Queue<Integer> queue = new LinkedList<>();
            Stack<String> stack = new Stack<>();

            for (char ch : input.toCharArray()) {
                queue.add(Character.getNumericValue(ch));
            }

            answer.append("Case #").append(caseNumber).append(": ");
            int previous = 0;

            while (!queue.isEmpty()) {
                int current = queue.remove();
                while (previous < current) {
                    answer.append("(");
                    stack.push("(");
                    previous++;
                }
                while (previous > current) {
                    answer.append(")");
                    stack.pop();
                    previous--;
                }
                answer.append(current);
            }

            while (!stack.isEmpty()) {
                answer.append(")");
                stack.pop();
            }

            answer.append("\n");
            T--;
            caseNumber++;
        }

        System.out.println(answer);
    }
}