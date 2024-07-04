import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCases = in.nextInt();
        for (int numTestCase = 0; numTestCase < numTestCases; ++numTestCase) {
            String digits = in.next();
            boolean isOpen = false;
            StringBuilder sb = new StringBuilder();
            int curOpenPars = 0;
            int neededClosedPars = 0;
            for(int i = 0; i < digits.length(); ++i) {
                int digit = digits.charAt(i) - '0';
                if(curOpenPars >= digit) {
                    int diff = curOpenPars - digit;
                    for(int j = 0; j < diff; ++j) {
                        sb.append(')');
                    }
                    curOpenPars -= diff;
                    neededClosedPars -= diff;
                } else {
                    int diff = digit - curOpenPars;
                    for(int j = 0; j < diff; ++j) {
                        sb.append('(');
                    }
                    curOpenPars += diff;
                    neededClosedPars += diff;
                }
                sb.append(digit);
            }
            for(int i = 0; i < neededClosedPars; ++i) {
                sb.append(')');
            }
            System.out.println("Case #" + (numTestCase + 1) + ": " + sb.toString());
        }
    }

}