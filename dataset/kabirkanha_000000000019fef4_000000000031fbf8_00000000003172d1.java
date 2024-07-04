import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cnt = 0;
        while (T > 0) {
            ++cnt;
            System.out.print("Case #" + cnt + ": ");
            --T;
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            double[] arr = new double[N];
            for (int i = 0; i < N; ++i) {
                arr[i] = scanner.nextDouble();
            }
            Arrays.sort(arr);
            boolean flag = true;
            if (D == 2) {
                for (int i = 1; i < N; ++i) {
                    if (arr[i] == arr[i - 1]) {
                        System.out.println("0");
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    System.out.println("1");
            } else {
                for (int i = 1; i < N - 1; ++i) {
                    if (arr[i] == arr[i - 1] && arr[i] == arr[i + 1]) {
                        System.out.println("0");
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int i = 1; i < N - 1; ++i) {
                        if (arr[i] == arr[i - 1]) {
                            System.out.println("1");
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    for (int i = 0; i < N; ++i) {
                        for (int j = 0; j < N; ++j) {
                            if (arr[i] == 2 * arr[j]) {
                                if (flag)
                                    System.out.println("1");
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (flag)
                    System.out.println("2");
            }
        }
    }
}
