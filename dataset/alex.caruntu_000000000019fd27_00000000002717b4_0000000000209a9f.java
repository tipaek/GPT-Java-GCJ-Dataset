import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
            String line = input.next();
            
            StringBuilder sb = new StringBuilder();
            int prev = 0;
            for (char c : line.toCharArray()) {
                int val = Character.getNumericValue(c);
                if (val != 0) {
                    if (prev < val) {
                        for (int i = 0;i < val - prev;i++) {
                            sb.append('(');
                        }
                    } else if (prev > val) {
                        for (int i = 0;i < prev - val;i++) {
                            sb.append(')');
                        }
                    }
                    sb.append(val);
                    prev = val;
                } else {
                    if (prev != 0) {
                        for (int i = 0;i < prev;i++) {
                            sb.append(')');
                        }
                    }
                    sb.append(0);
                    prev = 0;
                }
            }
            
            if (prev != 0) {
                for (int i = 0;i < prev;i++) {
                    sb.append(')');
                }
            }
            
            System.out.printf("Case #%d: ", n + 1);
            System.out.println(sb.toString());
        }
    }
}