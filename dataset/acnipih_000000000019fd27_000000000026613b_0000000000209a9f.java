
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(reader);

        int t = Integer.parseInt(reader.readLine().trim());
        for (int i = 1; i <= t; i++) {
            String s = reader.readLine().trim();
            String res = solve(s);

            System.out.println("Case #" + i + ": " +res);
        }
    }

    private static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        int currentParen = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int num = c - '0';
            if(num == currentParen){
                sb.append(num);
            } else if (num < currentParen){
                int diff = currentParen - num;
                currentParen = num;
                while(diff-- > 0) sb.append(")");
                sb.append(num);
            } else {
                int diff = num - currentParen;
                currentParen = num;
                while(diff-- > 0) sb.append("(");
                sb.append(num);
            }
        }
        while(currentParen-- > 0) sb.append(")");
        return sb.toString();
    }
}
