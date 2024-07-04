import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < N; j++) {
                if (inputs[j].charAt(0) == ('0' + i) && inputs[j].length() == results[j].length()) {
                    char c = results[j].charAt(0);
                    if (!used.contains(c)) {
                        used.add(c);
                        r += c;
                        break;
                    }
                }
            }
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
