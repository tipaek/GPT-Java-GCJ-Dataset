import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<t; i++)
            System.out.println(String.format("Case #%d: %s", (i+1), doit(i)));
    }

    private static String doit(int t) {
        char[] line = sc.nextLine().toCharArray();
        StringBuffer sb = new StringBuffer();
        int lvl = 0, d;

        for(int i=0; i<line.length; ++i) {
            d = line[i] - '0';
            while(lvl < d) {
                sb.append('(');
                lvl++;
            }
            while(lvl > d) {
                sb.append(')');
                lvl--;
            }
            sb.append(d);
        }

        while(lvl > 0) {
            sb.append(')');
            lvl--;
        }

        return String.format("%s", sb.toString());
    }
}

