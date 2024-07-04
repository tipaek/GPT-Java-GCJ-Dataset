import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static final int MOD = 1000000007;
    private static final int INT_MAX = 1000000000;
    private static final int INT_MIN = -1000000000;
    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};

    private static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; ++t) {
            System.out.print("Case #" + t + ": ");
            int N = Integer.parseInt(br.readLine());
            String[] strings = new String[N];

            for (int i = 0; i < N; ++i) {
                strings[i] = br.readLine();
            }

            StringBuilder prefix = new StringBuilder();
            String suffix = "";
            int emptyCount = 0;

            for (int i = 0; i < N; ++i) {
                int index = 0;
                while (index < strings[i].length() && strings[i].charAt(index) != '*') {
                    if (index >= prefix.length()) {
                        prefix.append(strings[i].charAt(index));
                    } else if (prefix.charAt(index) != strings[i].charAt(index)) {
                        System.out.println("*");
                        continue;
                    }
                    index++;
                }

                int lastAsterisk = strings[i].lastIndexOf('*');
                for (int j = strings[i].length() - 1; j > lastAsterisk; --j) {
                    int suffixIndex = strings[i].length() - 1 - j;
                    if (suffixIndex >= suffix.length()) {
                        suffix = strings[i].charAt(j) + suffix;
                    } else if (suffix.charAt(suffixIndex) != strings[i].charAt(j)) {
                        System.out.println("*");
                        continue;
                    }
                }
            }

            StringBuilder result = new StringBuilder(prefix);
            result.append(suffix);

            for (int i = 0; i < N; ++i) {
                int start = strings[i].indexOf('*');
                int end = strings[i].lastIndexOf('*');

                if (start >= end) {
                    strings[i] = "";
                    emptyCount++;
                } else {
                    strings[i] = strings[i].substring(start + 1, end);
                }
            }

            while (emptyCount < N) {
                for (int i = 0; i < N; ++i) {
                    if (strings[i].isEmpty()) continue;

                    int firstAsterisk = strings[i].indexOf('*');
                    if (firstAsterisk == -1) {
                        result.insert(prefix.length(), strings[i]);
                        strings[i] = "";
                        emptyCount++;
                    } else if (strings[i].length() == 1) {
                        strings[i] = "";
                        emptyCount++;
                    } else {
                        String pre = strings[i].substring(0, firstAsterisk);
                        String suf = strings[i].substring(strings[i].lastIndexOf('*') + 1);

                        result.insert(prefix.length(), pre);
                        result.append(suf);

                        strings[i] = strings[i].substring(firstAsterisk + 1, strings[i].lastIndexOf('*'));
                    }
                }
            }

            System.out.println(result.toString());
        }

        br.close();
    }
}