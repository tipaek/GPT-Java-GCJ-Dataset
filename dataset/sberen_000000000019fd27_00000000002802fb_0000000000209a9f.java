import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= tests; i++) {
            String result = "";
            String value = in.nextLine();
            int openParens = 0;
            char[] values = values.toCharArray();
            for (int j = 0; j < values.length; j++) {
                int val = values[i] - '0';
                if (val > openParens) {
                    for (int k = 0; k < val - openParens; k++) {
                        result += "(";
                    }
                } else if (val < openParens) {
                    for (int k = 0; k < openParens - val; k++) {
                        result += ")";
                    }
                }
                result += val;
                openParens = val;
            }
            for (int z = 0; z < openParens; z++) {
               result += ")";
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}