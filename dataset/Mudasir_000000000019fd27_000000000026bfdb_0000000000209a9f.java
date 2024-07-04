import java.util.*;
import java.io.*;

public class Solution {
    static final String OPEN_BR = "(";
    static final String CLOSE_BR = ")";
    static final String CASE_HEAD = "Case #";
    static final String SEP = ": ";

    public static void main(String... args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();


        StringBuilder result = null;
        String line = null;

        int current;
        int bracketsOpen = 0;
        int n = 0;

        in.nextLine();
        for (int i = 1; i <= t; i++) {
            line = in.nextLine();
            n = line.length();
            result = new StringBuilder(CASE_HEAD).append(i).append(SEP);
            bracketsOpen = 0;
            for (int j = 0; j < n; j++) {
                current = line.charAt(j) - '0';
                if (current > bracketsOpen) {
                    int b = current - bracketsOpen;
                    for (int k = 0; k < b; k++) {
                        result.append(OPEN_BR);
                    }
                    bracketsOpen += b;
                    result.append(current);
                } else if (current < bracketsOpen) {
                    int b = bracketsOpen - current;
                    for (int k = 0; k < b; k++) {
                        result.append(CLOSE_BR);
                    }

                    bracketsOpen -= b;
                    result.append(current);
                } else {
                    result.append(current);
                }
            }

            for (int j = 0; j < bracketsOpen; j++) {
                result.append(CLOSE_BR);
            }

            System.out.println(result);
        }


    }
}