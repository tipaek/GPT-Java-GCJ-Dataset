import java.io.FileInputStream;
import java.util.*;
import java.util.Scanner;
import java.io.*;

class google2 {
    public static int toint(char c) {
        int x = c - 48;

        return x;

    }

    public static String salsa(String as) {
        int count = 0;
        int prev = 0;
        String str = "";
        for (int i = 0; i < as.length(); i++)

        {
            int z = toint(as.charAt(i));
            if (z < prev) {

                for (int j = count - z; j > 0; j--) {
                    count--;
                    str = str + ')';
                }
                str += as.charAt(i);
            }

            else if (z > prev) {
                for (int j = z - count; j > 0; j--) {
                    str += '(';

                    count++;
                }
                str += as.charAt(i);
            } else if (z == prev) {
                str += as.charAt(i);
            }
            prev = z;

        }

        for (int i = 0; i < count; i++) {
            str += ')';
        }
        return str;

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = s.nextInt();
        for (int v = 0; v < t; v++) {
            String n = s.next();
            String sa = salsa(n);
            System.out.print("Case #" + (v + 1) + ":");
            System.out.print(" " + sa);
            System.out.println();
        }
    }
}
