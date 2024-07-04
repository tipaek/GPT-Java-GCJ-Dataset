import java.util.*;

public class Solution {

    private static final int N = 10000;

    private void solve(Scanner scan) {
        int u = scan.nextInt();
        String[] inputs = new String[N];
        String[] results = new String[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = scan.next();
            results[i] = scan.next();
        }

        Set<Character> used = new HashSet<>();
        String r = "";

        int[] count = new int[26];
        for (String s : results) {
            count[s.charAt(0) - 'A']++;
        }

        for (int i = 0; i < 9; i++) {
            int max = 0;
            int best = 0;
            for (int j = 0; j < 26; j++) {
                int c = count[j];
                if (c > max) {
                    max = c;
                    best = j;
                }
            }
            count[best] = 0;
            char add = (char) (best + 'A');
            used.add(add);
            r = r + add;
        }


        for (String s : results) {
            for (char c : s.toCharArray()) {
                if (!used.contains(c)) {
                    r = c + r;
                    System.out.println(r);
                    return;
                }
            }
        }

        throw new RuntimeException();

    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}
