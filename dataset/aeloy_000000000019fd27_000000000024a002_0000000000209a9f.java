import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 0; x < t; x++) {
            List<Integer> input = Arrays.stream(sc.next().split(""))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            System.out.print(String.format("Case #%d: ", x + 1));
            nestingDepth(input);
            System.out.println();
        }
    }

    private static void nestingDepth(List<Integer> input) {
        Stack<Byte> stack = new Stack<>();

        input.forEach(n -> {
            int p = Math.abs(stack.size() - n);

            if (stack.size() >= n) {
                for (int i=0; i<p; i++) {
                    stack.pop();
                    System.out.print(")");
                }
            } else {
                for (int i=0; i<p; i++) {
                    stack.push(new Byte("1"));
                    System.out.print("(");
                }
            }

            System.out.print(n);
        });

        while (!stack.empty()) {
            stack.pop();
            System.out.print(")");
        }
    }

}
