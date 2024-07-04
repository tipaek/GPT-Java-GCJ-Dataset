import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = Integer.parseInt(in.nextLine());
        
        for (int t = 1; t <= T; t++) {
            String S = in.nextLine();
            StringBuilder result = new StringBuilder();
            
            int currentDepth = Character.getNumericValue(S.charAt(0));
            result.append("(".repeat(currentDepth)).append(currentDepth);
            
            for (int i = 1; i < S.length(); i++) {
                int nextDepth = Character.getNumericValue(S.charAt(i));
                if (currentDepth > nextDepth) {
                    result.append(")".repeat(currentDepth - nextDepth)).append(nextDepth);
                } else if (currentDepth < nextDepth) {
                    result.append("(".repeat(nextDepth - currentDepth)).append(nextDepth);
                } else {
                    result.append(nextDepth);
                }
                currentDepth = nextDepth;
            }
            result.append(")".repeat(currentDepth));
            
            System.out.println("Case #" + t + ": " + result);
        }
    }
}