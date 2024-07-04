import java.util.Scanner;

class Solution {
    public static void rotate(int[] array) {
        int length = array.length;
        int lastElement = array[length - 1];
        for (int i = length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = lastElement;
        for (int value : array) {
            System.out.print(value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int max = N * N;

            if ((K % N != 0) || (K > max)) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                break;
            } else {
                int v = K / N;
                int c = v + 1;
                int count = 1;
                int t = N - c;
                int[] temp = new int[N];
                int j;

                for (j = 0; j <= t; j++) {
                    temp[j] = c++;
                }
                for (int k = j; k < N; k++) {
                    temp[k] = count++;
                }

                System.out.println("Case #" + i + ": POSSIBLE");
                for (int p = 1; p <= N; p++) {
                    rotate(temp);
                    System.out.println();
                }
            }
        }
        scanner.close();
    }
}