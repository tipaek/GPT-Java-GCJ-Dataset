import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            processCase(caseNumber);
        }
    }

    private static void processCase(int caseNumber) throws IOException {
        System.out.print("Case #" + caseNumber + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        long[] cakes = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cakes[i] = Long.parseLong(st.nextToken());
        }

        if (D == 2) {
            handleCaseForD2(cakes, N);
        } else if (D == 3) {
            handleCaseForD3(cakes, N);
        }
    }

    private static void handleCaseForD2(long[] cakes, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (cakes[i] == cakes[j]) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
    }

    private static void handleCaseForD3(long[] cakes, int N) {
        Arrays.sort(cakes);

        for (int i = 0; i < N - 2; i++) {
            if (cakes[i] == cakes[i + 1] && cakes[i + 1] == cakes[i + 2]) {
                System.out.println(0);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (cakes[i] == 2 * cakes[j] || 2 * cakes[i] == cakes[j] || (cakes[i] == cakes[j] && i != N - 1)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(2);
    }
}