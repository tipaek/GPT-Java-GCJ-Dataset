import java.util.Scanner;

public class Solution {
    static class Pair {
        public int start;
        public int end;
        boolean flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cnt = 0;
        while (T > 0) {
            --T;
            cnt++;
            boolean flag = false;
            int C = 0;
            int J = 0;
            int N = scanner.nextInt();
            Pair task[] = new Pair[N];
            for (int i = 0; i < N; ++i)
                task[i] = new Pair();
            char[] ans = new char[N];
            for (int i = 0; i < N; ++i) {
                task[i].start = scanner.nextInt();
                task[i].end = scanner.nextInt();
                task[i].flag = false;
            }
            for (int i = 0; i < N; ++i) {
                int min = Integer.MAX_VALUE;
                int min_loc = 0;
                for (int j = 0; j < N; ++j) {
                    if (!task[j].flag && task[j].start <= min) {
                        min = task[j].start;
                        min_loc = j;
                    }
                }
                task[min_loc].flag = true;
                if (C <= min) {
                    C = task[min_loc].end;
                    ans[min_loc] = 'C';
                } else if (J <= min) {
                    J = task[min_loc].end;
                    ans[min_loc] = 'J';
                } else {
                    flag = true;
                    break;
                }
            }
            System.out.print("Case #" + cnt + ": ");
            if (flag)
                System.out.println("IMPOSSIBLE");
            else {
                for (char an : ans) System.out.print(an);
                System.out.println();
            }
        }
    }
}
