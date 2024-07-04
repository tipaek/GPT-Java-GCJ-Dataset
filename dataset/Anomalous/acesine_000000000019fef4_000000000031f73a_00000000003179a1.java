import java.util.*;

public class Solution {
    private final Scanner in = new Scanner(System.in);

    private String solve(int t, int U) {
        int[] freq = new int[26];
        for (int k = 0; k < 10000; k++) {
            long q = in.nextLong();
            String r = in.next();
            for (int j = 0; j < r.length(); j++) {
                freq[r.charAt(j) - 'A']++;
            }
        }

        List<int[]> frequencyList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                frequencyList.add(new int[]{i, freq[i]});
            }
        }
        frequencyList.sort(Comparator.comparingInt(x -> x[1]));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            result.append((char) ('A' + frequencyList.get((10 - i) % 10)[0]));
        }

        return result.toString();
    }

    private void run() {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.printf("Case #%d: %s%n", t, solve(t, in.nextInt()));
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}