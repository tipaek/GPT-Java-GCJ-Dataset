import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static Queue<String> queue = new LinkedList<>();
    private static Stack<String> stack = new Stack<>();
    private static StringBuilder out = new StringBuilder();
    private static String input;

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            init();
            wrapNumberWithParenthesis();
            compressParenthesisWithSameNumber();
            printAnswer(caseNum);
        }
    }

    private static void init() {
        queue.clear();
        stack.clear();
        out.setLength(0);
        input = sc.next();
    }

    /**
     * 1 -> (1)
     * 4 -> ((((4))))
     * 3312 -> (((3)))(((3)))(1)((2))
     * */
    private static void wrapNumberWithParenthesis() {
        for (String s : input.split("")) {
            int num = Integer.parseInt(s);
            for (int i = 0; i < num; i++) {
                queue.add("(");
            }
            queue.add(s);
            for (int i = 0; i < num; i++) {
                queue.add(")");
            }
        }
    }

    /**
     * (1) -> (1)
     * ((((4)))) -> ((((4))))
     * (((3)))(((3)))(1)((2)) -> (((33)))1((2))
     * */
    private static void compressParenthesisWithSameNumber() {
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (!stack.isEmpty() && (stack.peek().equals(")") && str.equals("("))) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }
    }

    private static void printAnswer(int caseNum) {
        stack.forEach(c -> out.append(c));
        System.out.printf("Case #%d: %s\n", caseNum, out);
    }
}