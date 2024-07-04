import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());
        for(int k=1; k<=T; k++) {
            String num = scanner.nextLine();
            solve(num, k);
        }
    }

    private static void solve(String num, int c) {
        LinkedList<Character> stack = new LinkedList<>();
        int score = 0;
        for(char ch : num.toCharArray()) {
            int d = ch - '0';
            while(score != d) {
                if(score < d) {
                    stack.push('(');
                    score++;
                } else {
                    stack.push(')');
                    score--;
                }
            }
            stack.push(ch);
        }
        while(score-- != 0) stack.push(')');

        StringBuilder sb = new StringBuilder();
        while(stack.size() != 0) 
            sb.append(stack.pollLast());
        System.out.println("Case #" + c + ": " + sb.toString());
    }
}