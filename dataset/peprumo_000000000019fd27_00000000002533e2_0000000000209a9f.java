import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Tests number
        int parentesisNum;
        StringBuffer output;
        for (int i = 1; i <= t; ++i) {
            output = new StringBuffer();
            parentesisNum = 0;
            String n = in.next();
            for (int j = 0; j < n.length(); j++) {
                int num = n.charAt(j) - 48;

                if (num > parentesisNum) {
                    output.append("(").append(num);
                    parentesisNum++;
                } else if (num < parentesisNum) {
                    output.append(")").append(num);
                    parentesisNum--;
                } else {
                    output.append(num);
                }
            }
            while (parentesisNum > 0) {
                output.append(")");
                parentesisNum--;
            }
            System.out.println("Case #" + i  + ": " + output);
        }
    }
}