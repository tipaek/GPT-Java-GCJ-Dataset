import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        /*
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int n = in.nextInt();
        int m = in.nextInt();
        */
        String head = in.nextLine();
        String[] heads = head.split(" ");
        int t = Integer.parseInt(heads[0]);
        int b = Integer.parseInt(heads[1]);


        for (int i = 1; i <= t; ++i) {

            //System.out.println("now");
            String ans;
            if (b == 10) {
                ans = solve(in, b);
            } else {
                ans = solve2(in, b);
            }
            if (ans == "")
                break;
            System.out.println(ans);
            String response = in.nextLine();
            if (response.equals("N")){ break; }
        }
    }

    public static String solve(Scanner in, int b){
        //first 14 rounds
        for (int i = 0; i < 14; i++) {
            //send 10 queries
            for (int j = 0; j < 10; j++) {
                System.out.println(0);
                String temp = in.nextLine();
            }
        }
        //last one
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 10; j++) {
            System.out.println(j);
            int curr = in.nextInt();
            sb.append(curr);
        }
        return sb.toString();

    }

    public static String solve2(Scanner in, int b){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b; i++) {
            sb.append(1);
        }
        return sb.toString();

    }
}