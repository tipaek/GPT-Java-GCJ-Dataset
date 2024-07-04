import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            String[] leftBraces = {"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
            String[] rightBraces = {"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};

            for (int idx=0;idx<numCases;++idx) {
                StringBuilder sb = new StringBuilder();
                String string = scanner.next();
                int left = 0;
                for (char c : string.toCharArray()) {
                    int t = Integer.parseInt("" + c);
                    if (left < t) {
                        sb.append(leftBraces[t - left]);
                        left += t;
                    } else if (left > t) {
                        sb.append(rightBraces[left - t]);
                        if (t == 0)
                            left = 0;
                        else
                            left -= (left - t);
                    }
                    sb.append(c);
                }
                sb.append(rightBraces[left]);

                System.out.println("Case #" + (idx+1) + ": " + sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}