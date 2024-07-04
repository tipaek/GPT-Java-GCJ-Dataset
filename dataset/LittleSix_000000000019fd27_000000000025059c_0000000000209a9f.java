import java.util.*;
import java.io.*;
import java.lang.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String input = in.nextLine();
            StringBuilder result = new StringBuilder();
            int currentOpenNum = 0;
            for (int j = 0; j < input.length(); j++) {
                int currentNum = input.charAt(j) - '0';
                if (currentOpenNum < currentNum) {
                    for (int k = 1; k <= currentNum - currentOpenNum; k++) {
                        result.append("(");
                    }
                    currentOpenNum = currentNum;
                }
                if (currentOpenNum > currentNum) {
                    for (int k = 1; k <= currentOpenNum - currentNum; k++) {
                        result.append(")");
                    }
                    currentOpenNum = currentNum;
                }
                result.append(currentNum);
            }
            for (int l = 1; l <= currentOpenNum; l++) {
                result.append(")");
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}