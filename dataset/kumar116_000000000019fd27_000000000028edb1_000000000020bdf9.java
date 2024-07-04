import java.util.*;

public class Solution {

    public static String schedule(int[] startTs, int[] endTs, int N) {
        String[] answer = new String[N];

        answer[0] = "C";
        for (int i = 1; i < N; i++) {
            int startT = startTs[i];
            int endT = endTs[i];
            boolean conflictJ, conflictC;
            conflictJ = conflictC = false;
            for (int j = 0; j < i; j++) {
                if (answer[j] == "J") {
                    if ((startTs[j] <= startT && endTs[j] <= startT)
                            || startTs[j] >= endT && startTs[j] >= endT) {
                        ;
                    } else {
                        conflictJ = true;
                    }
                } else if (answer[j] == "C") {
                    if ((startTs[j] <= startT && endTs[j] <= startT)
                            || startTs[j] >= endT && startTs[j] >= endT) {
                        ;
                    } else {
                        conflictC = true;
                    }
                }

                if (conflictJ && conflictC) {
                    return "IMPOSSIBLE";
                }
                if (!conflictJ) {
                    answer[i] = "J";
                }
                if (!conflictC) {
                    answer[i] = "C";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {

            int N = scanner.nextInt();
            int[] startTs = new int[N];
            int[] endTs = new int[N];

            for (int n = 0; n < N; n++) {
                startTs[n] = scanner.nextInt();
                endTs[n] = scanner.nextInt();
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule(startTs, endTs, N));
        }
    }
}
