import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); scanner.nextLine();
        for(int i = 0; i < t; i++) {
            solve(scanner, i+1);
        }
    }

    public static void solve(Scanner in, int id) {
        String input = in.nextLine();
        StringBuffer output = new StringBuffer();

        int prev = 0;
        for(char c : input.toCharArray()) {
            int next = c - '0';
            int diff = next - prev;
            if(diff > 0) {
                for(int i = 0; i < diff; i++) {
                    output.append('(');
                }
            }else if(diff < 0) {
                for(int i = 0; i < -diff; i++) {
                    output.append(')');
                }
            }
            output.append(c);
            prev = next;
        }
        if(prev > 0) {
            for (int i = 0; i < prev; i++) {
                output.append(')');
            }
        }
        System.out.println("Case #" + id + ": " + output.toString());
    }
}