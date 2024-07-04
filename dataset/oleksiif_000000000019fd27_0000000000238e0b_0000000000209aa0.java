public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int N = in.nextInt();
            int K = in.nextInt();
            if (K % N != 0) {
                System.out.println(String.format("Case #%s: IMPOSSIBLE", caseIndex));
            } else {
                System.out.println(String.format("Case #%s: POSSIBLE", caseIndex));
                int center = K / N;
                StringBuilder square = new StringBuilder();
                for (int i = 0; i < N; i++) {

                    for (int j = 0; j < N; j++) {
                        if (j == i) square.append(center).append(" ");
                    }
                    square.deleteCharAt(square.length() - 1);
                    square.append("\n");
                }
            }
        }
    }
}