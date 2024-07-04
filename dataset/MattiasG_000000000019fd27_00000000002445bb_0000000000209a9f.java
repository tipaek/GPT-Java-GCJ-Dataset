import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int tests = Integer.parseInt(in.readLine());
            for (int test = 0; test < tests; test++) {
                char[] line = in.readLine().toCharArray();
                StringBuilder out = new StringBuilder();
                int depth = 0;
                for (char c : line) {
                    int x = c - '0';
                    while (depth < x) {
                        depth++;
                        out.append('(');
                    }
                    while (depth > x) {
                        depth--;
                        out.append(')');
                    }
                    out.append(x);
                }

                while (depth > 0) {
                    depth--;
                    out.append(')');
                }

                System.out.printf("Case #%d: %s\n", test+1, out.toString());
            }
        }
    }
}