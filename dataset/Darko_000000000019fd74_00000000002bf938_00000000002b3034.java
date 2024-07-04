import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private void work() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            int n = sc.nextInt();
            List<String> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(sc.next().substring(1));
            }

            a.sort(Comparator.comparingInt(String::length));

            boolean ok = true;
            for (int i = 1; i < a.size(); i++) ok &= a.get(i).endsWith(a.get(i - 1));
            String ans = ok ? a.get(a.size() - 1) : "*";
            System.out.printf("Case #%d: %s\n", tc, ans);
        }
        sc.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
