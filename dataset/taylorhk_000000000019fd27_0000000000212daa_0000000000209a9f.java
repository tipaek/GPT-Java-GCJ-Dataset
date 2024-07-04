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
//        System.out.println("caseCnt: " + caseCnt);
        for (int i = 0; i < caseCnt; i++) {
            String input = s.nextLine();
            StringBuilder sb = new StringBuilder();
            for (char c : input.toCharArray()) {
                int num = c - '0';
                for (int j = 0; j < num; j++) {
                    sb.append("(");
                }
                sb.append(num);
                for (int j = 0; j < num; j++) {
                    sb.append(")");
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
    }
}
