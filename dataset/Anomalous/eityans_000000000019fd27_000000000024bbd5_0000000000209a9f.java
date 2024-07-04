import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.next());

        for (int t = 0; t < T; t++) {
            char[] A = sc.next().toCharArray();
            int[] S = new int[A.length + 2];
            for (int i = 0; i < A.length; i++) {
                S[i + 1] = A[i] - '0';
            }

            StringBuilder ans = new StringBuilder();

            for (int i = 1; i <= A.length + 1; i++) {
                int diff = S[i] - S[i - 1];
                if (diff == 0) {
                    if (i != A.length + 1) ans.append(S[i]);
                } else {
                    char bracket = diff > 0 ? '(' : ')';
                    for (int j = 0; j < Math.abs(diff); j++) ans.append(bracket);
                    if (i != A.length + 1) ans.append(S[i]);
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + ans);
        }

        sc.close();
    }
}