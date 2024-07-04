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
            int N = in.nextInt();
            System.out.println("Case #" + i + ":");
            solve(N);
        }
    }

    private static void solve(int N) {
        if (N < 500) {
            for (int i = 1; i <= N; i++) {
                System.out.println(i + " 1");
            }
            return;
        }

        int sum = 4;
        int row = 3;
        int next = 3;
        System.out.println("1 1");
        System.out.println("2 1");
        System.out.println("3 2");
        boolean useOnes = false;

        while (sum != N) {
            if (useOnes) {
                sum++;
                row++;
                System.out.println(row + " 1");
                continue;
            }

            if (sum + next <= N) {
                sum += next;
                row++;
                next++;
                System.out.println(row + " 2");
            } else {
                useOnes = true;
                sum++;
                System.out.println(row + " 1");
            }
        }
    }
}
