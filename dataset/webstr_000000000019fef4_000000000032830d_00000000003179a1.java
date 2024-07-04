import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 10000;
        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int u = in.nextInt();
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                in.nextInt();
                arr[i] = in.next();
            }

            char[] res = new char[10];
            Set<Character> isZero = new HashSet<>();
            Set<Character> a = new HashSet<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < arr[i].length() - 1; j++) {
                    isZero.add(arr[i].charAt(j));
                }
                if (arr[i].length() == 1) {
                    isZero.add(arr[i].charAt(0));
                }

                if (isZero.size() == 9) {
                    break;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < arr[i].length(); j++) {
                    a.add(arr[i].charAt(j));
                }
                if (a.size() == 10) {
                    break;
                }
            }

            for (Character i : a) {
                if (!isZero.contains(i)) {
                    res[0] = i;
                }
            }

            Map<Character, Integer> map = new HashMap<>();
            for (Character i : a) {
                map.put(i, 0);
            }

            for (int i = 0; i < N; i++) {
                char ch = arr[i].charAt(0);
                if (ch != res[0]) {
                    map.put(ch, map.get(ch) + 1);
                }
            }

            int k = 1;
            while (k < 10) {
                int max = -1;
                char v = ' ';

                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (max < entry.getValue()) {
                        max = entry.getValue();
                        v = entry.getKey();
                    }
                }
                res[k++] = v;
                map.remove(v);
            }

            StringBuilder resv = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                resv.append(res[i]);
            }

            System.out.println("Case #" + t + ": " + resv.toString());
        }
    }
}
