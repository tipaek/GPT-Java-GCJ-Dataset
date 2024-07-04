import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] arg) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        for(int i=0; i < t; i++) {
            String res = solve(b);
            if(!res.equals("Y")) {
                System.exit(0);
            }
        }
    }

    private static String solve(int b) {
        int[] ans = new int[b];
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        for(int i=0; i<150;i++) {
            System.out.println(i % 10);
            System.out.flush();

            ans[i % 10] = in.nextInt();
        }

        System.out.println(arrToString(ans));
        System.out.flush();

        String res = in.next();
        return res;
    }

    private static String arrToString(int[] arr) {
        String s = "";
        for(int i=0;i<arr.length;i++) s += arr[i];
        return s;
    }
}