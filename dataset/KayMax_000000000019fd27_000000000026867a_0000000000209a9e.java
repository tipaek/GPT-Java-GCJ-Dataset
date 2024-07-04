import java.util.*;
import java.io.*;

public class Solution {

    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int cases = in.nextInt();
        int bits = in.nextInt();

        for(int i = 1; i <= cases; i++) {
            if(!solve(i, bits))
                break;
        }
    }

    public static boolean solve(int num, int bits) {

        String result = "";

        if(bits == 10) {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= 10; i++) {
                System.out.println(i);
                sb.append(in.nextInt());
            }
            System.out.println(sb.toString());
            result = in.next();
        }
        return result.equals("Y");
    }
}
