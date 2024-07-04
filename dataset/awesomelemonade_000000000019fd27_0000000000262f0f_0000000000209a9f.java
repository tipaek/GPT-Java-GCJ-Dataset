import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());
        for (int tt = 0; tt < testCases; tt++) {
            String x = reader.readLine();
            StringBuilder builder = new StringBuilder();
            int current = 0;
            for (char c : x.toCharArray()) {
                int num = c - '0';
                if (num > current) {
                    for (int i = 0; i < num - current; i++) {
                        builder.append('(');
                    }
                } else {
                    for (int i = 0; i < current - num; i++) {
                        builder.append(')');
                    }
                }
                builder.append(c);
                current = num;
            }
            for (int i = 0; i < current; i++) {
                builder.append(')');
            }
            writer.printf("Case #%d: %s\n", tt + 1, builder.toString());
        }
        reader.close();
        writer.close();
    }
}