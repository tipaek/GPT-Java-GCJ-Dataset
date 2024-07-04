import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            int N = sc.nextInt();

            System.out.println(String.format("Case #%d:\n%s\n", tc, solve(N)));
        }

        sc.close();
    }

    static String solve(int N) {
        List<String> result = new ArrayList<>();
        result.add("1 1");

        if (N >= 2) {
            int r = 2;
            int current = 1;
            --N;
            while (N >= current) {
                result.add(String.format("%d 2", r));

                N -= current;
                ++r;
                ++current;
            }

            --r;
            while (N != 0) {
                result.add(String.format("%d 1", r));

                ++r;
                --N;
            }
        }

        return String.join("\n", result);
    }
}