import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            int n = s.length();
            int braceCount = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int value = s.charAt(i) - '0';
                
                if (value == braceCount) {
                    result.append(s.charAt(i));
                } else if (value > braceCount) {
                    int diff = value - braceCount;
                    result.append(repeatChar('(', diff)).append(s.charAt(i));
                    braceCount += diff;
                } else {
                    int diff = braceCount - value;
                    result.append(repeatChar(')', diff)).append(s.charAt(i));
                    braceCount -= diff;
                }
            }

            if (braceCount > 0) {
                result.append(repeatChar(')', braceCount));
            }

            System.out.println("Case #" + (tt + 1) + ": " + result.toString());
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}