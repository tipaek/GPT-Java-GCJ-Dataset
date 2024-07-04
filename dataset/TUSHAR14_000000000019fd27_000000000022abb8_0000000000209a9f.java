import java.io.*;
import java.util.*;
import java.lang.*;

class CodeJam2 {
    public static void main(String natgs[]) {
        Scanner cs = new Scanner(System.in);
        int a = 0, b, i, j, n;
        int[] arr = new int[20];
        n = cs.nextInt();
        for (i = 1; i <= n; i++) {
            arr[i] = cs.nextInt();
            String s = String.valueOf(arr[i]);
            char[] str = s.toCharArray();
            b = s.length();
            System.out.print("Case #" + i + ": ");
            for (j = 0; j < b; j++) {
                if (str[j] == '1') {
                    if (a == 0) {
                        System.out.print("(");
                        a = 1;
                    }
                    System.out.print(str[j]);
                    if (j < s.length() - 1) {
                        if (str[j + 1] != '1') {
                            System.out.print(")");
                            a = 0;
                        }
                    } else if (j == s.length() - 1) {
                        System.out.print(")");
                    }
                } else {
                    System.out.print(str[j]);
                }
            }
        }

    }
}