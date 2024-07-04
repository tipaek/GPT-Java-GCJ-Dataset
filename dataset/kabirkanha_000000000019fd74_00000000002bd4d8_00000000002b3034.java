import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cnt = 0;
        while (T > 0) {
            --T;
            ++cnt;
            System.out.print("Case #" + cnt + ": ");
            boolean flag = true;
            int N = scanner.nextInt();
            StringBuilder[] arr = new StringBuilder[N];
            for (int i = 0; i < N; ++i) {
                arr[i] = new StringBuilder();
                String temp = scanner.next();
                for (int j = 1; j < temp.length(); ++j)
                    arr[i].insert(j - 1, temp.charAt(j));
                arr[i].reverse();
            }
            StringBuilder final_str = new StringBuilder();
            final_str = arr[0];
            for (int i = 1; i < N; ++i) {
                if (final_str.toString().contains(arr[i].toString())) {
                } else if (arr[i].toString().contains(final_str.toString())) {
                    final_str = arr[i];
                } else {
                    System.out.println("*");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                final_str.reverse();
                System.out.println(final_str);
            }
        }
    }
}
