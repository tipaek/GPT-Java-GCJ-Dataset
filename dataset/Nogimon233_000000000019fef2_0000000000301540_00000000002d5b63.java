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
        int a = Integer.parseInt(heads[1]);
        int b = Integer.parseInt(heads[2]);


        for (int i = 1; i <= t; ++i) {

            //if (a == 1000000000 - 5) {
                if (!solve3(in)) {
                    return;
                };
            //}
        }
    }

    public static boolean solve3(Scanner in) {
        //int base = 1000000000;
        int base = 0;
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                int x = base + i;
                int y = base + j;
                System.out.println(x + " " + y);
                String resp = in.nextLine();
                if (resp.equals("CENTER")) {
                    return true;
                }
                else{
                    continue;
                }
            }
        }
        return false;

    }

    public static boolean solve1(Scanner in, int a, int b){
        int base = 1000000000;
        //smallest up edge
        int up = 10;
        //110
        for (int i = 0; i <= 10; i++) {
            for (int j = -5; j <= 5; j++) {
                int x = i;
                int y = base + j;
                System.out.println(x + " " + y);
                String resp = in.nextLine();
                if (resp.equals("CENTER")) {
                    return true;
                } else if (resp.equals("HIT")) {
                    up = Math.min(up, i);
                } //else if (resp.equals("MISS")) {
                else{
                    continue;
                }
            }
        }

        //smallest left edge
        int left = 10;
        for (int i = 0; i <= 10; i++) {
            for (int j = -5; j <= 5; j++) {
                int x = base + j;
                int y = i;
                System.out.println(x + " " + y);
                String resp = in.nextLine();
                if (resp.equals("CENTER")) {
                    return true;
                } else if (resp.equals("HIT")) {
                    left = Math.min(left, i);
                } //else if (resp.equals("MISS")) {
                else{
                    continue;
                }
            }
        }

        return false;

    }


}