import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int caseCnt = s.nextInt();
        s.nextLine();
//        System.out.println("caseCnt: " + caseCnt);
        for (int i = 0; i < caseCnt; i++) {
            String input = s.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) - '0' == 0) {
                    if (j > 0 && input.charAt(j - 1) - '0' != 0) {
                        sb.append(")");
                    }
                } else {
                    if (j == 0 || input.charAt(j - 1) - '0' == 0) {
                        sb.append("(");
                    }
                }
                sb.append(input.charAt(j));
            }
            if (input.charAt(input.length() - 1) - '0' != 0) {
                sb.append(")");
            }
            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
    }
}
