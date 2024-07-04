import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int n = in.nextInt();
            testCase(n);
        }
    }
    private static void testCase(int n) {
        if(n>6) {
            // for test set 2, but not for test set 3
            solve2(n);
        }
        else {
            solve1(n);
        }
    }
    private static void solve1(int n) {
        for(int i=1; i<=n; i++) {
            System.out.println(i+" 1");
        }
    }
    private static void solve2(int n) {
        System.out.println("1 1");
        System.out.println("2 1");
        System.out.println("2 2");
        System.out.println("3 2");
        System.out.println("3 1");
        for(int i=4; i<=n-3; i++) {
            System.out.println(i+" 1");
        }
    }
}