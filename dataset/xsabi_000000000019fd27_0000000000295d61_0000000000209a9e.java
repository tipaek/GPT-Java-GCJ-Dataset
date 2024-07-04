import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        int B = Integer.parseInt(in.nextLine());
        boolean passed = true;
        int t = 0;
        while (passed && t < T) {
            System.err.println("Test Case #" + t);
            int query = 1;
            boolean complete = false;
            char[] digits = new char[B];
            Arrays.fill(digits, '0');
            while (query <= 150 && !complete) {
                for (int p = 0; p < 10; p++) {
                    System.out.println(p + 1);
                    System.err.println("Query for index " + (p + 1));
                    char response = in.nextLine().charAt(0);
                    digits[p] = response;
                    query++;
                } 
                if (B == 10)
                    complete = true;
            }
            System.out.println(String.valueOf(digits));
            passed = (in.nextLine().charAt(0) == 'Y');
            t++;
        }
    }
}