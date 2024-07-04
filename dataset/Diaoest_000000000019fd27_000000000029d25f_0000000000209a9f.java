import java.util.*;

public class google {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            sc.nextLine();
            for (int i=0; i<num; i++) {
                String line = sc.nextLine();
                char[] arr = line.toCharArray();
                String ans = "";
                Stack<Character> stack = new Stack<>();
                for (char c : arr) {
                    int cur = c - '0';
                    while (cur < stack.size()) {
                        stack.pop();
                        ans += ')';
                    }
                    while (cur > stack.size()) {
                        stack.push('(');
                        ans += '(';
                    }
                    ans += c;
                }
                while (!stack.isEmpty()) {
                    stack.pop();
                    ans += ')';
                }
                System.out.println("Case #" + (i+1) + ": " + ans+"\n");
            }
        }
    }
}
