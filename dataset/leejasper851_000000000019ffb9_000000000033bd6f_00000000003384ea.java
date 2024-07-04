import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int caseN = 1; caseN <= numCases; caseN++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            long left = Long.parseLong(st.nextToken());
            long right = Long.parseLong(st.nextToken());
            
            boolean bigLeft = true;
            long big = left;
            long small = right;
            long diff = left - right;
            if (diff < 0) {
                diff *= -1;
                bigLeft = false;
                big = right;
                small = left;
            }
            
            long numCus = 0;
            double diffNum = -0.5 + Math.sqrt(0.25 + 2 * diff);
            numCus = (long) Math.floor(diffNum);
            big -= (numCus * (numCus + 1)) / 2;
//            if (bigLeft) {
//                System.out.println(big + " " + small);
//            } else {
//                System.out.println(small + " " + big);
//            }
            long nextNum = numCus + 1;
            if (big > small || (big == small && bigLeft)) {
                long num = getCus(big, nextNum);
                big -= (nextNum + nextNum + (num - 1) * 2) * num / 2;
                numCus += num;
                num = getCus(small, nextNum + 1);
                small -= (nextNum + 1 + nextNum + 1 + (num - 1) * 2) * num / 2;
                numCus += num;
            } else {
                long num = getCus(small, nextNum);
                small -= (nextNum + nextNum + (num - 1) * 2) * num / 2;
                numCus += num;
                num = getCus(big, nextNum + 1);
                big -= (nextNum + 1 + nextNum + 1 + (num - 1) * 2) * num / 2;
                numCus += num;
            }
            
            if (bigLeft) {
                writer.println("Case #" + caseN + ": " + numCus + " " + big + " " + small);
            } else {
                writer.println("Case #" + caseN + ": " + numCus + " " + small + " " + big);
            }
        }
        reader.close();
        writer.close();
    }
    
    private static long getCus(long numLeft, long startNum) {
        if (startNum % 2 == 1) {
            long prevNum = ((startNum - 2) + 1) / 2;
            long num = (long) Math.floor(Math.sqrt(numLeft + prevNum * prevNum));
            num = num * 2 - 1;
            return (num - startNum) / 2 + 1;
        }
        long prevNum = (startNum - 2) / 2;
        numLeft += prevNum * (prevNum + 1);
        double diffNum = (-1 + Math.sqrt(1 + 4 * numLeft)) / 2;
        long num = (long) Math.floor(diffNum);
        num *= 2;
        return (num - startNum) / 2 + 1;
    }
}