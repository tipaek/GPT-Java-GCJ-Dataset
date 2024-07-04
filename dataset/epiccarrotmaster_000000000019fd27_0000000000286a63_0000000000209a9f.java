import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = Integer.parseInt(in.nextLine());
        for (int k = 1; k <= N; k++) {
            String rawNum = in.nextLine();
            StringBuilder sb = new StringBuilder();

            boolean close = false;
            char prevChar = '0';
            for (char c : rawNum.toCharArray()) {
                int numOfParen = c - prevChar;
                char parenToAdd = numOfParen > 0 ? '(' : ')';

                for (int i = 0; i < Math.abs(numOfParen); i++) {
                    sb.append(parenToAdd);
                }

                sb.append(c);
                prevChar = c;
            }
            for (int i = 0; i < (prevChar - '0'); i++) {
                sb.append(')');
            }

            System.out.println("Case #" + k + ": " + sb.toString());
        }
    }
}