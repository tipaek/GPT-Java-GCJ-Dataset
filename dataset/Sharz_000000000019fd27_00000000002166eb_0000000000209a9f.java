import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            System.out.print("Case #" + i + ": ");
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != '0') {
                    System.out.print("(");
                    char tmp = s.charAt(j);
                    while (j < s.length() && s.charAt(j) == tmp) {
                        System.out.print(tmp);
                        j++;
                    }
                    if (j == s.length())
                        System.out.print(")");
                    else
                        System.out.print(")"+ s.charAt(j));
                } else {
                    System.out.print("0");
                }
            }
            System.out.print(System.lineSeparator());

        }

    }
}