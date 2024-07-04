import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static Scanner sc;
    private static int testNumber = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            System.out.println(String.format("Case #%d: %s", testNumber, getSolution()));
            testNumber++;
        }
    }

    private static String getSolution() {
        int n = sc.nextInt();
        Integer[][] a = new Integer[n][2];
        Integer[][] sol = new Integer[n][2];
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a[i].length; ++j) {
                a[i][j] = sc.nextInt();
                sol[i][j] = a[i][j];
            }
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        final Map<Integer, Character> schedule = getSchedule(a);
        if (schedule.size() != sol.length) {
            return "IMPOSSIBLE";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer[] p : sol) {
            sb.append(schedule.get(Arrays.hashCode(p)));
        }

        return sb.toString();
    }

    private static Map<Integer, Character> getSchedule(Integer[][] v) {
        Map<Integer, Character> res = new HashMap<>();
        Map<Character, Integer> freeAt = new HashMap<>();
        freeAt.put('C', 0);
        freeAt.put('J', 0);

        for (Integer[] a : v) {
            for (Character c : freeAt.keySet()) {
                if (freeAt.get(c) <= a[0]) {
                    freeAt.put(c, a[1]);
                    res.put(Arrays.hashCode(a), c);
                    break;
                }
            }
        }
        return res;
    }
}
