import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int i = 1; i <= t; ++i) {
                String data = scanner.next();
                System.out.println("Case #" + i + ": " + calculate(data));
            }
        } catch (Exception e) {
        }
    }

    public static String calculate(String input) {
        char element = ' ';
        char zero = '0';
        String ans = "";
        Stack<String> leftStack = new Stack<String>();
        for (int i = 0; i < input.length(); i++) {
            if (element == ' ') {
                element = input.charAt(i);
                int count = element - zero;
                for (int cp = 0; cp < count; cp++) {
                    ans += "(";
                    leftStack.push("(");
                }
                ans += element;
            } else {
                char curElement = input.charAt(i);
                if (element == curElement) {
                    ans += curElement;
                    continue;
                } else if (curElement < element) {
                    int gap = (int) (element - curElement);
                    while (!leftStack.isEmpty() && gap > 0) {
                        ans += ")";
                        leftStack.pop();
                        gap--;
                    }
                    element = curElement;
                    ans += element;
                } else {
                    while (!leftStack.isEmpty()) {
                        ans += ")";
                        leftStack.pop();
                    }
                    element = input.charAt(i);
                    int count = element - zero;
                    for (int cp = 0; cp < count; cp++) {
                        ans += "(";
                        leftStack.push("(");
                    }
                    ans += element;
                }
            }
        }
        while (!leftStack.isEmpty()) {
            ans += ")";
            leftStack.pop();
        }
        return ans;
    }

}