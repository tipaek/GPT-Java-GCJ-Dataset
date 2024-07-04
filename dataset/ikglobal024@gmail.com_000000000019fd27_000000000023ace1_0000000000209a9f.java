import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        in.nextLine();
        for (int t=1; t<= T; t++) {
            String S = in.nextLine();
            StringBuilder res = new StringBuilder();
            Stack<String> stack = new Stack<>();
            int len = S.length();
            int index = 0;
            while (index < len) {
                int value = Integer.parseInt(""+S.charAt(index));
                int stackSize = stack.size();
                if (value > stackSize) {
                    int diff = value - stackSize;
                    for (int i=0; i<diff; i++) {
                        res.append("(");
                        stack.push("(");
                    }
                } else if (value < stackSize) {
                    int diff = stackSize - value;
                    for (int i=0; i<diff; i++) {
                        stack.pop();
                        res.append(")");
                    }
                }
                res.append(value);
                index++;
            }
            while (!stack.isEmpty()) {
                stack.pop();
                res.append(")");
            }

            System.out.println("case #" + t + ": " + res.toString());
        }
    }

}