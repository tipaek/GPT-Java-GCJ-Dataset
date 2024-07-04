import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];

            for (int j = 0; j < n; j++) {
                s[j] = sc.nextInt();
                e[j] = sc.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + calcOverlap(s, e));
        }
    }

    public static String calcOverlap(int[] s, int[] e) {
        ArrayList<Integer>[] overlaps = new ArrayList[s.length];
        for (int i = 0; i < s.length; i++) {
            overlaps[i] = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                if ((s[i] > s[k] && s[i] < e[k]) || (e[i] > s[k] && e[i] < e[k]) || (s[i] > s[k] && e[i] < e[k])) {
                    overlaps[i].add(k);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < overlaps.length; i++) {
            if (overlaps[i].isEmpty()) {
                result.append("C");
            } else {
                StringBuilder busy = new StringBuilder();
                for (int index : overlaps[i]) {
                    busy.append(result.charAt(index));
                }
                if (busy.toString().contains("C")) {
                    if (busy.toString().contains("J")) {
                        return "IMPOSSIBLE";
                    }
                    result.append("J");
                } else {
                    result.append("C");
                }
            }
        }

        return result.toString();
    }
}