import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    private static final int MOD = 1000000007;
    private static final int INT_MAX = 1000000000;
    private static final int INT_MIN = -1000000000;
    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};

    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; ++t) {
            System.out.print("Case #" + t + ": ");
            int N = Integer.parseInt(br.readLine());
            String[] strings = new String[N];

            for (int i = 0; i < N; ++i) {
                strings[i] = br.readLine();
            }

            String suffix = "";
            StringBuilder prefix = new StringBuilder();

            for (int i = 0; i < N; ++i) {
                int index = 0;

                while (strings[i].charAt(index) != '*') {
                    if (index >= prefix.length()) {
                        prefix.append(strings[i].charAt(index));
                    } else if (prefix.charAt(index) != strings[i].charAt(index)) {
                        System.out.println("*");
                        continue;
                    }
                    index++;
                }

                int suffixIndex = 0;
                int endIndex = strings[i].length() - 1;

                while (endIndex >= index) {
                    if (strings[i].length() - 1 - endIndex >= suffix.length()) {
                        suffix = strings[i].charAt(endIndex) + suffix;
                    } else if (suffix.charAt(suffix.length() - 1 - suffixIndex) != strings[i].charAt(endIndex)) {
                        System.out.println("*");
                        continue;
                    }
                    endIndex--;
                    suffixIndex++;
                }
            }

            System.out.println(prefix.toString() + suffix);
        }

        br.close();
    }
}