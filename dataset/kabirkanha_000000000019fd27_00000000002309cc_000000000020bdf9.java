import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cnt = 0;
        while (T > 0) {
            --T;
            ++cnt;
            boolean flag = false;
            int N = scanner.nextInt();
            char[] ans = new char[N];
            int[] start = new int[N];
            int[] end = new int[N];
            int[] ref = new int[N];

            for (int i = 0; i < N; ++i)
                ref[i] = i + 1;

            for (int i = 0; i < N; ++i) {
                start[i] = scanner.nextInt();
                end[i] = scanner.nextInt();
            }

            for (int i = 0; i < N - 1; ++i) {
                for (int j = 0; j < N - i - 1; ++j) {
                    if (start[j] > start[j + 1]) {
                        int temp = start[j];
                        start[j] = start[j + 1];
                        start[j + 1] = temp;
                        temp = end[j];
                        end[j] = end[j + 1];
                        end[j + 1] = temp;
                        temp = ref[i];
                        ref[i] = ref[i + 1];
                        ref[i + 1] = temp;
                    }
                }
            }

            int C = 0;
            int J = 0;
            int tracker = 0;
            for (int i = 0; i < N; ++i) {
                if (C <= start[i]) {
                    C = end[i];
                    ans[tracker++] = 'C';
                } else if (J <= start[i]) {
                    J = end[i];
                    ans[tracker++] = 'J';
                } else {
                    flag = true;
                    break;
                }
            }

            for (int i = 0; i < N - 1; ++i) {
                for (int j = 0; j < N - i - 1; ++j) {
                    if (ref[j] > ref[j + 1]) {
                        int temp = ref[i];
                        ref[i] = ref[i + 1];
                        ref[i + 1] = temp;
                        char temp1 = ans[i];
                        ans[i] = ans[i + 1];
                        ans[i + 1] = temp1;
                    }
                }
            }
            System.out.print("Case #"+cnt+": ");
            if (flag)
                System.out.println("IMPOSSIBLE");
            else {
                for (int i = 0; i < N; ++i)
                    System.out.print(ans[i]);
                System.out.println("");
            }
        }
    }
}
