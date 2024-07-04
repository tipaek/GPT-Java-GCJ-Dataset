import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        int t1 = Integer.parseInt(in.readLine());

        for (int i = 1; i <= t1; i++) {
            String s = in.readLine();
            StringBuilder s1 = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < s.length(); j++) {
                int num = Character.getNumericValue(s.charAt(j));
                
                while (currentDepth < num) {
                    s1.append("(");
                    currentDepth++;
                }
                
                while (currentDepth > num) {
                    s1.append(")");
                    currentDepth--;
                }

                s1.append(num);
            }

            while (currentDepth > 0) {
                s1.append(")");
                currentDepth--;
            }

            System.out.println("Case #" + i + ": " + s1);
        }
    }
}