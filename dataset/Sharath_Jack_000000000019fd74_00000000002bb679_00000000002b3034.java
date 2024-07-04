import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static void solve(Scanner s) {
        int n;
        n = s.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = s.next();
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (int i = 1; i < strings.length; i++) {
            int l = strings[i].length() - 1;
            if (!strings[0].substring(strings[0].length() - l).equals(strings[i].substring(1))) {
                System.out.println("*");
                return;
            }
        }
        System.out.println(strings[0].substring(1));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T;
        T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            solve(s);
        }
    }
}
